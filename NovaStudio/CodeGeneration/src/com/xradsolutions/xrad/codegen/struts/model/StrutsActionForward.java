package com.xradsolutions.xrad.codegen.struts.model;

import javax.swing.JPanel;

public class StrutsActionForward {
    String name;
    String path;
    boolean global;

    public StrutsActionForward() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String toString() {
        return name + " ->" + path;
    }

    public String getNPath() {
      if(path.endsWith("FormAction.do")) {
        return path.substring(0,path.length()-"FormAction.do".length())+".do";
      } else
        return path;
    }

}
