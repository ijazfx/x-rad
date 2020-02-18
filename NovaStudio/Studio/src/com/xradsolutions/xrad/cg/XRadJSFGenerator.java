package com.xradsolutions.xrad.cg;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import javax.swing.*;

import net.sf.saxon.*;

public class XRadJSFGenerator
    extends AbstractCodeGenerator {

  public XRadJSFGenerator(JFrame parent, java.util.Properties props) {
    super(parent, props);
    // TODO Auto-generated constructor stub
  }

  public void generateCode() {
    // TODO Auto-generated method stub
    // generate xrad code...
    generateCode(super.SRC_PATH, "/org/apache/xrad/cg/xrad-code.xsl");
    // generate xrad struts code...
    generateCode(super.SRC_PATH, "/org/apache/xrad/cg/jsf-xrad-code.xsl");
    // generate jsp files
    generateCode(super.WEB_PATH, "/org/apache/xrad/cg/jsf-jsp.xsl");
    // generate struts-config.xml
    generateCode(super.WEB_PATH,
                 "/org/apache/xrad/cg/faces-config-xrad.xsl");
    // copy xrd file to web-inf folder...
    copyResource(super.WEB_PATH + "/pages", "xrad-style.css",
                 "/org/apache/xrad/cg/xrad-style.css");
    JOptionPane.showMessageDialog(parent,
                                  "The X-RAD Enabled JSF Code has been generated successfully!!");
  }

  public void generateCode(String path, String xslFile) {
    TransformerFactory factory = new TransformerFactoryImpl();
    InputStream xslStream = XRadJSFGenerator.class
        .getResourceAsStream(xslFile);
    StreamSource xslSource = new StreamSource(xslStream);
    try {
      Transformer transformer = factory.newTransformer(xslSource);
      StreamSource xmlSource = new StreamSource(new File(XRD_FILE));
      File tempFile = File.createTempFile("temp", "output.tmp");
      StreamResult tempOutput = new StreamResult(tempFile);
      transformer.transform(xmlSource, tempOutput);
      breakIntoFiles(tempFile, path);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void breakIntoFiles(File tempFile, String path) {
    try {
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
      while (true);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

}
