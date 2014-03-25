package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.*;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.User;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class UserDAO {

    private Log log = LogFactory.getLog(PersonaDAO.class);

    public UserDAO() {
    }


    
    public User buscarPorNombrePassword(String nombre,String password) throws ExcepcionInfraestructura {
        User user;
        Collection users;
        if (log.isDebugEnabled()) {
            log.debug(">buscarUserByPasswordNombre()");
        }

        try {
            /*
                Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Persona.class);
                personas = criteria.add(Example.create(persona)).list();
                personas = HibernateUtil.getSession()
                                    .createQuery("from Persona order by nombre desc")
                                    .setParameter("cadena",cadena)
                                    .list();
                
            */
            log.debug("<El parametro es: "+nombre);
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(User.class);
            criteria.add(Restrictions.eq("nombre", nombre));
            criteria.add(Restrictions.eq("password", password));
            users = criteria.list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException : "+e.toString());
            }
            throw new ExcepcionInfraestructura(e);
        }
        if(users != null)
            user = (User) users.iterator().next();
        else
            user = null;
        return user;

    }


}
