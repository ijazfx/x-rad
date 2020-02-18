/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: AppLayoutDescriptor.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/


/**
 * Class AppLayoutDescriptor.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class AppLayoutDescriptor
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

  public AppLayoutDescriptor() {
    super();
    xmlName = "app-layout";

    //-- set grouping compositor
    setCompositorAsSequence();
    org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
    org.exolab.castor.mapping.FieldHandler handler = null;
    org.exolab.castor.xml.FieldValidator fieldValidator = null;
    //-- initialize attribute descriptors

    //-- initialize element descriptors

    //-- _cellList
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.xradsolutions.xrad.layout.xmlbo.Cell.class, "_cellList", "cell",
        org.exolab.castor.xml.NodeType.Element);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        AppLayout target = (AppLayout) object;
        return target.getCell();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          AppLayout target = (AppLayout) object;
          target.addCell( (com.xradsolutions.xrad.layout.xmlbo.Cell) value);
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return new com.xradsolutions.xrad.layout.xmlbo.Cell();
      }
    };
    desc.setHandler(handler);
    desc.setMultivalued(true);
    addFieldDescriptor(desc);

    //-- validation code for: _cellList
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(0);
    { //-- local scope
    }
    desc.setValidator(fieldValidator);
    //-- _edgeList
    desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.xradsolutions.xrad.layout.xmlbo.Edge.class, "_edgeList", "edge",
        org.exolab.castor.xml.NodeType.Element);
    handler = new org.exolab.castor.xml.XMLFieldHandler() {
      public java.lang.Object getValue(java.lang.Object object) throws
          IllegalStateException {
        AppLayout target = (AppLayout) object;
        return target.getEdge();
      }

      public void setValue(java.lang.Object object, java.lang.Object value) throws
          IllegalStateException, IllegalArgumentException {
        try {
          AppLayout target = (AppLayout) object;
          target.addEdge( (com.xradsolutions.xrad.layout.xmlbo.Edge) value);
        }
        catch (java.lang.Exception ex) {
          throw new IllegalStateException(ex.toString());
        }
      }

      public java.lang.Object newInstance(java.lang.Object parent) {
        return new com.xradsolutions.xrad.layout.xmlbo.Edge();
      }
    };
    desc.setHandler(handler);
    desc.setMultivalued(true);
    addFieldDescriptor(desc);

    //-- validation code for: _edgeList
    fieldValidator = new org.exolab.castor.xml.FieldValidator();
    fieldValidator.setMinOccurs(0);
    { //-- local scope
    }
    desc.setValidator(fieldValidator);
  } //-- com.xradsolutions.xrad.layout.xmlbo.AppLayoutDescriptor()

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
    return com.xradsolutions.xrad.layout.xmlbo.AppLayout.class;
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
