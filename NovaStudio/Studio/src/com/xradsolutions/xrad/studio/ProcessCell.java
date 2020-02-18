/**
 * File: ProcessCell.java
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

import com.xradsolutions.xrad.xmlbo.Process;
import org.jgraph.graph.*;

/**
 * @author Ijaz
 *
 */
public class ProcessCell
    extends DefaultGraphCell {

  public String getToolTipString() {
     return toString();
  }

  /*
   * (non-Javadoc)
   *
   * @see javax.swing.tree.DefaultMutableTreeNode#toString()
   */
  public String toString() {
    // TODO Auto-generated method stub
    com.xradsolutions.xrad.xmlbo.Process process = (Process) getUserObject();
    return process.getName();
  }

}
