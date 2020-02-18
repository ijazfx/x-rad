package com.xradsolutions.xrad.studio;

import com.xradsolutions.xrad.xmlbo.Interaction;
import com.xradsolutions.xrad.xmlbo.ReturnValue;
import com.xradsolutions.xrad.xmlbo.Source;
import com.xradsolutions.xrad.xmlbo.SourceProcess;
import com.xradsolutions.xrad.xmlbo.SourceView;
import com.xradsolutions.xrad.xmlbo.SubmitMethod;
import com.xradsolutions.xrad.xmlbo.Target;
import com.xradsolutions.xrad.xmlbo.TargetProcess;
import com.xradsolutions.xrad.xmlbo.TargetView;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import javax.swing.table.DefaultTableModel;

/*
 * Created by JFormDesigner on Fri Nov 11 20:50:12 AST 2005
 */

/**
 * @author Farrukh Ijaz
 */
public class InteractionDefDialog extends JDialog {

    InteractionEdge edge;
    Vector submitMethods = new Vector();
    Vector returnValues = new Vector();

    public InteractionDefDialog(Frame owner, InteractionEdge edge) {
        super(owner);
        initComponents();
        this.edge = edge;
        updateFromInteraction();
    }

    private void updateFromInteraction() {
        Interaction interaction = (Interaction)edge.getUserObject();
        Source source = null;
        Target target = null;
        if (interaction != null) {
            source = interaction.getSource();
            target = interaction.getTarget();
        }

        Object obj = edge.getSourceCell();
        if (obj instanceof ViewCell) {

            ViewCell viewCell = (ViewCell)obj;
            com.xradsolutions.xrad.xmlbo.View view = 
                (com.xradsolutions.xrad.xmlbo.View)viewCell.getUserObject();
            boolean flag = true;
            lblSourceViewId.setEnabled(flag);
            txtSourceViewId.setEnabled(flag);
            // txtSourceViewId.setText(view.getId());
            txtSourceViewId.setText(view.getId());
            lblOnSubmit.setEnabled(flag);
            cbxOnSubmit.setEnabled(flag);
            //--- new code added ---
            submitMethods.add("<Create New>");
            for (int s = 0; s < view.getSubmitMethodCount(); s++) {
                SubmitMethod submitMethod = view.getSubmitMethod(s);
                String id = submitMethod.getName() + "@" + view.getId();
                if (!StudioUtilities.usedNavigations.contains(id)) {
                    submitMethods.add(submitMethod);
                }
            }
            //      if (submitMethods.size() == 0) {
            //        JOptionPane.showMessageDialog(this,
            //                                      "All submit methods of " + view.getName() + " view are already utilized for other interactions!\nPlease remove other interaction utilizing the submit method you want to utilize for this interaction!");
            //      }
            cbxOnSubmit.setModel(new DefaultComboBoxModel(submitMethods));

            returnValues.add("<Create New>");
            for (int r = 0; r < view.getReturnValueCount(); r++) {
                ReturnValue returnValue = view.getReturnValue(r);
                String id = returnValue.getText() + "@" + view.getId();
                if (!StudioUtilities.usedNavigations.contains(id)) {
                    returnValues.add(returnValue);
                }
            }
            //      if (returnValues.size() == 0) {
            //        JOptionPane.showMessageDialog(this,
            //                                      "All return values of " + process.getName() + " process are already utilized for other interactions!\nPlease remove other interaction utilizing the return value you want to utilize for this interaction!");
            //      }
            cbxOnReturnValue.setModel(new DefaultComboBoxModel(returnValues));

            // --- new code ended ---
            //      cbxOnSubmit.setModel(new DefaultComboBoxModel(view.getSubmitMethod()));
            //            if (interaction != null) {
            //                SourceView sourceView = 
            //                    interaction.getSource().getSourceView();
            //                for (int i = 0; i < view.getSubmitMethodCount(); i++) {
            //                    SubmitMethod submitMethod = view.getSubmitMethod(i);
            //                    if (submitMethod.getName().equals(sourceView.getSubmitMethodName())) {
            //                        cbxOnSubmit.setSelectedItem(submitMethod);
            //                        break;
            //                    }
            //                }
            //            } else {
            //                cbxOnSubmit.setSelectedIndex(0);
            //            }
            if (source != null) {
                if ("SubmitMethod".equals(source.getInteractionType())) {
                    cbxOnSubmit.setSelectedItem(source.getValue());
                    rbSubmitMethod.setSelected(true);
                    lblOnReturnValue.setEnabled(false);
                    cbxOnReturnValue.setEnabled(false);
                    cbxOnReturnValue.setSelectedIndex(-1);
                } else if ("ReturnValue".equals(source.getInteractionType())) {
                    cbxOnReturnValue.setSelectedItem(source.getValue());
                    rbReturnValue.setSelected(true);
                    lblOnSubmit.setEnabled(false);
                    cbxOnSubmit.setEnabled(false);
                    cbxOnSubmit.setSelectedIndex(-1);
                }

            } else {
                rbSubmitMethod.setSelected(true);
                cbxOnSubmit.setSelectedIndex(0);
                lblOnReturnValue.setEnabled(false);
                cbxOnReturnValue.setEnabled(false);
                cbxOnReturnValue.setSelectedIndex(-1);
            }
            lblSourceProcessId.setEnabled(!flag);
            txtSourceProcessId.setEnabled(!flag);
            //            lblOnReturnValue.setEnabled(flag);
            //            cbxOnReturnValue.setEnabled(flag);


        } else if (obj instanceof ProcessCell) {
            rbReturnValue.setSelected(true);
            rbSubmitMethod.setEnabled(false);
            cbxOnSubmit.setEnabled(false);
            lblOnSubmit.setEnabled(false);
            ProcessCell processCell = (ProcessCell)obj;
            com.xradsolutions.xrad.xmlbo.Process process = 
                (com.xradsolutions.xrad.xmlbo.Process)processCell.getUserObject();
            boolean flag = false;
            lblSourceViewId.setEnabled(flag);
            txtSourceViewId.setEnabled(flag);
            lblOnSubmit.setEnabled(flag);
            cbxOnSubmit.setEnabled(flag);
            lblSourceProcessId.setEnabled(!flag);
            txtSourceProcessId.setEnabled(!flag);
            // txtSourceProcessId.setText(process.getId());
            txtSourceProcessId.setText(process.getId());
            lblOnReturnValue.setEnabled(!flag);
            cbxOnReturnValue.setEnabled(!flag);
            //--- new code added ---
            returnValues.add("<Create New>");
            for (int r = 0; r < process.getReturnValueCount(); r++) {
                ReturnValue returnValue = process.getReturnValue(r);
                String id = returnValue.getText() + "@" + process.getId();
                if (!StudioUtilities.usedNavigations.contains(id)) {
                    returnValues.add(returnValue);
                }
            }
            //      if (returnValues.size() == 0) {
            //        JOptionPane.showMessageDialog(this,
            //                                      "All return values of " + process.getName() + " process are already utilized for other interactions!\nPlease remove other interaction utilizing the return value you want to utilize for this interaction!");
            //      }
            cbxOnReturnValue.setModel(new DefaultComboBoxModel(returnValues));
            // --- new code ended ---
            //      cbxOnReturnValue.setModel(new DefaultComboBoxModel(process.getReturnValue()));
            //            if (interaction != null) {
            //                SourceProcess sourceProcess = 
            //                    interaction.getSource().getSourceProcess();
            //                for (int i = 0; i < process.getReturnValueCount(); i++) {
            //                    ReturnValue returnValue = process.getReturnValue(i);
            //                    if (returnValue.getText().equals(sourceProcess.getReturnValueText())) {
            //                        cbxOnReturnValue.setSelectedItem(returnValue);
            //                        break;
            //                    }
            //                }
            //            } else {
            //                cbxOnReturnValue.setSelectedIndex(0);
            //            }
            if (target != null) {
                cbxOnReturnValue.setSelectedItem(source.getValue());
            } else {
                cbxOnReturnValue.setSelectedIndex(0);
            }
        }
        obj = edge.getTargetCell();
        if (obj instanceof ViewCell) {
            ViewCell viewCell = (ViewCell)obj;
            com.xradsolutions.xrad.xmlbo.View view = 
                (com.xradsolutions.xrad.xmlbo.View)viewCell.getUserObject();
            boolean flag = true;
            lblTargetViewId.setEnabled(flag);
            txtTargetViewId.setEnabled(flag);
            // txtTargetViewId.setText(view.getId());
            txtTargetViewId.setText(view.getId());
            lblTargetProcessId.setEnabled(!flag);
            txtTargetProcessId.setEnabled(!flag);
        } else if (obj instanceof ProcessCell) {
            ProcessCell processCell = (ProcessCell)obj;
            com.xradsolutions.xrad.xmlbo.Process process = 
                (com.xradsolutions.xrad.xmlbo.Process)processCell.getUserObject();
            boolean flag = false;
            lblTargetViewId.setEnabled(flag);
            txtTargetViewId.setEnabled(flag);
            lblTargetProcessId.setEnabled(!flag);
            txtTargetProcessId.setEnabled(!flag);
            // txtTargetProcessId.setText(process.getId());
            txtTargetProcessId.setText(process.getId());
        }
    }

