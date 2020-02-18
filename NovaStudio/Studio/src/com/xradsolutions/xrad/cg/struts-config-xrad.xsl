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
	<global-forwards>]]><xsl:for-each select="view">
		<![CDATA[<forward name="]]><xsl:value-of select="@id"/><![CDATA[" path="/pages/]]><xsl:value-of select="@id"/><![CDATA[.jsp" />]]></xsl:for-each>
	<![CDATA[</global-forwards>
	<action-mappings>]]><xsl:for-each select="view">
		<![CDATA[<action input="/pages/]]><xsl:value-of select="@id"/><![CDATA[.jsp" name="]]><xsl:value-of select="@id"/><![CDATA[Form" path="/]]><xsl:value-of select="@id"/><![CDATA[" scope="request" type="]]><xsl:value-of select="@package-name"/>.<xsl:value-of select="@name"/><![CDATA[FormAction"/>]]></xsl:for-each>
	<![CDATA[</action-mappings>
</struts-config>]]>
{EndFile}
</xsl:template>
</xsl:stylesheet>