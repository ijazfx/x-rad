/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: View.java,v 1.1.1.1 2006/08/25 18:58:01 Ali Mazhar Exp $
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
 * Class View.
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:01 $
 */
public class View implements java.io.Serializable {


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
     * Field _title
     */
    private java.lang.String _title;

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
     * Field _propertyList
     */
    private java.util.Vector _propertyList;

    /**
     * Field _submitMethodList
     */
    private java.util.Vector _submitMethodList;

    /**
     * Field _returnValueList
     */
    private java.util.Vector _returnValueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public View() 
     {
        super();
        _propertyList = new Vector();
        _submitMethodList = new Vector();
        _returnValueList = new Vector();
    } //-- com.xradsolutions.xrad.xmlbo.View()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProperty
     * 
     * 
     * 
     * @param vProperty
     */
    public void addProperty(com.xradsolutions.xrad.xmlbo.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.addElement(vProperty);
    } //-- void addProperty(com.xradsolutions.xrad.xmlbo.Property) 

    /**
     * Method addProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void addProperty(int index, com.xradsolutions.xrad.xmlbo.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _propertyList.insertElementAt(vProperty, index);
    } //-- void addProperty(int, com.xradsolutions.xrad.xmlbo.Property) 

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
     * Method addSubmitMethod
     * 
     * 
     * 
     * @param vSubmitMethod
     */
    public void addSubmitMethod(com.xradsolutions.xrad.xmlbo.SubmitMethod vSubmitMethod)
        throws java.lang.IndexOutOfBoundsException
    {
        _submitMethodList.addElement(vSubmitMethod);
    } //-- void addSubmitMethod(com.xradsolutions.xrad.xmlbo.SubmitMethod) 

    /**
     * Method addSubmitMethod
     * 
     * 
     * 
     * @param index
     * @param vSubmitMethod
     */
    public void addSubmitMethod(int index, com.xradsolutions.xrad.xmlbo.SubmitMethod vSubmitMethod)
        throws java.lang.IndexOutOfBoundsException
    {
        _submitMethodList.insertElementAt(vSubmitMethod, index);
    } //-- void addSubmitMethod(int, com.xradsolutions.xrad.xmlbo.SubmitMethod) 

