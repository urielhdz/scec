    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <select name="ciudades_propuesta">
    	<c:forEach var="ciudad" items="${formaListadoCiudadesAJAX.ciudades}">
    		<option value="<c:out value="${ciudad.nombre}"/>"><c:out value="${ciudad.nombre}"/></option>
	        
	    </c:forEach>
	</select>
    
    