<?xml version='1.0'?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text"/>
<xsl:template match="/app-model">
<xsl:if test="view">
<xsl:for-each select="view">{BeginFile}
//@Location <xsl:value-of select="replace(@package-name, '[.]', '/')"/>
//@File <xsl:value-of select="@name"/>.java
//AUTO-GENERATED FILE GENERATED BY X-RAD CODE GENERATOR 1.0
//CODE WRITTEN IN user-code BLOCK WILL BE PRESERVED IF THE CODE IS
//REGENERATED USING X-RAD CODE GENERATOR.
package <xsl:value-of select="@package-name"/>;

//@begin-imports

import java.lang.reflect.*;
import java.util.*;
import javax.servlet.*;
import com.xradsolutions.xrad.core.*;

//@end-imports

//@begin-class

public class <xsl:value-of select="@name"/>
	extends com.xradsolutions.xrad.core.View {
	<xsl:if test="submit-method">
	//@begin-submit-method-constants

	<xsl:for-each select="submit-method">public static final String <xsl:value-of select="upper-case(@name)"/> = "<xsl:value-of select="@name"/>";
	</xsl:for-each>
	//@end-submit-method-constants
	</xsl:if>
	<xsl:if test="property">
	//@begin-view-properties

	<xsl:for-each select="property">private <xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>;
	</xsl:for-each>	
	//@end-view-properties
	</xsl:if>	
	//@begin-initialize
	
	public String initialize(Component source,
		ServletRequest request,
		Map params) {
		
		//@begin-user-code		

		//@todo Add your code here

		//@end-user-code

		//DO NOT REMOVE FOLLOWING LINES!!!
		return super.initialize(source, request, params);
	}
	
	//@end-initialize
	<xsl:if test="submit-method">
	//@begin-submit-methods
	<xsl:for-each select="submit-method">
	public String <xsl:value-of select="@name"/>(ServletRequest request,
		ServletResponse response, Map params) {
		
		//@begin-user-code		

		//@todo Add your code here

		//@end-user-code
		
		//DO NOT REMOVE FOLLOWING LINES!!!
		String returnValue = null;
		try {
			returnValue = dispatch(this, this, request, response, params, <xsl:value-of select="upper-case(@name)"/>);
		}
		catch(XRadDispatchException ex) {
			ex.printStackTrace();
		}
		finally {
			return returnValue;
		}
	}
	</xsl:for-each>
	//@end-submit-methods
	</xsl:if>
	
	<xsl:if test="property">
	//@begin-getters-setters
	<xsl:for-each select="property">
	public <xsl:value-of select="@type"/> get<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>() {
		return <xsl:value-of select="@name"/>;
	}

	public void set<xsl:value-of select="substring(upper-case(@name), 1, 1)"/><xsl:value-of select="substring(@name, 2)"/>(<xsl:value-of select="@type"/><xsl:text> </xsl:text><xsl:value-of select="@name"/>) {
		this.<xsl:value-of select="@name"/> = <xsl:value-of select="@name"/>;
	}
	</xsl:for-each>
	//@end-getters-setters
	</xsl:if>
}

//@end-class
{EndFile}
</xsl:for-each>
</xsl:if>
<xsl:if test="process">
<xsl:for-each select="process">{BeginFile}
//@Location <xsl:value-of select="replace(@package-name, '[.]', '/')"/>
//@File <xsl:value-of select="@name"/>.java
//AUTO-GENERATED FILE GENERATED BY X-RAD CODE GENERATOR 1.0
//CODE WRITTEN IN user-code BLOCK WILL BE PRESERVED IF THE CODE IS
//REGENERATED USING X-RAD CODE GENERATOR.
package <xsl:value-of select="@package-name"/>;

//@begin-imports

import java.util.*;
import javax.servlet.*;
import com.xradsolutions.xrad.core.*;

//@end-imports

//@begin-class

public class <xsl:value-of select="@name"/>
	extends com.xradsolutions.xrad.core.Process {
	<xsl:if test="return-value">	
	//@begin-return-value-constants

	<xsl:for-each select="return-value">public static final String <xsl:value-of select="upper-case(@text)"/> = "<xsl:value-of select="@text"/>";
	</xsl:for-each>
	//@end-return-value-constants
	</xsl:if>
	//@begin-execute
	
	protected String execute(Component source,
		ServletRequest request,
		ServletResponse response,
		Map params) {

		String returnValue = null;
		<xsl:if test="return-value">
		//IMPORTANT!!! YOUR CODE MUST SET VALUE OF returnValue VARIABLE
		//TO ONE OF THE VALUES SPECIFIED IN THE return-value-constants
		//BLOCK. BY DEFAULT, X-RAD CODE GENERATOR SETS THE VALUE OF 
		//returnValue TO FIRST VALUE IN THE return-value-constants BLOCK.
		
		returnValue = <xsl:value-of select="upper-case(return-value[1]/@text)"/>;
		</xsl:if>
		//@begin-user-code		

		//@todo Add your code here

		//@end-user-code

		//DO NOT REMOVE FOLLOWING LINE!!!
		return returnValue;
	}
	
	//@end-execute

}

//@end-class
{EndFile}
</xsl:for-each>
</xsl:if>
</xsl:template>
</xsl:stylesheet>