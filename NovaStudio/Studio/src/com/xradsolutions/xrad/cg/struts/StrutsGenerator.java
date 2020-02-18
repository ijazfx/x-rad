package com.xradsolutions.xrad.cg.struts;

import com.xradsolutions.xrad.cg.AbstractCodeGenerator;
import com.xradsolutions.xrad.cg.CodeGenProgressDialog;
import com.xradsolutions.xrad.studio.StudioUtilities;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import javax.swing.*;

import net.sf.saxon.*;

public class StrutsGenerator
    extends AbstractCodeGenerator {

  boolean overwriteFiles = false;

  public StrutsGenerator(JFrame parent, java.util.Properties props) {
    // Select Location...
    super(parent, props);
    System.setProperty("com.xradsolutions.xrad.files.overwrite", "false");
    // TODO Auto-generated constructor stub
  }

  public void generateCode() {
    StrutsCodeGeneratorDialog dialog = new StrutsCodeGeneratorDialog(parent);
    dialog.setSize(500, 200);
        StudioUtilities.center(dialog);
    dialog.setModal(true);
    int choice = dialog.showDialog();
    if (choice == JOptionPane.OK_OPTION) {
      super.SRC_PATH = System.getProperty("com.xradsolutions.xrad.path.src");
      super.WEB_PATH = System.getProperty("com.xradsolutions.xrad.path.web");
      overwriteFiles = Boolean.getBoolean("com.xradsolutions.xrad.files.overwrite");
      final CodeGenProgressDialog progressDialog = new CodeGenProgressDialog(parent);StudioUtilities.center(progressDialog);

      Thread cgThread = new Thread(new Runnable() {
        public void run() {
          try {
            generateCodeNow();
            progressDialog.setVisible(false);
            JOptionPane.showMessageDialog(parent,
                                          "The Struts Code has been generated successfully!!");

          }
          catch(Exception ex) {
            JOptionPane.showMessageDialog(parent, ex.getMessage());
          }
        }
      });
      cgThread.start();
      progressDialog.setVisible(true);
    }
  }

  private void generateCodeNow() throws Exception {
    // TODO Auto-generated method stub
    // generate struts code...
    generateCode(super.SRC_PATH, "cg/struts/struts-code.xsl", overwriteFiles);
    // generate jsp files
    String jspTemplate = "cg/struts/" +
        System.getProperty("com.xradsolutions.xrad.path.web.template");
    generateJSP(super.WEB_PATH, jspTemplate, overwriteFiles);
    // generate struts-config.xml
    generateCode(super.WEB_PATH, "cg/struts/struts-config.xsl", true);
  }

  private void generateJSP(String path, String jspTemplate, boolean overwrite) throws Exception {
    String xslFile = jspTemplate + "/jsp.xsl";
    generateCode(path, xslFile, overwrite);
    extractResources(super.WEB_PATH + "/pages", jspTemplate + "/resources.zip");
  }

  public void generateCode(String path, String xslFile, boolean overwrite) throws
      Exception {
    TransformerFactory factory = new TransformerFactoryImpl();
    InputStream xslStream = null;
    xslStream = new FileInputStream(xslFile);
    StreamSource xslSource = new StreamSource(xslStream);
    Transformer transformer = factory.newTransformer(xslSource);
    StreamSource xmlSource = new StreamSource(new File(XRD_FILE));
    File tempFile = File.createTempFile("temp", "output.tmp");
    StreamResult tempOutput = new StreamResult(tempFile);
    transformer.transform(xmlSource, tempOutput);
    breakIntoFiles(tempFile, path, overwrite);
  }

  private void breakIntoFiles(File tempFile, String path, boolean overwrite) throws
      Exception {

    BufferedReader reader = new BufferedReader(new FileReader(tempFile));
    String line = null;
    do {
      line = reader.readLine();
      if (line == null) {
        break;
      }
      if ("{BeginFile}".equals(line)) {
        line = reader.readLine();
        if (line == null) {
          break;
        }
        String location = line.substring(12);
        File folder = new File(path, location);
        folder.mkdirs();
        line = reader.readLine();
        if (line == null) {
          break;
        }
        File file = new File(folder, line.substring(8));
        if (!file.exists() || (file.exists() && overwrite)) {
          FileWriter writer = new FileWriter(file);
          do {
            line = reader.readLine();
            if (line == null || "{EndFile}".equals(line)) {
              break;
            }
            writer.write(line + "\r\n");
          }
          while (true);
          writer.close();
        }
      }
    }
    while (true);

  }

}
