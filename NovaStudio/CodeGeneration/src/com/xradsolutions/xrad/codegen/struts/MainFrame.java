package com.xradsolutions.xrad.codegen.struts;

import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import org.apache.velocity.*;
import org.apache.velocity.app.*;
import org.apache.velocity.context.*;
import org.apache.velocity.exception.*;
import com.xradsolutions.xrad.*;
import com.xradsolutions.xrad.codegen.struts.model.*;
import com.xradsolutions.xrad.xmlbo.*;
import com.xradsolutions.xrad.codegen.struts.helper.*;
import com.xradsolutions.xrad.codegen.generators.*;

public class MainFrame extends JFrame {
    StrutsModel model;
    File modelFile;

    private JMenuBar mbMain = new JMenuBar();
    private JMenu miFile = new JMenu();
    private JMenuItem miFileExit = new JMenuItem();
    private JMenu miModel = new JMenu();
    private JMenuItem miModelSettings = new JMenuItem();
    private JMenuItem miModelGenerateCode = new JMenuItem();
    private JMenu miTools = new JMenu();
    private JMenuItem miToolsConfigureThemes = new JMenuItem();
    private JMenu miHelp = new JMenu();
    private JMenuItem miHelpAbout = new JMenuItem();
    private JTabbedPane tpFrame = new JTabbedPane();
    private JSplitPane spStrutsStructure = new JSplitPane();
    private JPanel pnlProperties = new JPanel();
    private BorderLayout loProperties = new BorderLayout();
    private JScrollPane spTreStrutsStructure = new JScrollPane();
    private JTree treStrutsStructure = new JTree();
    private JMenuItem miFileSave = new JMenuItem();
  private AppModel appModel;

