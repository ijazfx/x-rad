package com.xradsolutions.xrad.codegen.struts;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.codegen.struts.model.StrutsAction;

import com.xradsolutions.xrad.codegen.struts.model.StrutsActionForward;

import com.xradsolutions.xrad.codegen.struts.model.StrutsFormProperty;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

public class StrutsActionPanel extends JPanel {
    private BorderLayout loPanel = new BorderLayout();
    private JPanel pnlInput = new JPanel();
    private FormLayout loInput = 
        new FormLayout("f:3dlu:n, f:max(d;150px):n, f:3dlu:n, f:max(d;300px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JButton btnApply = new JButton();
    private JLabel lblClassName = new JLabel();
    private JLabel lblIdentifier = new JLabel();
    private JLabel lblPackage = new JLabel();
    private JTextField txtClassName = new JTextField();
    private JTextField txtId = new JTextField();
    private JComboBox cbxPackage = new JComboBox();
    private JLabel lblActionForwards = new JLabel();
    private JScrollPane spLocalForwards = new JScrollPane();
    private JTable tblLocalForwards = new JTable();

    DefaultTableModel forwardsTableModel = 
        new DefaultTableModel(new String[] { "Name", "Path" }, 0);

    StrutsAction strutsAction;
    JComponent owner;
    
    private static StrutsActionPanel self;

    private StrutsActionPanel(JComponent owner) {
        try {
            this.owner = owner;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StrutsActionPanel createStrutsActionPanel(JComponent owner, StrutsAction action) {
        if(self == null) {
            self = new StrutsActionPanel(owner);
        }
        self.setStrutsAction(action);
        return self;
    }

    private void jbInit() throws Exception {
        this.setLayout(loPanel);
        this.setSize(new Dimension(500, 400));
        pnlInput.setLayout(loInput);
        pnlInput.setSize(new Dimension(400, 400));
        btnApply.setText("Apply!");
        btnApply.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnApply_actionPerformed(e);
                    }
                });
        lblClassName.setText("Action Class");
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
        lblActionForwards.setText("Action Forwards");
        tblLocalForwards.setPreferredScrollableViewportSize(new Dimension(450, 120));
        this.add(pnlInput, BorderLayout.WEST);
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
        pnlInput.add(lblActionForwards, 
                     new CellConstraints(2, 5, 1, 1, CellConstraints.DEFAULT, 
                                         CellConstraints.DEFAULT));
        spLocalForwards.getViewport().add(tblLocalForwards, null);
        pnlInput.add(spLocalForwards, 
                     new CellConstraints(2, 6, 3, 1, CellConstraints.DEFAULT, 
                                         CellConstraints.DEFAULT));pnlInput.add(btnApply, 
                     new CellConstraints(4, 8, 1, 1, CellConstraints.RIGHT, 
                                         CellConstraints.DEFAULT));
        tblLocalForwards.setModel(forwardsTableModel);
    }

    public StrutsAction getStrutsAction() {
        return strutsAction;
    }

    public void setStrutsAction(StrutsAction strutsAction) {
        this.strutsAction = strutsAction;
        txtClassName.setText(strutsAction.getClassName());
        txtId.setText(strutsAction.getIdentifier());
        cbxPackage.setSelectedItem(strutsAction.getPackageName());
        Vector data = forwardsTableModel.getDataVector();
        data.removeAllElements();
        for(StrutsActionForward forward : strutsAction.getForwards().values().toArray(new StrutsActionForward[]{})) {
            Vector row = new Vector();
            row.add(forward.getName());
            row.add(forward.getPath());
            data.addElement(row);
        }        
    }

    private void btnApply_actionPerformed(ActionEvent e) {
        strutsAction.setClassName(txtClassName.getText());
        strutsAction.setIdentifier(txtId.getText());
        strutsAction.setPackageName((String)cbxPackage.getSelectedItem());
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
}
