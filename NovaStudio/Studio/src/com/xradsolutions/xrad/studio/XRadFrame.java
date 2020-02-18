package com.xradsolutions.xrad.studio;

import com.xradsolutions.xrad.cg.AbstractCodeGenerator;
import com.xradsolutions.xrad.codegen.XCodeGenerator;
import com.xradsolutions.xrad.studio.resources.Resources;
import com.xradsolutions.xrad.xmlbo.AppModel;
import com.xradsolutions.xrad.xmlbo.Interaction;
import com.xradsolutions.xrad.xmlbo.Source;
import com.xradsolutions.xrad.xmlbo.SourceProcess;
import com.xradsolutions.xrad.xmlbo.SourceView;

import java.io.*;

import java.lang.reflect.*;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import org.jgraph.graph.*;

/*
 * Created by JFormDesigner on Wed Nov 09 11:36:29 AST 2005
 */

/**
 * @author Farrukh Ijaz
 */
public class XRadFrame extends JFrame {

    AppModel appModel = null;
    boolean modified = false;
    File xrdFile = null;

    public XRadFrame() {
        initComponents();
        reset();
    }

    public void reset() {
        setTitle(StudioUtilities.APP_TITLE);
        toggleControls(false);
        xrdFile =
                new File(System.getProperty("user.home"), "/.nova-models/.");
        if (!xrdFile.exists() || !xrdFile.isDirectory()) {
            xrdFile.mkdirs();
        }
    }

    public void toggleControls(boolean flag) {
        if (!flag) {
            // Global vectors...
            StudioUtilities.packages = new Vector();
            StudioUtilities.usedClassNames = new HashMap();
            StudioUtilities.usedIds = new HashMap();
            StudioUtilities.stereoTypes = new Vector();
            StudioUtilities.scenarios = new Vector();
            StudioUtilities.usedNavigations = new Vector();
            // Application config
            appModel = null;
            // Graph control...
            if (graph != null) {
                scrollPane.getViewport().remove(graph);
                scrollPane.getViewport().updateUI();
                graph = null;
            }
        } else {
            if (graph == null) {
                graph = XRadGraph.createGraph(this);
            }
            scrollPane.getViewport().add(graph);
        }
        // File menu items...
        miClose.setEnabled(flag);
        miSave.setEnabled(flag);
        miSaveAs.setEnabled(flag);
        // Edit menu items...
        miUndo.setEnabled(flag);
        miRedo.setEnabled(flag);
        miCut.setEnabled(flag);
        miCopy.setEnabled(flag);
        miPaste.setEnabled(flag);
        miDelete.setEnabled(flag);
        // Search menu items...
        miFind.setEnabled(flag);
        miFindNext.setEnabled(flag);
        // Application menu...
        mnuApplication.setEnabled(flag);
        // Toolbar buttons...
        btnView.setEnabled(flag);
        btnProcess.setEnabled(flag);
        btnLink.setEnabled(flag);
        btnSnap.setEnabled(flag);
        btnGrid.setEnabled(flag);
        btnZoomIn.setEnabled(flag);
        btnZoomOut.setEnabled(flag);
        btnZoom1By1.setEnabled(flag);
    }

