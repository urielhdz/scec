package edu.uag.iidis.scec.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es usada para representar a una persona. 
 *
 * <p>
 * <a href="Persona.java.html"><i>Ver código fuente</i></a>
 * </p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Persona {
    
    protected Long id;
    private String nombre;
    private Ciudad ciudad;

    public Persona(){
    }

    public Persona(String nombre, Ciudad ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    /**
     * Regresa el identificador de la persona.
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la persona.
     * @param id Identificador de la persona
     */
    public void setId(Long id) {
        this.id = id;
    }



    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Ciudad getCiudad(){
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad){
        this.ciudad = ciudad;
    }
}
