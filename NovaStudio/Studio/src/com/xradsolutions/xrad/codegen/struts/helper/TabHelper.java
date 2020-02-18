package com.xradsolutions.xrad.codegen.struts.helper;

import java.text.*;
import java.util.*;

public class TabHelper {
  private DescriptionHelper descHelper;

  private MessageFormat format = new MessageFormat("[tab:{0}({1})]");
  private MessageFormat paneFormat = new MessageFormat("{0}:{1}<{2}:{3}>");
  private String text;
  private String name;
  private HashMap panes = new HashMap();

  public TabHelper(DescriptionHelper descHelper,String text) throws
      TabHelperException {
    this.text = text;
    this.descHelper = descHelper;
    initailize();
  }

  /**
   * initailize
   */
  private void initailize() throws TabHelperException {
    try {
      Object[] obj = format.parse(text);
      this.name = (String) obj[0];
      String[] panesText = ((String) obj[1]).split(",");
      for(int i = 0 ; i <panesText.length;i++) {
        Pane pane = new Pane(panesText[i]);
        panes.put(pane.getPaneName(),pane);
      }

    }
    catch (ParseException ex) {
      throw new TabHelperException(ex);
    }
  }

  public String getName() throws TabHelperException {
    return this.name;
  }

  public HashMap getPanes() {
    return this.panes;
  }

  public class Pane {
    private String paneName;
    private String paneDisplay;
    private String paneContent;
    private String paneContentType;
    private int start;
    private boolean noLimit;
    private int end;

    public Pane(String paneText) throws ParseException {
      Object[] obj = paneFormat.parse(paneText);
      this.paneName = (String) obj[0];
      this.paneDisplay = (String) obj[1];
      this.paneContentType = (String) obj[2];
      this.paneContent = (String) obj[3];
      if(paneContentType.equals("form")) {
        String[] d = paneContent.split("-");
        this.start = Integer.parseInt(d[0]);
        if(d[1].equals("*")) {
          this.noLimit = true;
        } else {
          this.end = Integer.parseInt(d[1]);
        }
      }
    }

    public String getPaneName() {
      return this.paneName;
    }

    public String getPaneDisplay() {
      return this.paneDisplay;
    }

    public String getContentType() {
      return this.paneContentType;
    }

    public String getContent() {
      return paneContent;
    }

    public int getStart() {
      return this.start;
    }

    public int getEnd() {
      return this.end;
    }

    public boolean isNoLimit() {
      return noLimit;
    }

  }

}
