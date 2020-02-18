/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: EdgeDescriptor.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.*;

/**
 * Class EdgeDescriptor.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class EdgeDescriptor
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

  public EdgeDescriptor() {
    super();
    xmlName = "edge";

    //-- set grouping compositor
    setCompositorAsSequence();
    org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
    org.exolab.castor.mapping.FieldHandler handler = null;
    org.exolab.castor.xml.FieldValidator fieldValidator = null;
    //-- initialize attribute descriptors

    //-- _sourceCellId
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(long.class,
        "_sourceCellId", "source-cell-id",
        org.exolab.castor.xml.NodeType.Attribute);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Edge target = (Edge) object;
        if (!target.hasSourceCellId()) {
          return null;
        }
        return new java.lang.Long(target.getSourceCellId());
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
          // ignore null values for non optional primitives
          if (value == null) {
            return;
          }

          target.setSourceCellId( ( (java.lang.Long) value).longValue());
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

    //-- validation code for: _sourceCellId
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      LongValidator typeValidator = new LongValidator();
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- _sourceId
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.
        String.class, "_sourceId", "source-id",
        org.exolab.castor.xml.NodeType.Attribute);
    desc.setImmutable(true);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Edge target = (Edge) object;
        return target.getSourceId();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
          target.setSourceId( (java.lang.String) value);
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

    //-- validation code for: _sourceId
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      StringValidator typeValidator = new StringValidator();
      typeValidator.setWhiteSpace("preserve");
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- _targetCellId
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(long.class,
        "_targetCellId", "target-cell-id",
        org.exolab.castor.xml.NodeType.Attribute);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Edge target = (Edge) object;
        if (!target.hasTargetCellId()) {
          return null;
        }
        return new java.lang.Long(target.getTargetCellId());
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
          // ignore null values for non optional primitives
          if (value == null) {
            return;
          }

          target.setTargetCellId( ( (java.lang.Long) value).longValue());
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

    //-- validation code for: _targetCellId
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      LongValidator typeValidator = new LongValidator();
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- _targetId
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.
        String.class, "_targetId", "target-id",
        org.exolab.castor.xml.NodeType.Attribute);
    desc.setImmutable(true);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Edge target = (Edge) object;
        return target.getTargetId();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
          target.setTargetId( (java.lang.String) value);
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

    //-- validation code for: _targetId
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(1);
    { //-- local scope
      StringValidator typeValidator = new StringValidator();
      typeValidator.setWhiteSpace("preserve");
      fieldValidator.setValidator(typeValidator);
    }
    desc.setValidator(fieldValidator);
    //-- initialize element descriptors

    //-- _pointList
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.xradsolutions.xrad.layout.xmlbo.Point.class, "_pointList", "point",
        org.exolab.castor.xml.NodeType.Element);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        Edge target = (Edge) object;
        return target.getPoint();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
          target.addPoint( (com.xradsolutions.xrad.layout.xmlbo.Point) value);
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
    desc.setMultivalued(true);
    addFieldDescriptor(desc);

    //-- validation code for: _pointList
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
        Edge target = (Edge) object;
        return target.getLabelPoint();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          Edge target = (Edge) object;
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
  } //-- com.xradsolutions.xrad.layout.xmlbo.EdgeDescriptor()

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
    return com.xradsolutions.xrad.layout.xmlbo.Edge.class;
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
