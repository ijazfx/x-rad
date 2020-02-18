/**
 * File: InteractionEdge.java
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

import com.xradsolutions.xrad.xmlbo.Interaction;

import org.jgraph.graph.*;

/**
 * @author Ijaz
 *
 */
public class InteractionEdge
    extends DefaultEdge {

  DefaultGraphCell sourceCell;

  DefaultGraphCell targetCell;

    public InteractionEdge() {
        GraphConstants.setLineEnd(getAttributes(), GraphConstants.ARROW_SIMPLE);
        //GraphConstants.setLineStyle(map, GraphConstants.STYLE_SPLINE);
        // Add a label along edge attribute
        GraphConstants.setLabelAlongEdge(getAttributes(), true);
        GraphConstants.setOpaque(getAttributes(), true);    
    }

  /*
   * (non-Javadoc)
   *
   * @see javax.swing.tree.DefaultMutableTreeNode#toString()
   */
  public String toString() {
    Interaction interaction = (Interaction) getUserObject();
    String label = "???";
    if (interaction != null) {
      label = "on " + interaction.toString();
      if (targetCell instanceof ViewCell) {
        label += " renders";
      }
      else if (targetCell instanceof ProcessCell) {
        label += " invokes";
      }
    }
    return label;
  }

  /**
   * @return Returns the sourceCell.
   */
  public DefaultGraphCell getSourceCell() {
    return sourceCell;
  }

  /**
   * @param sourceCell
   *            The sourceCell to set.
   */
  public void setSourceCell(DefaultGraphCell sourceCell) {
    this.sourceCell = sourceCell;
  }

  /**
   * @return Returns the targetCell.
   */
  public DefaultGraphCell getTargetCell() {
    return targetCell;
  }

  /**
   * @param targetCell
   *            The targetCell to set.
   */
  public void setTargetCell(DefaultGraphCell targetCell) {
    this.targetCell = targetCell;
  }
}
