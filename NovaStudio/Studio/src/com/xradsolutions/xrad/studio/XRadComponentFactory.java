/**
 * File: ComponentFactory.java
 * Purpose: ???</br>
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

import com.xradsolutions.xrad.studio.resources.Resources;
import com.xradsolutions.xrad.xmlbo.View;

import java.awt.geom.*;

import org.jgraph.graph.*;

/**
 * @author Ijaz
 *
 */
public class XRadComponentFactory {

  public static ViewCell createView(View view) {
    ViewCell cell = new ViewCell();
    cell.add(new DefaultPort());
    Rectangle2D rect = new Rectangle2D.Double();
    rect.getBounds().setSize(100, 100);
    GraphConstants.setBounds(cell.getAttributes(), rect);
    //GraphConstants.setAutoSize(cell.getAttributes(), true);
    GraphConstants.setResize(cell.getAttributes(),true);
    GraphConstants.setIcon(cell.getAttributes(), Resources.VIEW_ICON_LARGE);
    cell.setUserObject(view);
    return cell;
  }

  public static ProcessCell createProcess(
      com.xradsolutions.xrad.xmlbo.Process process) {
    ProcessCell cell = new ProcessCell();
    cell.add(new DefaultPort());
    Rectangle2D rect = new Rectangle2D.Double();
    rect.getBounds().setSize(100, 100);
    //GraphConstants.setAutoSize(cell.getAttributes(), true);
    GraphConstants.setResize(cell.getAttributes(),true);
    GraphConstants.setIcon(cell.getAttributes(), Resources.PROCESS_ICON_LARGE);
    cell.setUserObject(process);
    return cell;
  }

  public static InteractionEdge createInteraction(
      DefaultGraphCell source, DefaultGraphCell target) {
    InteractionEdge cell = new InteractionEdge();
    cell.setSource(source);
    cell.setSourceCell( (DefaultGraphCell) source.getParent());
    cell.setTarget(target);
    cell.setTargetCell( (DefaultGraphCell) target.getParent());
    return cell;
  }

}
