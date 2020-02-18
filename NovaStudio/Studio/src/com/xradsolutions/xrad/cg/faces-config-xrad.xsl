<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
{BeginFile}
//@Location WEB-INF
//@File faces-config.xml
<![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE faces-config PUBLIC "-//Sun Microsystems, Inc.//DTD JavaServer Faces Config 1.1//EN" "http://java.sun.com/dtd/web-facesconfig_1_1.dtd">
<faces-config xmlns="http://java.sun.com/JSF/Configuration">
	]]><xsl:for-each select="view"><![CDATA[<managed-bean>
		<managed-bean-name>]]><xsl:value-of select="@id"/><![CDATA[Face</managed-bean-name>
		<managed-bean-class>]]><xsl:value-of select="@package-name"/>.<xsl:value-of select="@name"/><![CDATA[Face</managed-bean-class>
		<managed-bean-scope>request</managed-bean-scope>
	</managed-bean>
	]]></xsl:for-each><![CDATA[<navigation-rule>
		<from-view-id>*</from-view-id>
		]]><xsl:for-each select="view"><![CDATA[<navigation-case>
			<from-outcome>]]><xsl:value-of select="@id"/><![CDATA[</from-outcome>
			<to-view-id>/pages/]]><xsl:value-of select="@id"/><![CDATA[.jsp</to-view-id>
		</navigation-case>]]></xsl:for-each><![CDATA[
	</navigation-rule>
</faces-config>]]>
{EndFile}
</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2005. Progress Software Corporation. All rights reserved.
<metaInformation>
<scenarios ><scenario default="yes" name="Faces Config Generation" userelativepaths="yes" externalpreview="no" url="..\..\..\..\..\..\..\..\Documents and Settings\Ijaz\My Documents\regapp.xrd" htmlbaseurl="" outputurl="" processortype="saxon8" useresolver="no" profilemode="0" profiledepth="" profilelength="" urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator=""/></scenarios><MapperMetaTag><MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/><MapperBlockPosition></MapperBlockPosition><TemplateContext></TemplateContext><MapperFilter side="source"></MapperFilter></MapperMetaTag>
</metaInformation>
-->