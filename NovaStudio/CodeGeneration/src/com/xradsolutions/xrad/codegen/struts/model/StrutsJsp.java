package com.xradsolutions.xrad.codegen.struts.model;

import java.util.*;

public class StrutsJsp {
    String jspFile;
    String jspTemplate;
    boolean isGenerateSeparateLinksJsp;
    String linksJspFile;
    String linksJspTemplate;
    String title;
    String location;
    boolean useTilesFramework;
    String tilesBaseDefinition;
    LinkedHashMap<String, String>puts = new LinkedHashMap<String, String>();
    StrutsForm backingForm;
    StrutsAction backingAction;
  private String description;
  public StrutsJsp() {
    }

    public String getTilesBaseDefinition() {
        return tilesBaseDefinition;
    }

    public void setTilesBaseDefinition(String template) {
        this.tilesBaseDefinition = template;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return jspFile;
    }

    public String getJspFile() {
        return jspFile;
    }

    public void setJspFile(String jspFile) {
        this.jspFile = jspFile;
    }

    public String getJspTemplate() {
        return jspTemplate;
    }

    public void setJspTemplate(String jspTemplate) {
        this.jspTemplate = jspTemplate;
    }

    public boolean isGenerateSeparateLinksJsp() {
        return isGenerateSeparateLinksJsp;
    }

    public void setGenerateSeparateLinksJsp(boolean generateSeparateLinksJsp) {
        isGenerateSeparateLinksJsp = generateSeparateLinksJsp;
    }

    public String getLinksJspTemplate() {
        return linksJspTemplate;
    }

    public void setLinksJspTemplate(String linksJspTemplate) {
        this.linksJspTemplate = linksJspTemplate;
    }

    public String getLinksJspFile() {
        return linksJspFile;
    }

    public void setLinksJspFile(String linksJspFile) {
        this.linksJspFile = linksJspFile;
    }

    public StrutsForm getBackingForm() {
        return backingForm;
    }

    public void setBackingForm(StrutsForm backingForm) {
        this.backingForm = backingForm;
    }

    public LinkedHashMap<String, String> getPuts() {
        return puts;
    }

    public void setPuts(LinkedHashMap<String, String> puts) {
        this.puts = puts;
    }

    public StrutsAction getBackingAction() {
        return backingAction;
    }

    public void setBackingAction(StrutsAction backingAction) {
        this.backingAction = backingAction;
    }

    public boolean isUseTilesFramework() {
        return useTilesFramework;
    }

  public String getDescription() {
    return description;
  }

  public void setUseTilesFramework(boolean useTilesFramework) {
        this.useTilesFramework = useTilesFramework;
    }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFileName() {
    return jspFile.substring(0,jspFile.indexOf("."));
  }

  public String getIdentifier() {
    String jsp = jspFile.substring(0,jspFile.indexOf("."));
    return "" + Character.toLowerCase(jsp.charAt(0)) + jsp.substring(1);
  }

}
