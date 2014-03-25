<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <section>
      <div class="col-md-8 card_style top-space center-block no-float">
        <h1><fmt:message key="formaNuevoSesion.titulo" /></h1>
        <form id="forma" action="/USJv0.3/login/procesarRegistroSesion.do" method="post">
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
                   autocomplete="off"
                   value="${formaNuevaSesion.nombre}" />
          </div>
          <div class="form-group">
            <input type="password" 
                   placeholder="Password"
                   name= "password"
                   size="50"
                   class="form-control" 
                   maxlength="100"
                   autocomplete="off"
                   value="${formaNuevaSesion.password}" />
          </div>
          <div>
            <input type="submit" 
              name="submit"
              class="btn btn-info" 
              value="Agregar y terminar"/>
          </div>
      </form>
      </div>
    </section>
