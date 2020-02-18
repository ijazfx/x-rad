/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: AppModel.java,v 1.1.1.1 2006/08/25 18:58:01 Ali Mazhar Exp $
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
 * Comment describing your root element
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:01 $
 */
public class AppModel implements java.io.Serializable {


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
     * Field _version
     */
    private java.lang.String _version;

    /**
     * Field _author
     */
    private java.lang.String _author;

    /**
     * Field _company
     */
    private java.lang.String _company;

    /**
     * Field _viewList
     */
    private java.util.Vector _viewList;

    /**
     * Field _processList
     */
    private java.util.Vector _processList;

    /**
     * Field _interactionList
     */
    private java.util.Vector _interactionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AppModel() 
     {
        super();
        _viewList = new Vector();
        _processList = new Vector();
        _interactionList = new Vector();
    } //-- com.xradsolutions.xrad.xmlbo.AppConfig()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addInteraction
     * 
     * 
     * 
     * @param vInteraction
     */
    public void addInteraction(com.xradsolutions.xrad.xmlbo.Interaction vInteraction)
        throws java.lang.IndexOutOfBoundsException
    {
        _interactionList.addElement(vInteraction);
    } //-- void addInteraction(com.xradsolutions.xrad.xmlbo.Interaction) 

    /**
     * Method addInteraction
     * 
     * 
     * 
     * @param index
     * @param vInteraction
     */
    public void addInteraction(int index, com.xradsolutions.xrad.xmlbo.Interaction vInteraction)
        throws java.lang.IndexOutOfBoundsException
    {
        _interactionList.insertElementAt(vInteraction, index);
    } //-- void addInteraction(int, com.xradsolutions.xrad.xmlbo.Interaction) 

    /**
     * Method addProcess
     * 
     * 
     * 
     * @param vProcess
     */
    public void addProcess(com.xradsolutions.xrad.xmlbo.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        _processList.addElement(vProcess);
    } //-- void addProcess(com.xradsolutions.xrad.xmlbo.Process) 

    /**
     * Method addProcess
     * 
     * 
     * 
     * @param index
     * @param vProcess
     */
    public void addProcess(int index, com.xradsolutions.xrad.xmlbo.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        _processList.insertElementAt(vProcess, index);
    } //-- void addProcess(int, com.xradsolutions.xrad.xmlbo.Process) 

    /**
     * Method addView
     * 
     * 
     * 
     * @param vView
     */
    public void addView(com.xradsolutions.xrad.xmlbo.View vView)
        throws java.lang.IndexOutOfBoundsException
    {
        _viewList.addElement(vView);
    } //-- void addView(com.xradsolutions.xrad.xmlbo.View) 

    /**
     * Method addView
     * 
     * 
     * 
     * @param index
     * @param vView
     */
    public void addView(int index, com.xradsolutions.xrad.xmlbo.View vView)
        throws java.lang.IndexOutOfBoundsException
    {
        _viewList.insertElementAt(vView, index);
    } //-- void addView(int, com.xradsolutions.xrad.xmlbo.View) 

    /**
     * Method enumerateInteraction
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateInteraction()
    {
        return _interactionList.elements();
    } //-- java.util.Enumeration enumerateInteraction() 

    /**
     * Method enumerateProcess
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProcess()
    {
        return _processList.elements();
    } //-- java.util.Enumeration enumerateProcess() 

    /**
     * Method enumerateView
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateView()
    {
        return _viewList.elements();
    } //-- java.util.Enumeration enumerateView() 

    /**
     * Returns the value of field 'author'.
     * 
     * @return String
     * @return the value of field 'author'.
     */
    public java.lang.String getAuthor()
    {
        return this._author;
    } //-- java.lang.String getAuthor() 

