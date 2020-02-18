package com.xradsolutions.xrad.codegen.struts.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class StrutsForm {
    String className;
    String identifier;
    String packageName;
    LinkedHashMap<String, StrutsFormProperty> properties = new LinkedHashMap<String, StrutsFormProperty>();
    LinkedHashMap<String, StrutsFormSubmit> submits = new LinkedHashMap<String, StrutsFormSubmit>();

    public StrutsForm() {
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public LinkedHashMap<String, StrutsFormProperty> getProperties() {
        return properties;
    }

    public void setProperties(LinkedHashMap<String, StrutsFormProperty> properties) {
        this.properties = properties;
    }

    public LinkedHashMap<String, StrutsFormSubmit> getSubmits() {
        return submits;
    }

    public void setSubmits(LinkedHashMap<String, StrutsFormSubmit> submits) {
        this.submits = submits;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public String toString() {
        return className;
    }
}
