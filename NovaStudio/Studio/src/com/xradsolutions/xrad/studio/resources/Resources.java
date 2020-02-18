package com.xradsolutions.xrad.studio.resources;

import java.io.*;

import javax.swing.*;

public interface Resources {

  /**
   * This is the global static variable of the source folder.
   */
  public static File srcFolder = null;

  /**
   * This is the global static variable of the web folder.
   */
  public static File webFolder = null;

  /**
   * This constant defines the package where all the resources such as images
   * are placed.
   */
  String RESOURCE_PACKAGE = "";

  /**
   * This is the application title. It appears on the main frame of the ide.
   */
  String APP_TITLE = "NOVA Web Applications 2006 (Beta)";

  /**
   * This constant is used for application frame's icon and appears on the
   * main frame's title bar.
   */
  ImageIcon APP_ICON = new ImageIcon(Resources.class
                                     .getResource(RESOURCE_PACKAGE +
                                                  "S_B_BOOK.gif"));

  /**
   * This constant is used for view component, button and dialog.
   */
//  ImageIcon VIEW_ICON = new ImageIcon(Resources.class
//                                      .getResource(RESOURCE_PACKAGE +
//      "S_PERSET.gif"));

    ImageIcon VIEW_ICON = new ImageIcon(Resources.class
                                        .getResource(RESOURCE_PACKAGE +
        "view.gif"));


    ImageIcon VIEW_ICON_LARGE = new ImageIcon(Resources.class
                                        .getResource(RESOURCE_PACKAGE +
        "large/view.png"));


  /**
   * This constant is used for process component, button and dialog.
   */
//  ImageIcon PROCESS_ICON = new ImageIcon(Resources.class
//                                         .getResource(RESOURCE_PACKAGE +
//      "S_B_OPER.gif"));
    ImageIcon PROCESS_ICON = new ImageIcon(Resources.class
                                           .getResource(RESOURCE_PACKAGE +
        "process.gif"));

    ImageIcon PROCESS_ICON_LARGE = new ImageIcon(Resources.class
                                        .getResource(RESOURCE_PACKAGE +
        "large/process.png"));

  /**
   * This constant is used for link button and dialog.
   */
  ImageIcon LINK_ICON = new ImageIcon(Resources.class
                                      .getResource(RESOURCE_PACKAGE +
      "S_CLCOSP.gif"));

  /**
   * This constant is used fro delete button.
   */
  ImageIcon DELETE_ICON = new ImageIcon(Resources.class
                                        .getResource(RESOURCE_PACKAGE +
      "S_B_DELE.gif"));

  /**
   * This constant is used for generate code button.
   */
  ImageIcon GEN_CODE_ICON = new ImageIcon(Resources.class
                                          .getResource(RESOURCE_PACKAGE +
      "S_B_INPA.gif"));

  /**
   * This constant is used for save button.
   */
  ImageIcon SAVE_ICON = new ImageIcon(Resources.class
                                      .getResource(RESOURCE_PACKAGE +
      "S_WRITFI.gif"));

  ImageIcon OPEN_ICON = new ImageIcon(Resources.class
                                      .getResource(RESOURCE_PACKAGE +
      "S_OBJFOL.gif"));

  ImageIcon GRID_ICON = new ImageIcon(Resources.class
                                      .getResource(RESOURCE_PACKAGE +
      "grid-small.gif"));

  ImageIcon SNAP_ICON = new ImageIcon(Resources.class
                                      .getResource(RESOURCE_PACKAGE +
      "snap-small.gif"));

  ImageIcon ZOOMIN_ICON = new ImageIcon(Resources.class
                                        .getResource(RESOURCE_PACKAGE +
      "mn-zoom_in.gif"));

  ImageIcon ZOOMOUT_ICON = new ImageIcon(Resources.class
                                         .getResource(RESOURCE_PACKAGE +
      "mn-zoom_out.gif"));

  ImageIcon ZOOM1BY1_ICON = new ImageIcon(Resources.class
                                          .getResource(RESOURCE_PACKAGE +
      "mn-zoom_1_1.gif"));

}
