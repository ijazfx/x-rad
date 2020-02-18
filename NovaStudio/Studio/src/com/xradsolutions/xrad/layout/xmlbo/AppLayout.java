/*
 * This class was automatically generated with
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: AppLayout.java,v 1.1.1.1 2006/08/25 18:58:05 Ali Mazhar Exp $
 */

package com.xradsolutions.xrad.layout.xmlbo;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.*;

import org.exolab.castor.xml.*;

/**
 * Comment describing your root element
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2006/08/25 18:58:05 $
 */
public class AppLayout
    implements java.io.Serializable {

  //--------------------------/
  //- Class/Member Variables -/
  //--------------------------/

  /**
   * Field _cellList
   */
  private java.util.Vector _cellList;

  /**
   * Field _edgeList
   */
  private java.util.Vector _edgeList;

  //----------------/
  //- Constructors -/
  //----------------/

  public AppLayout() {
    super();
    _cellList = new Vector();
    _edgeList = new Vector();
  } //-- com.xradsolutions.xrad.layout.xmlbo.AppLayout()

  //-----------/
  //- Methods -/
  //-----------/

  /**
   * Method addCell
   *
   *
   *
   * @param vCell
   */
  public void addCell(com.xradsolutions.xrad.layout.xmlbo.Cell vCell) throws java.lang.
      IndexOutOfBoundsException {
    _cellList.addElement(vCell);
  } //-- void addCell(com.xradsolutions.xrad.layout.xmlbo.Cell)

  /**
   * Method addCell
   *
   *
   *
   * @param index
   * @param vCell
   */
  public void addCell(int index, com.xradsolutions.xrad.layout.xmlbo.Cell vCell) throws
      java.lang.IndexOutOfBoundsException {
    _cellList.insertElementAt(vCell, index);
  } //-- void addCell(int, com.xradsolutions.xrad.layout.xmlbo.Cell)

  /**
   * Method addEdge
   *
   *
   *
   * @param vEdge
   */
  public void addEdge(com.xradsolutions.xrad.layout.xmlbo.Edge vEdge) throws java.lang.
      IndexOutOfBoundsException {
    _edgeList.addElement(vEdge);
  } //-- void addEdge(com.xradsolutions.xrad.layout.xmlbo.Edge)

  /**
   * Method addEdge
   *
   *
   *
   * @param index
   * @param vEdge
   */
  public void addEdge(int index, com.xradsolutions.xrad.layout.xmlbo.Edge vEdge) throws
      java.lang.IndexOutOfBoundsException {
    _edgeList.insertElementAt(vEdge, index);
  } //-- void addEdge(int, com.xradsolutions.xrad.layout.xmlbo.Edge)

  /**
   * Method enumerateCell
   *
   *
   *
   * @return Enumeration
   */
  public java.util.Enumeration enumerateCell() {
    return _cellList.elements();
  } //-- java.util.Enumeration enumerateCell()

  /**
   * Method enumerateEdge
   *
   *
   *
   * @return Enumeration
   */
  public java.util.Enumeration enumerateEdge() {
    return _edgeList.elements();
  } //-- java.util.Enumeration enumerateEdge()

  /**
   * Method getCell
   *
   *
   *
   * @param index
   * @return Cell
   */
  public com.xradsolutions.xrad.layout.xmlbo.Cell getCell(int index) throws java.lang.
      IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _cellList.size())) {
      throw new IndexOutOfBoundsException("getCell: Index value '" + index +
                                          "' not in range [0.." +
                                          _cellList.size() + "]");
    }

    return (com.xradsolutions.xrad.layout.xmlbo.Cell) _cellList.elementAt(index);
  } //-- com.xradsolutions.xrad.layout.xmlbo.Cell getCell(int)

  /**
   * Method getCell
   *
   *
   *
   * @return Cell
   */
  public com.xradsolutions.xrad.layout.xmlbo.Cell[] getCell() {
    int size = _cellList.size();
    com.xradsolutions.xrad.layout.xmlbo.Cell[] mArray = new com.xradsolutions.xrad.layout.xmlbo.Cell[size];
    for (int index = 0; index < size; index++) {
      mArray[index] = (com.xradsolutions.xrad.layout.xmlbo.Cell) _cellList.elementAt(
          index);
    }
    return mArray;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Cell[] getCell()

  /**
   * Method getCellCount
   *
   *
   *
   * @return int
   */
  public int getCellCount() {
    return _cellList.size();
  } //-- int getCellCount()

  /**
   * Method getEdge
   *
   *
   *
   * @param index
   * @return Edge
   */
  public com.xradsolutions.xrad.layout.xmlbo.Edge getEdge(int index) throws java.lang.
      IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _edgeList.size())) {
      throw new IndexOutOfBoundsException("getEdge: Index value '" + index +
                                          "' not in range [0.." +
                                          _edgeList.size() + "]");
    }

    return (com.xradsolutions.xrad.layout.xmlbo.Edge) _edgeList.elementAt(index);
  } //-- com.xradsolutions.xrad.layout.xmlbo.Edge getEdge(int)

  /**
   * Method getEdge
   *
   *
   *
   * @return Edge
   */
  public com.xradsolutions.xrad.layout.xmlbo.Edge[] getEdge() {
    int size = _edgeList.size();
    com.xradsolutions.xrad.layout.xmlbo.Edge[] mArray = new com.xradsolutions.xrad.layout.xmlbo.Edge[size];
    for (int index = 0; index < size; index++) {
      mArray[index] = (com.xradsolutions.xrad.layout.xmlbo.Edge) _edgeList.elementAt(
          index);
    }
    return mArray;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Edge[] getEdge()

  /**
   * Method getEdgeCount
   *
   *
   *
   * @return int
   */
  public int getEdgeCount() {
    return _edgeList.size();
  } //-- int getEdgeCount()

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
   * Method removeAllCell
   *
   */
  public void removeAllCell() {
    _cellList.removeAllElements();
  } //-- void removeAllCell()

  /**
   * Method removeAllEdge
   *
   */
  public void removeAllEdge() {
    _edgeList.removeAllElements();
  } //-- void removeAllEdge()

  /**
   * Method removeCell
   *
   *
   *
   * @param index
   * @return Cell
   */
  public com.xradsolutions.xrad.layout.xmlbo.Cell removeCell(int index) {
    java.lang.Object obj = _cellList.elementAt(index);
    _cellList.removeElementAt(index);
    return (com.xradsolutions.xrad.layout.xmlbo.Cell) obj;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Cell removeCell(int)

  /**
   * Method removeEdge
   *
   *
   *
   * @param index
   * @return Edge
   */
  public com.xradsolutions.xrad.layout.xmlbo.Edge removeEdge(int index) {
    java.lang.Object obj = _edgeList.elementAt(index);
    _edgeList.removeElementAt(index);
    return (com.xradsolutions.xrad.layout.xmlbo.Edge) obj;
  } //-- com.xradsolutions.xrad.layout.xmlbo.Edge removeEdge(int)

  /**
   * Method setCell
   *
   *
   *
   * @param index
   * @param vCell
   */
  public void setCell(int index, com.xradsolutions.xrad.layout.xmlbo.Cell vCell) throws
      java.lang.IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _cellList.size())) {
      throw new IndexOutOfBoundsException("setCell: Index value '" + index +
                                          "' not in range [0.." +
                                          _cellList.size() + "]");
    }
    _cellList.setElementAt(vCell, index);
  } //-- void setCell(int, com.xradsolutions.xrad.layout.xmlbo.Cell)

  /**
   * Method setCell
   *
   *
   *
   * @param cellArray
   */
  public void setCell(com.xradsolutions.xrad.layout.xmlbo.Cell[] cellArray) {
    //-- copy array
    _cellList.removeAllElements();
    for (int i = 0; i < cellArray.length; i++) {
      _cellList.addElement(cellArray[i]);
    }
  } //-- void setCell(com.xradsolutions.xrad.layout.xmlbo.Cell)

  /**
   * Method setEdge
   *
   *
   *
   * @param index
   * @param vEdge
   */
  public void setEdge(int index, com.xradsolutions.xrad.layout.xmlbo.Edge vEdge) throws
      java.lang.IndexOutOfBoundsException {
    //-- check bounds for index
    if ( (index < 0) || (index > _edgeList.size())) {
      throw new IndexOutOfBoundsException("setEdge: Index value '" + index +
                                          "' not in range [0.." +
                                          _edgeList.size() + "]");
    }
    _edgeList.setElementAt(vEdge, index);
  } //-- void setEdge(int, com.xradsolutions.xrad.layout.xmlbo.Edge)

  /**
   * Method setEdge
   *
   *
   *
   * @param edgeArray
   */
  public void setEdge(com.xradsolutions.xrad.layout.xmlbo.Edge[] edgeArray) {
    //-- copy array
    _edgeList.removeAllElements();
    for (int i = 0; i < edgeArray.length; i++) {
      _edgeList.addElement(edgeArray[i]);
    }
  } //-- void setEdge(com.xradsolutions.xrad.layout.xmlbo.Edge)

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
    return (com.xradsolutions.xrad.layout.xmlbo.AppLayout) Unmarshaller.unmarshal(com.xradsolutions.xrad.layout.xmlbo.AppLayout.class, reader);
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
