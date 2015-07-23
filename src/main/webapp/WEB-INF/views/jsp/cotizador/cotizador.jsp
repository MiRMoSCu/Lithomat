<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/cliente/busca"           var="urlBuscaCliente"/>
<c:url value="/agrega_orden_produccion" var="urlAgregaOrdenProduccion"/>
<c:url value="/agrega_partida"          var="urlAgregaPartida"/>
<c:url value="/agrega_detalle_partida"  var="urlAgregaDetallePartida"/>
<c:url value="/elimina_detalle_partida" var="urlEliminaDetallePartida"/>
<c:url value="/calcula_pliego"          var="urlCalculaPliego"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Cotizador</title>
        <style type="text/css" media="screen"></style>
        <link rel="stylesheet" href="resources/shadowbox/shadowbox.css" type="text/css"></link>
        <link rel="stylesheet" href="resources/css/master.css"          type="text/css"></link>
        <link rel="stylesheet" href="resources/css/font.css"            type="text/css"></link>
        <link rel="stylesheet" href="resources/css/menu.css"            type="text/css"></link>
        <link rel="stylesheet" href="resources/css/cotizador.css"       type="text/css"></link>
        <script type="text/javascript" src="resources/shadowbox/shadowbox.js"></script>
        <script type="text/javascript" src="resources/js/jquery-1_9_1.js"></script>
        <script type="text/javascript" src="resources/js/cotizador_limpia_form.js"></script>
        <script type="text/javascript" src="resources/js/cotizador_ajax.js"></script>
        <script type="text/javascript" src="resources/js/cotizador.js"></script>
        <script type="text/javascript" src="resources/js/prueba.js"></script>
        <script type="text/javascript">
            //inicializacion jquery
            $(document).ready(function (){  });
            //inicializacion shadowbox
            Shadowbox.init({
                //modal: true,
                //overlayOpacity: 0.75
            });
        </script>
        <script type="text/javascript">
            var urlReenvioPaginaPrueba      = '${urlReenvioPaginaPrueba}';
            var urlBuscaCliente             = '${urlBuscaCliente}';
            var urlAgregaOrdenProduccion    = '${urlAgregaOrdenProduccion}';
            var urlAgregaPartida            = '${urlAgregaPartida}';
            var urlAgregaDetallePartida     = '${urlAgregaDetallePartida}';
            var urlEliminaDetallePartida    = '${urlEliminaDetallePartida}';
            var urlCalculaPliego            = '${urlCalculaPliego}';
        </script>
    </head>
    <body>
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="." src="resources/image/logo.png">
                        </div>
                        <div id="div_encabezado">
                            <img alt="." src="resources/image/encabezado_cotizador.png">
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div id="div_cerrar_sesion">
                                    <a href="#"><img alt="" src="resources/image/boton_regresar_menu.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                        
<!-- div de ayuda, display: none; -->
                            <div id="div_prueba" style="display:none;">
                                <input type="button" value="presioname" onclick="sb();">                            
                                <br/>
                                <br/>
                                <br/>
                                <div id="div_resultado_prueba"></div>
                                <!--
                                <select name="select_combinacion_tintas" 
                                        tabindex=""
                                        onchange="">
                                    <c:forEach var="ct" items="${listaCombinacionTintas}">
                                        <option value="${ct.id_combinacion_tintas}">${ct.descripcion}</option>
                                    </c:forEach>
                                </select>
                                -->
                            </div>
                            

                            
<!-- div_orden_produccion -->
                            <div id="div_orden_produccion">
                                <form name="orden_produccion" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_usuario"                  value="">
                                    <input type="hidden" name="id_cliente"                  value="">
                                    <input type="hidden" name="id_tipo_comprobante_fiscal"  value="">
                                    <div class="div_separador_grande">
                                        <img alt="" src="resources/image/separador_grande.png">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_orden.png">
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="1%">Nombre:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="nombre"
                                                                    value=""
                                                                    tabindex="3">
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
                                                        <td width="1%">Descripci&oacute;n:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="descripcion"
                                                                    value=""
                                                                    tabindex="4">
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Comprobante:</td>
                                                            <td>
                                                                <select name="comprobante_fiscal" 
                                                                        tabindex="5" 
                                                                        onchange="">
                                                                    <c:forEach var="c" items="${listaTipoComprobanteFiscal}">
                                                                        <option value="${c.id_tipo_comprobante_fiscal}">${c.nombre}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="43%">Fecha aproximada entrega:</td>
                                                            <td>
                                                                <input  type="date" 
                                                                        class="input" 
                                                                        name="fecha_prometida_entrega" 
                                                                        tabindex="6">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarOrdnProdActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaFormOrdenProduccion();"
                                                 src="resources/image/boton_limpiar.jpg">
                                            <img id="imgBtnLimpiarOrdnProdInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_limpiar_des.jpg">
                                            <img id="imgBtnAgregarOrdnProdActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaOrdenProduccion();"
                                                 src="resources/image/boton_agregar.jpg">
                                            <img id="imgBtnAgregarOrdnProdInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_agregar_des.jpg">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            
                            
                            
                            
                            
