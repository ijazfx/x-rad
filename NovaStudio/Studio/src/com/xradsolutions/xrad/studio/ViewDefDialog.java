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

import com.xradsolutions.xrad.xmlbo.Property;
import com.xradsolutions.xrad.xmlbo.SubmitMethod;
import com.xradsolutions.xrad.xmlbo.View;
import com.xradsolutions.xrad.swing.ComboBoxEditor;

/*
 * Created by JFormDesigner on Sun Nov 20 02:43:01 AST 2005
 */

/**
 * @author Farrukh Ijaz
 */
public class ViewDefDialog extends JDialog {

    private void btnMoveUpProperty_actionPerformed(ActionEvent e) {
        int rowIndex = tblProperties.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblProperties.getModel();
        int newRowIndex = (rowIndex > 0) ? rowIndex - 1 : 0;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblProperties.getSelectionModel().setLeadSelectionIndex(newRowIndex);
    }

    private void btnMoveDownProperty_actionPerformed(ActionEvent e) {
        int rowIndex = tblProperties.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblProperties.getModel();
        int newRowIndex =
            (rowIndex < tblProperties.getRowCount() - 1) ? rowIndex + 1 :
            tblProperties.getRowCount() - 1;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblProperties.getSelectionModel().setLeadSelectionIndex(newRowIndex);
    }

    private void btnMoveUpSubmitMethod_actionPerformed(ActionEvent e) {
        int rowIndex = tblSubmitMethods.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblSubmitMethods.getModel();
        int newRowIndex = (rowIndex > 0) ? rowIndex - 1 : 0;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblSubmitMethods.getSelectionModel().setLeadSelectionIndex(newRowIndex);
    }

