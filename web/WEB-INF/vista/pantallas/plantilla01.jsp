<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <title>Titulo del documento</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="/USJv0.3/css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="/USJv0.3/css/app.css">
        <link rel="stylesheet" type="text/css" href="/USJv0.3/css/mensajes.css">
    </head>
	
    <body>
        <table class="marco" cellpadding="0">
            <tr>
                <td colspan="2">
                    <c:import url="/WEB-INF/vista/comun/banner.jsp" />
                    <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
                </td>
            </tr>
            <tr height="490px">
                <td align="center" valign="center" width="100%">
                    <c:import url="/WEB-INF/vista/pantallas/${param.c}" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />
                </td>
            </tr>
        </table>
        
        
    </body>
</html>
