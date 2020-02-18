package com.xradsolutions.xrad.codegen;

import com.xradsolutions.xrad.xmlbo.AppModel;

import java.io.File;

public abstract class XCodeGenerator {

    public abstract void cgMain(AppModel model, File modelFile);

}
