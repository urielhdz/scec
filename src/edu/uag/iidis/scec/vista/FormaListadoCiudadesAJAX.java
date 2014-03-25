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
public final class FormaListadoCiudadesAJAX
        extends ValidatorForm {

    private String nombre;
    private Long idCiudad;
    private Collection ciudades;
    private int contador;


    public void setCiudades(Collection ciudades) {
        this.ciudades = ciudades;
        if (ciudades != null) {
          this.contador = ciudades.size();
        } else
          this.contador = -1;
    }

    public Collection getCiudades() {
        return (this.ciudades);
    }
  
    public int getContador() {
        return (this.contador);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return (this.nombre);
    }

    public void setIdCiudad(Long id){
        this.idCiudad = idCiudad;
    }
    public Long getIdCiudad(){
        return this.idCiudad;
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        idCiudad=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
