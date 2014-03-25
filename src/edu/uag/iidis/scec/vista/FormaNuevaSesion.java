package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import java.util.Collection;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaNuevaSesion
        extends ValidatorForm {

    private String nombre;
    private String password;
    


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return (this.nombre);
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return (this.password);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        password=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
