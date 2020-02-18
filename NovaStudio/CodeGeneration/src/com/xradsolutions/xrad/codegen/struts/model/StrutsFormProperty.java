package com.xradsolutions.xrad.codegen.struts.model;

public class StrutsFormProperty {
    String name;
    String dataType;
    String controlType;
    String label;
    boolean rendered;
    boolean readonly;
    boolean required;
    String[] valueRange;
    String initValue;

    public StrutsFormProperty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String[] getValueRange() {
        return valueRange;
    }

    public void setValueRange(String[] valueRange) {
        this.valueRange = valueRange;
    }


    public String getInitValue() {
        return initValue;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
    }
    
    public String toString() {
        return name + ": " + dataType;
    }
    
}
