<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
<xsl:for-each select="view">
{BeginFile}
//@Location pages
//@File <xsl:value-of select="@id"/>.jsp
<![CDATA[
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=windows-1252" %>
<html:html>
<head>
<title>
]]><xsl:value-of select="@title"/><![CDATA[
</title>
<html:base/>
<link href="xrad-style.css" rel="stylesheet" type="text/css">
</head>
<body class="xradBody">
<html:form styleClass="xradForm" action="/]]><xsl:value-of select="@id"/><![CDATA[.do" method="POST">
<html:hidden property="xradSubmitMethod"/>
<div class="xradTitleBar">]]><xsl:value-of select="@title"/><![CDATA[</div>
<div id="xradLinkBar">|]]><xsl:for-each select="submit-method"><xsl:if test="@display-type eq 'Link'"><![CDATA[<html:link property="]]><xsl:value-of select="@name"/><![CDATA[" href="javascript:xradSubmit(']]><xsl:value-of select="@name"/><![CDATA[')">]]><xsl:value-of select="@title"/><![CDATA[</html:link>|]]></xsl:if></xsl:for-each>
<![CDATA[</div>]]>
<xsl:if test="property">
<![CDATA[<table>]]>
<xsl:for-each select="property">
<xsl:if test="@display-type eq 'TextField'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td><html:text styleClass="xradTextField" property="]]><xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'TextArea'">
<![CDATA[<tr><td width="150" class="xradLabelTopAlign">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td><html:textarea rows="5" style="width: 350;" styleClass="xradTextArea" property="]]><xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'PasswordField'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td><html:password styleClass="xradPasswordField" property="]]><xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'RadioButton'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td>
<html:radio styleClass="xradRadioButton" value="" property="]]><xsl:value-of select="@name"/><![CDATA[">
<span class="xradSimpleText">Choice A</span>
</html:radio>
<html:radio styleClass="xradRadioButton" value="" property="]]><xsl:value-of select="@name"/><![CDATA[">
<span class="xradSimpleText">Choice B</span>
</html:radio>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'CheckBox'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td><html:checkbox styleClass="xradCheckBox" property="]]><xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'ComboBox'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td>
<html:select styleClass="xradComboBox" value="" property="]]><xsl:value-of select="@name"/><![CDATA[">
<html:option styleClass="xradSimpleText" value="">Choice A</html:option>
<html:option styleClass="xradSimpleText" value="">Choice B</html:option>  
</html:select>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'List'">
<![CDATA[<tr><td width="150" class="xradLabelTopAlign">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td>
<html:select size="5" style="width: 350;" styleClass="xradComboBox" value="" property="]]><xsl:value-of select="@name"/><![CDATA[">
<html:option styleClass="xradSimpleText" value="">Choice A</html:option>
<html:option styleClass="xradSimpleText" value="">Choice B</html:option>  
</html:select>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'FileUpload'">
<![CDATA[<tr><td width="150" class="xradLabel">]]><xsl:value-of select="@title"/><![CDATA[</td>]]>
<![CDATA[<td><html:file styleClass="xradFileUpload" property="]]><xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'HiddenField'">
<![CDATA[<html:hidden property="]]><xsl:value-of select="@name"/><![CDATA["/>]]>
</xsl:if>
</xsl:for-each>
<![CDATA[</table>]]>
<xsl:if test="submit-method">
<![CDATA[<table><tr><td width="150" class="xradLabelGap">&nbsp;</td><td>]]>
<xsl:for-each select="submit-method">
<xsl:if test="@display-type eq 'Button'">
<![CDATA[<html:button styleClass="xradButton" property="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA[" onclick="javascript:xradSubmit(']]><xsl:value-of select="@name"/><![CDATA[')"/>]]>
</xsl:if>
</xsl:for-each>
<![CDATA[</td></tr></table>]]>
</xsl:if>
</xsl:if>
<![CDATA[
</html:form>
<script type="text/javascript">
function xradSubmit(methodName) {
  ]]><xsl:value-of select="@id"/><![CDATA[Form.xradSubmitMethod.value = methodName;
  ]]><xsl:value-of select="@id"/><![CDATA[Form.submit();
}
</script>
</body>
</html:html>
]]>
{EndFile}
</xsl:for-each>
</xsl:template>
</xsl:stylesheet><!-- Stylus Studio meta-information - (c) 2004-2005. Progress Software Corporation. All rights reserved.
<metaInformation>
<scenarios ><scenario default="yes" name="Scenario1" userelativepaths="yes" externalpreview="no" url="file:///e:/XRadApps/SampleApp/src/app&#x2D;config.xrd" htmlbaseurl="" outputurl="" processortype="internal" useresolver="yes" profilemode="0" profiledepth="" profilelength="" urlprofilexml="" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext="" validateoutput="no" validator="internal" customvalidator=""/></scenarios><MapperMetaTag><MapperInfo srcSchemaPathIsRelative="yes" srcSchemaInterpretAsXML="no" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" destSchemaInterpretAsXML="no"/><MapperBlockPosition></MapperBlockPosition><TemplateContext></TemplateContext><MapperFilter side="source"></MapperFilter></MapperMetaTag>
</metaInformation>
-->