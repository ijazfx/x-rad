/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: CellDescriptor.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.*;

/**
 * Class CellDescriptor.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class CellDescriptor
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

  public CellDescriptor() {
    super();
    xmlName = "cell";

    //-- set grouping compositor
    setCompositorAsSequence();
    org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
    org.exolab.castor.mapping.FieldHandler handler = null;
    org.exolab.castor.xml.FieldValidator fieldValidator = null;
    //-- initialize attribute descriptors

    //-- _id
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.
        String.class, "_id", "id", org.exolab.castor.xml.NodeType.Attribute);
    desc.setImmutable(true);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Cell target = (Cell) object;
        return target.getId();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Cell target = (Cell) object;
          target.setId( (java.lang.String) value);
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

    //-- validation code for: _id
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      StringValidator typeValidator = new StringValidator();
      typeValidator.setWhiteSpace("preserve");
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- _cellId
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(long.class,
        "_cellId", "cell-id", org.exolab.castor.xml.NodeType.Attribute);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Cell target = (Cell) object;
        if (!target.hasCellId()) {
          return null;
        }
        return new java.lang.Long(target.getCellId());
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Cell target = (Cell) object;
          // ignore null values for non optional primitives
          if (value == null) {
            return;
          }

          target.setCellId( ( (java.lang.Long) value).longValue());
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

    //-- validation code for: _cellId
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      LongValidator typeValidator = new LongValidator();
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- initialize element descriptors

    //-- _point
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.xradsolutions.xrad.layout.xmlbo.Point.class, "_point", "point",
        org.exolab.castor.xml.NodeType.Element);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Cell target = (Cell) object;
        return target.getPoint();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Cell target = (Cell) object;
          target.setPoint( (com.xradsolutions.xrad.layout.xmlbo.Point) value);
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return new com.xradsolutions.xrad.layout.xmlbo.Point();
      }
    };
    desc.setHandler(handler);
    desc.setRequired(true);
    desc.setMultivalued(false);
    addFieldDescriptor(desc);

    //-- validation code for: _point
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
    }
    desc.setValidator(fieldValidator);
    //-- _labelPoint
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.xradsolutions.xrad.layout.xmlbo.LabelPoint.class, "_labelPoint", "label-point",
        org.exolab.castor.xml.NodeType.Element);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Cell target = (Cell) object;
        return target.getLabelPoint();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Cell target = (Cell) object;
          target.setLabelPoint( (com.xradsolutions.xrad.layout.xmlbo.LabelPoint) value);
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return new com.xradsolutions.xrad.layout.xmlbo.LabelPoint();
      }
    };
    desc.setHandler(handler);
    desc.setRequired(true);
    desc.setMultivalued(false);
    addFieldDescriptor(desc);

    //-- validation code for: _labelPoint
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
    }
    desc.setValidator(fieldValidator);
  } //-- com.xradsolutions.xrad.layout.xmlbo.CellDescriptor()

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
    return com.xradsolutions.xrad.layout.xmlbo.Cell.class;
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
