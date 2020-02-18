/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Cell.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.*;

/**
 * Class Cell.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class Cell
    implements java.io.Serializable {

  //--------------------------/
  //- Class/Member Variables -/
  //--------------------------/

  /**
   * Field _id
   */
  private java.lang.String _id;

  /**
   * Field _cellId
   */
  private long _cellId;

  /**
   * keeps track of state for field: _cellId
   */
  private boolean _has_cellId;

  /**
   * Field _point
   */
  private com.xradsolutions.xrad.layout.xmlbo.Point _point;

  /**
   * Field _labelPoint
   */
  private com.xradsolutions.xrad.layout.xmlbo.LabelPoint _labelPoint;

  //----------------/
  //- Constructors -/
  //----------------/

  public Cell() {
    super();
  } //-- com.xradsolutions.xrad.layout.xmlbo.Cell()

  //-----------/
  //- Methods -/
  //-----------/

  /**
   * Method deleteCellId
   *
   */
  public void deleteCellId() {
    this._has_cellId = false;
  } //-- void deleteCellId()

  /**
   * Returns the value of field 'cellId'.
   *
   * @return long
   * @return the value of field 'cellId'.
   */
  public long getCellId() {
    return this._cellId;
  } //-- long getCellId()

  /**
   * Returns the value of field 'id'.
   *
   * @return String
   * @return the value of field 'id'.
   */
  public java.lang.String getId() {
    return this._id;
  } //-- java.lang.String getId()

  /**
   * Returns the value of field 'labelPoint'.
   *
   * @return LabelPoint
   * @return the value of field 'labelPoint'.
   */
  public com.xradsolutions.xrad.layout.xmlbo.LabelPoint getLabelPoint() {
    return this._labelPoint;
  } //-- com.xradsolutions.xrad.layout.xmlbo.LabelPoint getLabelPoint()

  /**
   * Returns the value of field 'point'.
   *
   * @return Point
   * @return the value of field 'point'.
   */
  public com.xradsolutions.xrad.layout.xmlbo.Point getPoint() {
    return this._point;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Point getPoint()

  /**
   * Method hasCellId
   *
   *
   *
   * @return boolean
   */
  public boolean hasCellId() {
    return this._has_cellId;
  } //-- boolean hasCellId()

  /**
   * Method isValid
   *
   *
   *
   * @return boolean
   */
  public boolean isValid() {
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
  public void marshal(java.io.Writer out) throws org.exolab.castor.xml.
      MarshalException, org.exolab.castor.xml.ValidationException {

    Marshaller.marshal(this, out);
  } //-- void marshal(java.io.Writer)

  /**
   * Method marshal
   *
   *
   *
   * @param handler
   */
  public void marshal(org.xml.sax.ContentHandler handler) throws java.io.
      IOException, org.exolab.castor.xml.MarshalException,
      org.exolab.castor.xml.ValidationException {

    Marshaller.marshal(this, handler);
  } //-- void marshal(org.xml.sax.ContentHandler)

  /**
   * Sets the value of field 'cellId'.
   *
   * @param cellId the value of field 'cellId'.
   */
  public void setCellId(long cellId) {
    this._cellId = cellId;
    this._has_cellId = true;
  } //-- void setCellId(long)

  /**
   * Sets the value of field 'id'.
   *
   * @param id the value of field 'id'.
   */
  public void setId(java.lang.String id) {
    this._id = id;
  } //-- void setId(java.lang.String)

  /**
   * Sets the value of field 'labelPoint'.
   *
   * @param labelPoint the value of field 'labelPoint'.
   */
  public void setLabelPoint(com.xradsolutions.xrad.layout.xmlbo.LabelPoint labelPoint) {
    this._labelPoint = labelPoint;
  } //-- void setLabelPoint(com.xradsolutions.xrad.layout.xmlbo.LabelPoint)

  /**
   * Sets the value of field 'point'.
   *
   * @param point the value of field 'point'.
   */
  public void setPoint(com.xradsolutions.xrad.layout.xmlbo.Point point) {
    this._point = point;
  } //-- void setPoint(com.xradsolutions.xrad.layout.xmlbo.Point)

  /**
   * Method unmarshal
   *
   *
   *
   * @param reader
   * @return Object
   */
  public static java.lang.Object unmarshal(java.io.Reader reader) throws org.
      exolab.castor.xml.MarshalException,
      org.exolab.castor.xml.ValidationException {
    return (com.xradsolutions.xrad.layout.xmlbo.Cell) Unmarshaller.unmarshal(com.xradsolutions.xrad.layout.xmlbo.Cell.class, reader);
  } //-- java.lang.Object unmarshal(java.io.Reader)

  /**
   * Method validate
   *
   */
  public void validate() throws org.exolab.castor.xml.ValidationException {
    org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.
        Validator();
    validator.validate(this);
  } //-- void validate()

}