    private void btnMoveDownSubmitMethod_actionPerformed(ActionEvent e) {
        int rowIndex = tblSubmitMethods.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tblSubmitMethods.getModel();
        int newRowIndex =
            (rowIndex < tblSubmitMethods.getRowCount() - 1) ? rowIndex + 1 :
            tblSubmitMethods.getRowCount() - 1;
        model.moveRow(rowIndex, rowIndex, newRowIndex);
        tblSubmitMethods.getSelectionModel().setLeadSelectionIndex(newRowIndex);
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

    interface IConstants {
        String[] propertyTypes = new String[] {"String", "Integer", "Long", "Float", "Double", "Boolean", "Object", "java.util.Date", "java.util.List","org.apache.struts.upload.FormFile", "java.util.Map", "int", "long", "float", "double", "boolean"};
        String[] propertyDisplayTypes = new String[] {
                           "StaticText",
                           "TextField", "TextArea", "PasswordField","TextField-Date","TextField-DateTime",
                           "RadioButton", "CheckBox", "ComboBox", "List",
                           "FileUpload","Table","Table-Top",
                           "HiddenField", "None"};
        String[] submitDisplayTypes = new String[] {"Button","Button-Top","Button-Ajax","Button-Ajax-Top", "Link","Link-Top","Link-Ajax-Top","Link-Ajax-Footer","Link-Footer","Link-Left","Link-Ajax-Left","None-Ajax","Link-Ajax", "None"};
    }

    private View view;
    private BorderLayout loDialog = new BorderLayout();
    private JPanel pnlButtons = new JPanel();
    private FormLayout loButtons =
        new FormLayout("f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n",
                       "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JTabbedPane tpDialog = new JTabbedPane();
    private JPanel pnlGeneral = new JPanel();
    private JPanel pnlReturnValues = new JPanel();
    private FormLayout loGeneral =
        new FormLayout("f:3dlu:n, r:max(d;100px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, t:max(d;15px):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n");
    private FormLayout loReturnValues =
        new FormLayout("f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n",
                       "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, t:max(d;15dlu):g, c:3dlu:n");
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

    private JLabel lblTitle = new JLabel();
    private JTextField txtTitle = new JTextField();
    private JPanel pnlSubmitMethods = new JPanel();
    private JPanel pnlProperties = new JPanel();
    private FormLayout loSubmitMethods =
    new FormLayout("f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n",
                   "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, t:max(d;15dlu):g, c:3dlu:n");
    private FormLayout loProperties =
    new FormLayout("f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n",
                   "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, t:max(d;15dlu):g, c:3dlu:n");


    private JButton btnAddReturnValue = new JButton();
    private JButton btnRemoveReturnValue = new JButton();
    private JButton btnMoveUpReturnValue = new JButton();
    private JButton btnMoveDownReturnValue = new JButton();
    private JScrollPane spReturnValues = new JScrollPane();
    private JTable tblReturnValues = new JTable();
    private DefaultTableModel returnValuesTableModel =
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

    private JButton btnAddSubmitMethod = new JButton();
    private JButton btnRemoveSubmitMethod = new JButton();
    private JButton btnMoveUpSubmitMethod = new JButton();
    private JButton btnMoveDownSubmitMethod = new JButton();
    private JScrollPane spSubmitMethods = new JScrollPane();
    private JTable tblSubmitMethods = new JTable();
    private DefaultTableModel submitMethodsTableModel =
        new DefaultTableModel(new Object[][] { }, new String[] { "Name", "Title", "Display Type" }) {
            Class[] columnTypes = new Class[] { String.class, String.class, String.class };

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

    private JButton btnAddProperty = new JButton();
    private JButton btnRemoveProperty = new JButton();
    private JButton btnMoveUpProperty = new JButton();
    private JButton btnMoveDownProperty = new JButton();
    private JScrollPane spProperties = new JScrollPane();
    private JTable tblProperties = new JTable();
    private DefaultTableModel propertiesTableModel =
        new DefaultTableModel(new Object[][] { }, new String[] { "Name", "Data Type", "Title", "Display Type" }) {
            Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

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


    public ViewDefDialog() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateFromView() {
        txtClass.setText(view.getName());
        txtId.setText(view.getId());
        txtTitle.setText(view.getTitle());
        txtDescription.setText(view.getDescription());
        cbxPackage.setModel(new DefaultComboBoxModel(StudioUtilities.packages));
        cbxPackage.getEditor().setItem(view.getPackageName());
        DefaultTableModel model =
            (DefaultTableModel)tblReturnValues.getModel();
        Vector rows = model.getDataVector();
        for (int i = 0; i < view.getReturnValueCount(); i++) {
            Vector cols = new Vector();
            ReturnValue returnValue = view.getReturnValue(i);
            cols.add(0, returnValue.getText());
            rows.add(cols);
        }
        model = (DefaultTableModel) tblProperties.getModel();
        rows = model.getDataVector();
        for (int i = 0; i < view.getPropertyCount(); i++) {
          Vector cols = new Vector();
          Property property = view.getProperty(i);
          cols.add(0, property.getName());
          cols.add(1, property.getType());
          cols.add(2, property.getTitle());
          cols.add(3, property.getDisplayType());
          rows.add(cols);
        }
        model = (DefaultTableModel) tblSubmitMethods.getModel();
        rows = model.getDataVector();
        for (int i = 0; i < view.getSubmitMethodCount(); i++) {
          Vector cols = new Vector();
          SubmitMethod submitMethod = view.getSubmitMethod(i);
          cols.add(0, submitMethod.getName());
          cols.add(1, submitMethod.getTitle());
          cols.add(2, submitMethod.getDisplayType());
          rows.add(cols);
        }
        cbxStereoType.setModel(new DefaultComboBoxModel(StudioUtilities.stereoTypes));
        cbxStereoType.getEditor().setItem(view.getStereoType());
    }

    public ViewDefDialog(View view) {
        try {
            jbInit();
            this.view = view;
            updateFromView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void txtClassCaretUpdate(CaretEvent e) {
        // TODO add your code here
        validateData();
        String id = StudioUtilities.generateId(txtClass.getText());
        txtId.setText(id);
        String title = StudioUtilities.generateTitle(id);
        txtTitle.setText(title);
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

    private void btnAddPropertyActionPerformed(ActionEvent e) {
      JOptionPane joPane = new JOptionPane();
      String name = JOptionPane.showInputDialog(this, "Enter property name:",
                                                "property");

      if (name == null || name.trim().length() == 0) {
        return;
      }

      name = StudioUtilities.normalizeId(name);

      String type = (String) JOptionPane.showInputDialog(this,
          "Select property type:", "Input", JOptionPane.PLAIN_MESSAGE,
          null, IConstants.propertyTypes, "String");

      if (type == null || type.trim().length() == 0) {
        return;
      }

      type = type.trim();

      String displayType = (String) JOptionPane
          .showInputDialog(this, "Select display type:", "Input",
                           JOptionPane.PLAIN_MESSAGE, null, IConstants.propertyDisplayTypes, "TextField");

      if (displayType == null || displayType.trim().length() == 0) {
        return;
      }

      displayType = displayType.trim();

      DefaultTableModel model = (DefaultTableModel) tblProperties.getModel();
      Vector data = model.getDataVector();
      if (data != null) {
        for (int i = 0; i < data.size(); i++) {
          Vector vector = (Vector) data.get(i);
          if (vector.get(0).equals(name)) {
            data.remove(i);
            break;
          }
        }
      }
      model.addRow(new Object[] {name, type, StudioUtilities.generateTitle(name),
                   displayType});
    }

    private void btnRemovePropertyActionPerformed(ActionEvent e) {
      DefaultTableModel model = (DefaultTableModel) tblProperties.getModel();
      int rownum = tblProperties.getSelectedRow();
      if (rownum == -1) {
        JOptionPane.showMessageDialog(this,
                                      "No property is selected to remove!");
      }
      else {
        model.removeRow(rownum);
      }
    }

    private void btnAddSubmitMethodActionPerformed(ActionEvent e) {
      String name = JOptionPane.showInputDialog(this,
                                                "Enter submit method name:",
                                                "method");
      if (name == null || name.trim().length() == 0) {
        return;
      }

      name = StudioUtilities.normalizeId(name);

      String type = (String) JOptionPane.showInputDialog(this,
          "Select display type:", "Input", JOptionPane.PLAIN_MESSAGE,
          null, IConstants.submitDisplayTypes, "Button");

      if (type == null || type.trim().length() == 0) {
        return;
      }

      type = type.trim();

      DefaultTableModel model = (DefaultTableModel) tblSubmitMethods
          .getModel();
      Vector data = model.getDataVector();
      if (data != null) {
        for (int i = 0; i < data.size(); i++) {
          Vector vector = (Vector) data.get(i);
          if (vector.get(0).equals(name)) {
            data.remove(i);
            break;
          }
        }
      }
      model.addRow(new Object[] {name, StudioUtilities.generateTitle(name), type});
    }

    private void btnRemoveSubmitMethodActionPerformed(ActionEvent e) {
      DefaultTableModel model = (DefaultTableModel) tblSubmitMethods
          .getModel();
      int rownum = tblSubmitMethods.getSelectedRow();
      if (rownum == -1) {
        JOptionPane.showMessageDialog(this,
                                      "No submit method is selected to remove!");
      }
      else {
        model.removeRow(rownum);
      }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        StudioUtilities.usedClassNames.remove(view.getName());
        view.setName(txtClass.getText());
        view.setTitle(txtTitle.getText());
        StudioUtilities.usedClassNames.put(view.getName(), view);
        StudioUtilities.usedIds.remove(view.getId());
        view.setId(txtId.getText());
        StudioUtilities.usedIds.put(view.getId(), view);
        view.setDescription(txtDescription.getText());
        view.setPackageName(cbxPackage.getEditor().getItem().toString());
        // Update global package list...
        if (!StudioUtilities.packages.contains(view.getPackageName())) {
            StudioUtilities.packages.add(view.getPackageName());
        }
        // Set stereotype
        view.setStereoType((String)cbxStereoType.getEditor().getItem());
        if (!StudioUtilities.stereoTypes.contains(view.getStereoType())) {
            StudioUtilities.stereoTypes.add(view.getStereoType());
        }
        DefaultTableModel model =
            (DefaultTableModel)tblReturnValues.getModel();
        Vector rows = model.getDataVector();
        Iterator iter = rows.iterator();
        view.removeAllReturnValue();
        while (iter.hasNext()) {
            Vector cols = (Vector)iter.next();
            ReturnValue returnValue = new ReturnValue();
            returnValue.setText((String)cols.get(0));
            view.addReturnValue(returnValue);
        }

        model =
            (DefaultTableModel)tblSubmitMethods.getModel();
        rows = model.getDataVector();
        iter = rows.iterator();
        view.removeAllSubmitMethod();
        while (iter.hasNext()) {
            Vector cols = (Vector)iter.next();
            SubmitMethod submitMethod = new SubmitMethod();
            submitMethod.setName((String)cols.get(0));
            submitMethod.setTitle((String)cols.get(1));
            submitMethod.setDisplayType((String)cols.get(2));
            view.addSubmitMethod(submitMethod);
        }

        model =
            (DefaultTableModel)tblProperties.getModel();
        rows = model.getDataVector();
        iter = rows.iterator();
        view.removeAllProperty();
        while (iter.hasNext()) {
            Vector cols = (Vector)iter.next();
            Property property = new Property();
            property.setName((String)cols.get(0));
            property.setType((String)cols.get(1));
            property.setTitle((String)cols.get(2));
            property.setDisplayType((String)cols.get(3));
            view.addProperty(property);
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
                                                    view)) {
            txtClass.setForeground(Color.RED);
            flag = false;
        } else {
            txtClass.setForeground(Color.BLACK);
        }
        if (txtId.getText().trim().length() == 0) {
            flag = false;
        }
        if (!StudioUtilities.checkIdValidity(txtId.getText(), view)) {
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
        this.setSize(new Dimension(700, 550));
        this.getContentPane().setLayout(loDialog);
        this.setTitle("View Definition");
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
            txtDescription.setRows(6);
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
        lblTitle.setText("Title");
        pnlSubmitMethods.setLayout(loSubmitMethods);
        pnlProperties.setLayout(loProperties);

        spReturnValues.setSize(new Dimension(480, 250));
        spReturnValues.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tblReturnValues.setPreferredScrollableViewportSize(new Dimension(450,
                                                                         250));
        btnMoveUpReturnValue.setText("Move Up");
        btnMoveUpReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveUpReturnValue_actionPerformed(e);
                    }
                });
        btnMoveDownReturnValue.setText("Move Down");

        btnMoveDownReturnValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveDownReturnValue_actionPerformed(e);
                    }
                });
        spProperties.setSize(new Dimension(480, 250));
        spProperties.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tblProperties.setPreferredScrollableViewportSize(new Dimension(450,
                                                                         250));
        btnMoveUpProperty.setText("Move Up");
        btnMoveUpProperty.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveUpProperty_actionPerformed(e);
                    }
                });
        btnMoveDownProperty.setText("Move Down");

        btnMoveDownProperty.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveDownProperty_actionPerformed(e);
                    }
                });
        spSubmitMethods.setSize(new Dimension(480, 250));
        spSubmitMethods.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tblSubmitMethods.setPreferredScrollableViewportSize(new Dimension(450,
                                                                         250));
        btnMoveUpSubmitMethod.setText("Move Up");
        btnMoveUpSubmitMethod.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveUpSubmitMethod_actionPerformed(e);
                    }
                });
        btnMoveDownSubmitMethod.setText("Move Down");


        btnMoveDownSubmitMethod.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnMoveDownSubmitMethod_actionPerformed(e);
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
        // ---- btnAddProperty ----
        btnAddProperty.setText("+");
        btnAddProperty.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnAddPropertyActionPerformed(e);
                    }
                });
        // ---- btnRemoveProperty ----
        btnRemoveProperty.setText("-");
        btnRemoveProperty.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnRemovePropertyActionPerformed(e);
                    }
                });
        // ---- btnAddSubmitMethod ----
        btnAddSubmitMethod.setText("+");
        btnAddSubmitMethod.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnAddSubmitMethodActionPerformed(e);
                    }
                });
        // ---- btnRemoveSubmitMethod ----
        btnRemoveSubmitMethod.setText("-");
        btnRemoveSubmitMethod.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnRemoveSubmitMethodActionPerformed(e);
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
                       new CellConstraints(2, 5, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblPackage,
                       new CellConstraints(2, 6, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblStereoType,
                       new CellConstraints(2, 7, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(txtId,
                       new CellConstraints(4, 3, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        spDescription.getViewport().add(txtDescription, null);
        pnlGeneral.add(spDescription,
                       new CellConstraints(4, 5, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(cbxPackage,
                       new CellConstraints(4, 6, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(lblTitle,
                       new CellConstraints(2, 4, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(txtTitle,
                       new CellConstraints(4, 4, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
        pnlGeneral.add(cbxStereoType,
                       new CellConstraints(4, 7, 1, 1, CellConstraints.DEFAULT,
                                           CellConstraints.DEFAULT));
//        pnlGeneral.add(new JLabel("Example: "),
//                       new CellConstraints(2, 8, 1, 1, CellConstraints.DEFAULT,
//                                           CellConstraints.DEFAULT));
//        String text = "[paging:myList(id: Project ID,name,title)] + \r\n"+
//
//            "[tab:myTab(orgs:Organizations<paging:myList>,input:Add/Updated<form:1-4>,input2:Detail<form:5-*>,summary:Summary<nothing:1>)]";
//        pnlGeneral.add(new JLabel(text),
//                       new CellConstraints(4, 8, 1, 1, CellConstraints.DEFAULT,
//                                           CellConstraints.DEFAULT));

        //-- Components Added
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
        //-- Components Added
        pnlSubmitMethods.add(btnAddSubmitMethod,
                            new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlSubmitMethods.add(btnRemoveSubmitMethod,
                            new CellConstraints(4, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlSubmitMethods.add(btnMoveUpSubmitMethod,
                            new CellConstraints(6, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlSubmitMethods.add(btnMoveDownSubmitMethod,
                            new CellConstraints(8, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        spSubmitMethods.getViewport().add(tblSubmitMethods, null);
        pnlSubmitMethods.add(spSubmitMethods,
                            new CellConstraints(2, 4, 9, 1, CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        //-- Components Added
        pnlProperties.add(btnAddProperty,
                            new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlProperties.add(btnRemoveProperty,
                            new CellConstraints(4, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlProperties.add(btnMoveUpProperty,
                            new CellConstraints(6, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        pnlProperties.add(btnMoveDownProperty,
                            new CellConstraints(8, 2, 1, 1,
                                                CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));
        spProperties.getViewport().add(tblProperties, null);
        pnlProperties.add(spProperties,
                            new CellConstraints(2, 4, 9, 1, CellConstraints.DEFAULT,
                                                CellConstraints.DEFAULT));

        tblProperties.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSubmitMethods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblReturnValues.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tpDialog.addTab("General", pnlGeneral);
        tpDialog.addTab("Properties", pnlProperties);
        tpDialog.addTab("Submit Methods", pnlSubmitMethods);
        tpDialog.addTab("Return Values", pnlReturnValues);
        this.getContentPane().add(tpDialog, BorderLayout.CENTER);
        tblReturnValues.setModel(returnValuesTableModel);
        tblProperties.setModel(propertiesTableModel);
        tblSubmitMethods.setModel(submitMethodsTableModel);
        TableColumn column = tblProperties.getColumnModel().getColumn(1);
        column.setCellEditor(new ComboBoxEditor(IConstants.propertyTypes, true));
        column = tblProperties.getColumnModel().getColumn(3);
        column.setCellEditor(new ComboBoxEditor(IConstants.propertyDisplayTypes, true));
        column = tblSubmitMethods.getColumnModel().getColumn(2);
        column.setCellEditor(new ComboBoxEditor(IConstants.submitDisplayTypes, true));
    }
}
