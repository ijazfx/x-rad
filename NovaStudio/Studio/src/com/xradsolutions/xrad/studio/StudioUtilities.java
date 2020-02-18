/**
 * File: StudioUtilities.java
 * Purpose: This class provides some utility methods for the x-rad-ide.</br>
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

import java.util.*;

import java.awt.*;

/**
 * This class contains some utility methods for x-rad-ide such as center the
 * frame on the screen.
 *
 * @author ijazfx
 *
 */
public class StudioUtilities {

  /**
   * This constant is used to get and set folder where the java source will be
   * stored.
   */
  public static final String SRC_FOLDER = "com.xradsolutions.xrad.path.src";

  /**
   * This constant is used to get and set folder of the web module. This
   * folder must have WEB-INF as its immediate sub-folder.
   */
  public static final String WEB_FOLDER = "com.xradsolutions.xrad.path.web";

  public static final String XRD_FILE = "com.xradsolutions.xrad.file.xrd";

  /**
   * This constant is used to get and set the look and feel for this ide.
   */
  public static final String LOOK_AND_FEEL = "com.xradsolutions.xrad.ide.laf";

  /**
   * This constant is used to get and set the properties file that can be used
   * when the ide runs in as standalone application.
   */
  public static final String XRAD_PROPERTIES = "com.xradsolutions.xrad.ide.properties";

  public static final String APP_NAME = "com.xradsolutions.xrad.app.name";
  public static final String APP_PACKAGE = "com.xradsolutions.xrad.app.package";
  public static final String APP_TITLE = "NOVA Web Applications 2006 (Beta)";
  public static final String APP_VERSION = "com.xradsolutions.xrad.app.version";
  public static final String APP_DESCRIPTION =
      "com.xradsolutions.xrad.app.description";

  public static Vector packages = new Vector();

  public static Vector scenarios = new Vector();

  public static Vector stereoTypes = new Vector();

  public static Map usedClassNames = new HashMap();
  public static Vector availableObjects = new Vector();

  public static Map usedIds = new HashMap();

  public static Vector usedNavigations = new Vector();

  public static HashMap cloneLinks = new HashMap();

  public static Vector foundObjects = new Vector();
  public static int selectedObjectIndex = -1;

  public static int submitCount = 0;
  public static int propertyCount = 0;
  public static int returnValueCount = 0;

  /**
   * This method centers a window with respect to screen.
   *
   * @param window
   */
//	public static void center(Window window) {
  public static void center(Component window) {
    // Get the dimensions of the screen.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Get the dimentions for the window.
    Dimension frameSize = window.getSize();
    // Set the frame size to screen size if it's bigger than screen size.
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    // Set the location of the window as centered on the screen.
    window.setLocation( (screenSize.width - frameSize.width) / 2,
                       (screenSize.height - frameSize.height) / 2);
  }

  public static boolean checkPackageNameValidity(String packageName) {
    boolean valid = true;
    if (!packageName.equals(packageName.toLowerCase())) {
      valid = false;
    }
    if (packageName.endsWith(".")) {
      valid = false;
    }
    if (packageName.indexOf(" ") != -1) {
      valid = false;
    }
    return valid;
  }

  public static boolean checkClassNameValidity(String className, Object object) {
    boolean valid = true;
    if (className.indexOf(" ") != -1) {
      valid = false;
    }
    Object temp = StudioUtilities.usedClassNames.get(className);
    if (temp != null && !temp.equals(object)) {
      valid = false;
    }
    return valid;
  }

  public static boolean checkIdValidity(String id, Object object) {
    boolean valid = true;
    if (id.indexOf(" ") != -1) {
      valid = false;
    }
    Object temp = StudioUtilities.usedIds.get(id);
    if (temp != null && !temp.equals(object)) {
      valid = false;
    }
    return valid;
  }

  public static String generateId(String name) {
    // TODO Auto-generated method stub
    if (name != null && name.length() > 0) {
      String[] parts = name.split("[.]");
      String temp = parts[parts.length - 1];
      String id = temp.toLowerCase().substring(0, 1)
          + temp.substring(1, temp.length());
      if (temp.equals(id)) {
        id = id + "1";
      }
      return id;
    }
    return "";
  }

  public static String generateTitle(String name) {
    StringBuffer title = new StringBuffer();
    if (name.length() > 0) {
      title.append(name.toUpperCase().charAt(0));
    }
    for (int i = 1; i < name.length(); i++) {
      char ch = name.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        title.append(" ");
      }
      title.append(ch);
    }
    return title.toString().trim();
  }

  public static String normalizeId(String id) {
    StringBuffer normalized = new StringBuffer();
    if (id != null) {
      String trimmed = id.trim();
      for (int i = 0; i < trimmed.length(); i++) {
        char ch = trimmed.charAt(i);
        if (i == 0 && (ch >= 'A' && ch <= 'Z')) {
          normalized.append(trimmed.toLowerCase().charAt(i));
        }
        else {
          if (ch != ' ') {
            normalized.append(ch);
          }
        }
      }
    }
    return normalized.toString();
  }
}
