/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: LabelPointDescriptor.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.*;

/**
 * Class LabelPointDescriptor.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class LabelPointDescriptor
    extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

  //--------------------------/
  //- Class/Member Variables -/
  //--------------------------/

  /**
   * Field nsPrefix
   */
  private java.lang.String nsPrefix;

  /**
   * Field nsURI
   */
  private java.lang.String nsURI;

  /**
   * Field xmlName
   */
  private java.lang.String xmlName;

  /**
   * Field identity
   */
  private org.exolab.castor.xml.XMLFieldDescriptor identity;

  //----------------/
  //- Constructors -/
  //----------------/

  public LabelPointDescriptor() {
    super();
    xmlName = "label-point";
    org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
    org.exolab.castor.mapping.FieldHandler handler = null;
    org.exolab.castor.xml.FieldValidator fieldValidator = null;
    //-- initialize attribute descriptors

    //-- _x
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.
        Double.TYPE, "_x", "x", org.exolab.castor.xml.NodeType.Attribute);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        LabelPoint target = (LabelPoint) object;
        if (!target.hasX()) {
          return null;
        }
        return new java.lang.Double(target.getX());
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          LabelPoint target = (LabelPoint) object;
          // ignore null values for non optional primitives
          if (value == null) {
            return;
          }

          target.setX( ( (java.lang.Double) value).doubleValue());
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return null;
      }
    };
    desc.setHandler(handler);
    desc.setRequired(true);
    desc.setMultivalued(false);
    addFieldDescriptor(desc);

    //-- validation code for: _x
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      DoubleValidator typeValidator = new DoubleValidator();
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- _y
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.
        Double.TYPE, "_y", "y", org.exolab.castor.xml.NodeType.Attribute);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        LabelPoint target = (LabelPoint) object;
        if (!target.hasY()) {
          return null;
        }
        return new java.lang.Double(target.getY());
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          LabelPoint target = (LabelPoint) object;
          // ignore null values for non optional primitives
          if (value == null) {
            return;
          }

          target.setY( ( (java.lang.Double) value).doubleValue());
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return null;
      }
    };
    desc.setHandler(handler);
    desc.setRequired(true);
    desc.setMultivalued(false);
    addFieldDescriptor(desc);

    //-- validation code for: _y
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      DoubleValidator typeValidator = new DoubleValidator();
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- initialize element descriptors

  } //-- com.xradsolutions.xrad.layout.xmlbo.LabelPointDescriptor()

  //-----------/
  //- Methods -/
  //-----------/

  /**
   * Method getAccessMode
   *
   *
   *
   * @return AccessMode
   */
  public org.exolab.castor.mapping.AccessMode getAccessMode() {
    return null;
  } //-- org.exolab.castor.mapping.AccessMode getAccessMode()

  /**
   * Method getExtends
   *
   *
   *
   * @return ClassDescriptor
   */
  public org.exolab.castor.mapping.ClassDescriptor getExtends() {
    return null;
  } //-- org.exolab.castor.mapping.ClassDescriptor getExtends()

  /**
   * Method getIdentity
   *
   *
   *
   * @return FieldDescriptor
   */
  public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
    return identity;
  } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity()

  /**
   * Method getJavaClass
   *
   *
   *
   * @return Class
   */
  public java.lang.Class getJavaClass() {
    return com.xradsolutions.xrad.layout.xmlbo.LabelPoint.class;
  } //-- java.lang.Class getJavaClass()

  /**
   * Method getNameSpacePrefix
   *
   *
   *
   * @return String
   */
  public java.lang.String getNameSpacePrefix() {
    return nsPrefix;
  } //-- java.lang.String getNameSpacePrefix()

  /**
   * Method getNameSpaceURI
   *
   *
   *
   * @return String
   */
  public java.lang.String getNameSpaceURI() {
    return nsURI;
  } //-- java.lang.String getNameSpaceURI()

  /**
   * Method getValidator
   *
   *
   *
   * @return TypeValidator
   */
  public org.exolab.castor.xml.TypeValidator getValidator() {
    return this;
  } //-- org.exolab.castor.xml.TypeValidator getValidator()

  /**
   * Method getXMLName
   *
   *
   *
   * @return String
   */
  public java.lang.String getXMLName() {
    return xmlName;
  } //-- java.lang.String getXMLName()

}
