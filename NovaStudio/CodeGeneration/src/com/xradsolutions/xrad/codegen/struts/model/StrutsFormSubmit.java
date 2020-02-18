package com.xradsolutions.xrad.codegen.struts.model;

public class StrutsFormSubmit {
    String name;
    String title;
    String controlType;
    boolean rendered;

    public StrutsFormSubmit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public String toString() {
        return name;
    }    
}
