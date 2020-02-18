package com.xradsolutions.xrad.codegen.struts.model;

import com.xradsolutions.xrad.XRadUtilities;
import com.xradsolutions.xrad.xmlbo.AppModel;

import com.xradsolutions.xrad.xmlbo.Interaction;
import com.xradsolutions.xrad.xmlbo.Process;
import com.xradsolutions.xrad.xmlbo.Property;
import com.xradsolutions.xrad.xmlbo.ReturnValue;
import com.xradsolutions.xrad.xmlbo.Source;
import com.xradsolutions.xrad.xmlbo.SubmitMethod;
import com.xradsolutions.xrad.xmlbo.Target;
import com.xradsolutions.xrad.xmlbo.View;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class StrutsModel {

    String sourceLocation;
    String webModuleLocation;
    String jspTheme;
    boolean overwriteFiles;
    String basePackageName;

    LinkedHashMap<String, StrutsJsp> jsps = new LinkedHashMap<String, StrutsJsp>();
    LinkedHashMap<String, StrutsForm> forms = new LinkedHashMap<String, StrutsForm>();
    LinkedHashMap<String, StrutsAction> actions = new LinkedHashMap<String, StrutsAction>();

    public void saveToFile(File modelFile) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(modelFile);
            XMLEncoder enc = new XMLEncoder(fos);
            enc.writeObject(this);
            enc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StrutsModel loadFromFile(File modelFile) {
        FileInputStream fis;
        StrutsModel model = null;
        try {
            fis = new FileInputStream(modelFile);
            XMLDecoder enc = new XMLDecoder(fis);
            model = (StrutsModel)enc.readObject();
            enc.close();
             } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

//    public void updateModelFrom(AppModel model) {
//        HashMap<String, StrutsJsp> newJsps = new HashMap<String, StrutsJsp>();
//        HashMap<String, StrutsForm> newForms = new HashMap<String, StrutsForm>();
//        HashMap<String, StrutsAction> newActions = new HashMap<String, StrutsAction>();
//
//        if(model != null) {
//            View[] views = model.getView();
//            String location = null;
//            for(View view : views) {
//                String key = view.getPackageName() + "." + view.getName();
//                // Process JSP...
//                StrutsJsp jsp = null;
//                if(getJsps().containsKey(key)) {
//                    jsp = getJsps().get(key);
//                }
//                else {
//                    jsp = new StrutsJsp();
//                    jsp.setJspFile(view.getName() + ".jsp");
//                    jsp.setLocation("/" + view.getPackageName().replace('.', '/'));
//                    jsp.setTitle(view.getTitle());
//                }
//                // Process ActionForm...
//                StrutsForm form = null;
//                if(getForms().containsKey(key)) {
//                    form = getForms().get(key);
//                }
//                else {
//                    form = new StrutsForm();
//                    form.setClassName(view.getName() + "Form");
//                    form.setIdentifier(view.getId() + "Form");
//                    form.setPackageName(view.getPackageName());
//                }
//                // Process Action...
//                StrutsAction action = null;
//                if(getActions().containsKey(key)) {
//                    action = getActions().get(key);
//                }
//                else {
//                    action = new StrutsAction();
//                    action.setBackingAction(true);
//                    action.setClassName(view.getName() + "FormAction");
//                    action.setIdentifier(view.getId() + "FormAction");
//                    action.setPackageName(view.getPackageName());
//                }
//                // Process ActionForm Properties
//                Property[] properties = view.getProperty();
//                HashMap<String, StrutsFormProperty> newProperties = new HashMap<String, StrutsFormProperty>();
//                for(Property property : properties) {
//                    key = view.getPackageName() + "." + view.getName() + "." + property.getName();
//                    StrutsFormProperty prop = null;
//                    if(form.getProperties().containsKey(key)) {
//                        prop = form.getProperties().get(key);
//                    }
//                    else {
//                        prop = new StrutsFormProperty();
//                        prop.setControlType(property.getDisplayType());
//                        prop.setDataType(property.getType());
//                        prop.setLabel(property.getTitle());
//                        prop.setName(property.getName());
//                        prop.setRendered(true);
//                    }
//                    // Add property to new map...
//                    newProperties.put(key, prop);
//                }
//                // Update form with new properties...
//                form.setProperties(newProperties);
//                // Process ActionForm Submits
//                HashMap<String, StrutsFormSubmit> newSubmits = new HashMap<String, StrutsFormSubmit>();
//                HashMap<String, StrutsActionForward> newForwards = new HashMap<String, StrutsActionForward>();
//                SubmitMethod[] submitMethods = view.getSubmitMethod();
//                for(SubmitMethod submitMethod : submitMethods) {
//                    key = view.getPackageName() + "." + view.getName() + "." + submitMethod.getName();
//                    StrutsFormSubmit submit = null;
//                    if(form.getSubmits().containsKey(key)) {
//                        submit = form.getSubmits().get(key);
//                    }
//                    else {
//                        submit = new StrutsFormSubmit();
//                        submit.setControlType(submitMethod.getDisplayType());
//                        submit.setName(submitMethod.getName());
//                        submit.setTitle(submitMethod.getTitle());
//                        submit.setRendered(true);
//                    }
//                    StrutsActionForward forward = null;
//                    if(action.getForwards().containsKey(key)) {
//                        forward = action.getForwards().get(key);
//                    }
//                    else {
//                        forward = new StrutsActionForward();
//                        forward.setGlobal(false);
//                        forward.setName(submitMethod.getName());
//                    }
//                    Interaction[] interactions = model.getInteraction();
//                    String path = null;
//                    for(Interaction interaction : interactions) {
//                        Source source = interaction.getSource();
//                        Target target = interaction.getTarget();
//                        if("View".equals(source.getSourceType())
//                            && "SubmitMethod".equals(source.getInteractionType())
//                            && source.getValue().equals(submitMethod.getName())
//                            && source.getPackageName().equals(view.getPackageName())
//                            && source.getId().equals(view.getId())
//                            && source.getName().equals(view.getName())) {
//                            if("View".equals(target.getTargetType())) {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "FormAction.do";
//                            }
//                            else {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "Action.do";
//                            }
//                        }
//                        if(target.getPackageName().equals(view.getPackageName())
//                            && target.getId().equals(view.getId())
//                            && target.getName().equals(view.getName())) {
//                            String formId = source.getId();
//                            String formType = source.getPackageName() + "." + source.getName();
//                            if(!action.getInboundActionForms().containsKey(formType)) {
//                                action.getInboundActionForms().put(formType, formId);
//                            }
//                        }
//                    }
//                    if(path == null) {
//                        path = "/" + view.getPackageName().replace('.', '/') + "/" + view.getId() + "FormAction.do";
//                    }
//                    forward.setPath(path);
//                    // Submit & Forward to new map...
//                    newSubmits.put(key, submit);
//                    newForwards.put(key, forward);
//                }
//                // Update form with new submits...
//                form.setSubmits(newSubmits);
//                // Process ActionForm ReturnValues
//                ReturnValue[] returnValues = view.getReturnValue();
//                for(ReturnValue returnValue : returnValues) {
//                    key = view.getPackageName() + "." + view.getName() + "." + returnValue.getText();
//                    StrutsActionForward forward = null;
//                    if(action.getForwards().containsKey(key)) {
//                        forward = action.getForwards().get(key);
//                    }
//                    else {
//                        forward = new StrutsActionForward();
//                        forward.setGlobal(false);
//                        forward.setName(returnValue.getText());
//                    }
//                    Interaction[] interactions = model.getInteraction();
//                    String path = null;
//                    for(Interaction interaction : interactions) {
//                        Source source = interaction.getSource();
//                        if("View".equals(source.getSourceType())
//                            && "ReturnValue".equals(source.getInteractionType())
//                            && source.getValue().equals(returnValue.getText())
//                            && source.getPackageName().equals(view.getPackageName())
//                            && source.getId().equals(view.getId())
//                            && source.getName().equals(view.getName())) {
//                            Target target = interaction.getTarget();
//                            if("View".equals(target.getTargetType())) {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "FormAction.do";
//                            }
//                            else {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "Action.do";
//                            }
//                        }
//                    }
//                    if(path == null) {
//                        path = "/" + view.getPackageName().replace('.', '/') + "/" + view.getId() + "FormAction.do";
//                    }
//                    forward.setPath(path);
//                    // Forward to new map...
//                    newForwards.put(key, forward);
//                }
//                // Update action with new forwards...
//                action.setForwards(newForwards);
//                // Set Backing Form and Backing Action for JSP...
//                jsp.setBackingForm(form);
//                jsp.setBackingAction(action);
//                // Add JSP, ActionForm & Action to new map...
//                newJsps.put(view.getPackageName() + "." + view.getName(), jsp);
//                newForms.put(view.getPackageName() + "." + view.getName(), form);
//                newActions.put(view.getPackageName() + "." + view.getName(), action);
//            }
//
//            com.xradsolutions.xrad.xmlbo.Process[] processes = model.getProcess();
//            for(com.xradsolutions.xrad.xmlbo.Process process : processes) {
//                HashMap<String, StrutsActionForward> newForwards = new HashMap<String, StrutsActionForward>();
//                String key = process.getPackageName() + "." + process.getName();
//                // Process Action...
//                StrutsAction action = null;
//                if(getActions().containsKey(key)) {
//                    action = getActions().get(key);
//                }
//                else {
//                    action = new StrutsAction();
//                    action.setBackingAction(false);
//                    action.setClassName(process.getName() + "Action");
//                    action.setIdentifier(process.getId() + "Action");
//                    action.setPackageName(process.getPackageName());
//                }
//                // Process ActionForm ReturnValues
//                ReturnValue[] returnValues = process.getReturnValue();
//                for(ReturnValue returnValue : returnValues) {
//                    key = process.getPackageName() + "." + process.getName() + "." + returnValue.getText();
//                    StrutsActionForward forward = null;
//                    if(action.getForwards().containsKey(key)) {
//                        forward = action.getForwards().get(key);
//                    }
//                    else {
//                        forward = new StrutsActionForward();
//                        forward.setGlobal(false);
//                        forward.setName(returnValue.getText());
//                    }
//                    Interaction[] interactions = model.getInteraction();
//                    String path = null;
//                    for(Interaction interaction : interactions) {
//                        Source source = interaction.getSource();
//                        if("Process".equals(source.getSourceType())
//                            && "ReturnValue".equals(source.getInteractionType())
//                            && source.getValue().equals(returnValue.getText())
//                            && source.getPackageName().equals(process.getPackageName())
//                            && source.getId().equals(process.getId())
//                            && source.getName().equals(process.getName())) {
//                            Target target = interaction.getTarget();
//                            if("View".equals(target.getTargetType())) {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "FormAction.do";
//                            }
//                            else {
//                                path = "/" + target.getPackageName().replace('.', '/') + "/" + target.getId() + "Action.do";
//                            }
//                        }
//                    }
//                    if(path != null) {
//                        forward.setPath(path);
//                        // Forward to new map...
//                        newForwards.put(key, forward);
//                    }
//                }
//                // Update action with new forwards...
//                action.setForwards(newForwards);
//                newActions.put(process.getPackageName() + "." + process.getName(), action);
//            }
//        }
//
//        setJsps(newJsps);
//        setForms(newForms);
//        setActions(newActions);
//    }
// TODO

    public StrutsModel() {
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getWebModuleLocation() {
        return webModuleLocation;
    }

    public void setWebModuleLocation(String webModuleLocation) {
        this.webModuleLocation = webModuleLocation;
    }

    public String getJspTheme() {
        return jspTheme;
    }

    public void setJspTheme(String jspTemplate) {
        this.jspTheme = jspTemplate;
    }

    public boolean isOverwriteFiles() {
        return overwriteFiles;
    }

    public void setOverwriteFiles(boolean overwriteFiles) {
        this.overwriteFiles = overwriteFiles;
    }

    public LinkedHashMap<String, StrutsJsp> getJsps() {
        return jsps;
    }

    public void setJsps(LinkedHashMap<String, StrutsJsp> jsps) {
        this.jsps = jsps;
    }

    public LinkedHashMap<String, StrutsForm> getForms() {
        return forms;
    }

    public void setForms(LinkedHashMap<String, StrutsForm> forms) {
        this.forms = forms;
    }

    public LinkedHashMap<String, StrutsAction> getActions() {
        return actions;
    }

    public void setActions(LinkedHashMap<String, StrutsAction> actions) {
        this.actions = actions;
    }

    public void updateModelFrom(AppModel model) {
        setBasePackageName(model.getPackageName());

        LinkedHashMap<String, StrutsJsp> newJsps = new LinkedHashMap<String, StrutsJsp>();
        LinkedHashMap<String, StrutsForm> newForms = new LinkedHashMap<String, StrutsForm>();
        LinkedHashMap<String, StrutsAction> newActions = new LinkedHashMap<String, StrutsAction>();

        StrutsJsp jsp = null;
        StrutsForm form = null;
        StrutsAction action = null;
        StrutsActionForward forward = null;
        StrutsFormProperty property = null;
        StrutsFormSubmit submit = null;

        String key = null;



        // Process All Views...
        for(com.xradsolutions.xrad.xmlbo.View _view : model.getView()) {

            key = _view.getPackageName() + "." + _view.getName() + "." + _view.getId();

            if(jsps.containsKey(key)) {
                jsp = jsps.get(key);
            }
            else {
                jsp = new StrutsJsp();
                jsp.setJspFile(_view.getName() + ".jsp");
                jsp.setJspTemplate("default.jsp");
                if(_view.getPackageName().length() > model.getPackageName().length()) {
                  String tmp = _view.getPackageName().substring(model.getPackageName().length());
                  tmp = tmp.replace('.','/');
                  jsp.setLocation(tmp+"/");
                } else {
                  jsp.setLocation("/");
                }
            }
            jsp.setTitle(_view.getTitle());
            jsp.setDescription(_view.getDescription());

            if(forms.containsKey(key)) {
                form = forms.get(key);
            }
            else {
                form = new StrutsForm();
                form.setClassName(_view.getName() + "Form");
                form.setIdentifier(_view.getId() + "Form");
                form.setPackageName(_view.getPackageName()+".forms");
            }

            if(actions.containsKey(key)) {
                action = actions.get(key);
            }
            else {
                action = new StrutsAction();
                action.setBackingAction(true);
                action.setClassName(_view.getName() + "FormAction");
                action.setIdentifier(_view.getId() + "FormAction");
                action.setPackageName(_view.getPackageName()+".actions");
            }

            action.getForwards().clear();
            action.getInboundActionForms().clear();
            action.getOutboundActionForms().clear();


            newJsps.put(key, jsp);
            newForms.put(key, form);
            newActions.put(key, action);

            jsp.setBackingForm(form);
            jsp.setBackingAction(action);

            LinkedHashMap<String, StrutsFormProperty> newProperties = new LinkedHashMap<String, StrutsFormProperty>();
            for(com.xradsolutions.xrad.xmlbo.Property _property : _view.getProperty()) {
                if(form.getProperties().containsKey(_property.getName())) {
                    property = form.getProperties().get(_property.getName());
                }
                else {
                    property = new StrutsFormProperty();
                }
                property.setControlType(_property.getDisplayType());
                property.setDataType(_property.getType());
                property.setLabel(_property.getTitle());
                property.setName(_property.getName());
                property.setRendered(true);
                newProperties.put(property.getName(), property);
            }
            form.setProperties(newProperties);

            LinkedHashMap<String, StrutsFormSubmit> newSubmits = new LinkedHashMap<String, StrutsFormSubmit>();
            for(com.xradsolutions.xrad.xmlbo.SubmitMethod _submit : _view.getSubmitMethod()) {
                if(form.getSubmits().containsKey(_submit.getName())) {
                    submit = form.getSubmits().get(_submit.getName());
                }
                else {
                    submit = new StrutsFormSubmit();
                }
                submit.setControlType(_submit.getDisplayType());
                submit.setName(_submit.getName());
                submit.setRendered(true);
                submit.setTitle(_submit.getTitle());
                newSubmits.put(submit.getName(), submit);
            }
            form.setSubmits(newSubmits);

        }

        // Process All Processes...
        for(com.xradsolutions.xrad.xmlbo.Process _process : model.getProcess()) {

            key = _process.getPackageName() + "." + _process.getName() + "." + _process.getId();

            if(actions.containsKey(key)) {
                action = actions.get(key);
            }
            else {
                action = new StrutsAction();
                action.setBackingAction(false);
                action.setClassName(_process.getName() + "Action");
                action.setIdentifier(_process.getId() + "Action");
                action.setPackageName(_process.getPackageName()+".actions");
            }

            action.getForwards().clear();
            action.getInboundActionForms().clear();
            action.getOutboundActionForms().clear();

            newActions.put(key, action);
        }

        // Process all Interactions...
        for(com.xradsolutions.xrad.xmlbo.Interaction _interaction : model.getInteraction()) {

            com.xradsolutions.xrad.xmlbo.Source source = _interaction.getSource();
            com.xradsolutions.xrad.xmlbo.Target target = _interaction.getTarget();

            key = source.getPackageName() + "." + source.getName() + "." + source.getId();
            String targetKey = target.getPackageName() + "." + target.getName() + "." + target.getId();

            action = newActions.get(key);
            StrutsAction targetAction = newActions.get(targetKey);

            forward = new StrutsActionForward();
            String forwardName = null;
            String value = (String)source.getValue();
            if("SubmitMethod".equals(source.getInteractionType())) {
                forwardName = "on" + value.toUpperCase().charAt(0) + value.substring(1, value.length());
            }
            else {
                forwardName = value;
            }
            StrutsForm targetForm = newForms.get(targetKey);
            if(targetForm == null) {
                String virtualFormPackageName = model.getPackageName() + ".forms";
                String newKey = virtualFormPackageName + "VirtualForm.virtualForm";
                targetForm = newForms.get(newKey);
                if(targetForm == null) {
                    targetForm = new StrutsForm();
                    targetForm.setPackageName(virtualFormPackageName);
                    targetForm.setIdentifier("virtualForm");
                    targetForm.setClassName("VirtualForm");
                    newForms.put(newKey, targetForm);
                }
            }
            if(!action.getOutboundActionForms().containsKey(forwardName)) {
                action.getOutboundActionForms().put(forwardName, targetForm);
            }
            forward.setName(forwardName);
            String location = "/";
            if("View".equals(target.getTargetType())) {
                jsp = newJsps.get(targetKey);
                location += jsp.getLocation();
            }
            location += targetAction.getIdentifier() + ".do";
            location = location.replace("//", "/");

            forward.setPath(location);

//            if(!action.getForwards().containsKey(forward.getName())) {
                action.getForwards().put(forward.getName(), forward);
//            }

            if("View".equals(source.getSourceType())) {
                form = newForms.get(key);
                if(!targetAction.getInboundActionForms().containsKey(key)) {
                    targetAction.getInboundActionForms().put(key, form);
                }
            }
        }

        // Replace old model with reconciled model.
        setJsps(newJsps);
        setForms(newForms);
        setActions(newActions);
    }

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }
}
