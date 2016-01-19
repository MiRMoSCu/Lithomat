<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/pliego/agrega" var="urlAgregaPliego"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Pliego</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/pliego.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/pliego.js"/>"></script>
		<script type="text/javascript">
            // inicializacion jquery
            $(document).ready(function (){});
        </script>        
        <script type="text/javascript">
            var urlAgregaPliego = '${urlAgregaPliego}';
        </script>
    </head>
    <body>
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                        <form name="pliego" action="" method="post" target="upload_target" accept-charset="ISO-8859-1">
                            <input type="hidden" name="id_tipo_trabajo_detalle" value="${id_tipo_trabajo_detalle}">
                            <input type="hidden" name="json"                    value="">
                            <div id="div_pliego">
                                <div class="titulo">
                                    <font size="5">REBASES, MEDIANILES, PINZAS</font>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div class="columna_pliego_izquierda">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="75%">Rebases (mm):</td>
                                                        <td>
                                                            <input  type="text"
                                                                    class="input"
                                                                    name="rebase_en_milimetros"
                                                                    value="5"
                                                                    maxlength="2"
                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="columna_pliego_centro">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="82%">Medianiles (mm):</td>
                                                        <td>
                                                            <input  type="text"
                                                                    class="input"
                                                                    name="medianiles_en_milimetros"
                                                                    value="5"
                                                                    maxlength="2"
                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="columna_pliego_derecha">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="62%">Pinzas (cm):</td>
                                                        <td>
                                                            <input  type="text"
                                                                    class="input"
                                                                    name="pinzas_en_centimetros"
                                                                    value="1"
                                                                    maxlength="2"
                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="linea">
                                    <div class="casilla" style="text-align: right;">
                                        <img alt="" style="cursor:pointer;" onclick="limpiaRebase()" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                    </div>
                                </div>
                                <div class="titulo">
                                    <font size="5">PLIEGOS</font>
                                </div>
                                <div class="columna_completa" style="margin: 0px 0px 5px 0px;">
                                    <div id="div_tabla_pliego">
                                        <table id="tabla_hojas_pliego">
                                            <tr>
                                                <th>Pgo.</th>
                                                <th>H. Req.</th>
                                                <th>H. Sobr.</th>
                                                <th>H. Tot.</th>
                                                <th>Observaciones.</th>
                                                <th>¿Vuelta mismas placas?</th>
                                                <th width="20%">Tipo vuelta</th>
                                                <th>Dec.</th>
                                            </tr>
                                        <c:forEach var="pliego" items="${listaPliego}" varStatus="i">
                                            <tr class='${i.count%2==0?"l1":"l2"}'
                                                onclick="setCampos('${i.count}', '${pliego.hojasRequeridas}', '${pliego.hojasSobrantes}', '${pliego.hojasTotales}', '${pliego.observaciones}', '${pliego.vueltaMismasPlacas}', '${pliego.tipoVuelta.nombre}');">
                                                <td>${i.count}</td>
                                                <td>${pliego.hojasRequeridas}</td>
                                                <td>${pliego.hojasSobrantes}</td>
                                                <td>${pliego.hojasTotales}</td>
                                                <td>${pliego.observaciones}</td>
                                                <c:choose>
                                                    <c:when test="${pliego.vueltaMismasPlacas}">
                                                        <td>Si</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>No</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td>${pliego.tipoVuelta.nombre}</td>
                                                <td>${pliego.numeroDecimal}</td>
                                            </tr>
                                        </c:forEach>
                                        </table>
                                    </div>
                                </div>
                                <div class="linea"></div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div class="columna_pliego_izquierda">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="1%">Pliego:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="numero_pliego"
                                                                    value="" 
                                                                    readonly/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div class="columna_pliego_izquierda">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="40%" title="Hojas Requeridas">H. Req.:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="hojas_requeridas"
                                                                    value="" 
                                                                    readonly/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="columna_pliego_centro">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="43%" title="Hojas Sobrantes">H. Sobr.:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="hojas_sobrantes"
                                                                    value="" 
                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                    onkeyup="sumatoria();"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="columna_pliego_derecha">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="37%" title="Hojas Totales">H. Tot.:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="hojas_totales"
                                                                    value="" 
                                                                    readonly/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="linea">
                                	<div class="casilla">
                                		<div class="" style="color: #898989;">
                                			<table>
                                				<tr>
                                					<td width="61%">¿Modificar todos los sobrantes similares?:</td>
                                					<td>
                                						<input 	type="checkbox"
                                								class="input"
                                								name="mismos_sobrantes"/>
                                					</td>
                                				</tr>
                                			</table>
                                		</div>
                                	</div>
                                </div>
                                <div class="linea">
                                    <div class="casilla">                            
                                        <div class="columna_completa">
                                            <table>
                                                <tr>
                                                    <td width="1%">Observaciones:</td>
                                                    <td>
                                                        <input  type="text"
                                                                class="input"
                                                                name="observaciones"
                                                                value=""/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div class="columna_completa">
                                            <table>
                                                <tr>
                                                    <td width="47%">¿Utiliza vuelta mismas placas?:</td>
                                                    <td align="left">
                                                        <input  type="checkbox" 
                                                                class="input"
                                                                name="mismas_placas"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div class="columna_completa">
                                            <table>
                                                <tr>
                                                    <td width="18%">Tipo vuelta:</td>
                                                    <td>
                                                        <select name="tipo_vuelta" 
                                                                onchange="">
                                                            <c:forEach var="v" items="${listaTipoVuelta}">
                                                                <option value="${v.value}">${v.text}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- <div class="linea"></div> -->
                                <br/>
                                <div class="linea">
                                    <div class="casilla" style="text-align: right;">
                                        <img alt="" style="cursor:pointer;" onclick="limpiaPliego();" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                        <img alt="" style="cursor:pointer;" onclick="modificaRegistro();" src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
                                        <img alt="" style="cursor:pointer;" onclick="agregaRegistro();" src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="div_derecha3d">
                    <div id="div_fondo_esq_sup"></div>
                    <div id="div_fondo_der"></div>
                </div>
            </div>
            <div id="div_abajo3d">
                <div id="div_fondo_esq_izq"></div>
                <div id="div_fondo_abajo"></div>
                <div id="div_fondo_esq_der"></div>
            </div>
        </div>
        <div>
            <iframe id="upload_target" name="upload_target" style="width:0px; height:0px; border:0px solid #fff;" onload="actualizaHtml()"></iframe>
        </div>
    </body>
</html>