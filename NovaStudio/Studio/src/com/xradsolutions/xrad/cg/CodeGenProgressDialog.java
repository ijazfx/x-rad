package com.xradsolutions.xrad.cg;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/*
 * Created by JFormDesigner on Wed Oct 19 23:02:40 AST 2005
 */



/**
 * @author Farrukh Ijaz
 */
public class CodeGenProgressDialog
    extends JDialog {
  public CodeGenProgressDialog(Frame owner) {
    super(owner);
    initComponents();
  }

  public CodeGenProgressDialog(Dialog owner) {
    super(owner);
    initComponents();
  }

  private void initComponents() {
    setSize(new Dimension(300, 100));
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
    pbCodeGeneration = new JProgressBar();
    CellConstraints cc = new CellConstraints();

    //======== this ========
    setModal(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setTitle("Code Generation In Progress...");
    Container contentPane = getContentPane();
    contentPane.setLayout(new FormLayout(
        new ColumnSpec[] {
        FormFactory.UNRELATED_GAP_COLSPEC,
        FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
        new ColumnSpec(ColumnSpec.CENTER, Sizes.DEFAULT, FormSpec.DEFAULT_GROW),
        FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
        FormFactory.UNRELATED_GAP_COLSPEC
    },
        new RowSpec[] {
        new RowSpec(RowSpec.CENTER, Sizes.DEFAULT, FormSpec.DEFAULT_GROW),
        FormFactory.LINE_GAP_ROWSPEC,
        FormFactory.DEFAULT_ROWSPEC,
        FormFactory.LINE_GAP_ROWSPEC,
        new RowSpec(RowSpec.CENTER, Sizes.DEFAULT, FormSpec.DEFAULT_GROW)
    }));

    //---- pbCodeGeneration ----
    pbCodeGeneration.setIndeterminate(true);
    contentPane.add(pbCodeGeneration,
                    cc.xywh(3, 3, 1, 1, CellConstraints.FILL,
                            CellConstraints.DEFAULT));
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
  }

  // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
  // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
  private JProgressBar pbCodeGeneration;
  // JFormDesigner - End of variables declaration  //GEN-END:variables
}
