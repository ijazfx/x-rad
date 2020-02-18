package com.xradsolutions.xrad.studio;

import com.xradsolutions.xrad.xmlbo.AppModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/*
 * Created by JFormDesigner on Wed Nov 09 20:20:56 AST 2005
 */

/**
 * @author Farrukh Ijaz
 */
public class XRadApplicationDialog
    extends JDialog {

  boolean commit = false;
  AppModel config;

  public XRadApplicationDialog(Frame owner, AppModel config) {
    super(owner);
    initComponents();
    this.config = config;
    updateFromConfig();
  }

  public XRadApplicationDialog(Dialog owner, AppModel config) {
    super(owner);
    initComponents();
    this.config = config;
    updateFromConfig();
  }

  private void updateFromConfig() {
    if (config == null) {
      config = new AppModel();
      config.setAuthor(System.getProperty("user.name"));
    }
    txtApplicationTitle.setText(config.getTitle());
    txtBasePackage.setText(config.getPackageName());
    txtVersion.setText(config.getVersion());
    txtAuthor.setText(config.getAuthor());
    txtCompany.setText(config.getCompany());
  }

  private void initComponents() {
    setSize(new Dimension(500, 225));
    // JFormDesigner - Component initialization - DO NOT MODIFY
    // //GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
    dialogPane = new JPanel();
    contentPane = new JPanel();
    lblApplicationTitle = new JLabel();
    txtApplicationTitle = new JTextField();
    lblBasePackage = new JLabel();
    txtBasePackage = new JTextField();
    lblVersion = new JLabel();
    txtVersion = new JTextField();
    lblAuthor = new JLabel();
    txtAuthor = new JTextField();
    lblCompany = new JLabel();
    txtCompany = new JTextField();
    buttonBar = new JPanel();
    okButton = new JButton();
    cancelButton = new JButton();
    helpButton = new JButton();
    CellConstraints cc = new CellConstraints();

    // ======== this ========
    setTitle("NOVA Web Applications 2006 (Beta)");
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setModal(true);
    setResizable(false);
    Container contentPane2 = getContentPane();
    contentPane2.setLayout(new BorderLayout());

    // ======== dialogPane ========
    {
      dialogPane.setBorder(Borders.DIALOG_BORDER);

      // JFormDesigner evaluation mark
      // dialogPane
      // .setBorder(new javax.swing.border.CompoundBorder(
      // new javax.swing.border.TitledBorder(
      // new javax.swing.border.EmptyBorder(0, 0, 0,
      // 0), "JFormDesigner Evaluation",
      // javax.swing.border.TitledBorder.CENTER,
      // javax.swing.border.TitledBorder.BOTTOM,
      // new java.awt.Font("Dialog",
      // java.awt.Font.BOLD, 12),
      // java.awt.Color.red), dialogPane.getBorder()));
      dialogPane
          .addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(
            java.beans.PropertyChangeEvent e) {
          if ("border".equals(e.getPropertyName())) {
            throw new RuntimeException();
          }
        }
      });

      dialogPane.setLayout(new BorderLayout());

      // ======== contentPane ========
      {
        contentPane.setLayout(new FormLayout(new ColumnSpec[] {
                                             FormFactory.DEFAULT_COLSPEC,
                                             FormFactory.
                                             LABEL_COMPONENT_GAP_COLSPEC,
                                             new ColumnSpec(ColumnSpec.FILL,
            Sizes.DEFAULT,
            FormSpec.DEFAULT_GROW)}, new RowSpec[] {
                                             FormFactory.DEFAULT_ROWSPEC,
                                             FormFactory.LINE_GAP_ROWSPEC,
                                             FormFactory.DEFAULT_ROWSPEC,
                                             FormFactory.LINE_GAP_ROWSPEC,
                                             FormFactory.DEFAULT_ROWSPEC,
                                             FormFactory.LINE_GAP_ROWSPEC,
                                             FormFactory.DEFAULT_ROWSPEC,
                                             FormFactory.LINE_GAP_ROWSPEC,
                                             FormFactory.DEFAULT_ROWSPEC}));

        // ---- lblApplicationTitle ----
        lblApplicationTitle.setForeground(Color.BLUE);
        lblApplicationTitle.setText("Application Title:");
        contentPane.add(lblApplicationTitle, cc.xywh(1, 1, 1, 1,
            CellConstraints.RIGHT, CellConstraints.DEFAULT));

        // ---- txtApplicationTitle ----
        txtApplicationTitle.setColumns(50);
        txtApplicationTitle.addCaretListener(new CaretListener() {
          public void caretUpdate(CaretEvent e) {
            txtApplicationTitleCaretUpdate(e);
          }
        });
        contentPane.add(txtApplicationTitle, cc.xy(3, 1));

        // ---- lblBasePackage ----
        lblBasePackage.setText("Base Package:");
        contentPane.add(lblBasePackage, cc.xywh(1, 3, 1, 1,
                                                CellConstraints.RIGHT,
                                                CellConstraints.DEFAULT));

        // ---- txtBasePackage ----
        txtBasePackage.addCaretListener(new CaretListener() {
          public void caretUpdate(CaretEvent e) {
            txtBasePackageCaretUpdate(e);
          }
        });
        contentPane.add(txtBasePackage, cc.xy(3, 3));

        // ---- lblVersion ----
        lblVersion.setText("Version:");
        contentPane.add(lblVersion, cc.xywh(1, 5, 1, 1,
                                            CellConstraints.RIGHT,
                                            CellConstraints.DEFAULT));

        // ---- txtVersion ----
        txtVersion.setColumns(10);
        contentPane.add(txtVersion, cc.xy(3, 5));

        // ---- lblAuthor ----
        lblAuthor.setText("Author:");
        contentPane.add(lblAuthor, cc.xywh(1, 7, 1, 1,
                                           CellConstraints.RIGHT,
                                           CellConstraints.DEFAULT));

        // --- txtAuthor ---
        contentPane.add(txtAuthor, cc.xy(3, 7));

        // ---- lblCompany ----
        lblCompany.setText("Company:");
        contentPane.add(lblCompany, cc.xywh(1, 9, 1, 1,
                                            CellConstraints.RIGHT,
                                            CellConstraints.DEFAULT));
        contentPane.add(txtCompany, cc.xy(3, 9));
      }
      dialogPane.add(contentPane, BorderLayout.CENTER);

      // ======== buttonBar ========
      {
        buttonBar.setBorder(Borders.BUTTON_BAR_GAP_BORDER);
        buttonBar.setLayout(new FormLayout(new ColumnSpec[] {
                                           FormFactory.GLUE_COLSPEC,
                                           FormFactory.BUTTON_COLSPEC,
                                           FormFactory.RELATED_GAP_COLSPEC,
                                           FormFactory.BUTTON_COLSPEC,
                                           FormFactory.RELATED_GAP_COLSPEC,
                                           FormFactory.BUTTON_COLSPEC}, RowSpec
                                           .decodeSpecs("pref")));

        // ---- okButton ----
        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            okButtonActionPerformed(e);
          }
        });
        buttonBar.add(okButton, cc.xy(2, 1));

        // ---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            cancelButtonActionPerformed(e);
          }
        });
        buttonBar.add(cancelButton, cc.xy(4, 1));

        // ---- helpButton ----
        helpButton.setText("Help");
        helpButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            helpButtonActionPerformed(e);
          }
        });
        buttonBar.add(helpButton, cc.xy(6, 1));
      }
      dialogPane.add(buttonBar, BorderLayout.SOUTH);
    }
    contentPane2.add(dialogPane, BorderLayout.CENTER);
    // JFormDesigner - End of component initialization
    // //GEN-END:initComponents
    getRootPane().setDefaultButton(okButton);
    getRootPane().registerKeyboardAction(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cancelButtonActionPerformed(e);
      }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_IN_FOCUSED_WINDOW);
  }

  private void okButtonActionPerformed(ActionEvent e) {
    AppModel config = new AppModel();
    config.setTitle(txtApplicationTitle.getText());
    config.setPackageName(txtBasePackage.getText());

    if (!StudioUtilities.packages.contains(config.getPackageName())) {
            StudioUtilities.packages.add(config.getPackageName());
    }

    config.setVersion(txtVersion.getText());
    config.setAuthor(txtAuthor.getText());
    config.setCompany(txtCompany.getText());
    if (getOwner() instanceof XRadFrame) {
      XRadFrame frame = (XRadFrame) getOwner();
      frame.appModel = config;
    }
    dispose();
    commit = true;
  }

  private void cancelButtonActionPerformed(ActionEvent e) {
    dispose();
    commit = false;
  }

  private void helpButtonActionPerformed(ActionEvent e) {
    // TODO add your code here
  }

  private void txtApplicationTitleCaretUpdate(CaretEvent e) {
    validateData();
  }

  private void txtBasePackageCaretUpdate(CaretEvent e) {
    validateData();
  }

  // JFormDesigner - Variables declaration - DO NOT MODIFY
  // //GEN-BEGIN:variables
  // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
  private JPanel dialogPane;
  private JPanel contentPane;
  private JLabel lblApplicationTitle;
  private JTextField txtApplicationTitle;
  private JLabel lblBasePackage;
  private JTextField txtBasePackage;
  private JLabel lblVersion;
  private JTextField txtVersion;
  private JLabel lblAuthor;
  private JTextField txtAuthor;
  private JLabel lblCompany;
  private JTextField txtCompany;
  private JPanel buttonBar;
  private JButton okButton;
  private JButton cancelButton;
  private JButton helpButton;
  // JFormDesigner - End of variables declaration //GEN-END:variables

  public boolean showDialog() {
    setVisible(true);
    return commit;
  }

  public void validateData() {
    boolean flag = true;
    if (txtApplicationTitle.getText().trim().length() == 0) {
      flag = false;
    }
    if (txtBasePackage.getText().length() != 0) {
      if (!StudioUtilities.checkPackageNameValidity(txtBasePackage
          .getText())) {
        txtBasePackage.setForeground(Color.RED);
        flag = false;
      }
      else {
        txtBasePackage.setForeground(Color.BLACK);
      }
    }
    okButton.setEnabled(flag);
  }
}