<!-- div_partida, display: none; -->
                            <div id="div_partida" style="display:block;">
                                <form name="partida" action="" accept-charset="ISO-8859-1" enctype="multipart/form-data">
                                    <input type="hidden" name="id_orden_produccion" value="">
                                    <input type="hidden" name="id_tipo_trabajo"     value="">
                                    <input type="hidden" name="id_maquina"          value="">
                                    <div class="div_separador_mediano">
                                        <img alt="" src="resources/image/separador_mediano.jpg">
                                    </div>    
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_descripcion_partida.png">
                                    </div>
                                    <div class="linea">
                                        <table border="0">
                                            <tr>
                                                <td width="33%" align="center">
                                                    <div style="width:39%; margin-left:auto; margin-right:auto;">
                                                        <table border="0">
                                                            <tr>
                                                                <td>
                                                                    <input  type="radio" 
                                                                            name="tipo_trabajo"
                                                                            value="1" 
                                                                            checked="checked"
                                                                            tabindex="7">
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="resources/image/titulo_flyer.png"
                                                                         style="cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[0].click();">
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </td>
                                                <td width="33%" align="center">
                                                    <div style="width:67%; margin-left:auto; margin-right:auto;">
                                                        <table border="0">
                                                            <tr>
                                                                <td width="1%">
                                                                    <input  type="radio" 
                                                                            name="tipo_trabajo"
                                                                            value="2">
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="resources/image/titulo_revista.png"
                                                                         style="cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[1].click();">
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </td>
                                                <td width="33%" align="center">
                                                    <div style="width:23%; margin-left:auto; margin-right:auto;">
                                                        <table border="0">
                                                            <tr>
                                                                <td width="1%">
                                                                    <input  type="radio" 
                                                                            name="tipo_trabajo"
                                                                            value="3">
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="resources/image/titulo_otros.png"
                                                                         style="padding-top:5px;cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[2].click();">
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="nombre_partida"
                                                                        value=""
                                                                        tabindex="8">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Cantidad:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="cantidad"
                                                                        value="" 
                                                                        tabindex="9"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">M&aacute;quina:</td>
                                                            <td>
                                                                <select name="maquina" 
                                                                        tabindex="10"
                                                                        onchange="">
                                                                    <c:forEach var="m" items="${listaMaquina}">
                                                                        <option value="${m.id_maquina}">${m.nombre}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="1%">Descripci&oacute;n:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input" 
                                                                    name="descripcion_partida"
                                                                    value=""
                                                                    tabindex="11">
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
                                                        <td width="1%">Diagrama:</td>
                                                        <td>
                                                            <input  type="file" 
                                                                    class="input" 
                                                                    name="diagrama_formacion"
                                                                    value=""
                                                                    tabindex="12">
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="doble_linea">
                                        <div class="casilla_doble_alto">
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="10%" valign="top" style="padding-top:4px;">Obs.
                                                                                                                  Generales:</td>
                                                            <td>
                                                                <textarea class="textarea_doble"
                                                                          name="observaciones_generales" 
                                                                          tabindex="13"></textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="10%" valign="top" style="padding-top:4px;">Obs.
                                                                                                                  Aprobaci&oacute;n:</td>
                                                            <td>
                                                                <textarea class="textarea_doble"
                                                                          name="observaciones_aprobacion" 
                                                                          tabindex="14"></textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarPartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaFormPartida();"
                                                 src="resources/image/boton_limpiar.jpg">
                                            <img id="imgBtnLimpiarPartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_limpiar_des.jpg">
                                            <img id="imgBtnAgregarPartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaPartida();"
                                                 src="resources/image/boton_agregar.jpg">
                                            <img id="imgBtnAgregarPartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_agregar_des.jpg">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            
