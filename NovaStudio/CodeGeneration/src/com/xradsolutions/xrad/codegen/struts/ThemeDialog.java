package com.xradsolutions.xrad.codegen.struts;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import com.xradsolutions.xrad.XRadUtilities;
import com.xradsolutions.xrad.swing.CustomizedFileChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import java.util.Vector;

import java.util.jar.JarFile;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.apache.tools.ant.taskdefs.Ant;
import org.apache.tools.ant.taskdefs.Jar;
import static com.xradsolutions.xrad.codegen.struts.ThemeManager.*;

public class ThemeDialog extends JDialog {
    private BorderLayout loDialog = new BorderLayout();
    private JPanel pnlButtons = new JPanel();
    private FormLayout loButtons = 
        new FormLayout("f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n", 
                       "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JButton btnOK = new JButton();
    private JButton btnCancel = new JButton();
    private JPanel pnlMain = new JPanel();
    private FormLayout loMain = 
        new FormLayout("f:3dlu:n, r:max(d;100px):n, f:3dlu:n, f:max(d;20dlu):g, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n, f:max(d;20dlu):n, f:3dlu:n", "c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n, c:max(d;15dlu):n, c:3dlu:n");
    private JLabel lblAvailableThemes = new JLabel();
    private JScrollPane spThemes = new JScrollPane();
    private JList lstThemes = new JList(new DefaultListModel());
    private JButton btnImport = new JButton();
    private JButton btnCompile = new JButton();

    static File currentDirectory;
    private JButton btnRemove = new JButton();

    public ThemeDialog() {
        try {
            jbInit();
            setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(500, 300));
        this.setTitle("Struts Website Themes");
        this.getContentPane().setLayout(loDialog);
        this.setModal(true);
        pnlButtons.setLayout(loButtons);
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
        pnlMain.setLayout(loMain);
        lblAvailableThemes.setText("Available Themes");
        spThemes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        btnImport.setText("Import...");
        btnImport.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnImport_actionPerformed(e);
                    }
                });
        btnCompile.setText("Compile...");
        btnCompile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnCompile_actionPerformed(e);
                    }
                });
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnRemove_actionPerformed(e);
                    }
                });
        pnlButtons.add(btnOK, 
                       new CellConstraints(4, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        pnlButtons.add(btnCancel, 
                       new CellConstraints(6, 2, 1, 1, CellConstraints.DEFAULT, 
                                           CellConstraints.DEFAULT));
        this.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
        this.getContentPane().add(pnlMain, BorderLayout.CENTER);
        pnlMain.add(lblAvailableThemes, 
                    new CellConstraints(2, 2, 3, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        spThemes.getViewport().add(lstThemes, null);
        pnlMain.add(spThemes, 
                    new CellConstraints(2, 4, 9, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        pnlMain.add(btnImport, 
                    new CellConstraints(6, 6, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));
        pnlMain.add(btnCompile, 
                    new CellConstraints(8, 6, 1, 1, CellConstraints.DEFAULT, 
                                        CellConstraints.DEFAULT));

        pnlMain.add(btnRemove,
                    new CellConstraints(10, 6, 1, 1, CellConstraints.DEFAULT,
                                        CellConstraints.DEFAULT));
        getRootPane().setDefaultButton(btnOK);
        getRootPane().registerKeyboardAction(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnCancel_actionPerformed(e);
                    }
                }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private void btnCancel_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    private void btnOK_actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    private void btnImport_actionPerformed(ActionEvent e) {
        DefaultListModel lmThemes = 
            (DefaultListModel)lstThemes.getModel();

        CustomizedFileChooser fc = 
            new CustomizedFileChooser(new String[] { ".jar", ".zip" }, 
                                      "Compiled Struts Themes (*.jar, *.zip) or Theme Folders");
        fc.setFileSelectionMode(CustomizedFileChooser.FILES_AND_DIRECTORIES);                                      
        fc.setCurrentDirectory(currentDirectory);
        int selection = fc.showOpenDialog(this);
        if (selection == CustomizedFileChooser.APPROVE_OPTION) {
            currentDirectory = fc.getCurrentDirectory();
            String description = 
                JOptionPane.showInputDialog(this, "Theme Description", 
                                            "Input", 
                                            JOptionPane.QUESTION_MESSAGE);
            if (description == null) {
                return;
            }
            String fileName = fc.getSelectedFile().getAbsolutePath();
            if (themes.containsKey(fileName)) {
                String elem = 
                    themes.getProperty(fileName) + " [" + fileName + "]";
                themes.remove(fileName);
                lmThemes.removeElement(elem);
            }
            themes.put(fileName, description);
//            lmThemes.addElement(description + " (" + fileName + ")");
            saveThemes();
            loadThemes();
        }
    }

    private void btnCompile_actionPerformed(ActionEvent e) {
        DefaultListModel lmThemes = 
            (DefaultListModel)lstThemes.getModel();

        CustomizedFileChooser fc = 
            new CustomizedFileChooser(null, 
                                      "Folder Containing Theme Resource");
        fc.setFileSelectionMode(CustomizedFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(currentDirectory);
        int selection = fc.showOpenDialog(this);
        if (selection == CustomizedFileChooser.APPROVE_OPTION) {
            currentDirectory = fc.getCurrentDirectory();
            String description = 
                JOptionPane.showInputDialog(this, "Theme Description", 
                                            "Input", 
                                            JOptionPane.QUESTION_MESSAGE);
            if (description == null) {
                return;
            }
            String basedir = fc.getSelectedFile().getAbsolutePath();
            String destfile = basedir + ".jar";
            
            try {
                
                String buildFile = XRadUtilities.XRAD_HOME + "/codegen/struts-1.2/ant/compile-theme-build.xml";
                Project project = new Project();
                project.init();
                project.setBaseDir(new File(basedir));
                ProjectHelper.getProjectHelper().parse(project, new File(buildFile));
                project.setProperty("basedir", basedir);
                project.setProperty("destfile", destfile);
                String target = project.getDefaultTarget();
                project.executeTarget(target);
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
            
            if (themes.containsKey(destfile)) {
                String elem = 
                    themes.getProperty(destfile) + " [" + destfile + "]";
                themes.remove(destfile);
                lmThemes.removeElement(elem);
            }
            themes.put(destfile, description);
        //            lmThemes.addElement(description + " (" + fileName + ")");
            saveThemes();
            loadThemes();
        }
    }

    private void setup() {
        loadThemes();
    }

    private void loadThemes() {
        DefaultListModel lmThemes = 
            (DefaultListModel)lstThemes.getModel();
        lmThemes.clear();

        try {
            File themeFile = new File(themeFileName);
            FileInputStream fis = new FileInputStream(themeFile);
            themes.load(fis);
            fis.close();
            Enumeration enu = themes.keys();
            while (enu.hasMoreElements()) {
                String key = (String)enu.nextElement();
                String value = (String)themes.get(key);
                lmThemes.addElement(value + " [" + key + "]");
            }
        } catch (IOException e) {
            // TODO
            lmThemes.addElement("-- No Tempates Available --");
        }
    }

    private void saveThemes() {
        try {
            File themeFile = new File(themeFileName);
            if (!themeFile.getParentFile().exists()) {
                themeFile.getParentFile().mkdirs();
            }
            if (!themeFile.exists()) {
                themeFile.createNewFile();
            }

            FileOutputStream fos = 
                new FileOutputStream(themeFile.getAbsolutePath());
            themes.store(fos, "Modified on " + new Date());
            fos.close();
        } catch (IOException ex) {

        }
    }

    private void btnRemove_actionPerformed(ActionEvent e) {
    
        int index = lstThemes.getSelectedIndex();
        if(index != -1) {
            DefaultListModel lmThemes = 
                (DefaultListModel)lstThemes.getModel();
            String selected = (String)lmThemes.getElementAt(index);
            int idx1 = selected.indexOf('[', 0);
            int idx2 = selected.indexOf(']', idx1);
            String key = selected.substring(idx1+1, idx2);
            lmThemes.removeElementAt(index);
            themes.remove(key);
            saveThemes();
        }
    }
}
