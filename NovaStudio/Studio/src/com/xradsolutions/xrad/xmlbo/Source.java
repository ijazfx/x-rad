/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Source.java,v 1.1.1.1 2006/08/25 18:58:07 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import org.xml.sax.ContentHandler;

/**
 * Class Source.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:07 $
 */
public class Source implements java.io.Serializable {


    //--------------------------/
    //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sourceType
     */
    private java.lang.String _sourceType;

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _packageName
     */
    private java.lang.String _packageName;

    /**
     * Field _interactionType
     */
    private java.lang.Object _interactionType;

    /**
     * Field _value
     */
    private java.lang.Object _value;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _sourceView
     */
    private com.xradsolutions.xrad.xmlbo.SourceView _sourceView;

    /**
     * Field _sourceProcess
     */
    private com.xradsolutions.xrad.xmlbo.SourceProcess _sourceProcess;


    //----------------/
    //- Constructors -/
    //----------------/

    public Source() {
        super();
    } //-- com.xradsolutions.xrad.xmlbo.Source()


    //-----------/
    //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     *
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue() {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'id'.
     *
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId() {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Returns the value of field 'interactionType'.
     *
     * @return Object
     * @return the value of field 'interactionType'.
     */
    public java.lang.Object getInteractionType() {
        return this._interactionType;
    } //-- java.lang.Object getInteractionType() 

    /**
     * Returns the value of field 'name'.
     *
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName() {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'packageName'.
     *
     * @return String
     * @return the value of field 'packageName'.
     */
    public java.lang.String getPackageName() {
        return this._packageName;
    } //-- java.lang.String getPackageName() 

    /**
     * Returns the value of field 'sourceProcess'.
     *
     * @return SourceProcess
     * @return the value of field 'sourceProcess'.
     */
    public com.xradsolutions.xrad.xmlbo.SourceProcess getSourceProcess() {
        return this._sourceProcess;
    } //-- com.xradsolutions.xrad.xmlbo.SourceProcess getSourceProcess() 

    /**
     * Returns the value of field 'sourceType'.
     *
     * @return String
     * @return the value of field 'sourceType'.
     */
    public java.lang.String getSourceType() {
        return this._sourceType;
    } //-- java.lang.String getSourceType() 

    /**
     * Returns the value of field 'sourceView'.
     *
     * @return SourceView
     * @return the value of field 'sourceView'.
     */
    public com.xradsolutions.xrad.xmlbo.SourceView getSourceView() {
        return this._sourceView;
    } //-- com.xradsolutions.xrad.xmlbo.SourceView getSourceView() 

    /**
     * Returns the value of field 'value'.
     *
     * @return Object
     * @return the value of field 'value'.
     */
    public java.lang.Object getValue() {
        return this._value;
    } //-- java.lang.Object getValue() 

    /**
     * Method isValid
     *
     *
     *
     * @return boolean
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     *
     *
     *
     * @param out
     */
    public void marshal(java.io.Writer out) throws org.exolab.castor.xml.MarshalException, 
                                                   org.exolab.castor.xml.ValidationException {

        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     *
     *
     *
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler) throws java.io.IOException, 
                                                                   org.exolab.castor.xml.MarshalException, 
                                                                   org.exolab.castor.xml.ValidationException {

        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'id'.
     *
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id) {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Sets the value of field 'interactionType'.
     *
     * @param interactionType the value of field 'interactionType'.
     */
    public void setInteractionType(java.lang.Object interactionType) {
        this._interactionType = interactionType;
    } //-- void setInteractionType(java.lang.Object) 

    /**
     * Sets the value of field 'name'.
     *
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name) {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'packageName'.
     *
     * @param packageName the value of field 'packageName'.
     */
    public void setPackageName(java.lang.String packageName) {
        this._packageName = packageName;
    } //-- void setPackageName(java.lang.String) 

    /**
     * Sets the value of field 'sourceProcess'.
     *
     * @param sourceProcess the value of field 'sourceProcess'.
     */
    public void setSourceProcess(com.xradsolutions.xrad.xmlbo.SourceProcess sourceProcess) {
        this._sourceProcess = sourceProcess;
        this._choiceValue = sourceProcess;
    } //-- void setSourceProcess(com.xradsolutions.xrad.xmlbo.SourceProcess) 

    /**
     * Sets the value of field 'sourceType'.
     *
     * @param sourceType the value of field 'sourceType'.
     */
    public void setSourceType(java.lang.String sourceType) {
        this._sourceType = sourceType;
    } //-- void setSourceType(java.lang.String) 

    /**
     * Sets the value of field 'sourceView'.
     *
     * @param sourceView the value of field 'sourceView'.
     */
    public void setSourceView(com.xradsolutions.xrad.xmlbo.SourceView sourceView) {
        this._sourceView = sourceView;
        this._choiceValue = sourceView;
    } //-- void setSourceView(com.xradsolutions.xrad.xmlbo.SourceView) 

    /**
     * Sets the value of field 'value'.
     *
     * @param value the value of field 'value'.
     */
    public void setValue(java.lang.Object value) {
        this._value = value;
    } //-- void setValue(java.lang.Object) 

    /**
     * Method unmarshal
     *
     *
     *
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshal(java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, 
                                                                           org.exolab.castor.xml.ValidationException {
        return (com.xradsolutions.xrad.xmlbo.Source)Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.Source.class, 
                                                                           reader);
    } //-- java.lang.Object unmarshal(java.io.Reader) 

    /**
     * Method validate
     *
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = 
            new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

    public String toString() {
        String label = "";
        if ("SubmitMethod".equals(getInteractionType())) {
            label = getValue() + "()";
        } else if ("ReturnValue".equals(getInteractionType())) {
            label = "[" + getValue() + "]";
        } else {
            if (getSourceView() != null) {
                if (getSourceView().getSubmitMethodName() != null) {
                    label = getSourceView().toString() + "()";
                } else if (getSourceView().getReturnValueText() != null) {
                    label = "[" + getSourceView().toString() + "]";
                }
            } else if (getSourceProcess() != null) {
                label = "[" + getSourceProcess().toString() + "]";
            }
        }
        return label;
    }

}
