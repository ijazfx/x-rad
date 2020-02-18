package com.xradsolutions.xrad.codegen.generators;

import java.io.*;
import java.util.*;

import org.apache.velocity.*;
import org.apache.velocity.app.*;
import org.apache.velocity.context.*;
import org.apache.velocity.exception.*;
import com.xradsolutions.xrad.*;
import com.xradsolutions.xrad.codegen.struts.*;
import com.xradsolutions.xrad.codegen.struts.helper.*;
import com.xradsolutions.xrad.codegen.struts.model.*;
import com.xradsolutions.xrad.xmlbo.*;

public class StrutsCodeGenerator {
  private AppModel appModel;
  private String modelFileName;
  private StrutsModel model;
  private static VelocityEngine ve4jt;
  private static VelocityEngine ve4ct;
  /**
   * StrutsCodeGenerator
   */
  public StrutsCodeGenerator(AppModel appModel, StrutsModel model,
                          String modelFileName) {
    this.model = model;
    this.modelFileName = modelFileName;
    this.appModel = appModel;
    String path = ThemeManager.retrievePath(model.getJspTheme()) +
        File.separator +
        "velocity";
    Properties props = new Properties();
    props.setProperty("resource.loader", "file");
    props.setProperty("file.resource.loader.path", path);
    ve4jt = new VelocityEngine();
    try {
      ve4jt.init(props);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    // Initialize Velocity Engine... for Classes
    String xradHome = XRadUtilities.XRAD_HOME;
    //String virtualFormPackageName = model.getBasePackageName() + ".forms";
    path = xradHome + File.separator + "codegen" + File.separator +
        "struts-1.2" + File.separator + XRadUtilities.TEMPLATES;
    props = new Properties();
    props.setProperty("resource.loader", "file");
    props.setProperty("file.resource.loader.path", path);
    ve4ct = new VelocityEngine();
    try {
      ve4ct.init(props);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }


  public void generateVersionOne() {
    generateStantdard();
    generateUtility("AjaxResponse",null);
    generateUtility("AjaxUtility",null);
    generateUtility("StrutsUtility",null);
    generateUtility("PagingUtility",null);
    generateUtility("WebUtility",null);
    generateUtility("AppUser",null);
    //generateUtilClasses(appModel, model, modelFileName);
  }

  /**
   * generateExtraClass
   *
   * @param string String
   */
  private void generateExtraClass(String string) {
  }

  public void generateStantdard() {
    // Generate JSPs, ActionForms, ActionForm Actions...
    Collection<StrutsJsp> jsps = model.getJsps().values();
    for (StrutsJsp jsp : jsps) {
      // Generate JSP...
      generateJSP(model, ve4jt, jsp);
      // Generate Links JSP if selected...
      if (jsp.isGenerateSeparateLinksJsp()) {
        generateSeperateLinksJSP(model, ve4jt, jsp);
      }
      generateForm(appModel, model, ve4ct, jsp);
      generateJSPAction(appModel, model, modelFileName, ve4ct, jsp);
    }
    // Generate action form classes
    boolean isIndepententAction = false;
    Collection<StrutsAction> actions = model.getActions().values();
    for (StrutsAction action : actions) {
      // Generate action classes...
      // abstract class
      if (!action.isBackingAction()) {
        generateIndependentAction(model, ve4ct, action);
        isIndepententAction = true;
      }
    }
    generateTileExtDefs(model, ve4ct);
    // Generate Virtual Form...
    if(isIndepententAction) {
      generateUtility("VirtualForm",null);
    }
    generateStrutsConfig(model, modelFileName, ve4ct);
  }




/////////////////////////////////////////////////////////////////////////

  private void generateUtility(String fileName,Object[] object) {
    FileWriter writer = null;
    Template template = null;
    try {
      template = ve4ct.getTemplate(fileName+".vm");
      Context ctx = new VelocityContext();
      ctx.put("appModel", appModel);
      ctx.put("model", model);
      ctx.put("modelFileName", modelFileName);
      String packagePath = (model.getBasePackageName()+".util") .replace('.', '/');
      File folder = new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, fileName+".java");
      if(!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
      }
    }

  }






  private static void generateStrutsConfig(StrutsModel model,
                                           String modelFileName,
                                           VelocityEngine ve4ct) {
    FileWriter writer = null;
    Template template = null;

    writer = null;
    try {
      template = ve4ct.getTemplate("xrad-struts-config.vm");
      Context ctx = new VelocityContext();
      ctx.put("model", model);
      ctx.put("virtualFormPackageName", model.getBasePackageName()+".util");
      ctx.put("modelFileName",
              modelFileName.toUpperCase().charAt(0) + modelFileName.substring(1));
      File folder = new File(model.getWebModuleLocation(), "WEB-INF");
      if (!folder.exists()) {
        folder.mkdirs();
      }

      File file = new File(folder, modelFileName + "-struts-config.xml");
      writer = new FileWriter(file);
      template.merge(ctx, writer);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }

  private static void generateIndependentAction(StrutsModel model,
                                                VelocityEngine ve4ct,
                                                StrutsAction action) {
    FileWriter writer = null;
    Template template = null;
    try {
      template = ve4ct.getTemplate("actionBase.vm");
      Context ctx = new VelocityContext();
      ctx.put("action", action);
      ctx.put("packageName", model.getBasePackageName());

      String packagePath =
          action.getPackageName().replace('.', '/');
      File folder =
          new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, action.getClassName() + "Base.java");
      writer = new FileWriter(file);
      template.merge(ctx, writer);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
    writer = null;
    // abstract class
    try {
      template = ve4ct.getTemplate("action.vm");
      Context ctx = new VelocityContext();
      ctx.put("action", action);
      ctx.put("packageName", model.getBasePackageName());

      String packagePath =
          action.getPackageName().replace('.', '/');
      File folder =
          new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, action.getClassName() + ".java");
      if (!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }

  private static void generateJSPAction(AppModel appModel, StrutsModel model,
                                        String modelFileName,
                                        VelocityEngine ve4ct, StrutsJsp jsp) {
    FileWriter writer = null;
    Template template = null;
    try {
      template = ve4ct.getTemplate("formActionBase.vm");
      Context ctx = new VelocityContext();
      ctx.put("jsp", jsp);
      ctx.put("appModel", appModel);
      ctx.put("modelFileName", modelFileName.toLowerCase());
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      String packagePath =
          jsp.getBackingAction().getPackageName().replace('.', '/');
      File folder = new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, jsp.getBackingAction().getClassName() +
                   "Base.java");
      writer = new FileWriter(file);
      template.merge(ctx, writer);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }

    writer = null;
    try {
      template = ve4ct.getTemplate("formAction.vm");
      Context ctx = new VelocityContext();
      ctx.put("jsp", jsp);
      ctx.put("packageName", model.getBasePackageName());
      ctx.put("modelFileName", modelFileName.toLowerCase());
      ctx.put("appModel", appModel);
      ctx.put("ndf_content",
              jsp.getJspFile().substring(0, jsp.getJspFile().lastIndexOf(".jsp")));
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      String packagePath =
          jsp.getBackingAction().getPackageName().replace('.', '/');
      File folder = new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, jsp.getBackingAction().getClassName() +
                   ".java");
      if (!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }

    // for Reporting classes
    DescriptionHelper helper = null;
    try {
      helper = new DescriptionHelper(jsp.getDescription());
    }
    catch (TabHelperException ex) {
    }
    catch (PagingHelperException ex) {
    }

  /*  if(helper!= null && helper.hasReport()) {
      String packageName = jsp.getBackingAction().getPackageName();
      packageName = packageName.substring(0,packageName.lastIndexOf(".")) + "reports";
      String className = jsp.getBackingAction().getClassName();
      className = className.substring(0,className.lastIndexOf("Action")) + "Report";
      // Report Base Class
      writer = null;
      try {
        template = ve4ct.getTemplate("ReportBase.vm");
        Context ctx = new VelocityContext();
        ctx.put("jsp", jsp);
        ctx.put("packageName", packageName);
        ctx.put("modelFileName", modelFileName.toLowerCase());
        ctx.put("appModel", appModel);
        ctx.put("ndf_content",
                jsp.getJspFile().substring(0, jsp.getJspFile().lastIndexOf(".jsp")));
        ctx.put("helper", helper);
        String packagePath = packageName.replace('.', '/');
        File folder = new File(model.getSourceLocation(), packagePath);
        if (!folder.exists()) {
          folder.mkdirs();
        }
        File file =
            new File(folder, className + "Base"+
                     ".java");
        if (!file.exists() || model.isOverwriteFiles()) {
          writer = new FileWriter(file);
          template.merge(ctx, writer);
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
      finally {
        try {
          if (writer != null) {
            writer.close();
          }
        }
        catch (Exception e) {
          ;
        }
      }


      // Report Base Class
      writer = null;
      try {
        template = ve4ct.getTemplate("Report.vm");
        Context ctx = new VelocityContext();
        ctx.put("jsp", jsp);
        ctx.put("packageName", packageName);
        ctx.put("modelFileName", modelFileName.toLowerCase());
        ctx.put("appModel", appModel);
        ctx.put("ndf_content",
                jsp.getJspFile().substring(0, jsp.getJspFile().lastIndexOf(".jsp")));
        ctx.put("helper", helper);
        String packagePath = packageName.replace('.', '/');
        File folder = new File(model.getSourceLocation(), packagePath);
        if (!folder.exists()) {
          folder.mkdirs();
        }
        File file =
            new File(folder, className +
                     ".java");
        if (!file.exists() || model.isOverwriteFiles()) {
          writer = new FileWriter(file);
          template.merge(ctx, writer);
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
      finally {
        try {
          if (writer != null) {
            writer.close();
          }
        }
        catch (Exception e) {
          ;
        }
      }


    } // Reporting Ends here.*/


  }

  private static void generateForm(AppModel appModel, StrutsModel model,
                                   VelocityEngine ve4ct, StrutsJsp jsp) {
    FileWriter writer = null;
    Template template = null;

    try {
      template = ve4ct.getTemplate("formBase.vm");
      Context ctx = new VelocityContext();
      ctx.put("form", jsp.getBackingForm());
      ctx.put("appModel", appModel);
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      String packagePath =
          jsp.getBackingForm().getPackageName().replace('.', '/');
      File folder = new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, jsp.getBackingForm().getClassName() +
                   "Base.java");
      writer = new FileWriter(file);
      template.merge(ctx, writer);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }

    writer = null;
    try {
      template = ve4ct.getTemplate("form.vm");
      Context ctx = new VelocityContext();
      ctx.put("form", jsp.getBackingForm());
      ctx.put("appModel", appModel);
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      String packagePath =
          jsp.getBackingForm().getPackageName().replace('.', '/');
      File folder = new File(model.getSourceLocation(), packagePath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, jsp.getBackingForm().getClassName() +
                   ".java");
      if (!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }

  private static void generateSeperateLinksJSP(StrutsModel model,
                                               VelocityEngine ve4jt,
                                               StrutsJsp jsp) {
    FileWriter writer = null;
    Template template = null;
    try {
      template = ve4jt.getTemplate(jsp.getLinksJspTemplate());
      Context ctx = new VelocityContext();
      ctx.put("jsp", jsp);
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      File folder =
          new File(model.getWebModuleLocation(), jsp.getLocation());
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file = new File(folder, jsp.getLinksJspFile());
      if (!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }

  private static void generateJSP(StrutsModel model, VelocityEngine ve4jt,
                                  StrutsJsp jsp) {
    FileWriter writer = null;
    Template template = null;
    try {
      template = ve4jt.getTemplate(jsp.getJspTemplate());
      Context ctx = new VelocityContext();
      ctx.put("jsp", jsp);
      ctx.put("helper", new DescriptionHelper(jsp.getDescription()));
      File folder =
          new File(model.getWebModuleLocation(), jsp.getLocation());
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file = new File(folder, jsp.getJspFile());
      if (!file.exists() || model.isOverwriteFiles()) {
        writer = new FileWriter(file);
        template.merge(ctx, writer);
        writer.close();
      }
      String tempName = jsp.getJspTemplate().substring(0,
          jsp.getJspTemplate().length() - 4) + ".js";
      File jsFolder = new File(folder + File.separator + "js");
      File jsFile = new File(jsFolder,
                             jsp.getJspFile().substring(0,
          jsp.getJspFile().lastIndexOf(".jsp")) + ".js");
      if (!jsFile.exists() || model.isOverwriteFiles()) {
        jsFolder.mkdirs();
        FileWriter tmpFile = new FileWriter(jsFile);
        try {
          template = ve4jt.getTemplate(tempName);
          template.merge(ctx, tmpFile);
        }
        catch (ResourceNotFoundException e) {
          tmpFile.write("");
        }
        tmpFile.close();
      }
      tempName = jsp.getJspTemplate().substring(0,
                                                jsp.getJspTemplate().length() - 4) +
          ".css";
      File cssFolder = new File(folder + File.separator + "css");
      File cssFile = new File(cssFolder,
                              jsp.getJspFile().substring(0,
          jsp.getJspFile().lastIndexOf(".jsp")) + ".css");
      if (!cssFile.exists() || model.isOverwriteFiles()) {
        cssFolder.mkdirs();
        FileWriter tmpFile = new FileWriter(cssFile);
        try {
          template = ve4jt.getTemplate(tempName);
          template.merge(ctx, tmpFile);
        }
        catch (ResourceNotFoundException e) {
          tmpFile.write("");
        }
        tmpFile.close();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }

  private static void generateTileExtDefs(StrutsModel model,
                                          VelocityEngine ve4ct) {
    FileWriter writer = null;
    Template template = null;
    // Generate Tiles Def Form...
    try {
      template = ve4ct.getTemplate("tiles-extended-defs.vm");
      Context ctx = new VelocityContext();
      ctx.put("model", model);
      File folder = new File(model.getWebModuleLocation(), "WEB-INF");
      if (!folder.exists()) {
        folder.mkdirs();
      }
      File file =
          new File(folder, "tiles-extended-defs.xml");
      writer = new FileWriter(file);
      template.merge(ctx, writer);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (writer != null) {
          writer.close();
        }
      }
      catch (Exception e) {
        ;
      }
    }
  }



}
