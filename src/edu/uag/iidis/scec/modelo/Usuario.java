package edu.uag.iidis.scec.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es usada para representar a un usuario de la
 * aplicación. 
 *
 * <p>
 * <a href="Usuario.java.html"><i>Ver código fuente</i></a>
 * </p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Usuario extends PersonaUsuario {
    
    protected Credencial credencial;
    protected List roles = new ArrayList();


    public Usuario(){
    }

    public Usuario(NombrePersona nombre, 
                   Credencial credencial) {
        //super((String) nombre);
        this.credencial=credencial;
    }



    public Credencial getCredencial() {
        return credencial;
    }


    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }



    public List getRoles() {
        return roles;
    }



    public void setRoles(List roles) {
        this.roles = roles;
    }



    public void addRol(Rol rol) {
        if (roles.indexOf(rol) < 0) {
            roles.add(rol);
            rol.getUsuarios().add(this);
        }
    }

    
    public void removeRol(Rol rol) {
        roles.remove(rol);
        rol.getUsuarios().remove(this);
    }

}
