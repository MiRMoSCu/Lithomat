<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alta_combinacion_tintas" var="urlAlta" />
<c:url value="/modifica_combinacion_tintas" var="urlModifica" />
<c:url value="/elimina_combinacion_tintas" var="urlElimina" />


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Log in</title>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript">
            $(document).ready(function (){
              //alert("comienza la magia");
           		
            });
            
            function setCampos(id, num, desc) {
            	document.forms[0].id_ct_seleccionado.value = id;
            	document.forms[0].num_tintas.value = num;
            	document.forms[0].descripcion.value = desc;
            }
            
			function crear() {
				document.forms[0].action = '${urlAlta}';
				document.forms[0].submit();
			}
			
			function modifica(id) {
				document.forms[0].action = '${urlModifica}';
				document.forms[0].submit();
			}
			
			function elimina(id) {
            	document.forms[0].id_ct_seleccionado.value = id;				
				document.forms[0].action = '${urlElimina}';
				document.forms[0].submit();
			}
			
	</script>
</head>
<body>
	combinacion tintas.
	<br />
	<br />
	<form:form action="${urlAlta}" method="post" modelAttribute="combinacionTintas">
	<input type="hidden" value="" name="id_ct_seleccionado" id="id_ct_seleccionado" />	
	<table width="90%">
		<tr>
			<td>Numero de tintas<td>
			<td>descripcion</td>
			<td>$nbsp;</td>
		</tr>
		<c:forEach var="combinacion_tintas" items="${listaCombinacionTintas}">
			<tr onclick="setCampos('${combinacion_tintas.id_combinacion_tintas}','${combinacion_tintas.num_tintas}', '${combinacion_tintas.descripcion}','${combinacion_tintas.activo}');">
				<td>${combinacion_tintas.num_tintas}<td>
				<td>${combinacion_tintas.descripcion}</td>
				<td><input type="button" value="eliminar" onclick="elimina('${combinacion_tintas.id_combinacion_tintas}');" /></td>
			</tr>
		</c:forEach>
	</table>

		numero tintas: 
		<input type="text" name="num_tintas" id="num_tintas" />
        <br/>
        descripcion:
        <input type="text" name="descripcion" id="descripcion" />
      	<br/>
		<input type="submit" value="Modificar" onclick="modifica();" />        
		<input type="submit" value="Alta" onclick="crear();" />
	</form:form>
</body>
</html>