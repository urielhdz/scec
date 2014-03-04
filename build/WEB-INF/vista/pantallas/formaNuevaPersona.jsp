<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <section>
      <div class="col-md-8 card_style top-space center-block no-float">
        <h1><fmt:message key="formaNuevoPersona.titulo" /></h1>
        <form id="forma" action="procesarRegistroPersona.do" method="post">
          <div>
            <html:errors />
          </div>
          <div class="form-group">
            <input type="text" 
                   placeholder="Nombre"
                   name= "nombre"
                   size="50"
                   class="form-control" 
                   maxlength="100"
                   value="${formaNuevoPersona.nombre}" />
          </div>
          <div class="form-group">
            <input type="text" 
                   placeholder="Ciudad"
                   name= "ciudad"
                   id = "ciudad"
                   class="form-control" 
                   maxlength="100"
                   value="${formaNuevoPersona.persona}" />
          </div>
          <div>
            <input type="submit" 
              name="submit"
              class="btn btn-info" 
              value="Agregar y terminar"/>
            <input type="submit" 
              name="submit"
              class="btn btn-info" 
              value="Agregar y volver"
              onclick="forma.action='procesarRegistroPersona.do?volver=si'"/>
            <input type="button"
              value="Reset"
              class="btn btn-info" 
              onclick="location.href='solicitarRegistroPersona.do'" />
            <input type="submit" 
              name="org.apache.struts.taglib.html.CANCEL" 
              value="cancelar" 
              class="btn btn-info" 
              onclick="bCancel=true;">    
          </div>
      </form>
      </div>
    </section>