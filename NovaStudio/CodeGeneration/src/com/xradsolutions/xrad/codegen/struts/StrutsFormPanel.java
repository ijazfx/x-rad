package com.xradsolutions.xrad.codegen.struts;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.codegen.struts.model.StrutsAction;

import com.xradsolutions.xrad.codegen.struts.model.StrutsForm;

import com.xradsolutions.xrad.codegen.struts.model.StrutsFormProperty;
import com.xradsolutions.xrad.codegen.struts.model.StrutsFormSubmit;
import com.xradsolutions.xrad.codegen.struts.model.StrutsModel;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

public class StrutsFormPanel extends JPanel {
    private BorderLayout loPanel = new BorderLayout();
    private JPanel pnlInput = new JPanel();
    private FormLayout loInput = 
        new FormLayout("f:3dlu:n, f:max(d;150px):n, f:3dlu:n, f:max(d;300px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JButton btnApply = new JButton();
    private JLabel lblClassName = new JLabel();
    private JLabel lblIdentifier = new JLabel();
    private JLabel lblPackage = new JLabel();
    private JTextField txtClassName = new JTextField();
    private JTextField txtId = new JTextField();
    private JComboBox cbxPackage = new JComboBox();
    private JLabel lblProperties = new JLabel();
    private JScrollPane spProperties = new JScrollPane();
    private JTable tblProperties = new JTable();

    DefaultTableModel propertiesTableModel = 
        new DefaultTableModel(new String[] { "Name", "Type", "Title", "Tag" }, 0);
    DefaultTableModel submitsTableModel = 
        new DefaultTableModel(new String[] { "Name", "Title", "Tag" }, 0);

    StrutsForm strutsForm;
    JComponent owner;
    StrutsModel model;
    
    private static StrutsFormPanel self;
    private JLabel lblSubmits = new JLabel();
    private JScrollPane spSumbits = new JScrollPane();
    private JTable tblSubmits = new JTable();

    private StrutsFormPanel(JComponent owner) {
        try {
            this.owner = owner;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StrutsFormPanel createStrutsFormPanel(JComponent owner, StrutsModel model, StrutsForm form) {
        if(self == null) {
            self = new StrutsFormPanel(owner);
        }
        self.setModel(model);
        self.setStrutsForm(form);
        return self;
    }

    private void jbInit() throws Exception {
        this.setLayout(loPanel);
        this.setSize(new Dimension(500, 500));
        pnlInput.setLayout(loInput);
        pnlInput.setSize(new Dimension(400, 400));
        btnApply.setText("Apply!");
        btnApply.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnApply_actionPerformed(e);
                    }
                });
        lblClassName.setText("Form Class");
        lblIdentifier.setText("ID");
        lblPackage.setText("Package");
        txtClassName.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e) {
                        txtClassName_caretUpdate(e);
                    }
                });
        txtId.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e) {
                        txtId_caretUpdate(e);
                    }
                });
        cbxPackage.setEditable(true);
//        ((JTextField) cbxPackage.getEditor()).addCaretListener(new CaretListener() {
//                    public void caretUpdate(CaretEvent e) {
//                        txtPackage_caretUpdate(e);
//                    }
//                });
        lblProperties.setText("Properties");
        tblProperties.setPreferredScrollableViewportSize(new Dimension(450, 120));
        this.add(pnlInput, BorderLayout.NORTH);
        pnlInput.add(lblClassName,
                     new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblIdentifier,
                     new CellConstraints(2, 3, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblPackage,
                     new CellConstraints(2, 4, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(txtClassName,
                     new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(txtId,
                     new CellConstraints(4, 3, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(cbxPackage,
                     new CellConstraints(4, 4, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblProperties,
                     new CellConstraints(2, 5, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        spProperties.getViewport().add(tblProperties, null);
        pnlInput.add(spProperties,
                     new CellConstraints(2, 6, 3, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblSubmits,
                     new CellConstraints(2, 7, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        spSumbits.getViewport().add(tblSubmits, null);
        pnlInput.add(spSumbits,
                     new CellConstraints(2, 8, 3, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));pnlInput.add(btnApply, 
                     new CellConstraints(4, 10, 1, 1, CellConstraints.RIGHT, 
                                         CellConstraints.DEFAULT));
        tblProperties.setModel(propertiesTableModel);
        lblSubmits.setText("Submits (Buttons/Links)");
        spSumbits.setPreferredSize(new Dimension(452, 120));
        tblSubmits.setModel(submitsTableModel);
    }

    public StrutsForm getStrutsAction() {
        return strutsForm;
    }

    public void setStrutsForm(StrutsForm strutsForm) {
        this.strutsForm = strutsForm;
        txtClassName.setText(strutsForm.getClassName());
        txtId.setText(strutsForm.getIdentifier());
        cbxPackage.setSelectedItem(strutsForm.getPackageName());
        Vector data = propertiesTableModel.getDataVector();
        data.removeAllElements();
        for(StrutsFormProperty property : strutsForm.getProperties().values()) {
            Vector row = new Vector();
            row.add(property.getName());
            row.add(property.getDataType());
            row.add(property.getLabel());
            row.add(property.getControlType());
            data.addElement(row);
        }
        data = submitsTableModel.getDataVector();
        data.removeAllElements();
        for(StrutsFormSubmit submit : strutsForm.getSubmits().values()) {
            Vector row = new Vector();
            row.add(submit.getName());
            row.add(submit.getTitle());
            row.add(submit.getControlType());
            data.addElement(row);
        }
    }

    private void btnApply_actionPerformed(ActionEvent e) {
        strutsForm.setClassName(txtClassName.getText());
        strutsForm.setIdentifier(txtId.getText());
        strutsForm.setPackageName((String)cbxPackage.getSelectedItem());
        owner.updateUI();
    }

    private void txtClassName_caretUpdate(CaretEvent e) {
        btnApply.setEnabled(true);    
    }

    private void txtId_caretUpdate(CaretEvent e) {
        btnApply.setEnabled(true);    
    }

    private void txtPackage_caretUpdate(CaretEvent e) {
        btnApply.setEnabled(true);    
    }

    public StrutsModel getModel() {
        return model;
    }

    public void setModel(StrutsModel model) {
        this.model = model;
    }
}
