/**
 * File: XRadGraph.java
 * Purpose: This class extends JGraph and provides a component to draw x-rad components as
 * nodes and links between them as edges.</br>
 * Author: Farrukh Ijaz<br/>
 * Version: 1.0<br/>
 * <p>
 * Copyright 2005 Farrukh Ijaz
 * </p>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">
 * http://www.apache.org/licenses/LICENSE-2.0
 * </a>
 * </p>
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package com.xradsolutions.xrad.studio;

import com.xradsolutions.xrad.layout.xmlbo.AppLayout;
import com.xradsolutions.xrad.layout.xmlbo.Cell;
import com.xradsolutions.xrad.layout.xmlbo.LabelPoint;
import com.xradsolutions.xrad.xmlbo.AppModel;
import com.xradsolutions.xrad.xmlbo.Interaction;
import com.xradsolutions.xrad.xmlbo.Process;
import com.xradsolutions.xrad.xmlbo.Source;
import com.xradsolutions.xrad.xmlbo.SourceProcess;
import com.xradsolutions.xrad.xmlbo.SourceView;
import com.xradsolutions.xrad.xmlbo.Target;
import com.xradsolutions.xrad.xmlbo.TargetProcess;
import com.xradsolutions.xrad.xmlbo.TargetView;
import com.xradsolutions.xrad.xmlbo.View;

import java.io.*;

import java.util.*;
import java.util.List;

import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

import org.exolab.castor.xml.*;

import org.jgraph.*;
import org.jgraph.graph.*;
import org.jgraph.graph.Edge;

/**
 * @author ijazfx
 *
 */
public class XRadGraph extends JGraph {

    JFrame parent;

    public static XRadGraph createGraph(JFrame parent) {
        GraphModel model = new XRadModel();
        XRadGraph graph = new XRadGraph(model);
        XRadCellViewFactory factory = new XRadCellViewFactory(graph);
        GraphLayoutCache cache = new GraphLayoutCache(model, factory);
        graph.setGraphLayoutCache(cache);
        graph.setHighlightColor(Color.red);
        graph.setMarqueeHandler(new XRadMarqueeHandler(graph));
        graph.setAntiAliased(true);
        graph.setCloneable(true);
        graph.setDisconnectable(false);
        graph.setConnectable(false);
        graph.setGridMode(2);
        graph.setGridVisible(true);
        graph.setGridEnabled(true);
        graph.setScale(0.9);
        graph.setGridSize(15);
        graph.setGridColor(new Color(245, 245, 245));
        graph.parent = parent;
        graph.setPreferredSize(new Dimension(20000, 20000));
        return graph;
    }

    /**
   * Default constructor of this class.
   */
    public XRadGraph(GraphModel model) {
        super(model);
        // TODO Auto-generated constructor stub
        ToolTipManager.sharedInstance().registerComponent(this);
    }

    public String getToolTipText(MouseEvent event) {
      Object cell = getFirstCellForLocation(event.getX(), event.getY());
      if (cell instanceof ViewCell) {
        return ((ViewCell) cell).getToolTipString();
      }
      else
      if (cell instanceof ProcessCell) {
        return ((ProcessCell) cell).getToolTipString();
      }
      return null;
    }


    //
    // Custom Model
    //

    // A Custom Model that does not allow Self-References

    public static class XRadModel extends DefaultGraphModel {
        // Override Superclass Method

        public boolean acceptsSource(Object edge, Object port) {
            // Source only Valid if not Equal Target
            return (((Edge)edge).getTarget() != port);
        }

        // Override Superclass Method

        public boolean acceptsTarget(Object edge, Object port) {
            // Target only Valid if not Equal Source
            return (((Edge)edge).getSource() != port);
        }
    }

