    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<c:forEach var="persona" items="${formaListadoPersonasAJAX.personas}">
	<tr>
		<td><c:out value="${persona.id}"/></td>
		<td><c:out value="${persona.nombre}"/></td>
		<td><c:out value="${persona.ciudad.nombre}"/></td>
		<td>
			<a href='solicitarModificarPersona.do?id=<c:out value="${persona.id}"/>'
				class="HipervinculoAdmon">
					<fmt:message key="formaListadoPersonas.etiqueta.modificar" />
			</a>
			<a href='procesarEliminarPersona.do?id=<c:out value="${persona.id}"/>'
				onClick="javascript: return EliminarPersona('<c:out value="${persona.nombre}"/>')"
				class="HipervinculoAdmon">
					<fmt:message key="formaListadoPersonas.etiqueta.eliminar" />
			</a>    
		</td>
	</tr>
</c:forEach>
    
    