    public InteractionDefDialog(Dialog owner, InteractionEdge edge) {
        super(owner);
        initComponents();
        this.edge = edge;
        updateFromInteraction();
    }

    private void initComponents() {
        setSize(500, 300);
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
        dialogPane = new JPanel();
        contentPane = new JPanel();
        lblSourceViewId = new JLabel();
        txtSourceViewId = new JTextField();
        lblOnSubmit = new JLabel();
        cbxOnSubmit = new JComboBox();
        lblSourceProcessId = new JLabel();
        txtSourceProcessId = new JTextField();
        lblOnReturnValue = new JLabel();
        cbxOnReturnValue = new JComboBox();
        lblTargetViewId = new JLabel();
        txtTargetViewId = new JTextField();
        lblTargetProcessId = new JLabel();
        txtTargetProcessId = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        lblInteractionType = new JLabel();
        rbSubmitMethod = new JRadioButton("Submit Method");
        rbReturnValue = new JRadioButton("Return Value");


        CellConstraints cc = new CellConstraints();

        // ======== this ========
        setTitle("Interaction Definition");
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
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent e) {
                            if ("border".equals(e.getPropertyName())) {
                                throw new RuntimeException();
                            }
                        }
                    });

            dialogPane.setLayout(new BorderLayout());

            // ======== contentPane ========
            {
                contentPane.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.DEFAULT_COLSPEC, 
                                                                        FormFactory.LABEL_COMPONENT_GAP_COLSPEC, 
                                                                        new ColumnSpec(ColumnSpec.FILL, 
                                                                                       Sizes.DEFAULT, 
                                                                                       FormSpec.DEFAULT_GROW) }, 
                                                     new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC, 
                                                                     FormFactory.LINE_GAP_ROWSPEC, 
                                                                     FormFactory.DEFAULT_ROWSPEC }));

                // ---- lblSourceViewId ----
                lblSourceViewId.setText("Source View ID:");
                contentPane.add(lblSourceViewId, 
                                cc.xywh(1, 1, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- txtSourceViewId ----
                txtSourceViewId.setEditable(false);
                contentPane.add(txtSourceViewId, cc.xy(3, 1));


                cbxOnSubmit.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                cbxOnSubmitActionPerformed(e);
                            }
                        });
                contentPane.add(cbxOnSubmit, cc.xy(3, 7));

                // ---- lblSourceProcessId ----
                lblSourceProcessId.setText("Source Process ID:");
                contentPane.add(lblSourceProcessId, 
                                cc.xywh(1, 3, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- txtSourceProcessId ----
                txtSourceProcessId.setEditable(false);
                contentPane.add(txtSourceProcessId, cc.xy(3, 3));

                // ---- lblInteractionType ----
                lblInteractionType.setText("Interaction Type:");
                contentPane.add(lblInteractionType, 
                                cc.xywh(1, 5, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                rbSubmitMethod.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                lblOnSubmit.setEnabled(true);
                                cbxOnSubmit.setEnabled(true);
                                cbxOnSubmit.setSelectedIndex(0);
                                lblOnReturnValue.setEnabled(false);
                                cbxOnReturnValue.setEnabled(false);
                                cbxOnReturnValue.setSelectedIndex(-1);
                            }
                        });

                rbReturnValue.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                lblOnSubmit.setEnabled(false);
                                cbxOnSubmit.setEnabled(false);
                                cbxOnSubmit.setSelectedIndex(-1);
                                lblOnReturnValue.setEnabled(true);
                                cbxOnReturnValue.setEnabled(true);
                                cbxOnReturnValue.setSelectedIndex(0);
                            }
                        });

                JPanel pnlInteractionType = 
                    new JPanel(new FlowLayout(FlowLayout.LEFT));
                ButtonGroup bgInteractionType = new ButtonGroup();
                bgInteractionType.add(rbSubmitMethod);
                bgInteractionType.add(rbReturnValue);

                pnlInteractionType.add(rbSubmitMethod);
                pnlInteractionType.add(rbReturnValue);
                contentPane.add(pnlInteractionType, cc.xy(3, 5));

                contentPane.add(lblSourceProcessId, 
                                cc.xywh(1, 3, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- txtSourceProcessId ----
                txtSourceProcessId.setEditable(false);
                contentPane.add(txtSourceProcessId, cc.xy(3, 3));


                // ---- lblOnSubmit ----
                lblOnSubmit.setText("On Submit:");
                contentPane.add(lblOnSubmit, 
                                cc.xywh(1, 7, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- lblOnReturnValue ----
                lblOnReturnValue.setText("On Return Value:");
                contentPane.add(lblOnReturnValue, 
                                cc.xywh(1, 9, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                cbxOnReturnValue.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                cbxOnReturnValueActionPerformed(e);
                            }
                        });
                contentPane.add(cbxOnReturnValue, cc.xy(3, 9));

                // ---- lblTargetViewId ----
                lblTargetViewId.setText("Target View ID:");
                contentPane.add(lblTargetViewId, 
                                cc.xywh(1, 11, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- txtTargetViewId ----
                txtTargetViewId.setEditable(false);
                contentPane.add(txtTargetViewId, cc.xy(3, 11));

                // ---- lblTargetProcessId ----
                lblTargetProcessId.setText("Target Process ID:");
                contentPane.add(lblTargetProcessId, 
                                cc.xywh(1, 13, 1, 1, CellConstraints.RIGHT, 
                                        CellConstraints.DEFAULT));

                // ---- txtTargetProcessId ----
                txtTargetProcessId.setEditable(false);
                contentPane.add(txtTargetProcessId, cc.xy(3, 13));
            }
            dialogPane.add(contentPane, BorderLayout.CENTER);

            // ======== buttonBar ========
            {
                buttonBar.setBorder(Borders.BUTTON_BAR_GAP_BORDER);
                buttonBar.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.GLUE_COLSPEC, 
                                                                      FormFactory.BUTTON_COLSPEC, 
                                                                      FormFactory.RELATED_GAP_COLSPEC, 
                                                                      FormFactory.BUTTON_COLSPEC }, 
                                                   RowSpec.decodeSpecs("pref")));

                // ---- okButton ----
                okButton.setText("OK");
                okButton.setEnabled(true);
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

    static boolean flag = false;

    protected void cbxOnReturnValueActionPerformed(ActionEvent e) {
    }

    protected void cbxOnSubmitActionPerformed(ActionEvent e) {
    }

    private void okButtonActionPerformed(ActionEvent e) {
        Interaction interaction = (Interaction)edge.getUserObject();
        if (interaction == null) {
            interaction = new Interaction();
        } else {
            //            Source source = interaction.getSource();
            //            String id = null;
            //            if (source.getId() != null) {
            //                id = source.getValue() + "@" + source.getId();
            //            } else {
            //                SourceView sourceView = 
            //                    interaction.getSource().getSourceView();
            //                SourceProcess sourceProcess = 
            //                    interaction.getSource().getSourceProcess();
            //                if (sourceView != null) {
            //                    id = 
            // sourceView.getSubmitMethodName() + "@" + sourceView.getId();
            //                } else if (sourceProcess != null) {
            //                    id = 
            // sourceProcess.getReturnValueText() + "@" + sourceProcess.getId();
            //                }
            //            }
            Source source = interaction.getSource();
            String id = source.getValue() + "@" + source.getId();
            StudioUtilities.usedNavigations.remove(id);
        }
        Source source = new Source();
        Target target = new Target();
        String id = null;
        com.xradsolutions.xrad.xmlbo.View view = null;
        com.xradsolutions.xrad.xmlbo.Process process = null;
        if (txtSourceViewId.isEnabled()) {
            source.setSourceType("View");
            Object obj = edge.getSourceCell();
            ViewCell viewCell = (ViewCell)obj;
            view = 
                (com.xradsolutions.xrad.xmlbo.View)viewCell.getUserObject();
            source.setPackageName(view.getPackageName());
            source.setName(view.getName());
            source.setId(txtSourceViewId.getText());
            if (cbxOnSubmit.getSelectedIndex() != -1) {
                source.setInteractionType("SubmitMethod");
                source.setValue(cbxOnSubmit.getSelectedItem().toString());
            } else if (cbxOnReturnValue.getSelectedIndex() != -1) {
                source.setInteractionType("ReturnValue");
                source.setValue(cbxOnReturnValue.getSelectedItem().toString());
            }

            if ("<Create New>".equals(source.getValue())) {
                if ("SubmitMethod".equals(source.getInteractionType())) {
                    String name = 
                        JOptionPane.showInputDialog(this, "Enter submit method name:", 
                                                    "method");
                    if (name == null || name.trim().length() == 0) {
                        return;
                    }

                    name = StudioUtilities.normalizeId(name);

                    String type = 
                        (String)JOptionPane.showInputDialog(this, "Select display type:", 
                                                            "Input", 
                                                            JOptionPane.PLAIN_MESSAGE, 
                                                            null, 
                                                            ViewDefDialog.IConstants.submitDisplayTypes, 
                                                            "Button");

                    if (type == null || type.trim().length() == 0) {
                        return;
                    }
                    type = type.trim();
                    SubmitMethod submitMethod = new SubmitMethod();
                    submitMethod.setName(name);
                    submitMethod.setTitle(StudioUtilities.generateTitle(name));
                    submitMethod.setDisplayType(type);
                    view.addSubmitMethod(submitMethod);
                    source.setValue(submitMethod.getName());
                    
                }
                else if ("ReturnValue".equals(source.getInteractionType())) {
                    String text = 
                        JOptionPane.showInputDialog(this, "Enter text to be returned:", 
                                                    "success");

                    if (text == null || text.trim().length() == 0) {
                        return;
                    }

                    text = StudioUtilities.normalizeId(text);

                    ReturnValue returnValue = new ReturnValue();
                    returnValue.setText(text);
                    view.addReturnValue(returnValue);
                    source.setValue(returnValue.getText());
                }
            }

            id = source.getValue() + "@" + source.getId();
            //      SourceView view = new SourceView();
            //      view.setId(txtSourceViewId.getText());
            //      view.setSubmitMethodName(cbxOnSubmit.getSelectedItem().toString());
            //      source.setSourceView(view);
            //      id = view.getSubmitMethodName() + "@" + view.getId();      
        } else if (txtSourceProcessId.isEnabled()) {
            source.setSourceType("Process");
            Object obj = edge.getSourceCell();
            ProcessCell processCell = (ProcessCell)obj;
            process = 
                (com.xradsolutions.xrad.xmlbo.Process)processCell.getUserObject();
            source.setPackageName(process.getPackageName());
            source.setName(process.getName());
            source.setId(txtSourceProcessId.getText());
            source.setInteractionType("ReturnValue");
            source.setValue(cbxOnReturnValue.getSelectedItem().toString());
            
            if ("<Create New>".equals(source.getValue())) {
                if ("ReturnValue".equals(source.getInteractionType())) {
                    String text = 
                        JOptionPane.showInputDialog(this, "Enter text to be returned:", 
                                                    "success");

                    if (text == null || text.trim().length() == 0) {
                        return;
                    }

                    text = StudioUtilities.normalizeId(text);

                    ReturnValue returnValue = new ReturnValue();
                    returnValue.setText(text);
                    process.addReturnValue(returnValue);
                    source.setValue(returnValue.getText());
                }
            }
            
            
            id = source.getValue() + "@" + source.getId();
            //      SourceProcess process = new SourceProcess();
            //      process.setId(txtSourceProcessId.getText());
            //      process.setReturnValueText(cbxOnReturnValue.getSelectedItem().toString());
            //      source.setSourceProcess(process);
            //      id = process.getReturnValueText() + "@" + process.getId();
        }
        if (txtTargetViewId.isEnabled()) {
            target.setTargetType("View");
            Object obj = edge.getTargetCell();
            ViewCell viewCell = (ViewCell)obj;
            view = 
                (com.xradsolutions.xrad.xmlbo.View)viewCell.getUserObject();
            target.setPackageName(view.getPackageName());
            target.setName(view.getName());
            target.setId(txtTargetViewId.getText());
            //      TargetView view = new TargetView();
            //      view.setId(txtTargetViewId.getText());
            //      target.setTargetView(view);
        } else if (txtTargetProcessId.isEnabled()) {
            target.setTargetType("Process");
            Object obj = edge.getTargetCell();
            ProcessCell processCell = (ProcessCell)obj;
            process = 
                (com.xradsolutions.xrad.xmlbo.Process)processCell.getUserObject();
            target.setPackageName(process.getPackageName());
            target.setName(process.getName());
            target.setId(txtTargetProcessId.getText());
            //      TargetProcess process = new TargetProcess();
            //      process.setId(txtTargetProcessId.getText());
            //      target.setTargetProcess(process);
        }
        interaction.setSource(source);
        interaction.setTarget(target);
        edge.setUserObject(interaction);
        StudioUtilities.usedNavigations.add(id);
        selection = JOptionPane.OK_OPTION;
        setVisible(false);
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        selection = JOptionPane.CANCEL_OPTION;
        setVisible(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY
    // //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
    private JPanel dialogPane;

    private JPanel contentPane;

    private JLabel lblSourceViewId;

    private JTextField txtSourceViewId;

    private JLabel lblOnSubmit;

    private JComboBox cbxOnSubmit;

    private JLabel lblSourceProcessId;

    private JTextField txtSourceProcessId;

    private JLabel lblOnReturnValue;

    private JComboBox cbxOnReturnValue;

    private JLabel lblTargetViewId;

    private JTextField txtTargetViewId;

    private JLabel lblTargetProcessId;

    private JTextField txtTargetProcessId;

    private JPanel buttonBar;

    private JButton okButton;

    private JButton cancelButton;


    private JLabel lblInteractionType;
    private JRadioButton rbSubmitMethod;
    private JRadioButton rbReturnValue;
    // JFormDesigner - End of variables declaration //GEN-END:variables

    int selection = JOptionPane.CANCEL_OPTION;

    public int showDialog() {
        setVisible(true);
        try {
            return selection;
        } finally {
            dispose();
        }
    }
}
