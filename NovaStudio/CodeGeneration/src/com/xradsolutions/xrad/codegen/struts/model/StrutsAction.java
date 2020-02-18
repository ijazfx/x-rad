package com.xradsolutions.xrad.codegen.struts.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class StrutsAction {
    String className;
    String identifier;
    String packageName;
    boolean backingAction;
    LinkedHashMap<String, StrutsActionForward> forwards = new LinkedHashMap<String, StrutsActionForward>();
    LinkedHashMap<String, StrutsForm> inboundActionForms = new LinkedHashMap<String, StrutsForm>();
    LinkedHashMap<String, StrutsForm> outboundActionForms = new LinkedHashMap<String, StrutsForm>();

    public StrutsAction() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public LinkedHashMap<String, StrutsActionForward> getForwards() {
        return forwards;
    }

    public void setForwards(LinkedHashMap<String, StrutsActionForward> forwards) {
        this.forwards = forwards;
    }

    public String toString() {
        return className;
    }

    public boolean isBackingAction() {
        return backingAction;
    }

    public void setBackingAction(boolean backingAction) {
        this.backingAction = backingAction;
    }

    public LinkedHashMap<String, StrutsForm> getInboundActionForms() {
        return inboundActionForms;
    }

    public void setInboundActionForms(LinkedHashMap<String, StrutsForm> inboundActionForms) {
        this.inboundActionForms = inboundActionForms;
    }

    public LinkedHashMap<String, StrutsForm> getOutboundActionForms() {
        return outboundActionForms;
    }

    public void setOutboundActionForms(LinkedHashMap<String, StrutsForm> outboundActionForms) {
        this.outboundActionForms = outboundActionForms;
    }

    public String getNIdentifier() {
      if(backingAction) {
        return identifier.substring(0,identifier.length()-"FormAction".length());
      } else{
        return identifier;
      }
    }
}
