<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <!--<xsl:apply-templates mode="head"/>-->
            </head>
            <body>
                <xsl:apply-templates mode="body"/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="content" mode="body">
        <h1>Parsed Excel</h1>
        <xsl:apply-templates select="table" />
    </xsl:template>

    <xsl:template match="table">
        <table width="100%" border="1" cellspacing="0">
            <xsl:apply-templates select="row" />
        </table>
    </xsl:template>

    <xsl:template match="row">
        <tr>
        <xsl:for-each select="cell">
            <td align="center"><xsl:value-of select="."/></td><br/>
        </xsl:for-each>
        </tr>
    </xsl:template>
</xsl:stylesheet>

