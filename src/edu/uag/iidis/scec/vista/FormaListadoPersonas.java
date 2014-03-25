package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Uriel Hernandez
 */
public final class FormaListadoPersonas
        extends ValidatorForm {

    private Collection personas;
    private ArrayList ciudades;
    private int contador;

    public void setCiudades(ArrayList ciudades){
        this.ciudades = ciudades;
    }
    public ArrayList getCiudades(){
        return this.ciudades;
    }
    
    public void setPersonas(Collection personas) {
        this.personas = personas;
        if (personas != null) {
          this.contador = personas.size();
        } else
          this.contador = -1;
    }

    public Collection getPersonas() {
        return (this.personas);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        personas=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
