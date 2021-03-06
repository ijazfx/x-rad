/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: SourceView.java,v 1.1.1.1 2006/08/25 18:58:01 Ali Mazhar Exp $
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
 * Class SourceView.
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:01 $
 */
public class SourceView implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _submitMethodName
     */
    private java.lang.String _submitMethodName;

    /**
     * Field _returnValueText
     */
    private java.lang.String _returnValueText;


      //----------------/
     //- Constructors -/
    //----------------/

    public SourceView() 
     {
        super();
    } //-- com.xradsolutions.xrad.xmlbo.SourceView()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'returnValueText'.
     * 
     * @return String
     * @return the value of field 'returnValueText'.
     */
    public java.lang.String getReturnValueText()
    {
        return this._returnValueText;
    } //-- java.lang.String getReturnValueText() 

    /**
     * Returns the value of field 'submitMethodName'.
     * 
     * @return String
     * @return the value of field 'submitMethodName'.
     */
    public java.lang.String getSubmitMethodName()
    {
        return this._submitMethodName;
    } //-- java.lang.String getSubmitMethodName() 

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
     * Sets the value of field 'returnValueText'.
     * 
     * @param returnValueText the value of field 'returnValueText'.
     */
    public void setReturnValueText(java.lang.String returnValueText)
    {
        this._returnValueText = returnValueText;
    } //-- void setReturnValueText(java.lang.String) 

    /**
     * Sets the value of field 'submitMethodName'.
     * 
     * @param submitMethodName the value of field 'submitMethodName'
     */
    public void setSubmitMethodName(java.lang.String submitMethodName)
    {
        this._submitMethodName = submitMethodName;
    } //-- void setSubmitMethodName(java.lang.String) 

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
        return (com.xradsolutions.xrad.xmlbo.SourceView) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.SourceView.class, reader);
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

    public String toString() {
        if(getSubmitMethodName() != null) {
            return getSubmitMethodName();
        }
        else 
        if(getReturnValueText() != null) {
            return getReturnValueText();
        }
        return "???";
    }

}