  public MainFrame(StrutsModel model, File modelFile) {
        try {
            this.model = model;
            this.modelFile = modelFile;
            jbInit();
            setupStrutsStructure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setTitle("Struts Code Generator");
        this.setSize(new Dimension(800, 600));
        this.setJMenuBar(mbMain);
        miFile.setText("File");
        miFileExit.setText("Exit");
        miFileExit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        miFileExit_actionPerformed(e);
                    }
                });
        miModel.setText("Model");
        miModelSettings.setText("Settings...");
        miModelSettings.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        miModelSettings_actionPerformed(e);
                    }
                });
        miModelGenerateCode.setText("Generate Code");
        miModelGenerateCode.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        miModelGenerateCode_actionPerformed(e);
                    }
                });
        miTools.setText("Tools");
        miToolsConfigureThemes.setText("Configure Themes...");
        miToolsConfigureThemes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        miToolsConfigureThemes_actionPerformed(e);
                    }
                });
        miHelp.setText("Help");
        miHelpAbout.setText("About");
        spStrutsStructure.setDividerSize(3);
        spStrutsStructure.setDividerLocation(300);
        spStrutsStructure.setLastDividerLocation(200);
        pnlProperties.setLayout(loProperties);
        pnlProperties.setBorder(BorderFactory.createTitledBorder("Properties"));
        treStrutsStructure.addTreeSelectionListener(new TreeSelectionListener() {
                    public void valueChanged(TreeSelectionEvent e) {
                        treStrutsStructure_valueChanged(e);
                    }
                });
        miFileSave.setText("Save!");
        miFileSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        miFileSave_actionPerformed(e);
                    }
                });
        miFile.add(miFileSave);
        miFile.addSeparator();
        miFile.add(miFileExit);
        mbMain.add(miFile);
        miModel.add(miModelSettings);
        miModel.addSeparator();
        miModel.add(miModelGenerateCode);
        mbMain.add(miModel);
        miTools.add(miToolsConfigureThemes);
        mbMain.add(miTools);
        miHelp.add(miHelpAbout);
        mbMain.add(miHelp);
        spStrutsStructure.add(pnlProperties, JSplitPane.RIGHT);
        spTreStrutsStructure.getViewport().add(treStrutsStructure, null);
        spStrutsStructure.add(spTreStrutsStructure, JSplitPane.LEFT);
        tpFrame.addTab("Struts Structure", spStrutsStructure);
        this.getContentPane().add(tpFrame, null);
    }

    private void miToolsConfigureThemes_actionPerformed(ActionEvent e) {
        JDialog dialog = new ThemeDialog();
        XRadUtilities.center(dialog);
        dialog.setVisible(true);

    }

    private void miFileExit_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    private void setupStrutsStructure() {
        MutableTreeNode root = new DefaultMutableTreeNode("*");
        MutableTreeNode jspsNode = new DefaultMutableTreeNode("JSP");
        MutableTreeNode formsNode = new DefaultMutableTreeNode("Action Form");
        MutableTreeNode actionsNode = new DefaultMutableTreeNode("Action");
        root.insert(jspsNode, 0);
        root.insert(formsNode, 1);
        root.insert(actionsNode, 2);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        if (model != null) {
            Collection<StrutsJsp> jsps = model.getJsps().values();
            MutableTreeNode child, subChild;
            int i = 0;
            for (StrutsJsp jsp: jsps) {
                child = new StrutsMutableTreeNode(TreeNodeType.JSP, jsp);

                jspsNode.insert(child, i++);
                if (jsp.getBackingForm() != null) {
                    subChild =
                            new StrutsMutableTreeNode(TreeNodeType.ACTION_FORM,
                                                      jsp.getBackingForm());
                    child.insert(subChild, 0);
                    if (jsp.getBackingAction() != null) {
                        subChild =
                                new StrutsMutableTreeNode(TreeNodeType.ACTION,
                                                          jsp.getBackingAction());
                        child.insert(subChild, 1);
                    }
                }
            }
            i = 0;
            Collection<StrutsForm> forms = model.getForms().values();
            for (StrutsForm form: forms) {
                child =
                        new StrutsMutableTreeNode(TreeNodeType.ACTION_FORM, form);
                formsNode.insert(child, i++);
            }
            i = 0;
            Collection<StrutsAction> actions = model.getActions().values();
            for (StrutsAction action: actions) {
                child = new StrutsMutableTreeNode(TreeNodeType.ACTION, action);
                actionsNode.insert(child, i++);
                subChild = new DefaultMutableTreeNode("Inbound");
                boolean found = false;
                int j = 0;
                for(StrutsForm form : action.getInboundActionForms().values()) {
                    found = true;
                    subChild.insert(new StrutsMutableTreeNode(TreeNodeType.ACTION_FORM, form), j++);
                }
                if(found) {
                    child.insert(subChild, 0);
                }
                subChild = new DefaultMutableTreeNode("Outbound");
                found = false;
                j = 0;
                for(StrutsForm form : action.getOutboundActionForms().values()) {
                    found = true;
                    subChild.insert(new StrutsMutableTreeNode(TreeNodeType.ACTION_FORM, form), j++);
                }
                if(found) {
                    child.insert(subChild, 0);
                }
            }
        }
        treStrutsStructure.setModel(treeModel);
    }

    private void treStrutsStructure_valueChanged(TreeSelectionEvent e) {
        MutableTreeNode node =
            (MutableTreeNode)treStrutsStructure.getLastSelectedPathComponent();
        if (node instanceof StrutsMutableTreeNode) {
            JComponent propertyPanel =
                new JLabel("Nothing to display!", JLabel.CENTER);
            StrutsMutableTreeNode smtnode = (StrutsMutableTreeNode)node;
            if (smtnode.getNodeType() == TreeNodeType.ACTION) {
                propertyPanel =
                        StrutsActionPanel.createStrutsActionPanel(treStrutsStructure,
                                                                  (StrutsAction)smtnode.getUserObject());
            } else if (smtnode.getNodeType() == TreeNodeType.JSP) {
                propertyPanel =
                        StrutsJspPanel.createStrutsJspPanel(treStrutsStructure,
                                                            model,
                                                            (StrutsJsp)smtnode.getUserObject());
            } else if (smtnode.getNodeType() == TreeNodeType.ACTION_FORM) {
                propertyPanel =
                        StrutsFormPanel.createStrutsFormPanel(treStrutsStructure,
                                                              model,
                                                              (StrutsForm)smtnode.getUserObject());
            }
            pnlProperties.removeAll();
            pnlProperties.add(propertyPanel, BorderLayout.CENTER);
            spStrutsStructure.updateUI();
        }

    }

    private void miModelSettings_actionPerformed(ActionEvent e) {
        JDialog dialog = new ModelSettingsDialog(model);
        XRadUtilities.center(dialog);
        dialog.setVisible(true);
    }

    private void miFileSave_actionPerformed(ActionEvent e) {
        model.saveToFile(modelFile);
    }

    private void miModelGenerateCode_actionPerformed(ActionEvent e) {
        generateCode();
    }

    static enum TreeNodeType {
        JSP,
        ACTION_FORM,
        ACTION,
        FORWARD,
        SUBMIT,
        PROPERTY,
        ;
    }

    static class StrutsMutableTreeNode extends DefaultMutableTreeNode {
        TreeNodeType nodeType;

        public StrutsMutableTreeNode(TreeNodeType nodeType,
                                     Object userObject) {
            super(userObject);
            this.nodeType = nodeType;
        }

        public MainFrame.TreeNodeType getNodeType() {
            return nodeType;
        }

        public void setNodeType(MainFrame.TreeNodeType nodeType) {
            this.nodeType = nodeType;
        }
    }
    private void generateCode() {
      String modelFileName = modelFile.getName().split("[.]")[0];
      StrutsCodeGenerator codeGen = new StrutsCodeGenerator(appModel,model,modelFileName);
      if(XRadUtilities.TEMPLATES.equals("templates-ase-1.0")) {
        codeGen.generateVersionOne();
      } else {
        codeGen.generateStantdard();
      }
    }

  /**
   * setAppModel
   *
   * @param model AppModel
   */
  public void setAppModel(AppModel appModel) {
    this.appModel = appModel;
  }

}
