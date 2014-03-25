    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <section>
    	<h1><fmt:message key="formaListadoPersonas.etiqueta.nombre" /></h1>
        <p>Total: ${formaListadoPersonas.contador}</p>
        
        
    	<div class="row">
    		<div class="col-md-7">
    	       <table class='table table-stripped'>
                    <thead>
                        <tr>
                            <th class="order" data-by="id" data-order="asc">#</th>
                            <th class="order" data-by="nombre" data-order="asc">Nombre</th>
                            <th class="order" data-by="ciudad" data-order="asc">Ciudad</th>
                            <th>Admin</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                        <c:forEach var="persona" items="${formaListadoPersonas.personas}">
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
                    </tbody>
                </table>		
    			
    		</div>
    		<div class="col-md-1">
    			
    		</div>
    		<div class="col-md-4">
    			<a href="solicitarRegistroPersona.do" class="HipervinculoAdmon btn btn-info">Agregar nueva persona...</a>
    		</div>
    	</div>
    </section>
    <!--
    <th class="order" data-by="id" data-order="asc">#</th>
                            <th class="order" data-by="nombre" data-order="asc">Nombre</th>
                            <th class="order" data-by="ciudad" data-order="asc">Ciudad</th>
    -->
<script src="js/jquery.js"></script>
<script>

$('.order').on("click",function(e){
    var self = this;
    var order_by = $(self).attr("data-by");
    var order = $(self).attr("data-order");
    if(order == "asc")
        $(self).attr("data-order","desc");
    else
        $(self).attr("data-order","asc");
    order = $(self).attr("data-order");
    $.ajax({
        url:"/USJv0.3/solicitarListaPersonasAJAX.do",
        type:"post",
        data: {cadena: order_by,order: order},
        success: function(e){
            $("#tbody").html(e);
        },
        error: function(e){
            console.log(e);
        }
    });
  });
</script>