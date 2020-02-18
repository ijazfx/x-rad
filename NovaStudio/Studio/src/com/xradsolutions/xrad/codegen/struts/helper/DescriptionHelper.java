package com.xradsolutions.xrad.codegen.struts.helper;

import java.util.*;

public class DescriptionHelper {
  private String desc;
  private HashMap pagings = new HashMap();
  private HashMap tabs = new HashMap();
  private boolean generateReport;

  public DescriptionHelper(String desc) throws PagingHelperException,
      TabHelperException {
    this.desc = desc;
    initialize();

  }

  /**
   * initialize
   */
  private void initialize() throws PagingHelperException, TabHelperException {
    String[] elements = desc.split("[+]");
    for(int i=0;i<elements.length;i++) {
      String temp = elements[i].trim();
      if(temp.startsWith("[paging:")) {
        PagingHelper pagingHelper = new PagingHelper(temp);
        pagings.put(pagingHelper.getName(),pagingHelper);
      } else if (temp.startsWith("[tab:")){
        TabHelper tabHelper = new TabHelper(this,temp);
        tabs.put(tabHelper.getName(),tabHelper);
      } else if (temp.startsWith("[Report")) {
        generateReport = true;
      }
    }
  }

  public HashMap getPagings() {
    return pagings;
  }

  public HashMap getTabs() {
    return tabs;
  }

  public boolean hasPaging() {
    return !pagings.isEmpty();
  }

  public boolean hasTabs() {
    return !tabs.isEmpty();
  }

  public boolean hasReport() {
    return this.generateReport;
  }

/*  public boolean isPaging(String text) {
    return PagingHelper.isPaging(text);
  }

  public PagingHelper getPagingHelper(String text) {
    return new PagingHelper(text);
  }*/
}
