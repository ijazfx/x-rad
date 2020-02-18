package com.xradsolutions.xrad.swing;

import javax.swing.JComboBox;

/**
 * @author Farrukh Ijaz (ijazfx@aramco.com.sa)
 * @version 1.0
 */
public class ComboBoxEditor
    extends javax.swing.DefaultCellEditor {

  static class MyComboBox extends JComboBox {
    public MyComboBox(String[] items, boolean editable) {
        super(items);
        setEditable(editable);
    }
  }

    public ComboBoxEditor(String[] items) {
      super(new MyComboBox(items, false));
    }
    
  public ComboBoxEditor(String[] items, boolean editable) {
    super(new MyComboBox(items, editable));
  }
}