    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<style>
  .HipervinculoAdmon{
    color:#000000;
	text-decoration:none;
  }
  
  .HipervinculoAdmon:hover{
    color:#006666;
	text-decoration:underline;
  }
</style>
<script language="javascript" type="text/javascript">
<!--
  function EliminarCiudad(strEstadoName){
    return confirm("¿Desea eliminar la ciudad '" + strEstadoName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoCiudades.titulo" /></font>
    <table cellpadding="0" cellspacing="0" width="60%" border="0">
        <tr>
            <td colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroCiudad.do" class="HipervinculoAdmon">Agregar nueva ciudad...</a>
            </td>
        </tr>
        <tr>
            <td colspan="4">
               <html:errors />
            </td>
        </tr>
        <tr bgcolor="#CCCCCC">
         <td><b><fmt:message key="formaListadoCiudades.etiqueta.nombre" /></b></td>
         
         <td colspan="2"><b><fmt:message key="formaListadoCiudades.etiqueta.administracion" /></b></td>
        </tr>
        <c:forEach var="ciudad" items="${formaListadoCiudades.ciudades}">
            <tr>
                <td align="left" width="20%"><c:out value="${ciudad.nombre}"/></td>
                
                <td align="left" width="20%">
                    <a href='solicitarModificarCiudad.do?id=<c:out value="${ciudad.id}"/>'
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoCiudades.etiqueta.modificar" />
                    </a>
                </td>
                <td>
                    <a href='procesarEliminarCiudad.do?id=<c:out value="${ciudad.id}"/>'
					   onClick="javascript: return EliminarCiudad('<c:out value="${ciudad.nombre}"/>')"
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoCiudades.etiqueta.eliminar" />
                    </a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoCiudades.contador}</td>
        </tr>
    </table>