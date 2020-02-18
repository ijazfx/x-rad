/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Interaction.java,v 1.1.1.1 2006/08/25 18:58:01 Ali Mazhar Exp $
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
 * Class Interaction.
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:01 $
 */
public class Interaction implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _source
     */
    private com.xradsolutions.xrad.xmlbo.Source _source;

    /**
     * Field _target
     */
    private com.xradsolutions.xrad.xmlbo.Target _target;


      //----------------/
     //- Constructors -/
    //----------------/

    public Interaction() 
     {
        super();
    } //-- com.xradsolutions.xrad.xmlbo.Interaction()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'source'.
     * 
     * @return Source
     * @return the value of field 'source'.
     */
    public com.xradsolutions.xrad.xmlbo.Source getSource()
    {
        return this._source;
    } //-- com.xradsolutions.xrad.xmlbo.Source getSource() 

    /**
     * Returns the value of field 'target'.
     * 
     * @return Target
     * @return the value of field 'target'.
     */
    public com.xradsolutions.xrad.xmlbo.Target getTarget()
    {
        return this._target;
    } //-- com.xradsolutions.xrad.xmlbo.Target getTarget() 

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
     * Sets the value of field 'source'.
     * 
     * @param source the value of field 'source'.
     */
    public void setSource(com.xradsolutions.xrad.xmlbo.Source source)
    {
        this._source = source;
    } //-- void setSource(com.xradsolutions.xrad.xmlbo.Source) 

    /**
     * Sets the value of field 'target'.
     * 
     * @param target the value of field 'target'.
     */
    public void setTarget(com.xradsolutions.xrad.xmlbo.Target target)
    {
        this._target = target;
    } //-- void setTarget(com.xradsolutions.xrad.xmlbo.Target) 

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
        return (com.xradsolutions.xrad.xmlbo.Interaction) Unmarshaller.unmarshal(com.xradsolutions.xrad.xmlbo.Interaction.class, reader);
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
        if(getSource() != null) {
            return getSource().toString();
        }
        return "???";
    }

}
