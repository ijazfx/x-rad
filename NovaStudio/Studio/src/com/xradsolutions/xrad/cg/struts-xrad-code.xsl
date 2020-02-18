<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
<xsl:if test="view">
<xsl:for-each select="view">
{BeginFile}
//@Location <xsl:value-of select="replace(@package-name, '[.]', '/')"/>
//@File <xsl:value-of select="@name"/>Form.java
package <xsl:value-of select="@package-name"/>;

//@begin imports

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.xradsolutions.xrad.core.*;

//@end imports

public class <xsl:value-of select="@name"/>Form
	extends ActionForm {

	//@begin properties

	private <xsl:value-of select="@name"/> xradView = new <xsl:value-of select="@name"/>();
	private String xradSubmitMethod;

	//@end properties

	public ActionErrors validate(ActionMapping actionMapping,
		HttpServletRequest httpServletRequest) {
		
		/** @todo: finish this method, this is just the skeleton.*/
		
		return null;
	}
    
	public void reset(ActionMapping actionMapping,
		HttpServletRequest servletRequest) {
	}

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
}
{EndFile}

{BeginFile}
//@Location <xsl:value-of select="replace(@package-name, '[.]', '/')"/>
//@File <xsl:value-of select="@name"/>FormAction.java
package <xsl:value-of select="@package-name"/>;

//@begin imports

import java.lang.reflect.*;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

//@end imports

public class <xsl:value-of select="@name"/>FormAction
	extends Action {

	//@begin execute method
	public ActionForward execute(ActionMapping actionMapping,
		ActionForm actionForm,
		HttpServletRequest servletRequest,
		HttpServletResponse servletResponse) {

		<xsl:value-of select="@name"/>Form <xsl:value-of select="@id"/>Form = (<xsl:value-of select="@name"/>Form) actionForm;
		String xradSubmitMethod = <xsl:value-of select="@id"/>Form.getXradSubmitMethod();
<xsl:if test="submit-method">
<xsl:for-each select="submit-method">
		if("<xsl:value-of select="@name"/>".equals(xradSubmitMethod)) {
			return <xsl:value-of select="@name"/>(actionMapping, actionForm, servletRequest, servletResponse);
		}
</xsl:for-each>
</xsl:if>
		throw new java.lang.UnsupportedOperationException(
			"Unexpected xradSubmitMethod" + xradSubmitMethod);
	}
	//@end execute method
<xsl:if test="submit-method">
	//@begin custom execute methods
<xsl:for-each select="submit-method">
	public ActionForward <xsl:value-of select="@name"/>(ActionMapping actionMapping,
		ActionForm actionForm,
		HttpServletRequest servletRequest,
		HttpServletResponse servletResponse) {

		<xsl:value-of select="../@name"/>Form <xsl:value-of select="../@id"/>Form = (<xsl:value-of select="../@name"/>Form) actionForm;
		<xsl:value-of select="../@name"/> xradView = <xsl:value-of select="../@id"/>Form.getXradView();
		Map params = new HashMap();

		//@todo Add your code here. Use can use 'params' map to pass additional
		// params to X-RAD view.

		// AVOID PASSING STRUTS FRAMEWORK SPECIFIC OBJECTS AS PARAMS TO X-RAD VIEW,
		// OTHERWISE THE X-RAD NAVIGATIONAL LOGIC WILL BECOME DEPENDENT OF STRUTS AND
		// YOUR APPLICATION WONT WORK IF MIGRATED FOR OTHER FRAMEWORK LIKE SUN JSF OR
		// SAP WEB DYNPRO!!

		// DO NOT REMOVE FOLLOWING LINE!!
		return actionMapping.findForward(xradView.<xsl:value-of select="@name"/>(servletRequest, servletResponse, params));
	}
</xsl:for-each>
	//@end custom execute methods
</xsl:if>
}
{EndFile}
</xsl:for-each>
</xsl:if>
</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2005. Progress Software Corporation. All rights reserved.
<metaInformation>
<scenarios ><scenario default="yes" name="Scenario1" userelativepaths="yes" externalpreview="no" url="..\..\..\..\..\..\..\XRadApps\SAIMS\src\app&#x2D;config.xrd" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="no" profilemode="0" profiledepth="" profilelength="" urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator=""/></scenarios><MapperMetaTag><MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/><MapperBlockPosition></MapperBlockPosition><TemplateContext></TemplateContext><MapperFilter side="source"></MapperFilter></MapperMetaTag>
</metaInformation>
-->