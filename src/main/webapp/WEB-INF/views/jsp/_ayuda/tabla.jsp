<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <link rel="stylesheet" href="resources/css/master.css" type="text/css"></link>
        <style type="text/css">
            
            #contenedor {
                width: 900px;
                height: 900px;
                margin-left: auto;
                margin-right: auto;
                background: white;
            }
            
            #contenedor_secundario {
                width: 500px;
                height: 500px;
                margin-left: auto;
                margin-right: auto;
                background: Fuchsia;
            }
        
        </style>
    </head>
    <body>
        <div id="contenedor">
            <div id="contenedor_secundario">
                
                <div id="div_x" style="clear:both;">
                    aqui hay algo...
                </div>
                
                
                <div id="contenedor_terciario" style="width:300px; height:100px; background:green; float:right;">
                    <div class="columna_completa">
                        <div id="div_tabla" style="width:100%; height:100%;">
                            <table>
                                <tr>
                                    <th>a</th>
                                    <th>b</th>
                                    <th>c</th>
                                </tr>
                                <tr class="l2">
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                </tr>
                                <tr class="l1">
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                </tr>
                                <tr>
                                    <td>Total</td>
                                    <td>2</td>
                                    <td>3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div style="clear:both;">
                    aquí
                </div>
            </div>
        </div>
    
    </body>
</html>