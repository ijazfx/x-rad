<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
<xsl:if test="view">
<xsl:for-each select="view">
{BeginFile}
//@Location <xsl:value-of select="replace(@package-name, '[.]', '/')"/>
//@File <xsl:value-of select="@name"/>Face.java
package <xsl:value-of select="@package-name"/>;

//@begin imports

import java.lang.reflect.*;
import java.util.*;
import javax.servlet.*;
import javax.faces.context.*;
import com.xradsolutions.xrad.core.*;

//@end imports

public class <xsl:value-of select="@name"/>Face {

	//@begin properties

	private <xsl:value-of select="@name"/> xradView = new <xsl:value-of select="@name"/>();
	private String xradSubmitMethod;

	//@end properties

	//@begin constructor

	public <xsl:value-of select="@name"/>Face() {
		reset();
	}

	//@end constructor

	//@begin getters/setters

	public <xsl:value-of select="@name"/> getXradView() {
		return xradView;
	}

	public void setXradView(<xsl:value-of select="@name"/> xradView) {
		this.xradView = xradView;
	}

	public String getXradSubmitMethod() {
		return xradSubmitMethod;
	}

	public void setXradSubmitMethod(String xradSubmitMethod) {
		this.xradSubmitMethod = xradSubmitMethod;
	}

	//@begin getters/setters
<xsl:if test="property">
	//@begin delegates to xradView properties
<xsl:for-each select="property">
	public <xsl:value-of select="@type"/> get<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>() {
		return xradView.get<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>();
	}

	public void set<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>(<xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>) {
		xradView.set<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>(<xsl:value-of select="@name"/>);
	}
	</xsl:for-each>
	//@end delegates to xradView properties
</xsl:if>
<xsl:if test="submit-method">
	//@begin actions
	public String reset() {	
	
		//@todo Add your code here to reset the form.
		
		return "";
	}

<xsl:for-each select="submit-method">
	public String <xsl:value-of select="@name"/>() throws
		InvocationTargetException {

		ServletRequest servletRequest = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ServletResponse servletResponse = (ServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		Map params = new HashMap();

		//@todo Add your code here. Use can use 'params' map to pass additional
		// params to X-RAD view.

		// AVOID PASSING JSF FRAMEWORK SPECIFIC OBJECTS AS PARAMS TO X-RAD VIEW,
		// OTHERWISE THE X-RAD NAVIGATIONAL LOGIC WILL BECOME DEPENDENT OF JSF AND
		// YOUR APPLICATION WONT WORK IF MIGRATED FOR OTHER FRAMEWORK LIKE APACHE
		// STRUTS OR SAP WEB DYNPRO!!

		// DO NOT REMOVE FOLLOWING LINE!!
		return xradView.<xsl:value-of select="@name"/>(servletRequest, servletResponse, params);
	}
</xsl:for-each>
	//@end actions
</xsl:if>
}
{EndFile}
</xsl:for-each>
</xsl:if>
</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2005. Progress Software Corporation. All rights reserved.
<metaInformation>
<scenarios/><MapperMetaTag><MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/><MapperBlockPosition></MapperBlockPosition><TemplateContext></TemplateContext><MapperFilter side="source"></MapperFilter></MapperMetaTag>
</metaInformation>
-->