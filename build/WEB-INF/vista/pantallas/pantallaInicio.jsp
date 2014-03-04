<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
    </head>
	
    <body>
        <table class="marco" cellpadding="0">
            <tr>
                <td colspan="2">
                    <c:import url="/WEB-INF/vista/comun/banner.jsp" />
                    <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
                </td>
            </tr>
            <tr height="590px">
                <td align="center" valign="center" width="100%">
                    <h3>Welcome </h3>
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
