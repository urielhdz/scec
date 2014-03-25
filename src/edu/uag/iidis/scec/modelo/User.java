package edu.uag.iidis.scec.modelo;

import java.util.ArrayList;
import java.io.Serializable;
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
public class User extends ClaseBase 
        implements Serializable{
    
    protected Long id;
    private String nombre;
    private String password;

    public User(){
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
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