<!-- div_detalle_partida,  display: none; -->
                            <div id="div_detalle_partida" style="display:block;">
                                <form name="detalle_partida" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_partida"                          value="">
                                    <input type="hidden" name="cliente_proporciona_papel"           value="">
                                    <input type="hidden" name="cliente_proporciona_tinta"           value="">
                                    <input type="hidden" name="cliente_proporciona_tinta_especial"  value="">
                                    <input type="hidden" name="cliente_proporciona_barniz"          value="">
                                    <input type="hidden" name="cliente_proporciona_placas"          value="">
                                    <input type="hidden" name="id_tipo_papel_extendido"             value="">
                                    <input type="hidden" name="id_tamanio_publicacion"              value="">
                                    <input type="hidden" name="frente_id_combinacion_tintas"        value="">
                                    <input type="hidden" name="frente_id_tipo_barniz"               value="">
                                    <input type="hidden" name="vuelta_mismas_placas"                value="">
                                    <input type="hidden" name="vuelta_id_combinacion_tintas"        value="">
                                    <input type="hidden" name="vuelta_id_tipo_barniz"               value="">
                                    <input type="hidden" name="id_tipo_placa"                       value="">
                                    <input type="hidden" name="id_tipo_vuelta"                      value="">
                                    <div class="div_separador_mediano">
                                        <img alt="" src="resources/image/separador_mediano.jpg">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_detalle_partida.png">
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="1%">Descripci&oacute;n:</td>
                                                        <td>
                                                            <input  type="text" 
                                                                    class="input"
                                                                    name="descripcion_partida_detalle"
                                                                    value=""
                                                                    tabindex="17">
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="40%">Ancho (cm):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="ancho" 
                                                                        value=""
                                                                        tabindex="20"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                        onblur="document.getElementsByName('ancho_extendido')[0].value=value;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="32%">Alto (cm):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="alto" 
                                                                        value=""
                                                                        tabindex="21"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                        onblur="document.getElementsByName('alto_extendido')[0].value=value;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="74%">Ancho extendido (cm):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="ancho_extendido" 
                                                                        value=""
                                                                        tabindex="20"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                        onblur="document.getElementsByName('ancho_extendido')[0].value=value;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="65%">Alto extendido (cm):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="alto_extendido" 
                                                                        value=""
                                                                        tabindex="21"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                        onblur="document.getElementsByName('alto_extendido')[0].value=value;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="58%">Cte provee papel:</td>
                                                            <td>
                                                                
                                                                <input  type="checkbox" 
                                                                        class="input"
                                                                        name="proporciona_papel">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="62%">Cte provee placas:</td>
                                                            <td>
                                                                <input  type="checkbox" 
                                                                        class="input"
                                                                        name="proporciona_placas">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="82%">Cte provee tinta especial:</td>
                                                            <td>
                                                                <input  type="checkbox" 
                                                                        class="input"
                                                                        name="proporciona_tinta_especial">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="60%">Cte provee barniz:</td>
                                                            <td>
                                                                <input  type="checkbox" 
                                                                        class="input"
                                                                        name="proporciona_barniz">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="div_separador_chico">
                                        <img alt="" src="resources/image/separador_chico.jpg">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_papel.png">
                                    </div>
                                    REVISTA: Medianiles + Tamaño publicacion = Tamaño de papel
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="18%">Tipo Papel:</td>
                                                            <td>
                                                                <select name="tipo_papel_extendido" 
                                                                        tabindex=""
                                                                        onchange="javascrip:obtieneDatosPapel(this.value)">
                                                                    <c:forEach var="tpe" items="${listaTipoPapelExtendido}">
                                                                        <option value="${tpe.id_tipo_papel_extendido}">${tpe.textoComboSelect}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div id="repeticiones_flyer" class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="66%">N&uacute;mero de flyer por pliego
                                                                            (Repeticiones):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="repeticiones_x_pliego" 
                                                                        value=""
                                                                        tabindex=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div id="numero_paginas_publicacion" class="mitad_columna_izquierda" style="display:none;" >
                                                    <table>
                                                        <tr>
                                                            <td width="56%">N&uacute;mero p&aacute;ginas:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="numero_paginas_publicacion"
                                                                        value="0"
                                                                        tabindex=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div id="tamanio_publicacion" class="mitad_columna_derecha" style="display:none;">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Tama&ntilde;o:</td>
                                                            <td>
                                                                <select name="tamanio_publicacion" tabindex="">
                                                                    <c:forEach var="tp" items="${listaTamanioPublicacion}">
                                                                        <option value="${tp.id_tamanio_publicacion}">${tp.nombre}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div id="div_especificaciones_papel">
                                        <div id="div_especificaciones_papel_tipo_flyer">
                                            
                                            
                                        </div>
                                        <div id="div_especificaciones_papel_tipo_revista">
                                            <div>
                                                Partida de papel interior 
                                                <br>
                                                 Partida de papel portadillas 
                                                <br>
                                                 Numero de hojas 
                                                <br>
                                                 Reglas de negocio: 
                                                <br>
                                                 1) que sea multiplo de 4. 
                                                <br>
                                                 2) el n&uacute;mero de hojas que caben en cada pliego 
                                                <br>
                                                 3) hacer el c&aacute;lculo de pliegos. 
                                                <br>
                                            </div>
                                        </div>
                                        <div id="div_especificaciones_papel_tipo_otro">
                                        
                                        
                                        </div>
                                    </div>
                                    <div class="div_separador_chico">
                                        <img alt="" src="resources/image/separador_chico.jpg">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_tinta.png">
                                    </div>
                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <img alt="" src="resources/image/titulo_frente.png">
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="40%">Num. Tinta:</td>
                                                            <td>
                                                                <select name="frente_combinacion_tintas" tabindex="">
                                                                    <c:forEach var="ct" items="${listaCombinacionTintas}">
                                                                        <option value="${ct.id_combinacion_tintas}">${ct.descripcion}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="68%">Num. Tinta Especial:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="frente_num_tinta_especial" 
                                                                        value="0"
                                                                        tabindex=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="41%">Descripci&oacute;n tinta especial:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="frente_descripcion_tinta_especial"
                                                                        value="" 
                                                                        tabindex="">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                        <!--<div class="columna_izquierda_tres_cuartos">-->
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="39%">Tipo barniz:</td>
                                                            <td>
                                                                <select name="frente_tipo_barniz" tabindex="">
                                                                    <c:forEach var="tb" items="${listaTipoBarniz}">
                                                                        <option value="${tb.id_tipo_barniz}">${tb.descripcion}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                        <img alt="" src="resources/image/titulo_vuelta.png">
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="87%">Vuelta con mismas placas:</td>
                                                            <td>
                                                                <input  type="checkbox" 
                                                                        class="input"
                                                                        name="mismas_placas">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="40%">Num. Tinta:</td>
                                                            <td>
                                                                <select name="vuelta_combinacion_tintas" tabindex="">
                                                                    <c:forEach var="ct" items="${listaCombinacionTintas}">
                                                                        <option value="${ct.id_combinacion_tintas}">${ct.descripcion}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="68%">Num. Tinta Especial:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="vuelta_num_tinta_especial" 
                                                                        value="0"
                                                                        tabindex=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="41%">Descripci&oacute;n tinta especial:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="vuelta_descripcion_tinta_especial"
                                                                        value="" 
                                                                        tabindex="">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                        <!--<div class="columna_izquierda_tres_cuartos">-->
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="39%">Tipo barniz:</td>
                                                            <td>
                                                                <select name="vuelta_tipo_barniz" tabindex="">
                                                                    <c:forEach var="tb" items="${listaTipoBarniz}">
                                                                        <option value="${tb.id_tipo_barniz}">${tb.descripcion}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="div_separador_chico">
                                        <img alt="" src="resources/image/separador_chico.jpg">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_placa.png"> <font size="5"> - VUELTA</font>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="18%">Tipo placa:</td>
                                                            <td>
                                                                <select name="tipo_placa" tabindex="">
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="19%">Tipo vuelta:</td>
                                                            <td>
                                                                <select name="tipo_vuelta" 
                                                                        tabindex="5" 
                                                                        onchange="">
                                                                    <c:forEach var="v" items="${listaTipoVuelta}">
                                                                        <option value="${v.id_tipo_vuelta}">${v.nombre}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarDetallePartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaFormDetallePartida();"
                                                 src="resources/image/boton_limpiar.jpg">
                                            <img id="imgBtnLimpiarDetallePartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_limpiar_des.jpg">
                                            <img id="imgBtnAgregarDetallePartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaDetallePartida();"
                                                 src="resources/image/boton_agregar.jpg">
                                            <img id="imgBtnAgregarDetallePartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="resources/image/boton_agregar_des.jpg">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            
