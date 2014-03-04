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
public final class FormaNuevoCiudad
        extends ValidatorForm {

    private String nombre;
    private String estado;
    private String descripcion;
    private Collection estados;
    private int contador;

    public void setEstados(Collection estados) {
        this.estados = estados;
        if (estados != null) {
          this.contador = estados.size();
        } else
          this.contador = -1;
    }

    public Collection getEstados() {
        return (this.estados);
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

    public void setDescripcion(String nombre) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return (this.descripcion);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return (this.estado);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        estado=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
