package com.xradsolutions.xrad;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public class XRadUtilities {

      /**
       * This method centers a window with respect to screen.
       *
       * @param window
       */
    //      public static void center(Window window) {
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
      return valid;
    }

    public static boolean checkIdValidity(String id, Object object) {
      boolean valid = true;
      if (id.indexOf(" ") != -1) {
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

    public static final String XRAD_HOME = (System.getProperty("XRAD_HOME") != null) ? System.getProperty("XRAD_HOME") : System.getenv("XRAD_HOME");
    public static final String TEMPLATES = (System.getProperty("templates") != null) ? System.getProperty("templates") : System.getenv("templates");


}
