/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: Edge.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.*;

import org.exolab.castor.xml.*;

/**
 * Class Edge.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class Edge
    implements java.io.Serializable {

  //--------------------------/
  //- Class/Member Variables -/
  //--------------------------/

  /**
   * Field _sourceCellId
   */
  private long _sourceCellId;

  /**
   * keeps track of state for field: _sourceCellId
   */
  private boolean _has_sourceCellId;

  /**
   * Field _sourceId
   */
  private java.lang.String _sourceId;

  /**
   * Field _targetCellId
   */
  private long _targetCellId;

  /**
   * keeps track of state for field: _targetCellId
   */
  private boolean _has_targetCellId;

  /**
   * Field _targetId
   */
  private java.lang.String _targetId;

  /**
   * Field _pointList
   */
  private java.util.Vector _pointList;

  /**
   * Field _labelPoint
   */
  private com.xradsolutions.xrad.layout.xmlbo.LabelPoint _labelPoint;

  //----------------/
  //- Constructors -/
  //----------------/

  public Edge() {
    super();
    _pointList = new Vector();
  } //-- com.xradsolutions.xrad.layout.xmlbo.Edge()

  //-----------/
  //- Methods -/
  //-----------/

  /**
   * Method addPoint
   *
   *
   *
   * @param vPoint
   */
  public void addPoint(com.xradsolutions.xrad.layout.xmlbo.Point vPoint) throws java.
      lang.IndexOutOfBoundsException {
    _pointList.addElement(vPoint);
  } //-- void addPoint(com.xradsolutions.xrad.layout.xmlbo.Point)

  /**
   * Method addPoint
   *
   *
   *
   * @param index
   * @param vPoint
   */
  public void addPoint(int index, com.xradsolutions.xrad.layout.xmlbo.Point vPoint) throws
      java.lang.IndexOutOfBoundsException {
    _pointList.insertElementAt(vPoint, index);
  } //-- void addPoint(int, com.xradsolutions.xrad.layout.xmlbo.Point)

  /**
   * Method deleteSourceCellId
   *
   */
  public void deleteSourceCellId() {
    this._has_sourceCellId = false;
  } //-- void deleteSourceCellId()

  /**
   * Method deleteTargetCellId
   *
   */
  public void deleteTargetCellId() {
    this._has_targetCellId = false;
  } //-- void deleteTargetCellId()

  /**
   * Method enumeratePoint
   *
   *
   *
   * @return Enumeration
   */
  public java.util.Enumeration enumeratePoint() {
    return _pointList.elements();
  } //-- java.util.Enumeration enumeratePoint()

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
   * Method getPoint
   *
   *
   *
   * @param index
   * @return Point
   */
  public com.xradsolutions.xrad.layout.xmlbo.Point getPoint(int index) throws java.
      lang.IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _pointList.size())) {
      throw new IndexOutOfBoundsException("getPoint: Index value '" + index +
                                          "' not in range [0.." +
                                          _pointList.size() + "]");
    }

    return (com.xradsolutions.xrad.layout.xmlbo.Point) _pointList.elementAt(index);
  } //-- com.xradsolutions.xrad.layout.xmlbo.Point getPoint(int)

  /**
   * Method getPoint
   *
   *
   *
   * @return Point
   */
  public com.xradsolutions.xrad.layout.xmlbo.Point[] getPoint() {
    int size = _pointList.size();
    com.xradsolutions.xrad.layout.xmlbo.Point[] mArray = new com.xradsolutions.xrad.layout.xmlbo.Point[size];
    for (int index = 0; index < size; index++) {
      mArray[index] = (com.xradsolutions.xrad.layout.xmlbo.Point) _pointList.elementAt(
          index);
    }
    return mArray;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Point[] getPoint()

  /**
   * Method getPointCount
   *
   *
   *
   * @return int
   */
  public int getPointCount() {
    return _pointList.size();
  } //-- int getPointCount()

  /**
   * Returns the value of field 'sourceCellId'.
   *
   * @return long
   * @return the value of field 'sourceCellId'.
   */
  public long getSourceCellId() {
    return this._sourceCellId;
  } //-- long getSourceCellId()

  /**
   * Returns the value of field 'sourceId'.
   *
   * @return String
   * @return the value of field 'sourceId'.
   */
  public java.lang.String getSourceId() {
    return this._sourceId;
  } //-- java.lang.String getSourceId()

  /**
   * Returns the value of field 'targetCellId'.
   *
   * @return long
   * @return the value of field 'targetCellId'.
   */
  public long getTargetCellId() {
    return this._targetCellId;
  } //-- long getTargetCellId()

  /**
   * Returns the value of field 'targetId'.
   *
   * @return String
   * @return the value of field 'targetId'.
   */
  public java.lang.String getTargetId() {
    return this._targetId;
  } //-- java.lang.String getTargetId()

  /**
   * Method hasSourceCellId
   *
   *
   *
   * @return boolean
   */
  public boolean hasSourceCellId() {
    return this._has_sourceCellId;
  } //-- boolean hasSourceCellId()

  /**
   * Method hasTargetCellId
   *
   *
   *
   * @return boolean
   */
  public boolean hasTargetCellId() {
    return this._has_targetCellId;
  } //-- boolean hasTargetCellId()

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
   * Method removeAllPoint
   *
   */
  public void removeAllPoint() {
    _pointList.removeAllElements();
  } //-- void removeAllPoint()

  /**
   * Method removePoint
   *
   *
   *
   * @param index
   * @return Point
   */
  public com.xradsolutions.xrad.layout.xmlbo.Point removePoint(int index) {
    java.lang.Object obj = _pointList.elementAt(index);
    _pointList.removeElementAt(index);
    return (com.xradsolutions.xrad.layout.xmlbo.Point) obj;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Point removePoint(int)

  /**
   * Sets the value of field 'labelPoint'.
   *
   * @param labelPoint the value of field 'labelPoint'.
   */
  public void setLabelPoint(com.xradsolutions.xrad.layout.xmlbo.LabelPoint labelPoint) {
    this._labelPoint = labelPoint;
  } //-- void setLabelPoint(com.xradsolutions.xrad.layout.xmlbo.LabelPoint)

  /**
   * Method setPoint
   *
   *
   *
   * @param index
   * @param vPoint
   */
  public void setPoint(int index, com.xradsolutions.xrad.layout.xmlbo.Point vPoint) throws
      java.lang.IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _pointList.size())) {
      throw new IndexOutOfBoundsException("setPoint: Index value '" + index +
                                          "' not in range [0.." +
                                          _pointList.size() + "]");
    }
    _pointList.setElementAt(vPoint, index);
  } //-- void setPoint(int, com.xradsolutions.xrad.layout.xmlbo.Point)

  /**
   * Method setPoint
   *
   *
   *
   * @param pointArray
   */
  public void setPoint(com.xradsolutions.xrad.layout.xmlbo.Point[] pointArray) {
    //-- copy array
    _pointList.removeAllElements();
    for (int i = 0; i < pointArray.length; i++) {
      _pointList.addElement(pointArray[i]);
    }
  } //-- void setPoint(com.xradsolutions.xrad.layout.xmlbo.Point)

  /**
   * Sets the value of field 'sourceCellId'.
   *
   * @param sourceCellId the value of field 'sourceCellId'.
   */
  public void setSourceCellId(long sourceCellId) {
    this._sourceCellId = sourceCellId;
    this._has_sourceCellId = true;
  } //-- void setSourceCellId(long)

  /**
   * Sets the value of field 'sourceId'.
   *
   * @param sourceId the value of field 'sourceId'.
   */
  public void setSourceId(java.lang.String sourceId) {
    this._sourceId = sourceId;
  } //-- void setSourceId(java.lang.String)

  /**
   * Sets the value of field 'targetCellId'.
   *
   * @param targetCellId the value of field 'targetCellId'.
   */
  public void setTargetCellId(long targetCellId) {
    this._targetCellId = targetCellId;
    this._has_targetCellId = true;
  } //-- void setTargetCellId(long)

  /**
   * Sets the value of field 'targetId'.
   *
   * @param targetId the value of field 'targetId'.
   */
  public void setTargetId(java.lang.String targetId) {
    this._targetId = targetId;
  } //-- void setTargetId(java.lang.String)

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
    return (com.xradsolutions.xrad.layout.xmlbo.Edge) Unmarshaller.unmarshal(com.xradsolutions.xrad.layout.xmlbo.Edge.class, reader);
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
