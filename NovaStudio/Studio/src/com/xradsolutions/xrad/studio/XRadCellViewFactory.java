package com.xradsolutions.xrad.studio;

import java.awt.Color;

import java.util.HashMap;
import java.util.Vector;

import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.DefaultCellViewFactory;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.VertexView;

public class XRadCellViewFactory extends DefaultCellViewFactory {   
    
    JGraph graph = null;
    
    public XRadCellViewFactory(JGraph graph) {
        this.graph = graph;
    }
    
    protected VertexView createVertexView(Object object) {
        VertexView view = super.createVertexView(object);
        GraphLayoutCache cache = graph.getGraphLayoutCache();
        Object[] roots = cache.getRoots();
        for(int i = 0; i < roots.length; i++) {
            if(roots[i] instanceof VertexView) {
                DefaultGraphCell dgcSource = (DefaultGraphCell)((VertexView) roots[i]).getCell();
                DefaultPort sourcePort = (DefaultPort)dgcSource.getChildAt(0);
                Object source = dgcSource.getUserObject();
                for(int j = 0; j < roots.length; j++) {
                    if(roots[j] instanceof VertexView && roots[i] != roots[j]) {
                        DefaultGraphCell dgcTarget = (DefaultGraphCell)((VertexView) roots[j]).getCell();
                        DefaultPort targetPort = (DefaultPort)dgcTarget.getChildAt(0);
                        Object target = dgcTarget.getUserObject();
                        String hash = sourcePort.hashCode() + ":" + targetPort.hashCode();
                        String revHash = targetPort.hashCode() + ":" + sourcePort.hashCode();
                        if(source.equals(target) && !(StudioUtilities.cloneLinks.containsKey(hash) || StudioUtilities.cloneLinks.containsKey(revHash))) {
                            DefaultEdge edge = new DefaultEdge();
                            GraphConstants.setLineColor(edge.getAttributes(), new Color(235,235,235));
                            GraphConstants.setDashPattern(edge.getAttributes(), new float[] {3.0F, 3.0F});
                            GraphConstants.setSelectable(edge.getAttributes(), false);
                            cache.insertEdge(edge, sourcePort, targetPort);
                            StudioUtilities.cloneLinks.put(hash, edge);
                        }
                    }
                }
            }
        }
        
        return view;
    }
}
