package com.xradsolutions.xrad.studio;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import org.jgraph.graph.*;
import com.borland.plaf.borland.*;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyKrupp;

public class XRadApp {

  static XRadFrame xradFrame = null;

  public static void main(String[] args) {
    Plastic3DLookAndFeel laf = new Plastic3DLookAndFeel();
    laf.setMyCurrentTheme(new SkyKrupp());
    laf.setTabStyle(Plastic3DLookAndFeel.TAB_STYLE_METAL_VALUE);
//    BorlandLookAndFeel laf = new BorlandLookAndFeel();

    try {
      UIManager.setLookAndFeel(laf);
    }
    catch (UnsupportedLookAndFeelException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    xradFrame = new XRadFrame();
    xradFrame.pack();
        StudioUtilities.center(xradFrame);
    xradFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    xradFrame.setVisible(true);
  }

  public static DefaultGraphCell createVertex(String name, double x,
                                              double y, double w, double h,
                                              Color bg, boolean raised) {

    // Create vertex with the given name
    DefaultGraphCell cell = new DefaultGraphCell(name);

    // Set bounds
    GraphConstants.setBounds(cell.getAttributes(), new Rectangle2D.Double(
        x, y, w, h));

    // Set fill color
    if (bg != null) {
      GraphConstants.setGradientColor(cell.getAttributes(), Color.orange);
      GraphConstants.setOpaque(cell.getAttributes(), true);
    }

    // Set raised border
    if (raised) {
      GraphConstants.setBorder(cell.getAttributes(), BorderFactory
                               .createRaisedBevelBorder());
    }
    else {
      // Set black border
      GraphConstants.setBorderColor(cell.getAttributes(), Color.black);
    }

    // Add a Port
    DefaultPort port = new DefaultPort();
    cell.add(port);
    port.setParent(cell);

    return cell;
  }

}
