package com.xradsolutions.xrad.codegen.struts;

import com.xradsolutions.xrad.XRadUtilities;
import com.xradsolutions.xrad.codegen.struts.model.StrutsModel;
import com.xradsolutions.xrad.xmlbo.AppModel;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import java.util.Properties;

import javax.swing.JFrame;

public class MainApp {

    AppModel model;
    StrutsModel strutsModel;
    File modelFile;
    File strutsModelFile;

    public MainApp(AppModel model, File modelFile) {
        this.model = model;
        this.modelFile = modelFile;
        transformModel();
        MainFrame frame = new MainFrame(strutsModel, strutsModelFile);
        XRadUtilities.center(frame);
        frame.setAppModel(model);
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MainApp(null, null);
    }

    private void transformModel() {
        strutsModelFile = new File(modelFile.getAbsolutePath() + ".struts-model");
        if(strutsModelFile.exists()) {
            strutsModel = StrutsModel.loadFromFile(strutsModelFile);
        }
        else {
            strutsModel = new StrutsModel();
        }
        strutsModel.updateModelFrom(model);
        if(modelFile != null) {
            strutsModelFile = new File(modelFile.getAbsolutePath() + ".struts-model");
        }
    }

    public AppModel getModel() {
        return model;
    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public StrutsModel getStrutsModel() {
        return strutsModel;
    }

    public void setStrutsModel(StrutsModel strutsModel) {
        this.strutsModel = strutsModel;
    }
}
