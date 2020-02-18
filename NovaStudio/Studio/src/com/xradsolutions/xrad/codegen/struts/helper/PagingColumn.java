package com.xradsolutions.xrad.codegen.struts.helper;

public class PagingColumn {
  private String name;
  private String display;
  public PagingColumn() {
    super();
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public String getName() {
    return name;
  }

  public String getDisplay() {
    return display;
  }
}
