package com.xradsolutions.xrad.cg.struts;

import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/*
 * Created by JFormDesigner on Sun Nov 13 01:26:24 AST 2005
 */



/**
 * @author Farrukh Ijaz
 */
public class StrutsCodeGeneratorDialog
    extends JDialog {

  Map templatesMap = new HashMap();

  public StrutsCodeGeneratorDialog(Frame owner) {
    super(owner);
    initComponents();
    updateForm();
  }

  private void updateForm() {
    txtSourceLocation.setText(System.getProperty("com.xradsolutions.xrad.path.src"));
    txtWebModuleLocation.setText(System.getProperty("com.xradsolutions.xrad.path.web"));
    chkOverwriteFiles.setSelected(Boolean.getBoolean(
        "com.xradsolutions.xrad.files.overwrite"));
    Properties templates = new Properties();
    Vector templatesVector = new Vector();
    try {
      templates.load(new FileInputStream("cg/struts/templates.properties"));
      Iterator iter = templates.keySet().iterator();
      while (iter.hasNext()) {
        String key = (String) iter.next();
        String title = templates.getProperty(key);
        templatesMap.put(title, key);
        templatesVector.add(title);
      }
      cbxJSPTemplate.setModel(new DefaultComboBoxModel(templatesVector));
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
  }

  public StrutsCodeGeneratorDialog(Dialog owner) {
    super(owner);
    initComponents();
    updateForm();
  }

  private void initComponents() {
    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
    dialogPane = new JPanel();
    contentPane = new JPanel();
    lblSourceLocation = new JLabel();
    txtSourceLocation = new JTextField();
    btnBrowseSourceLocation = new JButton();
    lblWebModuleLocation = new JLabel();
    txtWebModuleLocation = new JTextField();
    btnBrowseWebModuleLocation = new JButton();
    lblJSPTemplate = new JLabel();
    cbxJSPTemplate = new JComboBox();
    lblOverwriteFiles = new JLabel();
    chkOverwriteFiles = new JCheckBox();
    buttonBar = new JPanel();
    okButton = new JButton();
    cancelButton = new JButton();
    CellConstraints cc = new CellConstraints();

    //======== this ========
    setTitle("Apache Struts 1.1 Code Generation");
    Container contentPane2 = getContentPane();
    contentPane2.setLayout(new BorderLayout());

    //======== dialogPane ========
    {
      dialogPane.setBorder(Borders.DIALOG_BORDER);

      // JFormDesigner evaluation mark
//      dialogPane.setBorder(new javax.swing.border.CompoundBorder(
//          new javax.swing.border.TitledBorder(new javax.swing.border.
//                                              EmptyBorder(0, 0, 0, 0),
//                                              "JFormDesigner Evaluation",
//                                              javax.swing.border.TitledBorder.
//                                              CENTER,
//                                              javax.swing.border.TitledBorder.
//                                              BOTTOM,
//                                              new java.awt.Font("Dialog",
//          java.awt.Font.BOLD, 12),
//                                              java.awt.Color.red),
//          dialogPane.getBorder()));
      dialogPane.addPropertyChangeListener(new java.beans.
                                           PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent e) {
          if ("border".equals(e.getPropertyName())) {
            throw new RuntimeException();
          }
        }
      });

      dialogPane.setLayout(new BorderLayout());

      //======== contentPane ========
      {
        contentPane.setLayout(new FormLayout(
            new ColumnSpec[] {
            FormFactory.DEFAULT_COLSPEC,
            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
            new ColumnSpec(ColumnSpec.FILL, Sizes.DEFAULT,
                           FormSpec.DEFAULT_GROW),
            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
            FormFactory.DEFAULT_COLSPEC
        },
            new RowSpec[] {
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.LINE_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.LINE_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC,
            FormFactory.LINE_GAP_ROWSPEC,
            FormFactory.DEFAULT_ROWSPEC
        }));

        //---- lblSourceLocation ----
        lblSourceLocation.setText("Source Location:");
        contentPane.add(lblSourceLocation,
                        cc.xywh(1, 1, 1, 1, CellConstraints.RIGHT,
                                CellConstraints.DEFAULT));
        contentPane.add(txtSourceLocation, cc.xy(3, 1));

        //---- btnBrowseSourceLocation ----
        btnBrowseSourceLocation.setText("Browse...");
        btnBrowseSourceLocation.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            btnBrowseSourceLocationActionPerformed(e);
          }
        });
        contentPane.add(btnBrowseSourceLocation, cc.xy(5, 1));

        //---- lblWebModuleLocation ----
        lblWebModuleLocation.setText("Web Module Location:");
        contentPane.add(lblWebModuleLocation,
                        cc.xywh(1, 3, 1, 1, CellConstraints.RIGHT,
                                CellConstraints.DEFAULT));
        contentPane.add(txtWebModuleLocation, cc.xy(3, 3));

        //---- btnBrowseWebModuleLocation ----
        btnBrowseWebModuleLocation.setText("Browse...");
        btnBrowseWebModuleLocation.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            btnBrowseWebModuleLocationActionPerformed(e);
          }
        });
        contentPane.add(btnBrowseWebModuleLocation, cc.xy(5, 3));

        //---- lblJSPTemplate ----
        lblJSPTemplate.setText("JSP Template:");
        contentPane.add(lblJSPTemplate,
                        cc.xywh(1, 5, 1, 1, CellConstraints.RIGHT,
                                CellConstraints.DEFAULT));
        contentPane.add(cbxJSPTemplate,
                        cc.xywh(3, 5, 1, 1, CellConstraints.DEFAULT,
                                CellConstraints.DEFAULT));

        //---- lblOverwriteFiles ----
        lblOverwriteFiles.setText("Overwrite Files?");
        contentPane.add(lblOverwriteFiles,
                        cc.xywh(1, 7, 1, 1, CellConstraints.RIGHT,
                                CellConstraints.DEFAULT));

        //---- chkOverwriteFiles ----
        chkOverwriteFiles.setText("No");
        chkOverwriteFiles.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            chkOverwriteFilesActionPerformed(e);
          }
        });
        contentPane.add(chkOverwriteFiles, cc.xy(3, 7));
      }
      dialogPane.add(contentPane, BorderLayout.CENTER);

      //======== buttonBar ========
      {
        buttonBar.setBorder(Borders.BUTTON_BAR_GAP_BORDER);
        buttonBar.setLayout(new FormLayout(
            new ColumnSpec[] {
            FormFactory.GLUE_COLSPEC,
            FormFactory.BUTTON_COLSPEC,
            FormFactory.RELATED_GAP_COLSPEC,
            FormFactory.BUTTON_COLSPEC
        },
            RowSpec.decodeSpecs("pref")));

        //---- okButton ----
        okButton.setText("Generate!");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            okButtonActionPerformed(e);
          }
        });
        buttonBar.add(okButton, cc.xy(2, 1));

        //---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            cancelButtonActionPerformed(e);
          }
        });
        buttonBar.add(cancelButton, cc.xy(4, 1));
      }
      dialogPane.add(buttonBar, BorderLayout.SOUTH);
    }
    contentPane2.add(dialogPane, BorderLayout.CENTER);
    // JFormDesigner - End of component initialization  //GEN-END:initComponents
  }

  private void btnBrowseSourceLocationActionPerformed(ActionEvent e) {
    JFileChooser chooser = new JFileChooser(txtSourceLocation.getText());
    chooser.setFileFilter(new FolderFilter());
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int choice = chooser.showDialog(this, "Source Location");
    if (choice == JFileChooser.APPROVE_OPTION) {
      txtSourceLocation.setText(chooser.getSelectedFile().getPath());
      System.setProperty("com.xradsolutions.xrad.path.src", txtSourceLocation.getText());
    }
  }

  private void btnBrowseWebModuleLocationActionPerformed(ActionEvent e) {
    JFileChooser chooser = new JFileChooser(txtSourceLocation.getText());
    chooser.setFileFilter(new FolderFilter());
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int choice = chooser.showDialog(this, "Web Module Location");
    if (choice == JFileChooser.APPROVE_OPTION) {
      txtWebModuleLocation.setText(chooser.getSelectedFile().getPath());
      System.setProperty("com.xradsolutions.xrad.path.web", txtWebModuleLocation.getText());
    }
  }

  private void chkOverwriteFilesActionPerformed(ActionEvent e) {
    if (chkOverwriteFiles.isSelected()) {
      chkOverwriteFiles.setText("Yes");
      System.setProperty("com.xradsolutions.xrad.files.overwrite", "true");
    }
    else {
      chkOverwriteFiles.setText("No");
      System.setProperty("com.xradsolutions.xrad.files.overwrite", "false");
    }
  }

  private void okButtonActionPerformed(ActionEvent e) {
    System.setProperty("com.xradsolutions.xrad.path.src", txtSourceLocation.getText());
    System.setProperty("com.xradsolutions.xrad.path.web", txtWebModuleLocation.getText());
    System.setProperty("com.xradsolutions.xrad.path.web.template",
                       (String) templatesMap.get(cbxJSPTemplate.getSelectedItem()));
    System.setProperty("com.xradsolutions.xrad.files.overwrite",
                       Boolean.toString(chkOverwriteFiles.isSelected()));
    selection = JOptionPane.OK_OPTION;
    setVisible(false);
  }

  private void cancelButtonActionPerformed(ActionEvent e) {
    selection = JOptionPane.CANCEL_OPTION;
    setVisible(false);
  }

  // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
  // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
  private JPanel dialogPane;
  private JPanel contentPane;
  private JLabel lblSourceLocation;
  private JTextField txtSourceLocation;
  private JButton btnBrowseSourceLocation;
  private JLabel lblWebModuleLocation;
  private JTextField txtWebModuleLocation;
  private JButton btnBrowseWebModuleLocation;
  private JLabel lblJSPTemplate;
  private JComboBox cbxJSPTemplate;
  private JLabel lblOverwriteFiles;
  private JCheckBox chkOverwriteFiles;
  private JPanel buttonBar;
  private JButton okButton;
  private JButton cancelButton;
  // JFormDesigner - End of variables declaration  //GEN-END:variables

  int selection = JOptionPane.CANCEL_OPTION;

  class FolderFilter
      extends FileFilter {

    public boolean accept(File arg0) {
      // TODO Auto-generated method stub
      if (arg0.isDirectory()) {
        return true;
      }
      return false;
    }

    public String getDescription() {
      // TODO Auto-generated method stub
      return "Directory";
    }
  }

  public int showDialog() {
    setVisible(true);
    try {
      return selection;
    }
    finally {
      dispose();
    }
  }
}
