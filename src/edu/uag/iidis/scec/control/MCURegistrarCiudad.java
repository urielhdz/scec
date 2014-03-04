package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.persistencia.EstadoDAO;

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



public final class MCURegistrarCiudad
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);
    private EstadoDAO eDAO = new EstadoDAO();

    public ActionForward solicitarRegistroCiudad(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevoCiudad forma = (FormaNuevoCiudad)form;

        ManejadorEstados mr = new ManejadorEstados();
        Collection resultado = mr.listarEstados();

        ActionMessages errores = new ActionMessages();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroCiudad");
        }
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setEstados( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }
    }



    public ActionForward procesarRegistroCiudad(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroCiudad");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        
        // Se obtienen los datos para procesar el registro
        FormaNuevoCiudad forma = (FormaNuevoCiudad)form;
        Estado estado = eDAO.buscarPorId(Long.parseLong(forma.getEstado()),false);

        Ciudad ciudad = new Ciudad(forma.getNombre(),
                          "placeholder",estado);
        //estado.addCiudad(ciudad);
        ManejadorCiudades mr = new ManejadorCiudades();
        int resultado = mr.crearCiudad(ciudad);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreCiudadYaExiste",
                                               forma.getNombre()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

