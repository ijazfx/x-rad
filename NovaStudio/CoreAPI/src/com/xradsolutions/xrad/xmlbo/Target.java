/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Target.java,v 1.1.1.1 2006/08/25 18:58:01 Ali Mazhar Exp $
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
 * Class Target.
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:01 $
 */
public class Target implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _targetType
     */
    private java.lang.String _targetType;

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
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _targetView
     */
    private com.xradsolutions.xrad.xmlbo.TargetView _targetView;

    /**
     * Field _targetProcess
     */
    private com.xradsolutions.xrad.xmlbo.TargetProcess _targetProcess;


      //----------------/
     //- Constructors -/
    //----------------/

    public Target() 
     {
        super();
    } //-- com.xradsolutions.xrad.xmlbo.Target()


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
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'packageName'.
     * 
     * @return String
     * @return the value of field 'packageName'.
     */
    public java.lang.String getPackageName()
    {
        return this._packageName;
    } //-- java.lang.String getPackageName() 

    /**
     * Returns the value of field 'targetProcess'.
     * 
     * @return TargetProcess
     * @return the value of field 'targetProcess'.
     */
    public com.xradsolutions.xrad.xmlbo.TargetProcess getTargetProcess()
    {
        return this._targetProcess;
    } //-- com.xradsolutions.xrad.xmlbo.TargetProcess getTargetProcess() 

    /**
     * Returns the value of field 'targetType'.
     * 
     * @return String
     * @return the value of field 'targetType'.
     */
    public java.lang.String getTargetType()
    {
        return this._targetType;
    } //-- java.lang.String getTargetType() 

    /**
     * Returns the value of field 'targetView'.
     * 
     * @return TargetView
     * @return the value of field 'targetView'.
     */
    public com.xradsolutions.xrad.xmlbo.TargetView getTargetView()
    {
        return this._targetView;
    } //-- com.xradsolutions.xrad.xmlbo.TargetView getTargetView() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
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
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'packageName'.
     * 
     * @param packageName the value of field 'packageName'.
     */
    public void setPackageName(java.lang.String packageName)
    {
        this._packageName = packageName;
    } //-- void setPackageName(java.lang.String) 

    /**
     * Sets the value of field 'targetProcess'.
     * 
     * @param targetProcess the value of field 'targetProcess'.
     */
    public void setTargetProcess(com.xradsolutions.xrad.xmlbo.TargetProcess targetProcess)
    {
        this._targetProcess = targetProcess;
        this._choiceValue = targetProcess;
    } //-- void setTargetProcess(com.xradsolutions.xrad.xmlbo.TargetProcess) 

    /**
     * Sets the value of field 'targetType'.
     * 
     * @param targetType the value of field 'targetType'.
     */
    public void setTargetType(java.lang.String targetType)
    {
        this._targetType = targetType;
    } //-- void setTargetType(java.lang.String) 

    /**
     * Sets the value of field 'targetView'.
     * 
     * @param targetView the value of field 'targetView'.
     */
    public void setTargetView(com.xradsolutions.xrad.xmlbo.TargetView targetView)
    {
        this._targetView = targetView;
        this._choiceValue = targetView;
    } //-- void setTargetView(com.xradsolutions.xrad.xmlbo.TargetView) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Object
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.xradsolutions.xrad.xmlbo.Target) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.Target.class, reader);
    } //-- java.lang.Object unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
