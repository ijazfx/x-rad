/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Process.java,v 1.1.1.1 2006/08/25 18:58:07 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.xmlbo;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Process.
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:07 $
 */
public class Process implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _description
     */
    private java.lang.String _description;

    /**
     * Field _packageName
     */
    private java.lang.String _packageName;

    /**
     * Field _stereoType
     */
    private java.lang.String _stereoType;

    /**
     * Field _returnValueList
     */
    private java.util.Vector _returnValueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Process() 
     {
        super();
        _returnValueList = new Vector();
    } //-- com.xradsolutions.xrad.xmlbo.Process()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addReturnValue
     * 
     * 
     * 
     * @param vReturnValue
     */
    public void addReturnValue(com.xradsolutions.xrad.xmlbo.ReturnValue vReturnValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _returnValueList.addElement(vReturnValue);
    } //-- void addReturnValue(com.xradsolutions.xrad.xmlbo.ReturnValue) 

    /**
     * Method addReturnValue
     * 
     * 
     * 
     * @param index
     * @param vReturnValue
     */
    public void addReturnValue(int index, com.xradsolutions.xrad.xmlbo.ReturnValue vReturnValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _returnValueList.insertElementAt(vReturnValue, index);
    } //-- void addReturnValue(int, com.xradsolutions.xrad.xmlbo.ReturnValue) 

    /**
     * Method enumerateReturnValue
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateReturnValue()
    {
        return _returnValueList.elements();
    } //-- java.util.Enumeration enumerateReturnValue() 

    /**
     * Returns the value of field 'description'.
     * 
     * @return String
     * @return the value of field 'description'.
     */
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

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
     * Method getReturnValue
     * 
     * 
     * 
     * @param index
     * @return ReturnValue
     */
    public com.xradsolutions.xrad.xmlbo.ReturnValue getReturnValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _returnValueList.size())) {
            throw new IndexOutOfBoundsException("getReturnValue: Index value '"+index+"' not in range [0.."+_returnValueList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.ReturnValue) _returnValueList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.ReturnValue getReturnValue(int) 

    /**
     * Method getReturnValue
     * 
     * 
     * 
     * @return ReturnValue
     */
    public com.xradsolutions.xrad.xmlbo.ReturnValue[] getReturnValue()
    {
        int size = _returnValueList.size();
        com.xradsolutions.xrad.xmlbo.ReturnValue[] mArray = new com.xradsolutions.xrad.xmlbo.ReturnValue[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.ReturnValue) _returnValueList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.ReturnValue[] getReturnValue() 

    /**
     * Method getReturnValueCount
     * 
     * 
     * 
     * @return int
     */
    public int getReturnValueCount()
    {
        return _returnValueList.size();
    } //-- int getReturnValueCount() 

    /**
     * Returns the value of field 'stereoType'.
     * 
     * @return String
     * @return the value of field 'stereoType'.
     */
    public java.lang.String getStereoType()
    {
        return this._stereoType;
    } //-- java.lang.String getStereoType() 

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
     * Method removeAllReturnValue
     * 
     */
    public void removeAllReturnValue()
    {
        _returnValueList.removeAllElements();
    } //-- void removeAllReturnValue() 

    /**
     * Method removeReturnValue
     * 
     * 
     * 
     * @param index
     * @return ReturnValue
     */
    public com.xradsolutions.xrad.xmlbo.ReturnValue removeReturnValue(int index)
    {
        java.lang.Object obj = _returnValueList.elementAt(index);
        _returnValueList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.ReturnValue) obj;
    } //-- com.xradsolutions.xrad.xmlbo.ReturnValue removeReturnValue(int) 

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

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
     * Method setReturnValue
     * 
     * 
     * 
     * @param index
     * @param vReturnValue
     */
    public void setReturnValue(int index, com.xradsolutions.xrad.xmlbo.ReturnValue vReturnValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _returnValueList.size())) {
            throw new IndexOutOfBoundsException("setReturnValue: Index value '"+index+"' not in range [0.."+_returnValueList.size()+ "]");
        }
        _returnValueList.setElementAt(vReturnValue, index);
    } //-- void setReturnValue(int, com.xradsolutions.xrad.xmlbo.ReturnValue) 

    /**
     * Method setReturnValue
     * 
     * 
     * 
     * @param returnValueArray
     */
    public void setReturnValue(com.xradsolutions.xrad.xmlbo.ReturnValue[] returnValueArray)
    {
        //-- copy array
        _returnValueList.removeAllElements();
        for (int i = 0; i < returnValueArray.length; i++) {
            _returnValueList.addElement(returnValueArray[i]);
        }
    } //-- void setReturnValue(com.xradsolutions.xrad.xmlbo.ReturnValue) 

    /**
     * Sets the value of field 'stereoType'.
     * 
     * @param stereoType the value of field 'stereoType'.
     */
    public void setStereoType(java.lang.String stereoType)
    {
        this._stereoType = stereoType;
    } //-- void setStereoType(java.lang.String) 

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
        return (com.xradsolutions.xrad.xmlbo.Process) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.Process.class, reader);
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
        return getName() + ": Process";
    }

}
