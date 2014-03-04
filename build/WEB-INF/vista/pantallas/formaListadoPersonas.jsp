    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <section>
    	<h1><fmt:message key="formaListadoPersonas.etiqueta.nombre" /></b></h1>
    	<div class="row">
    		<div class="col-md-7">
    			<c:forEach var="persona" items="${formaListadoPersonas.personas}">
    				<div class="card_style">
    					<h3><c:out value="${persona.nombre}"/></h3>
    					<p>Total: ${formaListadoPersonas.contador}</p>
    					<a href='solicitarModificarPersona.do?id=<c:out value="${persona.id}"/>'
					   class="HipervinculoAdmon">
	                        <fmt:message key="formaListadoPersonas.etiqueta.modificar" />
	                    </a>
	                    <a href='procesarEliminarPersona.do?id=<c:out value="${persona.id}"/>'
					   onClick="javascript: return EliminarPersona('<c:out value="${persona.nombre}"/>')"
					   class="HipervinculoAdmon">
	                        <fmt:message key="formaListadoPersonas.etiqueta.eliminar" />
	                    </a>
    				</div>
    			</c:forEach>
    		</div>
    		<div class="col-md-1">
    			
    		</div>
    		<div class="col-md-4">
    			<a href="solicitarRegistroPersona.do" class="HipervinculoAdmon btn btn-info">Agregar nueva ciudad...</a>
    		</div>
    	</div>
    </section>