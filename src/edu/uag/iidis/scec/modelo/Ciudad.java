package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Ciudad.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Ciudad extends ClaseBase 
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
    private Estado estado;
    private Set<Persona> personas;


    public Ciudad() {
    }

    public Ciudad(Long id){
        this.id = id;
    }

    public Ciudad(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public Ciudad(String nombre, String descripcion, Estado estado){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.estado = estado;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del rol.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del rol.
     * @return void
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEstado(Estado estado){

        this.estado = estado;
    }
    public Estado getEstado(){
        return this.estado;
    }
    public Set getPersonas(){
        return this.personas;
    }
    public void setPersonas(Set personas){
        this.personas = personas;
    }

}