    private void initComponents() {
        setIconImage(Resources.APP_ICON.getImage());
        setSize(new Dimension(1024, 768));
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
        pnlMain = new JPanel();
        menuBar = new JMenuBar();
        mnuFile = new JMenu();
        miNewApplication = new JMenuItem();
        miOpen = new JMenuItem();
        miClose = new JMenuItem();
        miSave = new JMenuItem();
        miSaveAs = new JMenuItem();
        miExit = new JMenuItem();
        mnuEdit = new JMenu();
        miUndo = new JMenuItem();
        miRedo = new JMenuItem();
        miCut = new JMenuItem();
        miCopy = new JMenuItem();
        miPaste = new JMenuItem();
        miDelete = new JMenuItem();
        miPreferences = new JMenuItem();
        mnuSearch = new JMenu();
        miFind = new JMenuItem();
        miFindNext = new JMenuItem();
        mnuApplication = new JMenu();
        miProperties = new JMenuItem();
        mnuCodeGeneration = new JMenu();
        miSettings = new JMenuItem();
        toolBar = new JToolBar();
        btnView = new JButton();
        btnProcess = new JButton();
        btnLink = new JToggleButton();
        btnSnap = new JToggleButton();
        btnGrid = new JToggleButton();
        btnZoomIn = new JButton();
        btnZoomOut = new JButton();
        btnZoom1By1 = new JButton();

        scrollPane = new JScrollPane();

        // ======== this ========
        setTitle(StudioUtilities.APP_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // ======== pnlMain ========
        {
            setSize(new Dimension(1024, 768));

            // JFormDesigner evaluation mark
            // pnlMain
            // .setBorder(new javax.swing.border.CompoundBorder(
            // new javax.swing.border.TitledBorder(
            // new javax.swing.border.EmptyBorder(0, 0, 0,
            // 0), "JFormDesigner Evaluation",
            // javax.swing.border.TitledBorder.CENTER,
            // javax.swing.border.TitledBorder.BOTTOM,
            // new java.awt.Font("Dialog",
            // java.awt.Font.BOLD, 12),
            // java.awt.Color.red), pnlMain.getBorder()));
            pnlMain.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent e) {
                            if ("border".equals(e.getPropertyName())) {
                                //            throw new RuntimeException();
                            }
                        }
                    });

            pnlMain.setLayout(new BorderLayout());

