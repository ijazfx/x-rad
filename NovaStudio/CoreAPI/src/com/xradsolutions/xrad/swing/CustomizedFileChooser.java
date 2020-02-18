package com.xradsolutions.xrad.swing;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class CustomizedFileChooser extends JFileChooser {

    String[] extentions;
    String description;

    public CustomizedFileChooser(final String[] extentions, 
                                 final String description) {
        this.extentions = extentions;
        this.description = description;
        setFileFilter(new FileFilter() {
                    public boolean accept(File f) {
                        if (extentions != null) {
                            for (int i = 0; i < extentions.length; i++) {
                                if (f.getName().endsWith(extentions[i])) {
                                    return true;
                                }
                            }
                        }
                        return f.isDirectory();
                    }

                    public String getDescription() {
                        return description;
                    }
                });
    }
}
