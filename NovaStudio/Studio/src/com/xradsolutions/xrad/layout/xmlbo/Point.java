/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Point.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.*;

/**
 * Class Point.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class Point
    implements java.io.Serializable {

  //--------------------------/
  //- Class/Member Variables -/
  //--------------------------/

  /**
   * Field _x
   */
  private double _x;

  /**
   * keeps track of state for field: _x
   */
  private boolean _has_x;

  /**
   * Field _y
   */
  private double _y;

  /**
   * keeps track of state for field: _y
   */
  private boolean _has_y;

  //----------------/
  //- Constructors -/
  //----------------/

  public Point() {
    super();
  } //-- com.xradsolutions.xrad.layout.xmlbo.Point()

  //-----------/
  //- Methods -/
  //-----------/

  /**
   * Method deleteX
   *
   */
  public void deleteX() {
    this._has_x = false;
  } //-- void deleteX()

  /**
   * Method deleteY
   *
   */
  public void deleteY() {
    this._has_y = false;
  } //-- void deleteY()

  /**
   * Returns the value of field 'x'.
   *
   * @return double
   * @return the value of field 'x'.
   */
  public double getX() {
    return this._x;
  } //-- double getX()

  /**
   * Returns the value of field 'y'.
   *
   * @return double
   * @return the value of field 'y'.
   */
  public double getY() {
    return this._y;
  } //-- double getY()

  /**
   * Method hasX
   *
   *
   *
   * @return boolean
   */
  public boolean hasX() {
    return this._has_x;
  } //-- boolean hasX()

  /**
   * Method hasY
   *
   *
   *
   * @return boolean
   */
  public boolean hasY() {
    return this._has_y;
  } //-- boolean hasY()

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
   * Sets the value of field 'x'.
   *
   * @param x the value of field 'x'.
   */
  public void setX(double x) {
    this._x = x;
    this._has_x = true;
  } //-- void setX(double)

  /**
   * Sets the value of field 'y'.
   *
   * @param y the value of field 'y'.
   */
  public void setY(double y) {
    this._y = y;
    this._has_y = true;
  } //-- void setY(double)

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
    return (com.xradsolutions.xrad.layout.xmlbo.Point) Unmarshaller.unmarshal(com.xradsolutions.xrad.layout.xmlbo.Point.class, reader);
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
