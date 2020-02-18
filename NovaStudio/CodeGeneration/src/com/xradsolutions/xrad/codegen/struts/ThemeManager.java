package com.xradsolutions.xrad.codegen.struts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.xml.transform.stream.StreamSource;

import org.apache.xerces.parsers.DOMParser;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;

public class ThemeManager {
    public static Properties themes = new Properties();
    public static String themeFileName =
        System.getProperty("user.home") + "/.x-rad-studio" +
        "/codegen/struts-1.2/themes.properties";


    public static String[] retrieveThemes() {
        List<String> list = new ArrayList<String>();
        try {
            File themeFile = new File(themeFileName);
            FileInputStream fis = new FileInputStream(themeFile);
            themes.load(fis);
            fis.close();
            Enumeration enu = themes.keys();

            while (enu.hasMoreElements()) {
                String key = (String)enu.nextElement();
                String value = (String)themes.get(key);
                list.add(value + " [" + key + "]");
            }
        } catch (IOException e) {
            ;
        }
        return list.toArray(new String[list.size()]);
    }

    public static String[] retriveVelocityThemes(String themeName) {
        String path = retrievePath(themeName);
        String[] layoutFiles = null;
        File file = new File(path);
        if (file.isDirectory()) {
            file = new File(file, "velocity");
            if (file.isDirectory()) {
                layoutFiles = file.list(new FilenameFilter() {
                                public boolean accept(File dir, String name) {
                                    if (name.endsWith(".jsp") || name.endsWith(".jspx") || name.endsWith(".htm") || name.endsWith(".html") || name.endsWith(".xhtml")) {
                                        return true;
                                    }
                                    return false;
                                }
                            });
            }
        }
        if (layoutFiles == null) {
            layoutFiles = new String[] { "-- No Theme File Found --" };
        }
        return layoutFiles;
    }

    public static String retrievePath(String themeName) {
        int obidx = themeName.indexOf('[');
        int cbidx = themeName.indexOf(']', obidx);
        String path = themeName.substring(obidx + 1, cbidx);
        return path;
    }

    static LinkedHashMap<String, LinkedHashMap<String, String>> retriveTilesBaseDefinitions(String themeName) {
        String path = retrievePath(themeName);
        LinkedHashMap<String, LinkedHashMap<String, String>> defs = null;
        File file = new File(path);
        if (file.isDirectory()) {
            file = new File(file, "WEB-INF/tiles-base-defs.xml");
            if(!file.exists()) return null;
            DOMParser parser = new DOMParser();
            try {
                InputSource source = new InputSource(new FileReader(file));
                parser.parse(source);
                Document document = parser.getDocument();
                NodeList defnodes = document.getElementsByTagName("definition");
                if(defnodes != null) {
                    defs = new LinkedHashMap();
                    for(int i = 0; i < defnodes.getLength(); i++) {
                        Node defnode = defnodes.item(i);
                        if(defnode.getNodeType() == Node.ELEMENT_NODE) {
                            String defname = defnode.getAttributes().getNamedItem("name").getNodeValue();
                            LinkedHashMap<String, String> puts = new LinkedHashMap();
                            NodeList putnodes = defnode.getChildNodes();
                            for(int j = 0; j < putnodes.getLength(); j++) {
                                Node putnode = putnodes.item(j);
                                if(putnode.getNodeType() == Node.ELEMENT_NODE && putnode.getNodeName().equals("put")) {
                                    String putname = putnode.getAttributes().getNamedItem("name").getNodeValue();
                                    String putvalue = putnode.getAttributes().getNamedItem("value").getNodeValue();
                                    puts.put(putname, putvalue);
                                }
                            }
                            defs.put(defname, puts);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return defs;
    }
}
