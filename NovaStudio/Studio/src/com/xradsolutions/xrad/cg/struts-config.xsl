<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
{BeginFile}
//@Location WEB-INF
//@File struts-config.xml
<![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts-config PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 1.1//EN" "http://jakarta.apache.org/struts/dtds/struts-config_1_1.dtd">
<struts-config>
	<form-beans>]]><xsl:for-each select="view">
		<![CDATA[<form-bean name="]]><xsl:value-of select="@id"/><![CDATA[Form" type="]]><xsl:value-of select="@package-name"/>.<xsl:value-of select="@name"/><![CDATA[Form" />]]></xsl:for-each>
	<![CDATA[</form-beans>
	<action-mappings>]]><xsl:for-each select="view">
		<xsl:variable name="vid" select="@id"/>
		<xsl:variable name="fname"/>
		<![CDATA[<action input="/pages/]]><xsl:value-of select="@id"/><![CDATA[.jsp" name="]]><xsl:value-of select="@id"/><![CDATA[Form" path="/]]><xsl:value-of select="@id"/><![CDATA[" scope="request" type="]]><xsl:value-of select="@package-name"/>.<xsl:value-of select="@name"/><![CDATA[FormAction">]]><xsl:for-each select="/app-model/interaction">
			<xsl:if test="source/source-view"><xsl:if test="$vid eq source/source-view/@id">
			<![CDATA[<forward name="]]><xsl:value-of select="source/source-view/@submit-method-name"/><![CDATA["]]><xsl:if test="target/target-view"><![CDATA[ path="/pages/]]><xsl:value-of select="target/target-view/@id"/><![CDATA[.jsp"/>]]></xsl:if><xsl:if test="target/target-process"><![CDATA[ path="/]]><xsl:value-of select="target/target-process/@id"/><![CDATA[.do"/>]]></xsl:if></xsl:if>
			</xsl:if>
			</xsl:for-each>
		<![CDATA[</action>]]></xsl:for-each>
		<xsl:for-each select="process">
		<xsl:variable name="pid" select="@id"/>
		<![CDATA[<action path="/]]><xsl:value-of select="@id"/><![CDATA[" type="]]><xsl:value-of select="@package-name"/>.<xsl:value-of select="@name"/><![CDATA[Action">]]><xsl:for-each select="/app-model/interaction">
			<xsl:if test="source/source-process"><xsl:if test="$pid eq source/source-process/@id">
			<![CDATA[<forward name="]]><xsl:value-of select="source/source-process/@return-value-text"/><![CDATA["]]><xsl:if test="target/target-view"><![CDATA[ path="/pages/]]><xsl:value-of select="target/target-view/@id"/><![CDATA[.jsp"/>]]></xsl:if><xsl:if test="target/target-process"><![CDATA[ path="/]]><xsl:value-of select="target/target-process/@id"/><![CDATA[.do"/>]]></xsl:if></xsl:if>
			</xsl:if>
			</xsl:for-each>		
		<![CDATA[</action>]]></xsl:for-each>
	<![CDATA[</action-mappings>
</struts-config>]]>
{EndFile}
</xsl:template>
</xsl:stylesheet>