    /**
     * Returns the value of field 'company'.
     * 
     * @return String
     * @return the value of field 'company'.
     */
    public java.lang.String getCompany()
    {
        return this._company;
    } //-- java.lang.String getCompany() 

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
     * Method getInteraction
     * 
     * 
     * 
     * @param index
     * @return Interaction
     */
    public com.xradsolutions.xrad.xmlbo.Interaction getInteraction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _interactionList.size())) {
            throw new IndexOutOfBoundsException("getInteraction: Index value '"+index+"' not in range [0.."+_interactionList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.Interaction) _interactionList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.Interaction getInteraction(int) 

    /**
     * Method getInteraction
     *
     *
     *
     * @return Interaction
     */
    public Interaction[] getInteraction()
    {
        int size = _interactionList.size();
        Interaction[] mArray = new com.xradsolutions.xrad.xmlbo.Interaction[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.Interaction) _interactionList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.Interaction[] getInteraction() 

    /**
     * Method getInteractionCount
     * 
     * 
     * 
     * @return int
     */
    public int getInteractionCount()
    {
        return _interactionList.size();
    } //-- int getInteractionCount() 

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
     * Method getProcess
     * 
     * 
     * 
     * @param index
     * @return Process
     */
    public com.xradsolutions.xrad.xmlbo.Process getProcess(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _processList.size())) {
            throw new IndexOutOfBoundsException("getProcess: Index value '"+index+"' not in range [0.."+_processList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.Process) _processList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.Process getProcess(int) 

    /**
     * Method getProcess
     *
     *
     *
     * @return Process
     */
    public Process[] getProcess()
    {
        int size = _processList.size();
        Process[] mArray = new com.xradsolutions.xrad.xmlbo.Process[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.Process) _processList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.Process[] getProcess() 

    /**
     * Method getProcessCount
     * 
     * 
     * 
     * @return int
     */
    public int getProcessCount()
    {
        return _processList.size();
    } //-- int getProcessCount() 

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
     * Returns the value of field 'version'.
     * 
     * @return String
     * @return the value of field 'version'.
     */
    public java.lang.String getVersion()
    {
        return this._version;
    } //-- java.lang.String getVersion() 

    /**
     * Method getView
     * 
     * 
     * 
     * @param index
     * @return View
     */
    public com.xradsolutions.xrad.xmlbo.View getView(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _viewList.size())) {
            throw new IndexOutOfBoundsException("getView: Index value '"+index+"' not in range [0.."+_viewList.size()+ "]");
        }
        
        return (com.xradsolutions.xrad.xmlbo.View) _viewList.elementAt(index);
    } //-- com.xradsolutions.xrad.xmlbo.View getView(int) 

    /**
     * Method getView
     *
     *
     *
     * @return View
     */
    public View[] getView()
    {
        int size = _viewList.size();
        View[] mArray = new com.xradsolutions.xrad.xmlbo.View[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.xradsolutions.xrad.xmlbo.View) _viewList.elementAt(index);
        }
        return mArray;
    } //-- com.xradsolutions.xrad.xmlbo.View[] getView() 

    /**
     * Method getViewCount
     * 
     * 
     * 
     * @return int
     */
    public int getViewCount()
    {
        return _viewList.size();
    } //-- int getViewCount() 

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
     * Method removeAllInteraction
     * 
     */
    public void removeAllInteraction()
    {
        _interactionList.removeAllElements();
    } //-- void removeAllInteraction() 

    /**
     * Method removeAllProcess
     * 
     */
    public void removeAllProcess()
    {
        _processList.removeAllElements();
    } //-- void removeAllProcess() 

    /**
     * Method removeAllView
     * 
     */
    public void removeAllView()
    {
        _viewList.removeAllElements();
    } //-- void removeAllView() 

    /**
     * Method removeInteraction
     * 
     * 
     * 
     * @param index
     * @return Interaction
     */
    public com.xradsolutions.xrad.xmlbo.Interaction removeInteraction(int index)
    {
        java.lang.Object obj = _interactionList.elementAt(index);
        _interactionList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.Interaction) obj;
    } //-- com.xradsolutions.xrad.xmlbo.Interaction removeInteraction(int) 

    /**
     * Method removeProcess
     * 
     * 
     * 
     * @param index
     * @return Process
     */
    public com.xradsolutions.xrad.xmlbo.Process removeProcess(int index)
    {
        java.lang.Object obj = _processList.elementAt(index);
        _processList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.Process) obj;
    } //-- com.xradsolutions.xrad.xmlbo.Process removeProcess(int) 

    /**
     * Method removeView
     * 
     * 
     * 
     * @param index
     * @return View
     */
    public com.xradsolutions.xrad.xmlbo.View removeView(int index)
    {
        java.lang.Object obj = _viewList.elementAt(index);
        _viewList.removeElementAt(index);
        return (com.xradsolutions.xrad.xmlbo.View) obj;
    } //-- com.xradsolutions.xrad.xmlbo.View removeView(int) 

    /**
     * Sets the value of field 'author'.
     * 
     * @param author the value of field 'author'.
     */
    public void setAuthor(java.lang.String author)
    {
        this._author = author;
    } //-- void setAuthor(java.lang.String) 

    /**
     * Sets the value of field 'company'.
     * 
     * @param company the value of field 'company'.
     */
    public void setCompany(java.lang.String company)
    {
        this._company = company;
    } //-- void setCompany(java.lang.String) 

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
     * Method setInteraction
     * 
     * 
     * 
     * @param index
     * @param vInteraction
     */
    public void setInteraction(int index, com.xradsolutions.xrad.xmlbo.Interaction vInteraction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _interactionList.size())) {
            throw new IndexOutOfBoundsException("setInteraction: Index value '"+index+"' not in range [0.."+_interactionList.size()+ "]");
        }
        _interactionList.setElementAt(vInteraction, index);
    } //-- void setInteraction(int, com.xradsolutions.xrad.xmlbo.Interaction) 

    /**
     * Method setInteraction
     * 
     * 
     * 
     * @param interactionArray
     */
    public void setInteraction(Interaction[] interactionArray)
    {
        //-- copy array
        _interactionList.removeAllElements();
        for (int i = 0; i < interactionArray.length; i++) {
            _interactionList.addElement(interactionArray[i]);
        }
    } //-- void setInteraction(com.xradsolutions.xrad.xmlbo.Interaction) 

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
     * Method setProcess
     * 
     * 
     * 
     * @param index
     * @param vProcess
     */
    public void setProcess(int index, com.xradsolutions.xrad.xmlbo.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _processList.size())) {
            throw new IndexOutOfBoundsException("setProcess: Index value '"+index+"' not in range [0.."+_processList.size()+ "]");
        }
        _processList.setElementAt(vProcess, index);
    } //-- void setProcess(int, com.xradsolutions.xrad.xmlbo.Process) 

    /**
     * Method setProcess
     * 
     * 
     * 
     * @param processArray
     */
    public void setProcess(Process[] processArray)
    {
        //-- copy array
        _processList.removeAllElements();
        for (int i = 0; i < processArray.length; i++) {
            _processList.addElement(processArray[i]);
        }
    } //-- void setProcess(com.xradsolutions.xrad.xmlbo.Process) 

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
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(java.lang.String version)
    {
        this._version = version;
    } //-- void setVersion(java.lang.String) 

    /**
     * Method setView
     * 
     * 
     * 
     * @param index
     * @param vView
     */
    public void setView(int index, com.xradsolutions.xrad.xmlbo.View vView)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _viewList.size())) {
            throw new IndexOutOfBoundsException("setView: Index value '"+index+"' not in range [0.."+_viewList.size()+ "]");
        }
        _viewList.setElementAt(vView, index);
    } //-- void setView(int, com.xradsolutions.xrad.xmlbo.View) 

    /**
     * Method setView
     * 
     * 
     * 
     * @param viewArray
     */
    public void setView(View[] viewArray)
    {
        //-- copy array
        _viewList.removeAllElements();
        for (int i = 0; i < viewArray.length; i++) {
            _viewList.addElement(viewArray[i]);
        }
    } //-- void setView(com.xradsolutions.xrad.xmlbo.View) 

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
        return (com.xradsolutions.xrad.xmlbo.AppModel) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.AppModel.class, reader);
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
