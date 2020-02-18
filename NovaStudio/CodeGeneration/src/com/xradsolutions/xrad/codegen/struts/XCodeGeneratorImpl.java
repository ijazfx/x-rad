package com.xradsolutions.xrad.codegen.struts;

import com.xradsolutions.xrad.codegen.XCodeGenerator;
import com.xradsolutions.xrad.xmlbo.AppModel;

import java.io.File;

public class XCodeGeneratorImpl extends XCodeGenerator {
    public void cgMain(AppModel model, File modelFile) {
        new MainApp(model, modelFile);
    }
}
