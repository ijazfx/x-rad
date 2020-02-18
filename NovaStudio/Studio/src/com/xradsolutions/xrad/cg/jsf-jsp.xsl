<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/02/xpath-functions" xmlns:xdt="http://www.w3.org/2005/02/xpath-datatypes">
<xsl:output method="text"/>
<xsl:template match="/app-model">
<xsl:for-each select="view">
{BeginFile}
//@Location pages
//@File <xsl:value-of select="@id"/>.jsp
<![CDATA[
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page contentType="text/html; charset=windows-1252" %>
<html>
<head>
<title>
]]><xsl:value-of select="@title"/><![CDATA[
</title>
<link href="xrad-style.css" rel="stylesheet" type="text/css">
</head>
<body class="xradBody">
<f:view>
<h:form styleClass="xradForm" id="]]><xsl:value-of select="@id"/>Face<![CDATA[">
<div class="xradTitleBar">]]><xsl:value-of select="@title"/><![CDATA[</div>
<div id="xradLinkBar">|]]><xsl:for-each select="submit-method"><xsl:if test="@display-type eq 'Link'"><![CDATA[<h:commandLink id="]]><xsl:value-of select="@name"/><![CDATA[" action="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}" value="]]><xsl:value-of select="@title"/><![CDATA["/>|]]></xsl:if></xsl:for-each>
<![CDATA[</div>]]>
<xsl:if test="property">
<![CDATA[<table>]]>
<xsl:for-each select="property">
<xsl:if test="@display-type eq 'TextField'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:inputText styleClass="xradTextField" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}"/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'TextArea'">
<![CDATA[<tr><td width="150" class="xradLabelTopAlign"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:inputTextarea rows="5" style="width: 350;" styleClass="xradTextArea" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}"/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'PasswordField'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:inputSecret styleClass="xradPasswordField" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}"/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'RadioButton'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:selectOneRadio styleClass="xradRadioButton" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}">
<f:selectItem itemLabel="Choice A" itemValue=""/>
<f:selectItem itemLabel="Choice B" itemValue=""/>
</h:selectOneRadio>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'CheckBox'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:selectBooleanCheckbox styleClass="xradCheckBox" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}"/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'ComboBox'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:selectOneMenu styleClass="xradComboBox" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}">
<f:selectItem itemLabel="Choice A" itemValue=""/>
<f:selectItem itemLabel="Choice B" itemValue=""/>
</h:selectOneMenu>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'List'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><h:selectOneListbox styleClass="xradListBox" id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}">
<f:selectItem itemLabel="Choice A" itemValue=""/>
<f:selectItem itemLabel="Choice B" itemValue=""/>
</h:selectOneListbox>
</td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'FileUpload'">
<![CDATA[<tr><td width="150" class="xradLabel"><h:outputLabel for="]]><xsl:value-of select="@name"/><![CDATA[" value="]]><xsl:value-of select="@title"/><![CDATA["/></td>]]>
<![CDATA[<td><input type="file" class="xradFileUpload" name="]]><xsl:value-of select="../@id"/>Face:<xsl:value-of select="@name"/><![CDATA[" id="]]><xsl:value-of select="../@id"/>Face:<xsl:value-of select="@name"/><![CDATA["/></td></tr>]]>
</xsl:if>
<xsl:if test="@display-type eq 'HiddenField'">
<![CDATA[<td><h:inputHidden id="]]><xsl:value-of select="@name"/><![CDATA[" value="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}"/>]]>
</xsl:if>
</xsl:for-each>
<![CDATA[</table>]]>
<xsl:if test="submit-method">
<![CDATA[<table><tr><td width="150" class="xradLabelGap">&nbsp;</td><td>]]>
<xsl:for-each select="submit-method">
<xsl:if test="@display-type eq 'Button'">
<![CDATA[<h:commandButton styleClass="xradButton" id="]]><xsl:value-of select="@name"/><![CDATA[" action="#{]]><xsl:value-of select="../@id"/>Face.<xsl:value-of select="@name"/><![CDATA[}" value="]]><xsl:value-of select="@title"/><![CDATA["/>]]>
</xsl:if>
</xsl:for-each>
<![CDATA[<h:commandButton styleClass="xradButton" id="reset" action="#{]]><xsl:value-of select="@id"/>Face.reset<![CDATA[}" value="Reset"/>]]>
</xsl:if>
</xsl:if>
<![CDATA[
</h:form>
</f:view>
</body>
</html>
]]>
{EndFile}
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>