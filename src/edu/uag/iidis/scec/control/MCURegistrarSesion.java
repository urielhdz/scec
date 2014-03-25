package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.persistencia.UserDAO;

import java.util.Map;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;



public final class MCURegistrarSesion
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);
    private UserDAO eDAO = new UserDAO();
    public ActionForward solicitarRegistroSesion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevaSesion forma = (FormaNuevaSesion)form;

        ActionMessages errores = new ActionMessages();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroPersona");
        }
        
        return (mapping.findForward("exito"));
    }



    public ActionForward procesarRegistroSesion(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroSesion");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        
        // Se obtienen los datos para procesar el registro
        FormaNuevaSesion forma = (FormaNuevaSesion)form;
        User usuario = eDAO.buscarPorNombrePassword(forma.getNombre(),forma.getPassword());
        int resultado;
        if(usuario != null){
            resultado = 0;
        }
        else
            resultado = 1;

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                request.getSession().setAttribute("user",usuario);
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.noExisteUsuario",
                                               forma.getNombre()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorSesion.crearSesion regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

