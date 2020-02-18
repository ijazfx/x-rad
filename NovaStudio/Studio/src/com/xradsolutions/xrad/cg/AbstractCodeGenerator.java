package com.xradsolutions.xrad.cg;

import com.xradsolutions.xrad.xmlbo.AppModel;

import java.io.*;
import java.util.*;
import java.util.zip.*;

import javax.swing.*;


/**
 * @stereotype code generator
 */
public abstract class AbstractCodeGenerator {

  protected JFrame parent;

  protected Properties props;

  protected String SRC_PATH;

  protected String WEB_PATH;

  protected String XRD_FILE;

  public AbstractCodeGenerator(JFrame parent, Properties props) {
    this.parent = parent;
    this.props = props;
    SRC_PATH = props.getProperty("com.xradsolutions.xrad.path.src");
    WEB_PATH = props.getProperty("com.xradsolutions.xrad.path.web");
    XRD_FILE = props.getProperty("com.xradsolutions.xrad.file.xrd");
    File folders = new File(SRC_PATH);
    folders.mkdirs();
    folders = new File(WEB_PATH);
    folders.mkdirs();
    try {
      File xrdFile = new File(XRD_FILE);
      AppModel config = (AppModel)AppModel.unmarshal(new FileReader(xrdFile));
      config.marshal(new FileWriter(new File(SRC_PATH + "/app-model.xrd")));
    }
    catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  protected void copyResource(String path, String filename, String res) {
    // TODO Auto-generated method stub
    File folder = new File(path);
    folder.mkdirs();
    try {
      FileOutputStream fos = new FileOutputStream(new File(folder, filename));
      InputStream is = getClass().getResourceAsStream(res);
      int read = is.read();
      while (read != -1) {
        fos.write(read);
        read = is.read();
      }
      fos.close();
      is.close();
    }
    catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  protected void extractResources(String path, String zipFilename) {
    try {
      File folder = new File(path);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      ZipFile zipFile = new ZipFile(zipFilename);
      Enumeration e = zipFile.entries();
      while (e.hasMoreElements()) {
        ZipEntry entry = (ZipEntry) e.nextElement();
        File targetFile = new File(folder, entry.getName()); ;
        if (!targetFile.getParentFile().exists()) {
          targetFile.getParentFile().mkdirs();
        }
        OutputStream fos = new FileOutputStream(targetFile);
        InputStream fis = zipFile.getInputStream(entry);
        fileTransfer(fis, fos);
      }
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(parent, ex.getMessage());
    }

  }

  protected void fileTransfer(InputStream is, OutputStream os) throws
      IOException {
    int read = 0;

    while ( (read = is.read()) != -1) {
      os.write(read);
    }
    is.close();
    os.close();

  }

  public abstract void generateCode();
}