    /**
   * This method is used to save the graph to *.xrd files.
   *
   */
    public void store(AppModel config, Writer out) {
        Object[] cells = getRoots();
        boolean found;
        for (int i = 0; i < cells.length; i++) {
            DefaultGraphCell cell = (DefaultGraphCell)cells[i];
            if (cell instanceof ViewCell) {
                View view = (View)cell.getUserObject();
                found = false;
                for (int c = 0; c < config.getViewCount(); c++) {
                    if (config.getView(c).getName().equals(view.getName())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    config.addView(view);
                }
            } else if (cell instanceof ProcessCell) {
                com.xradsolutions.xrad.xmlbo.Process process =
                    (com.xradsolutions.xrad.xmlbo.Process)cell.getUserObject();
                found = false;
                for (int c = 0; c < config.getProcessCount(); c++) {
                    if (config.getProcess(c).getName().equals(process.getName())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    config.addProcess(process);
                }
            } else if (cell instanceof InteractionEdge) {
                Interaction interaction = (Interaction)cell.getUserObject();
                found = false;
                for (int c = 0; c < config.getInteractionCount(); c++) {
                    if (config.getInteraction(c).getSource().equals(interaction.getSource())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    config.addInteraction(interaction);
                }
            }
        }
        try {
            config.marshal(out);
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void storeLayout(Writer writer) {
        AppLayout layout = new AppLayout();
        Map components = new HashMap();
        Object[] cells = getRoots();
        Cell cell = null;
        com.xradsolutions.xrad.layout.xmlbo.Point point = null;
        LabelPoint labelPoint = null;
        long cellId = 1;
        for (int c = 0; c < cells.length; c++) {

            if (cells[c] instanceof ViewCell) {
                cell = new Cell();
                ViewCell viewCell = (ViewCell)cells[c];
                View view = (View)viewCell.getUserObject();
                cell.setId(view.getId());
                cell.setCellId(cellId++);
                components.put(viewCell, new Long(cell.getCellId()));
                // store position...
                point = new com.xradsolutions.xrad.layout.xmlbo.Point();
                Rectangle2D rect =
                    GraphConstants.getBounds(viewCell.getAttributes());
                point.setX(rect.getX());
                point.setY(rect.getY());
                cell.setPoint(point);
                // add label position...
                labelPoint = new LabelPoint();
                labelPoint.setX(0.0);
                labelPoint.setY(0.0);
                cell.setLabelPoint(labelPoint);

                layout.addCell(cell);
            } else if (cells[c] instanceof ProcessCell) {
                cell = new Cell();
                ProcessCell processCell = (ProcessCell)cells[c];
                com.xradsolutions.xrad.xmlbo.Process process =
                    (com.xradsolutions.xrad.xmlbo.Process)processCell.getUserObject();
                cell.setId(process.getId());
                cell.setCellId(cellId++);
                components.put(processCell, new Long(cell.getCellId()));
                // store position...
                point = new com.xradsolutions.xrad.layout.xmlbo.Point();
                Rectangle2D rect =
                    GraphConstants.getBounds(processCell.getAttributes());
                point.setX(rect.getX());
                point.setY(rect.getY());
                cell.setPoint(point);
                // add label position...
                labelPoint = new LabelPoint();
                labelPoint.setX(0.0);
                labelPoint.setY(0.0);
                cell.setLabelPoint(labelPoint);

                layout.addCell(cell);
            }
        }
        for (int c = 0; c < cells.length; c++) {
            if (cells[c] instanceof InteractionEdge) {
                com.xradsolutions.xrad.layout.xmlbo.Edge edge =
                    new com.xradsolutions.xrad.layout.xmlbo.Edge();
                InteractionEdge iedge = (InteractionEdge)cells[c];
                Long sourceCellId =
                    (Long)components.get(iedge.getSourceCell());
                edge.setSourceCellId(sourceCellId.longValue());
                //        if (iedge.getSourceCell() instanceof ViewCell) {
                //          View view = (View) iedge.getSourceCell().getUserObject();
                //
                //          edge.setSourceId(view.getId());
                //        }
                //        else if (iedge.getSourceCell() instanceof ProcessCell) {
                //          com.xradsolutions.xrad.xmlbo.Process process = (com.xradsolutions.xrad.xmlbo.
                //              Process) iedge
                //              .getSourceCell().getUserObject();
                //          edge.setSourceId(process.getId());
                //        }
                Long targetCellId =
                    (Long)components.get(iedge.getTargetCell());
                edge.setTargetCellId(targetCellId.longValue());
                //        if (iedge.getTargetCell() instanceof ViewCell) {
                //          View view = (View) iedge.getTargetCell().getUserObject();
                //          edge.setTargetId(view.getId());
                //        }
                //        else if (iedge.getTargetCell() instanceof ProcessCell) {
                //          com.xradsolutions.xrad.xmlbo.Process process = (com.xradsolutions.xrad.xmlbo.
                //              Process) iedge
                //              .getTargetCell().getUserObject();
                //          edge.setTargetId(process.getId());
                //        }
                Interaction interaction = (Interaction)iedge.getUserObject();
                //                SourceView sview = interaction.getSource().getSourceView();
                //                SourceProcess sproc =
                //                    interaction.getSource().getSourceProcess();
                //                TargetView tview = interaction.getTarget().getTargetView();
                //                TargetProcess tproc =
                //                    interaction.getTarget().getTargetProcess();
                Source source = interaction.getSource();
                String id = source.getValue() + "@" + source.getId();
                //                if (sview != null) {
                //                    id = sview.getSubmitMethodName() + "@" + sview.getId();
                //                } else if (sproc != null) {
                //                    id = sproc.getReturnValueText() + "@" + sproc.getId();
                //                }
                edge.setSourceId(id);
                Target target = interaction.getTarget();
                id = target.getId();
                //                if (tview != null) {
                //                    id = tview.getId();
                //                } else if (tproc != null) {
                //                    id = tproc.getId();
                //                }
                edge.setTargetId(id);
                // get points...
                EdgeView edgeView =
                    (EdgeView)getGraphLayoutCache().getMapping(iedge, false);
                List points = edgeView.getPoints();
                Iterator iter = points.iterator();
                while (iter.hasNext()) {
                    point = new com.xradsolutions.xrad.layout.xmlbo.Point();
                    Object obj = iter.next();
                    if (obj instanceof PortView) {
                        PortView portView = (PortView)obj;
                        Rectangle2D rect = portView.getBounds();
                        point.setX(rect.getX());
                        point.setY(rect.getY());
                    } else if (obj instanceof Point2D) {
                        Point2D pt = (Point2D)obj;
                        point.setX(pt.getX());
                        point.setY(pt.getY());
                    } else {
                        point.setX(0.0);
                        point.setY(0.0);
                    }
                    edge.addPoint(point);
                }
                // add label position...
                labelPoint = new LabelPoint();
                Point2D labelPt = edgeView.getLabelPosition();
                labelPoint.setX(labelPt.getX());
                labelPoint.setY(labelPt.getY());
                edge.setLabelPoint(labelPoint);

                layout.addEdge(edge);
            }
        }
        try {
            layout.marshal(writer);
        } catch (MarshalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
   * This method is used to save the graph to *.xrd files.
   *
   */

    /**
   * @param out
   */
    // public void storeLayout(Writer out) {
    // long cellId = 1;
    // AppLayout layout = new AppLayout();
    // Object[] cells = getRoots();
    //
    // com.xradsolutions.xrad.xmlbo.Cell cell = null;
    // Point2D point = null;
    // com.xradsolutions.xrad.xmlbo.Point xmlPoint = null;
    // com.xradsolutions.xrad.xmlbo.LabelPoint labelPoint = null;
    //
    // Map components = new HashMap();
    //
    // for (int i = 0; i < cells.length; i++) {
    // DefaultGraphCell dgc = (DefaultGraphCell) cells[i];
    //
    // if (!(dgc instanceof InteractionEdge)) {
    // cell = new Cell();
    // long id = cellId++;
    // cell.setCellId(id);
    //
    // components.put(dgc, new Long(id));
    //
    // if (dgc instanceof ViewCell) {
    // View view = (View) dgc.getUserObject();
    // cell.setId(view.getId());
    // } else if (dgc instanceof ProcessCell) {
    // com.xradsolutions.xrad.xmlbo.Process process = (com.xradsolutions.xrad.xmlbo.Process)
    // dgc
    // .getUserObject();
    // cell.setId(process.getId());
    // }
    //
    // xmlPoint = new com.xradsolutions.xrad.xmlbo.Point();
    //
    // CellView cellView = (CellView) getGraphLayoutCache()
    // .getMapping(dgc, false);
    //
    // Rectangle2D rect = cellView.getBounds();
    //
    // xmlPoint.setX(rect.getX());
    // xmlPoint.setY(rect.getY());
    //
    // cell.setPoint(xmlPoint);
    //
    // labelPoint = new LabelPoint();
    // labelPoint.setX(0.0);
    // labelPoint.setY(0.0);
    //
    // cell.setLabelPoint(labelPoint);
    //
    // layout.addCell(cell);
    // }
    // }
    // for (int i = 0; i < cells.length; i++) {
    // DefaultGraphCell dgc = (DefaultGraphCell) cells[i];
    // if (dgc instanceof InteractionEdge) {
    //
    // InteractionEdge edge = (InteractionEdge) dgc;
    //
    // com.xradsolutions.xrad.xmlbo.Edge xmlEdge = new com.xradsolutions.xrad.xmlbo.Edge();
    //
    // EdgeView edgeView = (EdgeView) getGraphLayoutCache()
    // .getMapping(edge, false);
    //
    // SourceCell sourceCell = new SourceCell();
    // TargetCell targetCell = new TargetCell();
    //
    // dgc = (DefaultGraphCell) edge.getSourceCell();
    //
    // Object object = dgc.getUserObject();
    //
    // Long id = (Long) components.get(dgc);
    //
    // if (object instanceof View) {
    // sourceCell.setId(id.toString());;
    // } else if (object instanceof com.xradsolutions.xrad.xmlbo.Process) {
    // sourceCell.setId(id.toString());
    // }
    //
    // dgc = (DefaultGraphCell) edge.getTargetCell();
    // object = dgc.getUserObject();
    //
    // id = (Long) components.get(dgc);
    //
    // if (object instanceof View) {
    // targetCell.setId(id.toString());;
    // } else if (object instanceof com.xradsolutions.xrad.xmlbo.Process) {
    // targetCell.setId(id.toString());
    // }
    //
    // xmlEdge.setSourceCell(sourceCell);
    // xmlEdge.setTargetCell(targetCell);
    //
    // List points = edgeView.getPoints();
    //
    // for (int pi = 0; pi < points.size(); pi++) {
    // xmlPoint = new com.xradsolutions.xrad.xmlbo.Point();
    //
    // if (points.get(pi) instanceof CellView) {
    // CellView cellView = (CellView) points.get(pi);
    // Rectangle2D rect = cellView.getBounds();
    // xmlPoint.setX(rect.getX());
    // xmlPoint.setY(rect.getY());
    // } else if (points.get(pi) instanceof Point2D) {
    // point = (Point2D) points.get(pi);
    // xmlPoint.setX(point.getX());
    // xmlPoint.setY(point.getY());
    // }
    //
    // xmlEdge.addPoint(xmlPoint);
    // }
    //
    // point = edgeView.getLabelPosition();
    //
    // labelPoint = new LabelPoint();
    // labelPoint.setX(point.getX());
    // labelPoint.setY(point.getY());
    //
    // xmlEdge.setLabelPoint(labelPoint);
    //
    // layout.addEdge(xmlEdge);
    // // Add code to save edge...
    //
    // }
    // }
    //
    // try {
    // layout.marshal(out);
    // out.close();
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    Map cmap = new HashMap();

    Map imap = new HashMap();

    public void load(AppModel config) {
        try {
            StudioUtilities.usedClassNames = new HashMap();
            StudioUtilities.usedIds = new HashMap();
            StudioUtilities.usedNavigations = new Vector();
            StudioUtilities.availableObjects = new Vector();
            View[] views = config.getView();
            for (int i = 0; i < views.length; i++) {
                View view = views[i];
                cmap.put(view.getId(), view);
                if (!StudioUtilities.packages.contains(view.getPackageName())) {
                    StudioUtilities.packages.add(view.getPackageName());
                }
                if (StudioUtilities.usedClassNames.get(view.getName()) ==
                    null) {
                    StudioUtilities.usedClassNames.put(view.getName(), view);
                }
                if (StudioUtilities.usedIds.get(view.getId()) == null) {
                    StudioUtilities.usedIds.put(view.getId(), view);
                }
                if (!StudioUtilities.availableObjects.contains(view)) {
                    StudioUtilities.availableObjects.add(view);
                }
            }
            com.xradsolutions.xrad.xmlbo.Process[] processes =
                config.getProcess();
            for (int i = 0; i < processes.length; i++) {
                com.xradsolutions.xrad.xmlbo.Process process = processes[i];
                cmap.put(process.getId(), process);
                if (!StudioUtilities.packages.contains(process.getPackageName())) {
                    StudioUtilities.packages.add(process.getPackageName());
                }
                if (StudioUtilities.usedClassNames.get(process.getName()) ==
                    null) {
                    StudioUtilities.usedClassNames.put(process.getName(),
                                                       process);
                }
                if (StudioUtilities.usedIds.get(process.getId()) == null) {
                    StudioUtilities.usedIds.put(process.getId(), process);
                }
                if (!StudioUtilities.availableObjects.contains(process)) {
                    StudioUtilities.availableObjects.add(process);
                }
            }
            Interaction[] interactions = config.getInteraction();
            for (int i = 0; i < interactions.length; i++) {
                Interaction interaction = interactions[i];
                String id = null;
                //                if (interaction.getSource().getSourceView() != null) {
                //                    id =
                // interaction.getSource().getSourceView().getSubmitMethodName() + "@" +
                //    interaction.getSource().getSourceView().getId();
                //                } else if (interaction.getSource().getSourceProcess() !=
                //                           null) {
                //                    id =
                // interaction.getSource().getSourceProcess().getReturnValueText() + "@" +
                //    interaction.getSource().getSourceProcess().getId();
                //                }
                Source source = interaction.getSource();
                id = source.getValue() + "@" + source.getId();
                StudioUtilities.usedNavigations.add(id);
                Map map = (Map)imap.get(id);
                if (map == null) {
                    map = new HashMap();
                    imap.put(id, map);
                }
                //                if (interaction.getTarget().getTargetView() != null) {
                //                    id = interaction.getTarget().getTargetView().getId();
                //                } else if (interaction.getTarget().getTargetProcess() !=
                //                           null) {
                //                    id = interaction.getTarget().getTargetProcess().getId();
                //                }
                Target target = interaction.getTarget();
                id = target.getId();
                Object obj = map.get(id);
                if (obj == null) {
                    map.put(id, interaction);
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadLayout(Reader in) {
        try {
            Map vertecies = new HashMap();
            AppLayout config = (AppLayout)AppLayout.unmarshal(in);
            Cell[] cells = config.getCell();
            com.xradsolutions.xrad.layout.xmlbo.Point point = null;
            for (int c = 0; c < cells.length; c++) {
                Cell cell = cells[c];
                Object obj = cmap.get(cell.getId());
                if (obj instanceof com.xradsolutions.xrad.xmlbo.View) {
                    ViewCell viewCell =
                        XRadComponentFactory.createView((View)obj);
                    point = cell.getPoint();
                    Rectangle2D rect = new Rectangle2D.Double();
                    rect.setRect(point.getX(), point.getY(), 100.0, 100.0);
                    GraphConstants.setBounds(viewCell.getAttributes(), rect);
                    getGraphLayoutCache().insert(viewCell);
                    vertecies.put(new Long(cell.getCellId()), viewCell);
                } else if (obj instanceof
                           com.xradsolutions.xrad.xmlbo.Process) {
                    ProcessCell processCell =
                        XRadComponentFactory.createProcess((com.xradsolutions.xrad.xmlbo.Process)obj);
                    point = cell.getPoint();
                    Rectangle2D rect = new Rectangle2D.Double();
                    rect.setRect(point.getX(), point.getY(), 100.0, 100.0);
                    GraphConstants.setBounds(processCell.getAttributes(),
                                             rect);
                    getGraphLayoutCache().insert(processCell);
                    vertecies.put(new Long(cell.getCellId()), processCell);
                }
            }
            com.xradsolutions.xrad.layout.xmlbo.Edge[] edges =
                config.getEdge();
            Point2D pt = null;
            for (int e = 0; e < edges.length; e++) {
                com.xradsolutions.xrad.layout.xmlbo.Edge edge = edges[e];
                DefaultGraphCell sdgc =
                    (DefaultGraphCell)vertecies.get(new Long(edge.getSourceCellId()));
                DefaultGraphCell tdgc =
                    (DefaultGraphCell)vertecies.get(new Long(edge.getTargetCellId()));
                PortView source =
                    (PortView)getGraphLayoutCache().getMapping(sdgc.getChildAt(0),
                                                               false);
                PortView target =
                    (PortView)getGraphLayoutCache().getMapping(tdgc.getChildAt(0),
                                                               false);
                sdgc = (DefaultGraphCell)source.getCell();
                tdgc = (DefaultGraphCell)target.getCell();
                InteractionEdge iedge =
                    XRadComponentFactory.createInteraction(sdgc, tdgc);

                Map map = (Map)imap.get(edge.getSourceId());
                if (map != null) {
                    Interaction interaction =
                        (Interaction)map.get(edge.getTargetId());
                    if (interaction != null) {
                        iedge.setUserObject(interaction);
                    }
                }

                connect((Port)sdgc, (Port)tdgc, iedge);

                EdgeView edgeView =
                    (EdgeView)getGraphLayoutCache().getMapping(iedge, false);
                pt = new java.awt.geom.Point2D.Double();
                pt.setLocation(edge.getLabelPoint().getX(),
                               edge.getLabelPoint().getY());
                edgeView.setLabelPosition(pt);
                com.xradsolutions.xrad.layout.xmlbo.Point[] points =
                    edge.getPoint();
                for (int p = 0; p < points.length; p++) {
                    if (p > 0 && p < points.length - 1) {
                        edgeView.addPoint(p, null);
                    }

                }
                List pts = edgeView.getPoints();
                iedge.setAttributes(edgeView.getAllAttributes());
                //        edgeView.getAttributes().putAll(edgeView.getAllAttributes());
                for (int p = 0; p < points.length - 1; p++) {
                    Object obj = pts.get(p);
                    if (obj instanceof PortView) {
                        PortView pv = (PortView)obj;
                        Rectangle2D rect =
                            new Rectangle2D.Double(points[p].getX(),
                                                   points[p].getY(), 100.0,
                                                   100.0);
                        pv.setBounds(rect);
                    }
                    if (obj == null) {
                        pt = new java.awt.geom.Point2D.Double();
                        pt.setLocation(points[p].getX(), points[p].getY());
                        edgeView.setPoint(p, pt);
                    }
                }

            }
            //			drawAndRefreshExtensionEdges();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void connect(Port source, Port target, DefaultEdge edge) {
        // TODO Auto-generated method stub
        // Construct Edge with no label
        // DefaultEdge edge = createDefaultEdge();
        if (getModel().acceptsSource(edge, source) &&
            getModel().acceptsTarget(edge, target)) {
            // Create a Map thath holds the attributes for the edge
            edge.getAttributes().applyMap(createEdgeAttributes());
            // Insert the Edge and its Attributes
            getGraphLayoutCache().insertEdge(edge, source, target);
        }
    }

    // Hook for subclassers

    protected DefaultEdge createDefaultEdge() {
        return new DefaultEdge();
    }

    // Hook for subclassers

    public Map createEdgeAttributes() {
        Map map = new Hashtable();
        // Add a Line End Attribute
        GraphConstants.setLineEnd(map, GraphConstants.ARROW_SIMPLE);
        GraphConstants.setLineWidth(map, 1.2F);
        //        GraphConstants.setVerticalTextPosition(map, GraphConstants.getVerticalTextPosition(map) + 15);
        //    GraphConstants.setLineStyle(map, GraphConstants.STYLE_SPLINE);
        // Add a label along edge attribute
        GraphConstants.setLabelAlongEdge(map, false);
        return map;
    }

    public void drawAndRefreshExtensionEdges() {
        Object[] cells = getRoots();
        int max = cells.length;
        for (int i = 0; i < max; i++) {
            if (!(cells[i] instanceof DefaultEdge)) {
                DefaultGraphCell sdgc = (DefaultGraphCell)cells[i];
                Port sport = (Port)sdgc.getChildAt(0);
                PortView sportView =
                    (PortView)getGraphLayoutCache().getMapping(sdgc.getChildAt(0),
                                                               false);
                for (int j = 0; j < max; j++) {
                    if (!(cells[j] instanceof DefaultEdge)) {
                        DefaultGraphCell tdgc = (DefaultGraphCell)cells[j];
                        Port tport = (Port)sdgc.getChildAt(0);
                        PortView tportView =
                            (PortView)getGraphLayoutCache().getMapping(tdgc.getChildAt(0),
                                                                       false);
                        if (sdgc.getUserObject().equals(tdgc.getUserObject()) &&
                            !sportView.equals(tportView)) {
                            boolean found = false;
                            Object[] everything =
                                getGraphLayoutCache().getRoots();
                            int totalsize = everything.length;
                            for (int k = 0; k < totalsize; k++) {
                                if (everything[k] instanceof DefaultEdge) {
                                    DefaultEdge edge =
                                        (DefaultEdge)everything[k];
                                    if (edge.getUserObject() == null) {
                                        if (edge.getSource().equals(sport) &&
                                            edge.getTarget().equals(tport)) {
                                            found = true;
                                        } else if (edge.getSource().equals(tport) &&
                                                   edge.getTarget().equals(sport)) {
                                            found = true;
                                        }
                                    }
                                }
                            }
                            if (!found) {
                                connect((Port)sportView.getCell(),
                                        (Port)tportView.getCell(),
                                        createExtensionEdge());
                            }
                        }
                    }
                }
            }
        }
    }

    private DefaultEdge createExtensionEdge() {
        DefaultEdge edge = new DefaultEdge();
        Map map = new Hashtable();
        // Add a Line End Attribute
        GraphConstants.setLineEnd(map, GraphConstants.ARROW_CIRCLE);
        GraphConstants.setLineColor(map, new Color(245, 245, 245));
        //GraphConstants.setLineStyle(map, GraphConstants.STYLE_SPLINE);
        // Add a label along edge attribute
        GraphConstants.setLabelAlongEdge(map, false);
        edge.getAttributes().applyMap(map);
        return edge;
    }

    // public void _loadLayout(FileReader in) {
    // try {
    // AppLayout config = (AppLayout) AppLayout.unmarshal(in);
    // in.close();
    //
    // Map cellMap = new HashMap();
    //
    // Cell[] cells = config.getCell();
    // for (int i = 0; i < cells.length; i++) {
    // Cell cell = cells[i];
    // Object object = components.get(cell.getId());
    // DefaultGraphCell dgc = null;
    // if (object instanceof View) {
    // dgc = XRadComponentFactory.createView((View) object);
    // } else if (object instanceof com.xradsolutions.xrad.xmlbo.Process) {
    // dgc = XRadComponentFactory
    // .createProcess((com.xradsolutions.xrad.xmlbo.Process) object);
    // }
    // com.xradsolutions.xrad.xmlbo.Point point = cell.getPoint();
    // Rectangle rect = new Rectangle();
    // rect.setLocation((int) point.getX(), (int) point.getY());
    // GraphConstants.setBounds(dgc.getAttributes(), rect);
    // getGraphLayoutCache().insert(dgc);
    // cellMap.put(new Long(cell.getCellId()), dgc);
    // }

    // com.xradsolutions.xrad.xmlbo.Edge[] edges = config.getEdge();
    //
    // Map edgeAttributeMap = new Hashtable();
    // // Add a Line End Attribute
    // GraphConstants.setLineEnd(edgeAttributeMap,
    // GraphConstants.ARROW_SIMPLE);
    // GraphConstants.setLineStyle(edgeAttributeMap,
    // GraphConstants.STYLE_BEZIER);
    // // Add a label along edge attribute
    // GraphConstants.setLabelAlongEdge(edgeAttributeMap, true);
    //
    // for (int i = 0; i < edges.length; i++) {
    // com.xradsolutions.xrad.xmlbo.Edge xmlEdge = edges[i];
    // // edge.getSourceCell().getId()
    // Object source = cellMap.get(new
    // Long(xmlEdge.getSourceCell().getId()));
    // Object target = cellMap.get(new
    // Long(xmlEdge.getTargetCell().getId()));
    // InteractionEdge iedge =
    // XRadComponentFactory.createInteraction((DefaultGraphCell)source,
    // (DefaultGraphCell)target);
    //
    // DefaultEdge edge = new DefaultEdge();
    //
    // DefaultGraphCell dgcSource = (DefaultGraphCell) source;
    // DefaultGraphCell dgcTarget = (DefaultGraphCell) target;
    //
    // if (getModel().acceptsSource(edge, source)
    // && getModel().acceptsTarget(edge, target)) {
    // // Create a Map thath holds the attributes for the edge
    // edge.getAttributes().applyMap(edgeAttributeMap);
    // // Insert the Edge and its Attributes
    // getGraphLayoutCache().insertEdge(edge, dgcSource.getChildAt(0),
    // dgcTarget.getChildAt(0));
    // }
    //
    // getGraphLayoutCache().insert(edge);
    //
    //
    // EdgeView edgeView = (EdgeView) getGraphLayoutCache()
    // .getMapping(edge, true);
    // com.xradsolutions.xrad.xmlbo.Point[] points = xmlEdge.getPoint();
    // for(int pi = 0; pi < xmlEdge.getPointCount(); pi++) {
    // Point2D point = new Point.Double(points[pi].getX(),
    // points[pi].getY());
    // edgeView.addPoint(pi, point);
    // }
    // //edgeView.setLabelPosition(new
    // Point.Double(xmlEdge.getLabelPoint().getX(),
    // xmlEdge.getLabelPoint().getY()));
    //
    // }

    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

}

// --- Code used from JGraph Examples ---
//
// Custom MarqueeHandler

// MarqueeHandler that Connects Vertices and Displays PopupMenus
class XRadMarqueeHandler extends BasicMarqueeHandler {

    protected XRadGraph graph;

    // Holds the Start and the Current Point
    protected Point2D start, current;

    // Holds the First and the Current Port
    protected PortView port, firstPort;

    public XRadMarqueeHandler(XRadGraph graph) {
        // TODO Auto-generated constructor stub
        this.graph = graph;
    }

    // Override to Gain Control (for PopupMenu and ConnectMode)

    public boolean isForceMarqueeEvent(MouseEvent e) {
        if (e.isShiftDown()) {
            return false;
        }
        // If Right Mouse Button we want to Display the PopupMenu
        if (SwingUtilities.isRightMouseButton(e)) {
            // Return Immediately
            return true;
        }
        // Find and Remember Port
        port = getSourcePortAt(e.getPoint());
        // If Port Found and in ConnectMode (=Ports Visible)
        if (port != null && graph.isPortsVisible()) {
            return true;
        }
        // Else Call Superclass
        return super.isForceMarqueeEvent(e);
    }

    // Display PopupMenu or Remember Start Location and First Port

    public void mousePressed(final MouseEvent e) {
        // If Right Mouse Button
        if (SwingUtilities.isRightMouseButton(e)) {
            // Find Cell in Model Coordinates
            Object cell = graph.getFirstCellForLocation(e.getX(), e.getY());
            // Create PopupMenu for the Cell
            JPopupMenu menu = createPopupMenu(e.getPoint(), cell);
            // Display PopupMenu
            menu.show(graph, e.getX(), e.getY());
            // Else if in ConnectMode and Remembered Port is Valid
        } else if (port != null && graph.isPortsVisible()) {
            // Remember Start Location
            start = graph.toScreen(port.getLocation());
            // Remember First Port
            firstPort = port;
        } else {
            // Call Superclass
            super.mousePressed(e);
        }
    }

    private JPopupMenu createPopupMenu(final Point point, final Object cell) {
        // TODO Auto-generated method stub
        JPopupMenu menu = new JPopupMenu();
        if (cell != null) {
            // Edit
            menu.add(new AbstractAction("Definition") {
                        public void actionPerformed(ActionEvent e) {
                            DefaultGraphCell dgc = (DefaultGraphCell)cell;
                            if (dgc instanceof ViewCell) {
                                ViewDefDialog dialog =
                                    new ViewDefDialog((View)dgc.getUserObject());
                                StudioUtilities.center(dialog);
                                dialog.setModal(true);
                                dialog.showDialog();
                            } else if (dgc instanceof ProcessCell) {
                                ProcessDefDialog dialog =
                                    new ProcessDefDialog((com.xradsolutions.xrad.xmlbo.Process)dgc.getUserObject());
                                StudioUtilities.center(dialog);
                                dialog.setModal(true);
                                dialog.showDialog();
                            } else if (dgc instanceof InteractionEdge) {
                                InteractionDefDialog dialog =
                                    new InteractionDefDialog(XRadApp.xradFrame,
                                                             (InteractionEdge)dgc);
                                if (dialog.submitMethods.size() > 0 ||
                                    dialog.returnValues.size() > 0) {
                                    StudioUtilities.center(dialog);
                                    dialog.setModal(true);
                                    dialog.showDialog();
                                }
                            }
                        }
                    });
        }
        // Remove
        if (!graph.isSelectionEmpty()) {
            menu.add(new AbstractAction("Remove") {
                        public void actionPerformed(ActionEvent e) {
                            // Get the selected cell of the graph.
                            //          Object cell = graph.getSelectionCell();
                            // If some cell is selected on the graph then confirm from
                            // the user to
                            // delete.
                            //          if (cell != null) {
                            //            // Prompt the confirmation dialog.
                            //            int selection = JOptionPane.showConfirmDialog(
                            //                new JDialog(), "Are you sure to delete?");
                            //            // Check and delete the cell from the graph if user has
                            //            // selected YES
                            //            // on the confirmation dialog.
                            //            if (selection == JOptionPane.YES_OPTION) {
                            //              // Type cast the cell to DefaultGraphCell. This is
                            //              // required to
                            //              // delete children of the cell.
                            //              DefaultGraphCell dgc = (DefaultGraphCell) cell;
                            //              // Remove all children of the cell.
                            //              dgc.removeAllChildren();
                            //              // Remove cell from the graph.
                            //              graph.getGraphLayoutCache().remove(
                            //                  new Object[] {cell});
                            //            }
                            // Get the selected cell of the graph.
                            Object[] cells = graph.getSelectionCells();
                            // If some cell is selected on the graph then confirm from the user to
                            // delete.
                            if (cells != null && cells.length > 0) {
                                // Prompt the confirmation dialog.
                                int selection =
                                    JOptionPane.showConfirmDialog(XRadApp.xradFrame,
                                                                  "Are you sure to delete selected component(s)? This will also delete associated interaction(s)!");
                                // Check and delete the cell from the graph if user has selected YES
                                // on the confirmation dialog.
                                if (selection == JOptionPane.YES_OPTION) {
                                    for (int i = 0; i < cells.length; i++) {
                                        DefaultGraphCell dgc =
                                            (DefaultGraphCell)cells[i];
                                        if (!(dgc instanceof
                                              InteractionEdge)) {
                                            DefaultPort port =
                                                (DefaultPort)dgc.getChildAt(0);
                                            if (port != null) {
                                                Iterator iter =
                                                    port.getEdges().iterator();
                                                while (iter.hasNext()) {
                                                    InteractionEdge iedge =
                                                        (InteractionEdge)iter.next();
                                                    Interaction interaction =
                                                        (Interaction)iedge.getUserObject();
                                                    //                      SourceView sview = interaction.getSource().
                                                    //                          getSourceView();
                                                    //                      SourceProcess sproc = interaction.getSource().
                                                    //                          getSourceProcess();
                                                    //                      String id = null;
                                                    //                      if (sview != null) {
                                                    //                        id = sview.getSubmitMethodName() + "@" + sview.getId();
                                                    //                      }
                                                    //                      else if (sproc != null) {
                                                    //                        id = sproc.getReturnValueText() + "@" + sproc.getId();
                                                    //                      }
                                                    Source source =
                                                        interaction.getSource();
                                                    String id =
                                                        source.getValue() +
                                                        "@" + source.getId();

                                                    StudioUtilities.usedNavigations.remove(id);
                                                }
                                            }
                                        }
                                        if (dgc.getUserObject() instanceof
                                            com.xradsolutions.xrad.xmlbo.View) {
                                            com.xradsolutions.xrad.xmlbo.View view =
                                                (com.xradsolutions.xrad.xmlbo.View)dgc.getUserObject();
                                            StudioUtilities.usedClassNames.remove(view.getName());
                                            StudioUtilities.usedIds.remove(view.getId());
                                        } else if (dgc.getUserObject() instanceof
                                                   com.xradsolutions.xrad.xmlbo.Process) {
                                            com.xradsolutions.xrad.xmlbo.Process process =
                                                (com.xradsolutions.xrad.xmlbo.Process)dgc.getUserObject();
                                            StudioUtilities.usedClassNames.remove(process.getName());
                                            StudioUtilities.usedIds.remove(process.getId());
                                        } else if (dgc.getUserObject() instanceof
                                                   com.xradsolutions.xrad.xmlbo.Interaction) {
                                            com.xradsolutions.xrad.xmlbo.Interaction interaction =
                                                (com.xradsolutions.xrad.xmlbo.Interaction)dgc.getUserObject();
                                            Source source =
                                                interaction.getSource();
                                            String id =
                                                source.getValue() + "@" +
                                                source.getId();

                                            //                  SourceView sourceView = interaction.getSource().getSourceView();
                                            //                  SourceProcess sourceProcess = interaction.getSource().
                                            //                      getSourceProcess();
                                            //                  if (sourceView != null) {
                                            //                    id = sourceView.getSubmitMethodName() + "@" +
                                            //                        sourceView.getId();
                                            //                  }
                                            //                  else if (sourceProcess != null) {
                                            //                    id = sourceProcess.getReturnValueText() + "@" +
                                            //                        sourceProcess.getId();
                                            //                  }
                                            StudioUtilities.usedNavigations.remove(id);
                                        }
                                    }
                                    // Type cast the cell to DefaultGraphCell. This is required to
                                    // delete children of the cell.
                                    graph.getGraphLayoutCache().remove(cells,
                                                                       true,
                                                                       true);
                                }
                            }
                        }
                        //        }
                    });
        }
        // Insert View
        menu.add(new AbstractAction("Insert View") {
                    public void actionPerformed(ActionEvent ev) {
                        com.xradsolutions.xrad.xmlbo.View view =
                            new com.xradsolutions.xrad.xmlbo.View();
                        ViewDefDialog dialog = new ViewDefDialog(view);
                        // Center the dialog on the screen.
                        StudioUtilities.center(dialog);
                        // Set the dialog to be modal.
                        dialog.setModal(true);
                        // Show dialog.
                        int selection = dialog.showDialog();
                        if (selection == JOptionPane.CANCEL_OPTION) {
                            return;
                        }
                        if (!StudioUtilities.availableObjects.contains(view)) {
                            StudioUtilities.availableObjects.add(view);
                        }
                        ViewCell cell = XRadComponentFactory.createView(view);
                        DefaultGraphCell dgc =
                            (DefaultGraphCell)graph.getSelectionCell();
                        Point location = null;
                        if (dgc != null && !(dgc instanceof DefaultEdge)) {
                            Rectangle2D rect =
                                GraphConstants.getBounds(dgc.getAttributes());
                            int x = (int)(rect.getX() + 250);
                            int y = (int)rect.getY();
                            location = new Point(x, y);
                        } else {
                            location = point;
                        }
                        GraphConstants.setBounds(cell.getAttributes(),
                                                 new Rectangle(location));
                        graph.getGraphLayoutCache().insert(cell);
                    }
                });
        // Insert Process
        menu.add(new AbstractAction("Insert Process") {
                    public void actionPerformed(ActionEvent ev) {
                        com.xradsolutions.xrad.xmlbo.Process process =
                            new com.xradsolutions.xrad.xmlbo.Process();
                        ProcessDefDialog dialog =
                            new ProcessDefDialog(process);
                        // Center the dialog on the screen.
                        StudioUtilities.center(dialog);
                        // Set the dialog to be modal.
                        dialog.setModal(true);
                        // Show dialog.
                        int selection = dialog.showDialog();
                        if (selection == JOptionPane.CANCEL_OPTION) {
                            return;
                        }
                        if (!StudioUtilities.availableObjects.contains(process)) {
                            StudioUtilities.availableObjects.add(process);
                        }

                        ProcessCell cell =
                            XRadComponentFactory.createProcess(process);
                        DefaultGraphCell dgc =
                            (DefaultGraphCell)graph.getSelectionCell();
                        Point location = null;
                        if (dgc != null && !(dgc instanceof DefaultEdge)) {
                            Rectangle2D rect =
                                GraphConstants.getBounds(dgc.getAttributes());
                            int x = (int)(rect.getX() + 250);
                            int y = (int)rect.getY();
                            location = new Point(x, y);
                        } else {
                            location = point;
                        }
                        GraphConstants.setBounds(cell.getAttributes(),
                                                 new Rectangle(location));
                        graph.getGraphLayoutCache().insert(cell);
                    }
                });
        // Insert Reference...
        menu.add(new AbstractAction("Create Reference...") {
                    public void actionPerformed(ActionEvent ev) {

                        Object selected =
                            JOptionPane.showInputDialog(null, "Select View/Process:",
                                                        "Available Objects",
                                                        JOptionPane.QUESTION_MESSAGE,
                                                        null,
                                                        StudioUtilities.availableObjects.toArray(),
                                                        null);
                        if (selected == null) {
                            return;
                        }

                        if (selected.toString().endsWith(": View")) {
                            ViewCell cell =
                                XRadComponentFactory.createView((View)selected);
                            DefaultGraphCell dgc =
                                (DefaultGraphCell)graph.getSelectionCell();
                            Point location = null;
                            if (dgc != null && !(dgc instanceof DefaultEdge)) {
                                Rectangle2D rect =
                                    GraphConstants.getBounds(dgc.getAttributes());
                                int x = (int)(rect.getX() + 250);
                                int y = (int)rect.getY();
                                location = new Point(x, y);
                            } else {
                                location = point;
                            }
                            GraphConstants.setBounds(cell.getAttributes(),
                                                     new Rectangle(location));
                            graph.getGraphLayoutCache().insert(cell);
                        } else {
                            ProcessCell cell =
                                XRadComponentFactory.createProcess((com.xradsolutions.xrad.xmlbo.Process)selected);
                            DefaultGraphCell dgc =
                                (DefaultGraphCell)graph.getSelectionCell();
                            Point location = null;
                            if (dgc != null && !(dgc instanceof DefaultEdge)) {
                                Rectangle2D rect =
                                    GraphConstants.getBounds(dgc.getAttributes());
                                int x = (int)(rect.getX() + 250);
                                int y = (int)rect.getY();
                                location = new Point(x, y);
                            } else {
                                location = point;
                            }
                            GraphConstants.setBounds(cell.getAttributes(),
                                                     new Rectangle(location));
                            graph.getGraphLayoutCache().insert(cell);
                        }

                    }
                });
        menu.add(new AbstractAction("Create Clone...") {
                    public void actionPerformed(ActionEvent ev) {

                        Object cloned =
                            JOptionPane.showInputDialog(null, "Select View/Process:",
                                                        "Available Objects",
                                                        JOptionPane.QUESTION_MESSAGE,
                                                        null,
                                                        StudioUtilities.availableObjects.toArray(),
                                                        null);
                        if (cloned == null) {
                            return;
                        }

                        StringWriter sw = new StringWriter();

                        try {
                            if (cloned instanceof View) {
                                ((View)cloned).marshal(sw);
                                cloned = View.unmarshal(new StringReader(sw.getBuffer().toString()));
                                ((View)cloned).setName("Unnamed");
                                ((View)cloned).setId("unnamed");
                            }
                            else {
                                ((com.xradsolutions.xrad.xmlbo.Process)cloned).marshal(sw);
                                cloned = com.xradsolutions.xrad.xmlbo.Process.unmarshal(new StringReader(sw.getBuffer().toString()));
                                ((com.xradsolutions.xrad.xmlbo.Process)cloned).setName("Unnamed");
                                ((com.xradsolutions.xrad.xmlbo.Process)cloned).setId("unnamed");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (cloned instanceof View) {
                            ViewCell cell =
                                XRadComponentFactory.createView((View)cloned);
                            DefaultGraphCell dgc =
                                (DefaultGraphCell)graph.getSelectionCell();
                            Point location = null;
                            if (dgc != null && !(dgc instanceof DefaultEdge)) {
                                Rectangle2D rect =
                                    GraphConstants.getBounds(dgc.getAttributes());
                                int x = (int)(rect.getX() + 250);
                                int y = (int)rect.getY();
                                location = new Point(x, y);
                            } else {
                                location = point;
                            }
                            GraphConstants.setBounds(cell.getAttributes(),
                                                     new Rectangle(location));
                            graph.getGraphLayoutCache().insert(cell);
                        } else {
                            ProcessCell cell =
                                XRadComponentFactory.createProcess((com.xradsolutions.xrad.xmlbo.Process)cloned);
                            DefaultGraphCell dgc =
                                (DefaultGraphCell)graph.getSelectionCell();
                            Point location = null;
                            if (dgc != null && !(dgc instanceof DefaultEdge)) {
                                Rectangle2D rect =
                                    GraphConstants.getBounds(dgc.getAttributes());
                                int x = (int)(rect.getX() + 250);
                                int y = (int)rect.getY();
                                location = new Point(x, y);
                            } else {
                                location = point;
                            }
                            GraphConstants.setBounds(cell.getAttributes(),
                                                     new Rectangle(location));
                            graph.getGraphLayoutCache().insert(cell);
                        }
                        if (!StudioUtilities.availableObjects.contains(cloned)) {
                            StudioUtilities.availableObjects.add(cloned);
                        }
                    }
                });

        // Insert Reference...
        return menu;
    }

    // Find Port under Mouse and Repaint Connector

    public void mouseDragged(MouseEvent e) {
        // If remembered Start Point is Valid
        if (start != null) {
            // Fetch Graphics from Graph
            Graphics g = graph.getGraphics();
            // Reset Remembered Port
            PortView newPort = getTargetPortAt(e.getPoint());
            // Do not flicker (repaint only on real changes)
            if (newPort == null || newPort != port) {
                // Xor-Paint the old Connector (Hide old Connector)
                paintConnector(Color.black, graph.getBackground(), g);
                // If Port was found then Point to Port Location
                port = newPort;
                if (port != null) {
                    current = graph.toScreen(port.getLocation());
                }
                // Else If no Port was found then Point to Mouse Location
                else {
                    current = graph.snap(e.getPoint());
                }
                // Xor-Paint the new Connector
                paintConnector(graph.getBackground(), Color.black, g);
            }
        }
        // Call Superclass
        super.mouseDragged(e);
    }

    public PortView getSourcePortAt(Point2D point) {
        // Disable jumping
        graph.setJumpToDefaultPort(false);
        PortView result;
        try {
            // Find a Port View in Model Coordinates and Remember
            result = graph.getPortViewAt(point.getX(), point.getY());
        } finally {
            graph.setJumpToDefaultPort(true);
        }
        return result;
    }

    // Find a Cell at point and Return its first Port as a PortView

    protected PortView getTargetPortAt(Point2D point) {
        // Find a Port View in Model Coordinates and Remember
        return graph.getPortViewAt(point.getX(), point.getY());
    }

    // Connect the First Port and the Current Port in the Graph or Repaint

    public void mouseReleased(MouseEvent e) {
        // If Valid Event, Current and First Port
        if (e != null && port != null && firstPort != null &&
            firstPort != port) {
            // Show interaction dialog.
            DefaultGraphCell source = (DefaultGraphCell)firstPort.getCell();
            if (source.getParent() instanceof ViewCell) {
                View view =
                    (View)((DefaultGraphCell)source.getParent()).getUserObject();
                //        if (view.getSubmitMethodCount() == 0) {
                //          JOptionPane
                //              .showMessageDialog(XRadApp.xradFrame,
                //                  view.getName()
                //                  + " does not have a submit method and therefore cannot be used as a source of an interaction!");
                //          return;
                //        }
            } else if (source.getParent() instanceof ProcessCell) {
                com.xradsolutions.xrad.xmlbo.Process process =
                    (com.xradsolutions.xrad.xmlbo.Process)((DefaultGraphCell)source.getParent()).getUserObject();
                //        if (process.getReturnValueCount() == 0) {
                //          JOptionPane
                //              .showMessageDialog(XRadApp.xradFrame,
                //                  process.getName()
                //                  + " does not have a return value and therefore cannot be used as a source of an interaction!");
                //          return;
                //        }
            }

            DefaultGraphCell target = (DefaultGraphCell)port.getCell();
            InteractionEdge edge =
                XRadComponentFactory.createInteraction(source, target);

            InteractionDefDialog dialog =
                new InteractionDefDialog(XRadApp.xradFrame, edge);
            if (dialog.submitMethods.size() > 0 ||
                dialog.returnValues.size() > 0) {
                StudioUtilities.center(dialog);
                dialog.setModal(true);
                int choice = dialog.showDialog();
                if (choice == JOptionPane.OK_OPTION) {
                    // Then Establish Connection
                    connect((Port)source, (Port)target, edge);
                    e.consume();
                }
            }
            // Else Repaint the Graph
        } else {
            graph.repaint();
        }
        // Reset Global Vars
        firstPort = port = null;
        start = current = null;
        // Call Superclass
        super.mouseReleased(e);
    }

    private void connect(Port source, Port target, DefaultEdge edge) {
        // TODO Auto-generated method stub
        // Construct Edge with no label
        // DefaultEdge edge = createDefaultEdge();
        if (graph.getModel().acceptsSource(edge, source) &&
            graph.getModel().acceptsTarget(edge, target)) {
            // Create a Map thath holds the attributes for the edge
            edge.getAttributes().applyMap(createEdgeAttributes());
            // Insert the Edge and its Attributes
            //            List points = new ArrayList();
            //            PortView sourceView = (PortView)graph.getGraphLayoutCache().getMapping(source, true);
            //            PortView targetView = (PortView)graph.getGraphLayoutCache().getMapping(target, true);;
            //            Point2D sp = sourceView.getCenterPoint(sourceView);
            //            Point2D tp = targetView.getCenterPoint(targetView) ;
            //            Point2D.Double np = new Point2D.Double();
            //            if(sp.getY() > np.getY()) {
            //                np.setLocation(tp.getX(), sp.getY());
            //            }
            //            else {
            //                np.setLocation(sp.getX(), tp.getY());
            //            }
            //            points.add(sp);
            //            points.add(np);
            //            points.add(tp);
            //            GraphConstants.setPoints(edge.getAttributes(), points);
            graph.getGraphLayoutCache().insertEdge(edge, source, target);
        }
    }

    // Hook for subclassers

    protected DefaultEdge createDefaultEdge() {
        return new DefaultEdge();
    }

    // Hook for subclassers

    public Map createEdgeAttributes() {
        Map map = new Hashtable();
        // Add a Line End Attribute
        GraphConstants.setLineEnd(map, GraphConstants.ARROW_SIMPLE);
        //GraphConstants.setLineStyle(map, GraphConstants.STYLE_SPLINE);
        // Add a label along edge attribute
        GraphConstants.setLabelAlongEdge(map, false);
        GraphConstants.setOpaque(map, true);
        return map;
    }

    // Show Special Cursor if Over Port

    public void mouseMoved(MouseEvent e) {
        // Check Mode and Find Port
        if (e != null && getSourcePortAt(e.getPoint()) != null &&
            graph.isPortsVisible()) {
            // Set Cusor on Graph (Automatically Reset)
            graph.setCursor(new Cursor(Cursor.HAND_CURSOR));
            // Consume Event
            // Note: This is to signal the BasicGraphUI's
            // MouseHandle to stop further event processing.
            e.consume();
        } else {
            // PortView port = getSourcePortAt(e.getPoint());
            // if (port != null) {
            // DefaultGraphCell cell = (DefaultGraphCell) port.getCell();
            // Object object =
            // ((DefaultGraphCell)cell.getParent()).getUserObject();
            // if (object instanceof com.xradsolutions.xrad.xmlbo.View) {
            // graph.setToolTipText(((com.xradsolutions.xrad.xmlbo.View) object)
            // .getDescription());
            // } else if (object instanceof com.xradsolutions.xrad.xmlbo.Process) {
            // graph
            // .setToolTipText(((com.xradsolutions.xrad.xmlbo.Process) object)
            // .getDescription());
            // } else {
            // graph.setToolTipText(null);
            // }
            // }
            // Call Superclass
            super.mouseMoved(e);
        }
    }

    // Use Xor-Mode on Graphics to Paint Connector

    protected void paintConnector(Color fg, Color bg, Graphics g) {
        // Set Foreground
        g.setColor(fg);
        // Set Xor-Mode Color
        g.setXORMode(bg);
        // Highlight the Current Port
        paintPort(graph.getGraphics());
        // If Valid First Port, Start and Current Point
        if (firstPort != null && start != null && current != null) {
            // Then Draw A Line From Start to Current Point
            g.drawLine((int)start.getX(), (int)start.getY(),
                       (int)current.getX(), (int)current.getY());
        }
    }

    // Use the Preview Flag to Draw a Highlighted Port

    protected void paintPort(Graphics g) {
        // If Current Port is Valid
        if (port != null) {
            // If Not Floating Port...
            boolean o =
                (GraphConstants.getOffset(port.getAllAttributes()) != null);
            // ...Then use Parent's Bounds
            Rectangle2D r =
                (o) ? port.getBounds() : port.getParentView().getBounds();
            // Scale from Model to Screen
            r = graph.toScreen((Rectangle2D)r.clone());
            // Add Space For the Highlight Border
            r.setFrame(r.getX() - 3, r.getY() - 3, r.getWidth() + 6,
                       r.getHeight() + 6);
            // Paint Port in Preview (=Highlight) Mode
            graph.getUI().paintCell(g, port, r, true);
        }
    }

} // End of XRadMarqueeHandler
