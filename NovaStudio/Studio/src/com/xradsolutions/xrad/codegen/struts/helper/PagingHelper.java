package com.xradsolutions.xrad.codegen.struts.helper;

import java.text.*;
import java.util.*;

public class PagingHelper {
  private String text;

  private static MessageFormat format = new MessageFormat("[paging:{0}({1})]");
  private static MessageFormat column = new MessageFormat("{0}:{1}");

  public PagingHelper(String text) {
    this.text = text;
  }

  public String getName() throws PagingHelperException {
    try {
      Object[] obj = format.parse(text);
      //obj = listing.parse((String)obj[0]);
      return (String) obj[0];
    }
    catch (ParseException ex) {
      throw new PagingHelperException(ex);
    }
  }

  public Collection getItems() throws PagingHelperException {
    try {
      Object[] obj = format.parse(text);
      //obj = listing.parse((String)obj[0]);
      String[] items = ((String)obj[1]).split(",");
      Vector vector = new Vector();
      for(int i=0;i<items.length;i++) {
        vector.add(getItem(items[i]));
      }
      return vector;
    }
    catch (ParseException ex) {
      throw new PagingHelperException(ex);
    }
  }

  /**
   * getItem
   *
   * @param string String
   * @return E
   */
  private PagingColumn getItem(String string) throws PagingHelperException {
    try {
      Object[] obj;
      PagingColumn col = new PagingColumn();
      if(string.indexOf(":") >-1) {
        obj = column.parse(string);
        col.setName((String)obj[0]);
        col.setDisplay((String)obj[1]);
      } else {
        col.setName(string);
        col.setDisplay(HelperUtilities.generateTitle(string));
      }
      return col;
    }
    catch (ParseException ex) {
      throw new PagingHelperException(ex);
    }
  }



  public static boolean isPaging(String text) {
    if(text.startsWith("[paging")) return true;
    return false;
/*    try {
      format.parse(text);
      return true;
    }
    catch (ParseException ex) {
      return false;
    }*/
  }

  public static void main(String[] args) throws PagingHelperException {
    String t = "[paging:projects(projectId:Project ID,projectTitle:Title,owner,date:Created Date)]";
    PagingHelper p = new PagingHelper(t);
    System.out.println(p.getName());
    p.getItems();
  }


}
