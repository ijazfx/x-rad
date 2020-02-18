package com.xradsolutions.xrad.codegen.struts;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.codegen.struts.model.StrutsModel;
import com.xradsolutions.xrad.swing.CustomizedFileChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.XMLEncoder;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static com.xradsolutions.xrad.codegen.struts.ThemeManager.*;

public class ModelSettingsDialog extends JDialog {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private FormLayout formLayout1 = 
        new FormLayout("f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JPanel jPanel2 = new JPanel();
    private FormLayout formLayout2 = 
        new FormLayout("f:3dlu:n, f:max(d;150px):n, f:3dlu:n, f:250px:g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n");
    private JButton btnOK = new JButton();
    private JButton btnCancel = new JButton();
    private JButton btnBrowseSourceLocation = new JButton();
    private JButton btnBrowseWebModuleLocation = new JButton();
    private JLabel lblSourceLocation = new JLabel();
    private JLabel lblWebModuleLocation = new JLabel();
    private JLabel lblJspTheme = new JLabel();
    private JTextField txtSourceLocation = new JTextField();
    private JTextField txtWebModuleLocation = new JTextField();
    private JComboBox cbxJspTheme = new JComboBox(retrieveThemes());
    private JCheckBox chkOverwriteFiles = new JCheckBox();

    StrutsModel model;

    public ModelSettingsDialog(StrutsModel model) {
        try {
            this.model = model;
            jbInit();
            updateFromModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        this.setSize(new Dimension(500, 200));
        this.setTitle("Model Settings");
        this.getContentPane().setLayout(borderLayout1);
        this.setModal(true);
        jPanel1.setLayout(formLayout1);
        jPanel2.setLayout(formLayout2);
        btnOK.setText("OK");
        btnOK.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnOK_actionPerformed(e);
                    }
                });
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnCancel_actionPerformed(e);
                    }
                });
        btnBrowseSourceLocation.setText("...");
        btnBrowseSourceLocation.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnBrowseSourceLocation_actionPerformed(e);
                    }
                });
        btnBrowseWebModuleLocation.setText("...");
        btnBrowseWebModuleLocation.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnBrowseWebModuleLocation_actionPerformed(e);
                    }
                });
        lblSourceLocation.setText("Source Location");
        lblWebModuleLocation.setText("WebModule Location");
        lblJspTheme.setText("JSP Theme");
        chkOverwriteFiles.setText("Overwrite Files");
        jPanel1.add(btnOK,
                    new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT,
                                        CellConstraints.DEFAULT));jPanel1.add(btnCancel,
                    new CellConstraints(6, 2, 1, 1, CellConstraints.DEFAULT,
                                        CellConstraints.DEFAULT));
        this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
        this.getContentPane().add(jPanel2, BorderLayout.NORTH);
        jPanel2.add(btnBrowseSourceLocation, 
                    new CellConstraints(6, 2, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        jPanel2.add(btnBrowseWebModuleLocation, 
                    new CellConstraints(6, 3, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        jPanel2.add(lblSourceLocation, 
                    new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        jPanel2.add(lblWebModuleLocation, 
                    new CellConstraints(2, 3, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        jPanel2.add(lblJspTheme, 
                    new CellConstraints(2, 4, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));jPanel2.add(txtSourceLocation,
                    new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT,
                                        CellConstraints.DEFAULT));
        jPanel2.add(txtWebModuleLocation, 
                    new CellConstraints(4, 3, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));jPanel2.add(cbxJspTheme, 
                    new CellConstraints(4, 4, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));jPanel2.add(chkOverwriteFiles, 
                    new CellConstraints(4, 5, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
    }

    private void btnBrowseSourceLocation_actionPerformed(ActionEvent e) {
        CustomizedFileChooser fc = new CustomizedFileChooser(null, "Source Location");
        fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File(txtSourceLocation.getText()));
        int selection = fc.showSaveDialog(this);
        if(selection == fc.APPROVE_OPTION) {
            txtSourceLocation.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }

    private void btnBrowseWebModuleLocation_actionPerformed(ActionEvent e) {
        CustomizedFileChooser fc = new CustomizedFileChooser(null, "WebModule Location");
        fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File(txtWebModuleLocation.getText()));
        int selection = fc.showSaveDialog(this);
        if(selection == fc.APPROVE_OPTION) {
            txtWebModuleLocation.setText(fc.getSelectedFile().getAbsolutePath());
        }    
    }

    private void btnOK_actionPerformed(ActionEvent e) {
        int selection = JOptionPane.showConfirmDialog(this, "Are you sure you want to save these changes?", "Alert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(selection == JOptionPane.YES_OPTION) {
            model.setSourceLocation(txtSourceLocation.getText());
            model.setWebModuleLocation(txtWebModuleLocation.getText());
            model.setJspTheme((String)cbxJspTheme.getSelectedItem());
            model.setOverwriteFiles(chkOverwriteFiles.isSelected());
        }
        setVisible(false);    
    }

    private void btnCancel_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    private void updateFromModel() {
        txtSourceLocation.setText(model.getSourceLocation());
        txtWebModuleLocation.setText(model.getWebModuleLocation());
        cbxJspTheme.setSelectedItem(model.getJspTheme());
        chkOverwriteFiles.setSelected(model.isOverwriteFiles());
    }
}
