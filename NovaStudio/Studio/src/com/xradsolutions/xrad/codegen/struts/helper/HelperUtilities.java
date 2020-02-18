package com.xradsolutions.xrad.codegen.struts.helper;


public class HelperUtilities {
  public HelperUtilities() {
    super();
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

}