<!-- div_visualizador_pliegos, display: none; -->
                            <div id="div_visualizador_pliegos" style="display:block;">
                                <form name="visualizador_pliegos" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_tipo_trabajo_detalle" value="">
                                    <div class="div_separador_chico">
                                        <img alt="" src="resources/image/separador_chico.jpg">
                                    </div>                                
                                    <div class="titulo">
                                        <font size="5">LISTA DE PLIEGOS</font>
                                    </div>
                                    <div id="div_tabla_lista_pliegos"></div>
                                </form>
                            </div>
                            
                            
                            <div id="div_proceso_disenio" style="display:none;">
                            
                            </div>
                            
                            <div id="div_proceso_transporte" style="display:none;">
                            
                            </div>
                            
                            <div id="div_proceso_externo" style="display:none;">
                            
                            </div>
                            
                            
                            
                            
<!--  div_acabado, display: none; (proceso externo) -->
                            <div id="div_acabado" style="display:block;">
                                <form name="">
                                
                                
                                </form>
                                    
                                <div class="div_separador_mediano">
                                    <img alt="" src="resources/image/separador_mediano.jpg">
                                </div>
                                <div class="titulo">
                                    <img alt="" src="resources/image/titulo_acabado.png">
                                </div>
                                <!--
                                <div>
                                    <div class="columna_izquierda">
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Proceso:</td>
                                                            <td>
                                                                <select name="material_ayuda" tabindex="">
                                                                    <option value="1">Corte</option>
                                                                    <option value="2">Doblez</option>
                                                                    <option value="3">UV</option>
                                                                    <option value="4">Alce</option>
                                                                    <option value="5">Plastificado</option>
                                                                    <option value="6">Engrapado</option>
                                                                    <option value="7">Pegado</option>
                                                                    <option value="8">Suaje</option>
                                                                    <option value="9">Suajado</option>
                                                                    <option value="10">Hot-melt</option>
                                                                    <option value="11">Caballo a grapa</option>
                                                                    <option value="12">Empacado en papel</option>
                                                                    <option value="13">Empacado en cajas</option>
                                                                    <option value="14">Env&iacute;o for&aacute;neo
                                                                                       a&eacute;reo</option>
                                                                    <option value="15">Env&iacute;o for&aacute;neo
                                                                                       terrestre</option>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Cantidad:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="cantidad_proceso_externo" value="100"
                                                                       tabindex=""
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Ancho:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="ancho_proceso_externo" value="0"
                                                                       tabindex="20"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Alto:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="alto_proceso_externo" value="0"
                                                                       tabindex="20"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
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
                                                            <td width="1%">Especificaciones:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="especificaciones_proceso_externo"
                                                                       value="Regresar al finalizar proceso."
                                                                       tabindex=""></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla" style="text-align:right;">
                                                <img alt="" style="cursor:pointer;"
                                                     src="resources/image/boton_agregar.jpg"></img>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="columna_derecha">
                                        <div id="div_tabla_acabado">
                                            <table id="tabla_acabado">
                                                <tr>
                                                    <th>Proceso</th>
                                                    <th>Cantidad</th>
                                                    <th>Ancho</th>
                                                    <th>Alto</th>
                                                    <th>Especificaciones</th>
                                                    <th></th>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Corte</td>
                                                    <td>100</td>
                                                    <td>10</td>
                                                    <td>5</td>
                                                    <td></td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Doblez</td>
                                                    <td>2</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>Mitad</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Corte</td>
                                                    <td>100</td>
                                                    <td>10</td>
                                                    <td>5</td>
                                                    <td></td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Doblez</td>
                                                    <td>2</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>Mitad</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Corte</td>
                                                    <td>100</td>
                                                    <td>10</td>
                                                    <td>5</td>
                                                    <td></td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Doblez</td>
                                                    <td>2</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td>Mitad</td>
                                                    <td>X</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                -->
                                
                                
                                
                                
                            </div>
                            
                                    
                                    
