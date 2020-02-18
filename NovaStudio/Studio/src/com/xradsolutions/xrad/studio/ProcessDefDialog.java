package com.xradsolutions.xrad.studio;

import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.xmlbo.Process;
import com.xradsolutions.xrad.xmlbo.ReturnValue;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.*;
import javax.swing.table.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/*
 * Created by JFormDesigner on Sun Nov 20 02:43:01 AST 2005
 */

/**
 * @author Farrukh Ijaz
 */
public class ProcessDefDialog extends JDialog {

    private Process process;
    private BorderLayout loDialog = new BorderLayout();
    private JPanel pnlButtons = new JPanel();
    private FormLayout loButtons = 
        new FormLayout("f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n", 
                       "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JTabbedPane tpDialog = new JTabbedPane();
    private JPanel pnlGeneral = new JPanel();
    private JPanel pnlReturnValues = new JPanel();
    private FormLayout loGeneral = 
        new FormLayout("f:3dlu:n, r:max(d;100px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, t:max(d;15px):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n");
    private FormLayout loReturnValues = 
        new FormLayout("f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", 
                       "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, t:max(d;15dlu):g, c:3dlu:n");
    private JButton btnAddReturnValue = new JButton();
    private JButton okButton = new JButton();
    private JButton cancelButton = new JButton();
    private JLabel lblClass = new JLabel();
    private JTextField txtClass = new JTextField();
    private JLabel lblId = new JLabel();
    private JLabel lblDescription = new JLabel();
    private JLabel lblPackage = new JLabel();
    private JLabel lblStereoType = new JLabel();
    private JTextField txtId = new JTextField();
    private JScrollPane spDescription = new JScrollPane();
    private JTextArea txtDescription = new JTextArea();
    private JComboBox cbxPackage = new JComboBox();
    private JComboBox cbxStereoType = new JComboBox();
    private JButton btnRemoveReturnValue = new JButton();
    private JButton btnMoveUpReturnValue = new JButton();
    private JButton btnMoveDownReturnValue = new JButton();
    private JScrollPane spReturnValues = new JScrollPane();
    private JTable tblReturnValues = new JTable();
    private DefaultTableModel ReturnValuesTableModel = 
        new DefaultTableModel(new Object[][] { }, new String[] { "Return Value" }) {
            Class[] columnTypes = new Class[] { String.class };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                case 0:
                    return false;
                default:
                    return true;
                }
            }

        };

    public ProcessDefDialog() {
        try {
            jbInit();
            txtClass.grabFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateFromProcess() {
        txtClass.setText(process.getName());
        txtId.setText(process.getId());
        txtDescription.setText(process.getDescription());
        cbxPackage.setModel(new DefaultComboBoxModel(StudioUtilities.packages));
        cbxPackage.getEditor().setItem(process.getPackageName());
        DefaultTableModel model = 
            (DefaultTableModel)tblReturnValues.getModel();
        Vector rows = model.getDataVector();
        for (int i = 0; i < process.getReturnValueCount(); i++) {
            Vector cols = new Vector();
            ReturnValue returnValue = process.getReturnValue(i);
            cols.add(0, returnValue.getText());
            rows.add(cols);
        }
        cbxStereoType.setModel(new DefaultComboBoxModel(StudioUtilities.stereoTypes));
        cbxStereoType.getEditor().setItem(process.getStereoType());
    }

    public ProcessDefDialog(Process process) {
        try {
            jbInit();
            this.process = process;
            updateFromProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void txtClassCaretUpdate(CaretEvent e) {
        // TODO add your code here
        validateData();
        String id = StudioUtilities.generateId(txtClass.getText());
        txtId.setText(id);
    }

    private void txtIdCaretUpdate(CaretEvent e) {
        // TODO add your code here
        validateData();
    }

    private void btnAddReturnValueActionPerformed(ActionEvent e) {
        // TODO add your code here
        String text = 
            JOptionPane.showInputDialog(this, "Enter text to be returned:", 
                                        "success");

        if (text == null || text.trim().length() == 0) {
            return;
        }

        text = StudioUtilities.normalizeId(text);

        DefaultTableModel model = 
            (DefaultTableModel)tblReturnValues.getModel();
        Vector data = model.getDataVector();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                Vector vector = (Vector)data.get(i);
                if (vector.get(0).equals(text)) {
                    data.remove(i);
                    break;
                }
            }
        }
        model.addRow(new Object[] { text });
    }

    private void btnRemoveReturnValueActionPerformed(ActionEvent e) {
        // TODO add your code here
        DefaultTableModel model = 
            (DefaultTableModel)tblReturnValues.getModel();
        int rownum = tblReturnValues.getSelectedRow();
        if (rownum == -1) {
            JOptionPane.showMessageDialog(this, 
                                          "No return value is selected to remove!");
        } else {
            model.removeRow(rownum);
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudioUtilities.usedClassNames.remove(process.getName());
        process.setName(txtClass.getText());
        StudioUtilities.usedClassNames.put(process.getName(), process);
        StudioUtilities.usedIds.remove(process.getId());
        process.setId(txtId.getText());
        StudioUtilities.usedIds.put(process.getId(), process);
        process.setDescription(txtDescription.getText());
        process.setPackageName(cbxPackage.getEditor().getItem().toString());
        // Update global package list...
        if (!StudioUtilities.packages.contains(process.getPackageName())) {
            StudioUtilities.packages.add(process.getPackageName());
        }
        // Set stereotype
        process.setStereoType((String)cbxStereoType.getEditor().getItem());
        if (!StudioUtilities.stereoTypes.contains(process.getStereoType())) {
            StudioUtilities.stereoTypes.add(process.getStereoType());
        }
        DefaultTableModel model = 
            (DefaultTableModel)tblReturnValues.getModel();
        Vector rows = model.getDataVector();
        Iterator iter = rows.iterator();
        process.removeAllReturnValue();
        while (iter.hasNext()) {
            Vector cols = (Vector)iter.next();
            ReturnValue returnValue = new ReturnValue();
            returnValue.setText((String)cols.get(0));
            process.addReturnValue(returnValue);
        }
        selection = JOptionPane.OK_OPTION;
        setVisible(false);
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        selection = JOptionPane.CANCEL_OPTION;
        setVisible(false);
    }

    int selection = JOptionPane.CANCEL_OPTION;

    public int showDialog() {
        setVisible(true);
        try {
            return selection;
        } finally {
            dispose();
        }
    }

    public void validateData() {
        boolean flag = true;
        if (txtClass.getText().trim().length() == 0) {
            flag = false;
        }
        if (!StudioUtilities.checkClassNameValidity(txtClass.getText(), 
                                                    process)) {
            txtClass.setForeground(Color.RED);
            flag = false;
        } else {
            txtClass.setForeground(Color.BLACK);
        }
        if (txtId.getText().trim().length() == 0) {
            flag = false;
        }
        if (!StudioUtilities.checkIdValidity(txtId.getText(), process)) {
            txtId.setForeground(Color.RED);
            flag = false;
        } else {
            txtId.setForeground(Color.BLACK);
        }
        if (((String)cbxPackage.getEditor().getItem()).trim().length() == 0) {
            flag = false;
        }
        String packageName = (String)cbxPackage.getEditor().getItem();
        if (packageName.length() != 0) {
            if (!StudioUtilities.checkPackageNameValidity(packageName)) {
                cbxPackage.getEditor().getEditorComponent().setForeground(Color.RED);
                flag = false;
            } else {
                cbxPackage.getEditor().getEditorComponent().setForeground(Color.BLACK);
            }
        }
        okButton.setEnabled(flag);
    }

    private void jbInit() throws Exception {
        DefaultComponentFactory compFactory = 
            DefaultComponentFactory.getInstance();
        this.setSize(new Dimension(500, 400));
        this.getContentPane().setLayout(loDialog);
        this.setTitle("Process Definition");
        pnlButtons.setLayout(loButtons);
        pnlGeneral.setLayout(loGeneral);
        pnlReturnValues.setLayout(loReturnValues);
        lblClass = new JLabel();
        txtClass = new JTextField();
        lblId = new JLabel();
        txtId = new JTextField();
        lblDescription = new JLabel();
        spDescription = new JScrollPane();
        txtDescription = new JTextArea();
        lblPackage = new JLabel();
        cbxPackage = new JComboBox();
        cbxStereoType = new JComboBox();
        btnAddReturnValue = new JButton();
        btnRemoveReturnValue = new JButton();
        spReturnValues = new JScrollPane();
        tblReturnValues = new JTable();
        okButton = new JButton();
        cancelButton = new JButton();
        // ---- lblClass ----
        lblClass.setForeground(Color.BLUE);
        lblClass.setText("Name:");
        // ---- txtClass ----
        txtClass.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e) {
                        txtClassCaretUpdate(e);
                    }
                });
        // ---- lblId ----
        lblId.setForeground(Color.BLUE);
        lblId.setText("ID:");
        // ---- txtId ----
        txtId.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e) {
                        txtIdCaretUpdate(e);
                    }
                });
        // ---- lblDescription ----
        txtDescription.setLineWrap(true);
        txtDescription.setRows(10);
        lblDescription.setText("Description:");
        // ======== spDescription ========
        {

            // ---- txtDescription ----
            txtDescription.setRows(3);
            txtDescription.setLineWrap(true);
            txtDescription.setWrapStyleWord(true);
            spDescription.setViewportView(txtDescription);
        }
        // ---- lblPackage ----
        lblPackage.setForeground(Color.BLUE);
        lblPackage.setText("Package:");
        // ---- cbxPackage ----
        cbxPackage.setEditable(true);
        JTextField txtPackage = 
            (JTextField)cbxPackage.getEditor().getEditorComponent();
        txtPackage.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e) {
                        validateData();
                    }
                });

        // ---- lblGrouped ----
        btnMoveDownReturnValue.setText("Move Down");
        btnMoveDownReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveDownReturnValue_actionPerformed(e);
                    }
                });
        spReturnValues.setSize(new Dimension(480, 250));
        spReturnValues.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tblReturnValues.setPreferredScrollableViewportSize(new Dimension(450, 
                                                                         250));
        tblReturnValues.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btnMoveUpReturnValue.setText("Move Up");
        btnMoveUpReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveUpReturnValue_actionPerformed(e);
                    }
                });
        lblId.setText("Identifier");
        lblDescription.setText("Description");
        lblPackage.setText("Package");
        lblStereoType.setText("Stereo Type");
        lblClass.setText("Class Name");
        // ---- btnAddReturnValue ----
        btnAddReturnValue.setText("+");
        btnAddReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnAddReturnValueActionPerformed(e);
                    }
                });
        // ---- btnRemoveReturnValue ----
        btnRemoveReturnValue.setText("-");
        btnRemoveReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnRemoveReturnValueActionPerformed(e);
                    }
                });
        // ---- okButton ----
        okButton.setText("OK");
        okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
        // ---- cancelButton ----
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                });

        getRootPane().setDefaultButton(okButton);
        getRootPane().registerKeyboardAction(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        //--- Setting up components...
        pnlButtons.add(okButton, 
                       new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlButtons.add(cancelButton, 
                       new CellConstraints(6, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlButtons.add(cancelButton, 
                       new CellConstraints(6, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlButtons.add(okButton, 
                       new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        this.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
        pnlGeneral.add(lblClass, 
                       new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(txtClass, 
                       new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblId, 
                       new CellConstraints(2, 3, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblDescription, 
                       new CellConstraints(2, 4, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblPackage, 
                       new CellConstraints(2, 5, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblStereoType, 
                       new CellConstraints(2, 6, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(txtId, 
                       new CellConstraints(4, 3, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        spDescription.getViewport().add(txtDescription, null);
        pnlGeneral.add(spDescription, 
                       new CellConstraints(4, 4, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(cbxPackage, 
                       new CellConstraints(4, 5, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(cbxStereoType, 
                       new CellConstraints(4, 6, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlReturnValues.add(btnAddReturnValue, 
                            new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT, 
                                                CellConstraints.DEFAULT));
        pnlReturnValues.add(btnRemoveReturnValue, 
                            new CellConstraints(4, 2, 1, 1, 
                                                CellConstraints.DEFAULT, 
                                                CellConstraints.DEFAULT));
        pnlReturnValues.add(btnMoveUpReturnValue, 
                            new CellConstraints(6, 2, 1, 1, 
                                                CellConstraints.DEFAULT, 
                                                CellConstraints.DEFAULT));
        pnlReturnValues.add(btnMoveDownReturnValue, 
                            new CellConstraints(8, 2, 1, 1, 
                                                CellConstraints.DEFAULT, 
                                                CellConstraints.DEFAULT));
        spReturnValues.getViewport().add(tblReturnValues, null);
        pnlReturnValues.add(spReturnValues, 
                            new CellConstraints(2, 4, 9, 1, CellConstraints.DEFAULT, 
                                                CellConstraints.DEFAULT));
        tpDialog.addTab("General", pnlGeneral);
        tpDialog.addTab("Return Values", pnlReturnValues);
        this.getContentPane().add(tpDialog, BorderLayout.CENTER);
        tblReturnValues.setModel(ReturnValuesTableModel);
    }

    private void btnMoveUpReturnValue_actionPerformed(ActionEvent e) {
        int rowIndex = tblReturnValues.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblReturnValues.getModel();
        int newRowIndex = (rowIndex > 0) ? rowIndex - 1 : 0;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblReturnValues.getSelectionModel().setLeadSelectionIndex(newRowIndex);    
    }

    private void btnMoveDownReturnValue_actionPerformed(ActionEvent e) {
        int rowIndex = tblReturnValues.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblReturnValues.getModel();
        int newRowIndex = 
            (rowIndex < tblReturnValues.getRowCount() - 1) ? rowIndex + 1 : 
            tblReturnValues.getRowCount() - 1;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblReturnValues.getSelectionModel().setLeadSelectionIndex(newRowIndex);    
    }

}
