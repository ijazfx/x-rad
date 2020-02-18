package com.xradsolutions.xrad.codegen.struts;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.codegen.struts.model.StrutsAction;

import com.xradsolutions.xrad.codegen.struts.model.StrutsActionForward;
import com.xradsolutions.xrad.codegen.struts.model.StrutsJsp;

import com.xradsolutions.xrad.codegen.struts.model.StrutsModel;

import com.xradsolutions.xrad.swing.ComboBoxEditor;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class StrutsJspPanel extends JPanel {
    private BorderLayout loPanel = new BorderLayout();
    private JPanel pnlInput = new JPanel();
    private FormLayout loInput =
        new FormLayout("f:3dlu:n, f:max(d;150px):n, f:3dlu:n, f:max(d;300px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:max(d;15dlu):n, c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JButton btnApply = new JButton();
    private static StrutsJspPanel self;
    private JLabel lblFilename = new JLabel();
    private JLabel lblTitle = new JLabel();
    private JLabel lblLocation = new JLabel();
    private JLabel lblTilesBaseDefinition = new JLabel();
    private JTextField txtJspFile = new JTextField();
    private JTextField txtTitle = new JTextField();
    private JComboBox cbxLocation = new JComboBox();
    private JComboBox cbxTilesBaseDefinition = new JComboBox();
    private JCheckBox chkGenerateSeparateLinksJsp = new JCheckBox();
    private JTextField txtLinksJspFile = new JTextField();
    private JComboBox cbxJspTemplate = new JComboBox();
    private JComboBox cbxLinksJspTemplate = new JComboBox();
    private JLabel lblJspTemplate = new JLabel();
    private JLabel lblLinksJspTemplate = new JLabel();
    private JLabel lblLinksJsp = new JLabel();
    private JLabel lblTilesExtendedDefinition = new JLabel();
    private JScrollPane spTilesDefinitions = new JScrollPane();
    private JTable tblTilesExtendedDefinition = new JTable();
    LinkedHashMap<String, String> puts = new LinkedHashMap<String, String>();

    DefaultTableModel tilesTableModel =
        new DefaultTableModel(new String[] { "Put", "Value" }, 0);

    StrutsJsp strutsJsp;
    JComponent owner;
    StrutsModel model;
    private JCheckBox chkUseTilesFramework = new JCheckBox();

    private StrutsJspPanel(JComponent owner) {
        try {
            this.owner = owner;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StrutsJspPanel createStrutsJspPanel(JComponent owner,
                                                      StrutsModel model,
                                                      StrutsJsp jsp) {
        if (self == null) {
            self = new StrutsJspPanel(owner);
        }
        self.setModel(model);
        self.setup();
        self.setStrutsJsp(jsp);
        return self;
    }

    private void jbInit() throws Exception {
        this.setLayout(loPanel);
        this.setSize(new Dimension(500, 450));
        pnlInput.setLayout(loInput);
        pnlInput.setSize(new Dimension(400, 400));
        btnApply.setText("Apply!");
        btnApply.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnApply_actionPerformed(e);
                    }
                });
        lblFilename.setText("JSP File");
        lblTitle.setText("Title");
        lblLocation.setText("Location");
        lblTilesBaseDefinition.setText("Tiles Base Definition");
        cbxLocation.setEditable(true);
        cbxTilesBaseDefinition.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cbxLayout_actionPerformed(e);
                    }
                });
        chkGenerateSeparateLinksJsp.setText("Generate Separate JSP for Links");
        chkGenerateSeparateLinksJsp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        chkGenerateSeparateLinksJsp_actionPerformed(e);
                    }
                });
        txtLinksJspFile.setEditable(false);
        cbxLinksJspTemplate.setEnabled(false);
        lblJspTemplate.setText("JSP Template");
        lblLinksJspTemplate.setText("Links JSP Template");
        lblLinksJspTemplate.setEnabled(false);
        lblLinksJsp.setText("Links JSP File");
        lblLinksJsp.setEnabled(false);
        lblTilesExtendedDefinition.setText("Tiles Extended Definition");
        tblTilesExtendedDefinition.setPreferredScrollableViewportSize(new Dimension(450,
                                                                             100));
        this.add(pnlInput, BorderLayout.NORTH);
        pnlInput.add(lblFilename,
                     new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblTitle,
                     new CellConstraints(2, 7, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblLocation,
                     new CellConstraints(2, 8, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblTilesBaseDefinition,
                     new CellConstraints(2, 10, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        txtJspFile.setEditable(false);
        pnlInput.add(txtJspFile,
                     new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        txtTitle.setEditable(false);
        pnlInput.add(txtTitle,
                     new CellConstraints(4, 7, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(cbxLocation,
                     new CellConstraints(4, 8, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(cbxTilesBaseDefinition,
                     new CellConstraints(4, 10, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(chkGenerateSeparateLinksJsp,
                     new CellConstraints(2, 4, 3, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(txtLinksJspFile,
                     new CellConstraints(4, 5, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(cbxJspTemplate,
                     new CellConstraints(4, 3, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(cbxLinksJspTemplate,
                     new CellConstraints(4, 6, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblJspTemplate,
                     new CellConstraints(2, 3, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblLinksJspTemplate,
                     new CellConstraints(2, 6, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblLinksJsp,
                     new CellConstraints(2, 5, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(lblTilesExtendedDefinition,
                     new CellConstraints(2, 11, 1, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        spTilesDefinitions.getViewport().add(tblTilesExtendedDefinition, null);
        pnlInput.add(spTilesDefinitions,
                     new CellConstraints(2, 12, 3, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));
        pnlInput.add(chkUseTilesFramework,
                     new CellConstraints(2, 9, 3, 1, CellConstraints.DEFAULT,
                                         CellConstraints.DEFAULT));pnlInput.add(btnApply,
                     new CellConstraints(4, 14, 1, 1, CellConstraints.RIGHT,
                                         CellConstraints.DEFAULT));
        tblTilesExtendedDefinition.setModel(tilesTableModel);
        chkUseTilesFramework.setText("Use Tiles Framework");
        chkUseTilesFramework.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        chkUseTilesFramework_actionPerformed(e);
                    }
                });

    }

    public StrutsJsp getStrutsJsp() {
        return strutsJsp;
    }

    public void setStrutsJsp(StrutsJsp strutsJsp) {
        this.strutsJsp = strutsJsp;
        txtJspFile.setText(strutsJsp.getJspFile());
        cbxJspTemplate.setSelectedItem(strutsJsp.getJspTemplate());
        chkGenerateSeparateLinksJsp.setSelected(strutsJsp.isGenerateSeparateLinksJsp());
        txtLinksJspFile.setText(strutsJsp.getLinksJspFile());
        cbxLinksJspTemplate.setSelectedItem(strutsJsp.getLinksJspTemplate());
        txtTitle.setText(strutsJsp.getTitle());
        cbxLocation.setSelectedItem(strutsJsp.getLocation());
        if(strutsJsp.getTilesBaseDefinition() !=null) {
          cbxTilesBaseDefinition.setSelectedItem(strutsJsp.
                                                 getTilesBaseDefinition());
        }
        String selectedLayout = (String)cbxTilesBaseDefinition.getSelectedItem();
        chkUseTilesFramework.setSelected(strutsJsp.isUseTilesFramework());
        if (selectedLayout != null) {
        }
    }

    private void btnApply_actionPerformed(ActionEvent e) {
        int selection = JOptionPane.showConfirmDialog(this, "Are you sure to apply changes?", "Alert", JOptionPane.YES_NO_OPTION);
        if(selection == JOptionPane.YES_OPTION){
        strutsJsp.setJspFile(txtJspFile.getText());
        strutsJsp.setJspTemplate((String)cbxJspTemplate.getSelectedItem());
        strutsJsp.setGenerateSeparateLinksJsp(chkGenerateSeparateLinksJsp.isSelected());
        strutsJsp.setLinksJspFile(txtLinksJspFile.getText());
        strutsJsp.setLinksJspTemplate((String)cbxLinksJspTemplate.getSelectedItem());
        strutsJsp.setTitle(txtTitle.getText());
        String oldPath = strutsJsp.getLocation() + strutsJsp.getBackingAction().getIdentifier();
        strutsJsp.setLocation((String)cbxLocation.getSelectedItem());
        String newPath = strutsJsp.getLocation() + strutsJsp.getBackingAction().getIdentifier();
        if(!oldPath.equals(newPath)) {
            for(StrutsAction action : model.getActions().values()) {
                for(StrutsActionForward forward : action.getForwards().values()) {
                    System.out.println(action.getClassName() + ":" + forward.getName() + ":" + forward.getPath());
                    if(forward.getPath().contains(oldPath)) {
                        forward.setPath(forward.getPath().replace(oldPath, newPath));
                    }
                }
            }
        }
        strutsJsp.setUseTilesFramework(chkUseTilesFramework.isSelected());
        LinkedHashMap<String, LinkedHashMap<String, String>> odefs = ThemeManager.retriveTilesBaseDefinitions(model.getJspTheme());
        if(cbxTilesBaseDefinition.getSelectedItem()!=null) {
          LinkedHashMap<String,
              String>
              oputs = odefs.get( (String) cbxTilesBaseDefinition.getSelectedItem());
          if (strutsJsp.isUseTilesFramework()) {
            strutsJsp.setTilesBaseDefinition( (String) cbxTilesBaseDefinition.
                                             getSelectedItem());
            LinkedHashMap<String, String> puts = new LinkedHashMap();
            Vector rows = tilesTableModel.getDataVector();
            for (int i = 0; i < rows.size(); i++) {
              Vector cols = (Vector) rows.get(i);
              String put = (String) cols.get(0);
              String source = (String) cols.get(1);
              if (source == null || source.trim().length() == 0) {
                ; // Donot add empty put in the puts map.
              }
              else {
                String value = oputs.get(put);
                if (!source.equals(value)) {
                  puts.put(put, source);
                }
              }
            }
            strutsJsp.setPuts(puts);
          }
        }
      }
    }

    private void chkGenerateSeparateLinksJsp_actionPerformed(ActionEvent e) {
        boolean flag = chkGenerateSeparateLinksJsp.isSelected();
        lblLinksJsp.setEnabled(flag);
        txtLinksJspFile.setEditable(flag);
        lblLinksJspTemplate.setEnabled(flag);
        cbxLinksJspTemplate.setEnabled(flag);
        if (flag) {
            txtLinksJspFile.setText("Links_" + txtJspFile.getText());
        } else {
            txtLinksJspFile.setText(null);
            cbxLinksJspTemplate.setSelectedIndex(-1);
        }
    }

    private void setup() {
        if (model.getJspTheme() != null) {
            String[] templates = ThemeManager.retriveVelocityThemes(model.getJspTheme());
            LinkedHashMap<String, LinkedHashMap<String, String>> defs = ThemeManager.retriveTilesBaseDefinitions(model.getJspTheme());
            DefaultComboBoxModel jspTemplateModel =
                new DefaultComboBoxModel(templates);
            DefaultComboBoxModel jspLinksTemplateModel =
                new DefaultComboBoxModel(templates);
            cbxLinksJspTemplate.setModel(jspLinksTemplateModel);
            cbxJspTemplate.setModel(jspTemplateModel);
            cbxLinksJspTemplate.setSelectedIndex(-1);
            cbxJspTemplate.setSelectedIndex(-1);
            String[] tilesDefs = (defs == null) ? new String[] {"-- No Definition Found --"} :
                defs.keySet().toArray(new String[] {});
            DefaultComboBoxModel tilesLayoutModel =
                new DefaultComboBoxModel(tilesDefs);
            cbxTilesBaseDefinition.setModel(tilesLayoutModel);
            cbxTilesBaseDefinition.setSelectedIndex(-1);
        }
    }

    public StrutsModel getModel() {
        return model;
    }

    public void setModel(StrutsModel model) {
        this.model = model;
    }

    private void cbxLayout_actionPerformed(ActionEvent e) {

        String selectedDefinition = (String)cbxTilesBaseDefinition.getSelectedItem();
        tilesTableModel.getDataVector().removeAllElements();

        LinkedHashMap<String, LinkedHashMap<String, String>> defs = ThemeManager.retriveTilesBaseDefinitions(model.getJspTheme());
        List<String> files = new ArrayList();
        files.add(cbxLocation.getSelectedItem() + txtJspFile.getText());
        files.add(cbxLocation.getSelectedItem() + txtLinksJspFile.getText());


        if (selectedDefinition != null && selectedDefinition.indexOf("No Definition Found")==-1) {
          puts = defs.get(selectedDefinition);
          Iterator iter = puts.keySet().iterator();
          while (iter.hasNext()) {
            String put = (String) iter.next();
            String value = puts.get(put);
            if (strutsJsp.getPuts().containsKey(put)) {
              value = strutsJsp.getPuts().get(put);
            }
            else {
              value = puts.get(put);
            }
            files.add(value);
            tilesTableModel.addRow(new String[] {put, value});
          }
        }
        TableColumn column = tblTilesExtendedDefinition.getColumnModel().getColumn(1);
        column.setCellEditor(new ComboBoxEditor(files.toArray(new String[] {}), true));

    }

    private void chkUseTilesFramework_actionPerformed(ActionEvent e) {
//        boolean flag = chkUseTilesFramework.isSelected();
//        lblTilesBaseDefinition.setEnabled(flag);
//        lblTilesExtendedDefinition.setEnabled(flag);
//        cbxTilesBaseDefinition.setEnabled(flag);
//        tblTilesExtendedDefinition.setEnabled(flag);
    }
}