<!--                                    
                                    
<div class="columna_completa">
    <div style="height: 150px; overflow-x: scroll;">
        <table id="tabla_lista_pliegos">
        
            <tr>
                <th>No. Partida</th>
                <th>Tipo Trabajo</th>
                <th>Partida</th>
                <th>Cantidad</th>
                <th>M&aacute;quina</th>
            </tr>
            
            <tr class="l2">
                <td>1</td>
                <td>Flyer/Poster</td>
                <td>Flyer</td>
                <td>10000</td>
                <td>Heidelberg Speed Master 6</td>
            </tr>
            
            <tr class="l1">
                <td>1</td>
                <td>Publicacion/Revista/Libro</td>
                <td>Publicacion</td>
                <td>5000</td>
                <td>Heidelberg Speed Master 6</td>
            </tr>
        
        </table>
    </div>
</div>


-->
                                    
                                  
                            
                            
                            
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                <div id="div_material_ayuda" style="display:block;">
                                    <div class="div_separador_mediano">
                                        <img alt="" src="resources/image/separador_mediano.jpg">
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="resources/image/titulo_material_ayuda.png">
                                    </div>
                                    
                                    <!--
                                    <div class="columna_izquierda">
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Material:</td>
                                                            <td>
                                                                <select name="material_ayuda" tabindex="">
                                                                    <option value="1">Dummy</option>
                                                                    <option value="2">Match print</option>
                                                                    <option value="3">Prueba de color</option>
                                                                    <option value="4">Archivo electr&oacute;nico</option>
                                                                    <option value="5">Negativos</option>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Responsable:</td>
                                                            <td>
                                                                <select name="responsable_insumo" tabindex="">
                                                                    <option value="1">Cliente</option>
                                                                    <option value="2">Lithomat</option>
                                                                    <option value="3">Otro</option>
                                                                </select>
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
                                                            <td width="1%">Obs:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="observaciones_muestra_ayuda"
                                                                       value="Regresar al finalizar proceso."
                                                                       tabindex=""></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla" style="text-align:right;">
                                                <img alt="" style="cursor:pointer;"
                                                     src="resources/image/boton_agregar.jpg"></img>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="columna_derecha">
                                        <div id="div_tabla_material_ayuda">
                                            <table id="tabla_material_ayuda">
                                                <tr>
                                                    <th>Material</th>
                                                    <th>Responsable</th>
                                                    <th>Observaciones</th>
                                                    <th></th>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l1">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                                 
                                                <tr class="l2">
                                                    <td>Dummy</td>
                                                    <td>Cliente</td>
                                                    <td>Regresar al finalizar el proceso.</td>
                                                    <td>X</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    -->
                                    <div class="div_separador_mediano">
                                        <img alt="" src="resources/image/separador_mediano.jpg">
                                    </div>
                                </div>
                                
                                
                                
                                
                                <!-- 
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img alt="" src="resources/image/boton_prueba_2.jpg">
                                        </div>
                                    </div>
                                -->
                                
                                
                                
                                <div class="div_cotizar" style="display:none;">
                                    <div class="linea" style="text-align:right;">
                                        <img alt="" src="resources/image/boton_enviar.jpg">
                                    </div>
                                </div>
                                <!--
								<div id="div_empaque">
									<div class="titulo">
										<span style="font-size:28px;">EMPAQUE</span>
									</div>
									
									<div class="div_separador_mediano">
										<img alt="" src="../../../../resources/image/linea_division.jpg">										
									</div>
								</div>
								
								<div id="div_envio">
									<div class="titulo">
										<span style="font-size:28px;">ENVIO</span>
									</div>
									
									<div class="div_separador_mediano">
										<img alt="" src="../../../../resources/image/linea_division.jpg">										
									</div>
								</div>
								-->
                                <!--
								<div id="div_boton_agregar_pliego">
									<img id="img_boton" alt="" src="../../../../resources/image/boton_limpiar.jpg">
									<img id="img_boton" alt="" src="../../../../resources/image/boton_agregar.jpg">
								</div>
								-->
                                <!--
								<div id="div_contenido_area_envio">
									<div id="div_area_boton_enviar">
										<select name="area_envio" tabindex="" style="margin-:top =>9px;">
											<option value="Diseño">Area</option>
										</select>
										
									</div>
								</div>
								-->
                                                                
                            
                        </div>
                    </div>
                    <div id="div_pie"></div>
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
        <div id="div_espacio_inf"></div>
        <div id="notificacion_tipo_growl">
            <span id="cerrar_notificacion_growl" style="cursor:pointer;">CLOSE
                <br></br>Se recomienda que el ancho sea mayor que el alto.</span>
        </div>
        <!-- NO BORRAR: FORM DE MUESTRA PARA SUBIR UN ARCHIVO AL SERVIDOR
        <div>
            <form name="upload_file" action="upload_file_example" method="POST" enctype="multipart/form-data">
                File to upload: <input type="file" name="file"><br/>
                Notes about the file: <input type="text" name="note"><br/>
                <br/>
                <input  type="submit" value="Press"> to upload file!
            </form>
        </div>
        -->
    </body>
</html>