    /**
     * Method enumerateProperty
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProperty()
    {
        return _propertyList.elements();
    } //-- java.util.Enumeration enumerateProperty() 

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
     * Method enumerateSubmitMethod
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSubmitMethod()
    {
        return _submitMethodList.elements();
    } //-- java.util.Enumeration enumerateSubmitMethod() 

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
     * Method getProperty
     * 
     * 
     * 
     * @param index
     * @return Property
     */
    public com.xradsolutions.xrad.xmlbo.Property getProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _propertyList.size())) {
            throw new IndexOutOfBoundsException("getProperty: Index value '"+index+"' not in range [0.."+_propertyList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.Property) _propertyList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.Property getProperty(int) 

    /**
     * Method getProperty
     * 
     * 
     * 
     * @return Property
     */
    public com.xradsolutions.xrad.xmlbo.Property[] getProperty()
    {
        int size = _propertyList.size();
        com.xradsolutions.xrad.xmlbo.Property[] mArray = new com.xradsolutions.xrad.xmlbo.Property[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.Property) _propertyList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.Property[] getProperty() 

    /**
     * Method getPropertyCount
     * 
     * 
     * 
     * @return int
     */
    public int getPropertyCount()
    {
        return _propertyList.size();
    } //-- int getPropertyCount() 

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
     * Method getSubmitMethod
     * 
     * 
     * 
     * @param index
     * @return SubmitMethod
     */
    public com.xradsolutions.xrad.xmlbo.SubmitMethod getSubmitMethod(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _submitMethodList.size())) {
            throw new IndexOutOfBoundsException("getSubmitMethod: Index value '"+index+"' not in range [0.."+_submitMethodList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.SubmitMethod) _submitMethodList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.SubmitMethod getSubmitMethod(int) 

    /**
     * Method getSubmitMethod
     * 
     * 
     * 
     * @return SubmitMethod
     */
    public com.xradsolutions.xrad.xmlbo.SubmitMethod[] getSubmitMethod()
    {
        int size = _submitMethodList.size();
        com.xradsolutions.xrad.xmlbo.SubmitMethod[] mArray = new com.xradsolutions.xrad.xmlbo.SubmitMethod[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.SubmitMethod) _submitMethodList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.SubmitMethod[] getSubmitMethod() 

    /**
     * Method getSubmitMethodCount
     * 
     * 
     * 
     * @return int
     */
    public int getSubmitMethodCount()
    {
        return _submitMethodList.size();
    } //-- int getSubmitMethodCount() 

    /**
     * Returns the value of field 'title'.
     * 
     * @return String
     * @return the value of field 'title'.
     */
    public java.lang.String getTitle()
    {
        return this._title;
    } //-- java.lang.String getTitle() 

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
     * Method removeAllProperty
     * 
     */
    public void removeAllProperty()
    {
        _propertyList.removeAllElements();
    } //-- void removeAllProperty() 

    /**
     * Method removeAllReturnValue
     * 
     */
    public void removeAllReturnValue()
    {
        _returnValueList.removeAllElements();
    } //-- void removeAllReturnValue() 

    /**
     * Method removeAllSubmitMethod
     * 
     */
    public void removeAllSubmitMethod()
    {
        _submitMethodList.removeAllElements();
    } //-- void removeAllSubmitMethod() 

    /**
     * Method removeProperty
     * 
     * 
     * 
     * @param index
     * @return Property
     */
    public com.xradsolutions.xrad.xmlbo.Property removeProperty(int index)
    {
        java.lang.Object obj = _propertyList.elementAt(index);
        _propertyList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.Property) obj;
    } //-- com.xradsolutions.xrad.xmlbo.Property removeProperty(int) 

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
     * Method removeSubmitMethod
     * 
     * 
     * 
     * @param index
     * @return SubmitMethod
     */
    public com.xradsolutions.xrad.xmlbo.SubmitMethod removeSubmitMethod(int index)
    {
        java.lang.Object obj = _submitMethodList.elementAt(index);
        _submitMethodList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.SubmitMethod) obj;
    } //-- com.xradsolutions.xrad.xmlbo.SubmitMethod removeSubmitMethod(int) 

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
     * Method setProperty
     * 
     * 
     * 
     * @param index
     * @param vProperty
     */
    public void setProperty(int index, com.xradsolutions.xrad.xmlbo.Property vProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _propertyList.size())) {
            throw new IndexOutOfBoundsException("setProperty: Index value '"+index+"' not in range [0.."+_propertyList.size()+ "]");
        }
        _propertyList.setElementAt(vProperty, index);
    } //-- void setProperty(int, com.xradsolutions.xrad.xmlbo.Property) 

    /**
     * Method setProperty
     * 
     * 
     * 
     * @param propertyArray
     */
    public void setProperty(com.xradsolutions.xrad.xmlbo.Property[] propertyArray)
    {
        //-- copy array
        _propertyList.removeAllElements();
        for (int i = 0; i < propertyArray.length; i++) {
            _propertyList.addElement(propertyArray[i]);
        }
    } //-- void setProperty(com.xradsolutions.xrad.xmlbo.Property) 

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
     * Method setSubmitMethod
     * 
     * 
     * 
     * @param index
     * @param vSubmitMethod
     */
    public void setSubmitMethod(int index, com.xradsolutions.xrad.xmlbo.SubmitMethod vSubmitMethod)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _submitMethodList.size())) {
            throw new IndexOutOfBoundsException("setSubmitMethod: Index value '"+index+"' not in range [0.."+_submitMethodList.size()+ "]");
        }
        _submitMethodList.setElementAt(vSubmitMethod, index);
    } //-- void setSubmitMethod(int, com.xradsolutions.xrad.xmlbo.SubmitMethod) 

    /**
     * Method setSubmitMethod
     * 
     * 
     * 
     * @param submitMethodArray
     */
    public void setSubmitMethod(com.xradsolutions.xrad.xmlbo.SubmitMethod[] submitMethodArray)
    {
        //-- copy array
        _submitMethodList.removeAllElements();
        for (int i = 0; i < submitMethodArray.length; i++) {
            _submitMethodList.addElement(submitMethodArray[i]);
        }
    } //-- void setSubmitMethod(com.xradsolutions.xrad.xmlbo.SubmitMethod) 

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.String title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.String) 

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
        return (com.xradsolutions.xrad.xmlbo.View) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.View.class, reader);
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
