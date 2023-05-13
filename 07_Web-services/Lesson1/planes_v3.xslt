<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Самолёты</h2>
                <table border="1" cellpadding="8">
                    <tr>
                        <th>Проивзодитель</th>
                        <th>Семейство</th>
                        <th>Модель</th>
                        <th>Цена, долл.</th>
                        <th>Экипаж</th>
                        <th>Грузоподъёмность, кг</th>
                        <th>Пассажировместимость</th>
                        <th>Длина, м</th>
                        <th>Ширина, м</th>
                        <th>Высота, м</th>


                    </tr>
                    <xsl:for-each select="planes/model">
                        <xsl:sort select="price" data-type="number" order="ascending"/>
                        <tr>
                            <td><xsl:value-of select="manufacturer"/></td>
                            <td><xsl:value-of select="@family"/></td>
                            <td><xsl:value-of select="@variant"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="characteristics/crew"/></td>
                            <td><xsl:value-of select="characteristics/loadParams/maximumPayload"/></td>
                            <td><xsl:value-of select="characteristics/loadParams/seating"/></td>
                            <td><xsl:value-of select="characteristics/dimensions/length"/></td>
                            <td><xsl:value-of select="characteristics/dimensions/wingspan"/></td>
                            <td><xsl:value-of select="characteristics/dimensions/height"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