            // ======== menuBar ========
            {

                // ======== mnuFile ========
                {
                    mnuFile.setText("File");
                    mnuFile.setMnemonic('F');

                    // ---- miNewApplication ----
                    miNewApplication.setText("New Application...");
                    miNewApplication.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                                                                           KeyEvent.CTRL_MASK));
                    miNewApplication.setMnemonic('N');
                    miNewApplication.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miNewApplicationActionPerformed(e);
                                }
                            });
                    mnuFile.add(miNewApplication);

                    // ---- miOpen ----
                    miOpen.setText("Open...");
                    miOpen.setMnemonic('O');
                    miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                                                 KeyEvent.CTRL_MASK));
                    miOpen.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miOpenActionPerformed(e);
                                }
                            });
                    mnuFile.add(miOpen);
                    mnuFile.addSeparator();

                    // ---- miClose ----
                    miClose.setText("Close");
                    miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                                                                  KeyEvent.CTRL_MASK));
                    miClose.setMnemonic('C');
                    miClose.setEnabled(false);
                    miClose.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miCloseActionPerformed(e);
                                }
                            });
                    mnuFile.add(miClose);
                    mnuFile.addSeparator();

                    // ---- miSave ----
                    miSave.setText("Save");
                    miSave.setMnemonic('S');
                    miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                                                 KeyEvent.CTRL_MASK));
                    miSave.setEnabled(false);
                    miSave.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miSaveActionPerformed(e);
                                }
                            });
                    mnuFile.add(miSave);

                    // ---- miSaveAs ----
                    miSaveAs.setText("Save As...");
                    miSaveAs.setMnemonic('A');
                    miSaveAs.setIcon(null);
                    miSaveAs.setEnabled(false);
                    miSaveAs.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miSaveAsActionPerformed(e);
                                }
                            });
                    mnuFile.add(miSaveAs);
                    mnuFile.addSeparator();

                    // ---- miExit ----
                    miExit.setText("Exit");
                    miExit.setMnemonic('X');
                    miExit.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miExitActionPerformed(e);
                                }
                            });
                    mnuFile.add(miExit);
                }
                menuBar.add(mnuFile);

                // ======== mnuEdit ========
                {
                    mnuEdit.setText("Edit");
                    mnuEdit.setMnemonic('E');

                    // ---- miUndo ----
                    miUndo.setText("Undo");
                    miUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                                                                 KeyEvent.CTRL_MASK));
                    miUndo.setMnemonic('U');
                    miUndo.setEnabled(false);
                    miUndo.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miUndoActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miUndo);

                    // ---- miRedo ----
                    miRedo.setText("Redo");
                    miRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                                                                 KeyEvent.CTRL_MASK));
                    miRedo.setMnemonic('R');
                    miRedo.setEnabled(false);
                    miRedo.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miRedoActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miRedo);
                    mnuEdit.addSeparator();

                    // ---- miCut ----
                    miCut.setText("Cut");
                    miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                                                KeyEvent.CTRL_MASK));
                    miCut.setMnemonic('T');
                    miCut.setEnabled(false);
                    miCut.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miCutActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miCut);

                    // ---- miCopy ----
                    miCopy.setText("Copy");
                    miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                                                                 KeyEvent.CTRL_MASK));
                    miCopy.setIcon(null);
                    miCopy.setMnemonic('C');
                    miCopy.setEnabled(false);
                    miCopy.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miCopyActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miCopy);

                    // ---- miPaste ----
                    miPaste.setText("Paste");
                    miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
                                                                  KeyEvent.CTRL_MASK));
                    miPaste.setMnemonic('P');
                    miPaste.setEnabled(false);
                    miPaste.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miPasteActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miPaste);
                    mnuEdit.addSeparator();

                    // ---- miDelete ----
                    miDelete.setText("Delete");
                    miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,
                                                                   0));
                    miDelete.setMnemonic('D');
                    miDelete.setEnabled(false);
                    miDelete.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miDeleteActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miDelete);
                    mnuEdit.addSeparator();

                    // ---- miPreferences ----
                    miPreferences.setText("Preferences...");
                    miPreferences.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miPreferencesActionPerformed(e);
                                }
                            });
                    mnuEdit.add(miPreferences);
                }
                menuBar.add(mnuEdit);

                // ======== mnuSearch ========
                {
                    mnuSearch.setText("Search");
                    mnuSearch.setMnemonic('S');

                    // ---- miFind ----
                    miFind.setText("Find...");
                    miFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                                                                 KeyEvent.CTRL_MASK));
                    miFind.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miFindActionPerformed(e);
                                }
                            });
                    mnuSearch.add(miFind);

                    // ---- miFindNext ----
                    miFindNext.setText("Find Next...");
                    miFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,
                                                                     0));
                    miFindNext.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miFindNextActionPerformed(e);
                                }
                            });
                    mnuSearch.add(miFindNext);

                }
                menuBar.add(mnuSearch);

                // ======== mnuApplication ========
                {
                    mnuApplication.setText("Application");
                    mnuApplication.setMnemonic('A');
                    mnuApplication.setEnabled(false);

                    // ---- miProperties ----
                    miProperties.setText("Properties...");
                    miProperties.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    miPropertiesActionPerformed(e);
                                }
                            });
                    mnuApplication.add(miProperties);

                    // ======== mnuCodeGeneration ========
                    {
                        mnuCodeGeneration.setText("Code Generation");
                        mnuCodeGeneration.setMnemonic('G');

                        // ---- miSettings ----
                        miSettings.setVisible(false);

                        miSettings.setText("Settings...");
                        miSettings.setMnemonic('S');
                        miSettings.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        miSettingsActionPerformed(e);
                                    }
                                });
                        mnuCodeGeneration.add(miSettings);
                        //mnuCodeGeneration.addSeparator();
                    }
                    mnuApplication.add(mnuCodeGeneration);
                }
                menuBar.add(mnuApplication);
            }

            mnuOptions = new JMenu("Options");
            miLookAndFeel = new JMenu("Look And Feel");
            mnuOptions.add(miLookAndFeel);

            Properties lafProps = new Properties();
            try {
                lafProps.load(new FileInputStream("x-rad-laf.properties"));
                Iterator iter = lafProps.keySet().iterator();
                while (iter.hasNext()) {
                    final String className = (String)iter.next();
                    final XRadFrame frame = this;
                    UIManager.installLookAndFeel(lafProps.getProperty(className),
                                                 className);
                    AbstractAction lafAction =
                        new AbstractAction(lafProps.getProperty(className)) {
                            public void actionPerformed(ActionEvent e) {
                                Object obj = null;
                                try {
                                    obj =
Class.forName(className).newInstance();

                                    if (obj instanceof LookAndFeel) {

                                        UIManager.setLookAndFeel((LookAndFeel)obj);
                                        try {
                                            SwingUtilities.updateComponentTreeUI(XRadApp.xradFrame);
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(XRadApp.xradFrame,
                                                                  "Failed to add " +
                                                                  className +
                                                                  " Look And Feel!");
                                    this.setEnabled(false);
                                }
                            }
                        };
                    miLookAndFeel.add(lafAction);
                    try {
                        Class.forName(className);
                    } catch (Exception ex) {
                        lafAction.setEnabled(false);
                    }
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this,
                                              "x-rad-laf.properties file not found");
                miLookAndFeel.setEnabled(false);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                                              "Failed to load x-rad-laf.properties file");
                e.printStackTrace();
                miLookAndFeel.setEnabled(false);
            }

            menuBar.add(mnuOptions);

            pnlMain.add(menuBar, BorderLayout.NORTH);

            // ======== toolBar ========
            {
                toolBar.setOrientation(SwingConstants.VERTICAL);

                // ---- btnView ----
                btnView.setIcon(Resources.VIEW_ICON);
                btnView.setToolTipText("Click to Add a View");
                btnView.setEnabled(false);
                btnView.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnViewActionPerformed(e);
                            }
                        });
                toolBar.add(btnView);

                // ---- btnProcess ----
                btnProcess.setIcon(Resources.PROCESS_ICON);
                btnProcess.setToolTipText("Click to Add a Process");
                btnProcess.setEnabled(false);
                btnProcess.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnProcessActionPerformed(e);
                            }
                        });
                toolBar.add(btnProcess);

                // ---- btnLink ----
                btnLink.setIcon(Resources.LINK_ICON);
                btnLink.setToolTipText("Enable/Disable Connect Mode");
                btnLink.setEnabled(false);
                btnLink.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnLinkActionPerformed(e);
                            }
                        });
                toolBar.add(btnLink);
                toolBar.addSeparator();

                // ---- btnSnap ----
                btnSnap.setIcon(Resources.SNAP_ICON);
                btnSnap.setToolTipText("Enable/Disable Snap to Grid");
                btnSnap.setEnabled(false);
                btnSnap.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnSnapActionPerformed(e);
                            }
                        });
                toolBar.add(btnSnap);

                // ---- btnGrid ----
                btnGrid.setIcon(Resources.GRID_ICON);
                btnGrid.setToolTipText("Show/Hide Grid");
                btnGrid.setEnabled(false);
                btnGrid.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnGridActionPerformed(e);
                            }
                        });
                toolBar.add(btnGrid);
                toolBar.addSeparator();

                // ---- btnZoomIn ----
                btnZoomIn.setIcon(Resources.ZOOMIN_ICON);
                btnZoomIn.setToolTipText("Click to Zoom In");
                btnZoomIn.setEnabled(false);
                btnZoomIn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnZoomInActionPerformed(e);
                            }
                        });
                toolBar.add(btnZoomIn);

                // ---- btnZoomOut ----
                btnZoomOut.setIcon(Resources.ZOOMOUT_ICON);
                btnZoomOut.setToolTipText("Click to Zoom Out");
                btnZoomOut.setEnabled(false);
                btnZoomOut.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnZoomOutActionPerformed(e);
                            }
                        });
                toolBar.add(btnZoomOut);

                // ---- btnZoom1By1 ----
                btnZoom1By1.setIcon(Resources.ZOOM1BY1_ICON);
                btnZoom1By1.setToolTipText("Click to Reset Zoom to 1:1");
                btnZoom1By1.setEnabled(false);
                btnZoom1By1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                btnZoom1By1ActionPerformed(e);
                            }
                        });
                toolBar.add(btnZoom1By1);

            }
            pnlMain.add(toolBar, BorderLayout.WEST);

            // ======== scrollPane ========
            {
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            }
            pnlMain.add(scrollPane, BorderLayout.CENTER);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization
        // //GEN-END:initComponents
        // Add code generators to the Application Menu...
        addCodeGenerators();
    }

    protected void btnZoom1By1ActionPerformed(ActionEvent e) {
        graph.setScale(0.9);

    }

    protected void btnZoomOutActionPerformed(ActionEvent e) {
        if (graph.getScale() > 0.5) {
            graph.setScale(graph.getScale() - 0.1);
        }
    }

    protected void btnZoomInActionPerformed(ActionEvent e) {
        if (graph.getScale() < 2.0) {
            graph.setScale(graph.getScale() + 0.1);
        }
    }

    protected void btnGridActionPerformed(ActionEvent e) {
        graph.setGridVisible(btnGrid.isSelected());

    }

    protected void btnSnapActionPerformed(ActionEvent e) {
        graph.setGridEnabled(btnSnap.isSelected());
    }

    private void addCodeGenerators() {
        Properties cg = new Properties();
        File file = new File("x-rad-cg.properties");
        try {
            cg.load(new FileInputStream(file));
            Iterator iter = cg.keySet().iterator();
            final XRadFrame xradFrame = this;
            while (iter.hasNext()) {
                final String cgClassName = (String)iter.next();
                String cgTitle = cg.getProperty(cgClassName);
                mnuCodeGeneration.add(new AbstractAction(cgTitle) {
                            public void actionPerformed(ActionEvent arg0) {
                              int selection = JOptionPane.showConfirmDialog(xradFrame, "The model must be saved in order to invoke the code generation. Do you want to continue?", "Alert", JOptionPane.YES_NO_OPTION);
                              if(selection == JOptionPane.NO_OPTION) return;
                              saveXrdFile();
                              try {
                                  Class clazz = Class.forName(cgClassName);
                                  XCodeGenerator cg =
                                      (XCodeGenerator)clazz.newInstance();
                                  cg.cgMain(appModel, xrdFile);
                              } catch (Exception ex) {
                                  ex.printStackTrace();
                                  JOptionPane.showMessageDialog(xradFrame,
                                                                cgClassName +
                                                                " is not a valid x-RAD Studio plugable code generator");
                              }
                            }
                        });
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                                          "x-rad-cg.properties file not found");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                                          "Failed to load x-rad-cg.properties file");
            e.printStackTrace();
        }

    }

    private void miNewApplicationActionPerformed(ActionEvent e) {
        if (appModel != null) {
            miCloseActionPerformed(e);
        }
        XRadApplicationDialog dialog =
            new XRadApplicationDialog(this, appModel);
        dialog.pack();
        StudioUtilities.center(dialog);
        boolean commit = dialog.showDialog();
        if (commit) {
            modified = true;
            toggleControls(true);
        }
        setTitle(StudioUtilities.APP_TITLE + "[Untitled.xrd]");
    }

    private void miFindActionPerformed(ActionEvent e) {
        String text =
            JOptionPane.showInputDialog(XRadApp.xradFrame, "Enter Text to Find in Processes, Viewes and Interactions",
                                        "Find", JOptionPane.QUESTION_MESSAGE);
        if (text != null) {
            text = text.toLowerCase().trim();
            Object[] objects = graph.getRoots();

            StudioUtilities.foundObjects.removeAllElements();
            StudioUtilities.selectedObjectIndex = -1;

            for (int i = 0; i < objects.length; i++) {
                DefaultGraphCell dgc = (DefaultGraphCell)objects[i];
                Object obj = dgc.getUserObject();
                if (obj instanceof com.xradsolutions.xrad.xmlbo.Process) {
                    com.xradsolutions.xrad.xmlbo.Process process =
                        (com.xradsolutions.xrad.xmlbo.Process)obj;
                    if (process.getName().toLowerCase().indexOf(text) > -1) {
                        if (!StudioUtilities.foundObjects.contains(dgc)) {
                            StudioUtilities.foundObjects.add(dgc);
                        }
                    } else if (process.getId().toLowerCase().indexOf(text) >
                               -1) {
                        if (!StudioUtilities.foundObjects.contains(dgc)) {
                            StudioUtilities.foundObjects.add(dgc);
                        }
                    }
                } else if (obj instanceof com.xradsolutions.xrad.xmlbo.View) {
                    com.xradsolutions.xrad.xmlbo.View view =
                        (com.xradsolutions.xrad.xmlbo.View)obj;
                    if (view.getName().toLowerCase().indexOf(text) > -1) {
                        if (!StudioUtilities.foundObjects.contains(dgc)) {
                            StudioUtilities.foundObjects.add(dgc);
                        }
                    } else if (view.getId().toLowerCase().indexOf(text) > -1) {
                        if (!StudioUtilities.foundObjects.contains(dgc)) {
                            StudioUtilities.foundObjects.add(dgc);
                        }
                    }
                } else if (obj instanceof
                           com.xradsolutions.xrad.xmlbo.Interaction) {
                    com.xradsolutions.xrad.xmlbo.Interaction interaction =
                        (com.xradsolutions.xrad.xmlbo.Interaction)obj;
                    String temp = interaction.getSource().toString();
                    if (temp.toLowerCase().indexOf(text) > -1) {
                        if (!StudioUtilities.foundObjects.contains(dgc)) {
                            StudioUtilities.foundObjects.add(dgc);
                        }
                    }
                }
            }

            miFindNextActionPerformed(e);
        }
    }

    private void miFindNextActionPerformed(ActionEvent e) {
        Vector v = StudioUtilities.foundObjects;
        int index = StudioUtilities.selectedObjectIndex;
        if (v.size() == 0) {
            JOptionPane.showMessageDialog(XRadApp.xradFrame, "Nothing found!");
        } else {
            index++;
            if (index >= v.size()) {
                index = 0;
            }
            DefaultGraphCell dgc = (DefaultGraphCell)v.get(index);
            graph.setSelectionCell(dgc);
            graph.scrollCellToVisible(dgc);
            StudioUtilities.selectedObjectIndex = index;
        }
    }

    private void miOpenActionPerformed(ActionEvent e) {
        if (modified && appModel != null) {
            miCloseActionPerformed(e);
        }
        JFileChooser jfc = new JFileChooser(xrdFile);
        jfc.setSelectedFile(xrdFile);
        jfc.setFileFilter(new XRadFileFilter());
        int choice = jfc.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            if (selectedFile.getName().endsWith(".xrd")) {
                xrdFile = selectedFile;
                openXrdFile();
                setTitle(StudioUtilities.APP_TITLE + "[" + xrdFile.getAbsolutePath() + "]");
            }
        }
    }

    private void miCloseActionPerformed(ActionEvent e) {
        if (modified) {
            int choice =
                JOptionPane.showConfirmDialog(this, "Do you want to save changes before closing the application!");
            if (choice == JOptionPane.OK_OPTION) {
                miSaveActionPerformed(e);
            }
        }
        reset();
    }

    private void miSaveActionPerformed(ActionEvent e) {
        if (xrdFile.getName().equals(".")) {
            miSaveAsActionPerformed(e);
        } else {
            saveXrdFile();
        }
    }

    private void miSaveAsActionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(xrdFile);
        jfc.setSelectedFile(xrdFile);
        jfc.setFileFilter(new XRadFileFilter());
        int choice = jfc.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            if (selectedFile.getName().endsWith(".xrd")) {
                xrdFile = selectedFile;
            } else {
                xrdFile =
                        new File(selectedFile.getParentFile(), selectedFile.getName() +
                                 ".xrd");
            }
            saveXrdFile();
        }
    }

    private void miExitActionPerformed(ActionEvent e) {
        dispose();
    }

    private void miUndoActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miRedoActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miCutActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miCopyActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miPasteActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miDeleteActionPerformed(ActionEvent e) {
        // Get the selected cell of the graph.
        Object[] cells = graph.getSelectionCells();
        // If some cell is selected on the graph then confirm from the user to
        // delete.
        if (cells != null && cells.length > 0) {
            // Prompt the confirmation dialog.
            int selection =
                JOptionPane.showConfirmDialog(this, "Are you sure to delete selected component(s)? This will also delete associated interaction(s)!");
            // Check and delete the cell from the graph if user has selected YES
            // on the confirmation dialog.
            if (selection == JOptionPane.YES_OPTION) {
                for (int i = 0; i < cells.length; i++) {
                    DefaultGraphCell dgc = (DefaultGraphCell)cells[i];
                    if (!(dgc instanceof DefaultEdge)) {
                        DefaultPort port = (DefaultPort)dgc.getChildAt(0);
                        if (port != null) {
                            Iterator iter = port.getEdges().iterator();
                            while (iter.hasNext()) {
                                DefaultEdge edge = (DefaultEdge)iter.next();
                                if (edge instanceof InteractionEdge) {
                                    InteractionEdge iedge =
                                        (InteractionEdge)edge;
                                    Interaction interaction =
                                        (Interaction)iedge.getUserObject();
                                    Source source = interaction.getSource();
                                    String id =
                                        source.getValue() + "@" + source.getId();

                                    StudioUtilities.usedNavigations.remove(id);
                                }
                            }

                        }
                    }
                    if (dgc.getUserObject() instanceof
                        com.xradsolutions.xrad.xmlbo.View) {
                        com.xradsolutions.xrad.xmlbo.View view =
                            (com.xradsolutions.xrad.xmlbo.View)dgc.getUserObject();
                        StudioUtilities.usedClassNames.remove(view.getName());
                        StudioUtilities.usedIds.remove(view.getId());
                    } else if (dgc.getUserObject() instanceof
                               com.xradsolutions.xrad.xmlbo.Process) {
                        com.xradsolutions.xrad.xmlbo.Process process =
                            (com.xradsolutions.xrad.xmlbo.Process)dgc.getUserObject();
                        StudioUtilities.usedClassNames.remove(process.getName());
                        StudioUtilities.usedIds.remove(process.getId());
                    } else if (dgc.getUserObject() instanceof
                               com.xradsolutions.xrad.xmlbo.Interaction) {
                        com.xradsolutions.xrad.xmlbo.Interaction interaction =
                            (com.xradsolutions.xrad.xmlbo.Interaction)dgc.getUserObject();
                        //            SourceView sourceView = interaction.getSource().getSourceView();
                        //            SourceProcess sourceProcess = interaction.getSource().
                        //                getSourceProcess();
                        //            String id = null;
                        //            if (sourceView != null) {
                        //              id = sourceView.getSubmitMethodName() + "@" + sourceView.getId();
                        //            }
                        //            else if (sourceProcess != null) {
                        //              id = sourceProcess.getReturnValueText() + "@" +
                        //                  sourceProcess.getId();
                        //            }
                        Source source = interaction.getSource();
                        String id = source.getValue() + "@" + source.getId();

                        StudioUtilities.usedNavigations.remove(id);
                    }
                }
                StudioUtilities.cloneLinks.clear();
                // Type cast the cell to DefaultGraphCell. This is required to
                // delete children of the cell.
                graph.getGraphLayoutCache().remove(cells, true, true);
            }
        }
    }

    private void miPreferencesActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miPropertiesActionPerformed(ActionEvent e) {
        XRadApplicationDialog dialog =
            new XRadApplicationDialog(this, appModel);
        dialog.pack();
        StudioUtilities.center(dialog);
        dialog.showDialog();
    }

    private void miSettingsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnViewActionPerformed(ActionEvent e) {
        // Create an instance of ViewGenDialog class. This dialog is designed to
        // capture minimum required information from the user.
        com.xradsolutions.xrad.xmlbo.View view =
            new com.xradsolutions.xrad.xmlbo.View();
        ViewDefDialog dialog = new ViewDefDialog(view);
        // Center the dialog on the screen.
        StudioUtilities.center(dialog);
        // Set the dialog to be modal.
        dialog.setModal(true);
        // Show dialog.
        int selection = dialog.showDialog();
        if (selection == JOptionPane.CANCEL_OPTION) {
            return;
        }

        ViewCell cell = XRadComponentFactory.createView(view);
        DefaultGraphCell dgc = (DefaultGraphCell)graph.getSelectionCell();
        Point location = null;
        if (dgc != null && !(dgc instanceof DefaultEdge)) {
            Rectangle2D rect = GraphConstants.getBounds(dgc.getAttributes());
            int x = (int)(rect.getX() + 250);
            int y = (int)rect.getY();
            location = new Point(x, y);
        } else {
            location = new Point(50, 50);
        }
        GraphConstants.setBounds(cell.getAttributes(),
                                 new Rectangle(location));
        graph.getGraphLayoutCache().insert(cell);
    }

    private void btnProcessActionPerformed(ActionEvent e) {
        // Create an instance of ProcessGenDialog class. This dialog is designed
        // to capture minimum required information from the user.
        com.xradsolutions.xrad.xmlbo.Process process =
            new com.xradsolutions.xrad.xmlbo.Process();
        ProcessDefDialog dialog = new ProcessDefDialog(process);
        // Center the dialog on the screen.
        StudioUtilities.center(dialog);
        // Set the dialog to be modal.
        dialog.setModal(true);
        // Show dialog.
        int selection = dialog.showDialog();
        if (selection == JOptionPane.CANCEL_OPTION) {
            return;
        }

        ProcessCell cell = XRadComponentFactory.createProcess(process);
        DefaultGraphCell dgc = (DefaultGraphCell)graph.getSelectionCell();
        Point location = null;
        if (dgc != null && !(dgc instanceof DefaultEdge)) {
            Rectangle2D rect = GraphConstants.getBounds(dgc.getAttributes());
            int x = (int)(rect.getX() + 250);
            int y = (int)rect.getY();
            location = new Point(x, y);
        } else {
            location = new Point(50, 50);
        }
        GraphConstants.setBounds(cell.getAttributes(),
                                 new Rectangle(location));
        graph.getGraphLayoutCache().insert(cell);
    }

    private void btnLinkActionPerformed(ActionEvent e) {
        // Toggle ports of graph components. This helps look / unlock
        // connectors.
        graph.setPortsVisible(btnLink.isSelected());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY
    // //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Farrukh Ijaz
    private JPanel pnlMain;
    private JMenuBar menuBar;
    private JMenu mnuFile;
    private JMenuItem miNewApplication;
    private JMenuItem miOpen;
    private JMenuItem miClose;
    private JMenuItem miSave;
    private JMenuItem miSaveAs;
    private JMenuItem miExit;
    private JMenu mnuEdit;
    private JMenuItem miUndo;
    private JMenuItem miRedo;
    private JMenuItem miCut;
    private JMenuItem miCopy;
    private JMenuItem miPaste;
    private JMenuItem miDelete;
    private JMenuItem miPreferences;
    private JMenu mnuSearch;
    private JMenuItem miFind;
    private JMenuItem miFindNext;
    private JMenu mnuApplication;
    private JMenuItem miProperties;
    private JMenu mnuCodeGeneration;
    private JMenuItem miSettings;
    private JMenu mnuOptions;
    private JMenu miLookAndFeel;
    private JToolBar toolBar;
    private JButton btnView;
    private JButton btnProcess;
    private JToggleButton btnLink;
    private JToggleButton btnSnap;
    private JToggleButton btnGrid;
    private JButton btnZoomIn;
    private JButton btnZoomOut;
    private JButton btnZoom1By1;

    private JScrollPane scrollPane;
    // JFormDesigner - End of variables declaration //GEN-END:variables
    private XRadGraph graph;

    public void saveXrdFile() {
        try {
            Writer writer = new FileWriter(xrdFile);

            appModel.removeAllView();
            appModel.removeAllProcess();
            appModel.removeAllInteraction();

            graph.store(appModel, writer);
            writer.close();
            File xrdLayoutFile =
                new File(xrdFile.getParent(), xrdFile.getName() + ".layout");
            writer = new FileWriter(xrdLayoutFile);
            graph.storeLayout(writer);
            writer.close();
            modified = false;
            setTitle(StudioUtilities.APP_TITLE + "[" + xrdFile.getAbsolutePath() + "]");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                                          "Failed to save x-RAD application configuration to file " +
                                          xrdFile.getName());
        }
    }

    public void openXrdFile() {
        try {
            Reader reader = new FileReader(xrdFile);
            appModel = (AppModel)AppModel.unmarshal(reader);
            reader.close();
            StudioUtilities.packages = new Vector();
            StudioUtilities.packages.add(appModel.getPackageName());
            graph = XRadGraph.createGraph(this);
            graph.load(appModel);
            File xrdLayoutFile =
                new File(xrdFile.getParent(), xrdFile.getName() + ".layout");
            reader = new FileReader(xrdLayoutFile);
            graph.loadLayout(reader);
            reader.close();
            modified = false;
            toggleControls(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                                          xrdFile.getName() + " is not a valid x-RAD file");
        }
    }

}

class XRadFileFilter extends FileFilter {

    public boolean accept(File file) {
        // TODO Auto-generated method stub
        if (file.getName().endsWith(".xrd") || file.isDirectory()) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        // TODO Auto-generated method stub
        return "Nova Application Configuration File";
    }

}
