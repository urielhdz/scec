package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Persona;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class PersonaDAO {

    private Log log = LogFactory.getLog(PersonaDAO.class);

    public PersonaDAO() {
    }


    public Persona buscarPorId(Long idPersona, boolean bloquear)
            throws ExcepcionInfraestructura {

        Persona persona = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idPersona + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                persona = (Persona)HibernateUtil.getSession()
                                                .load(Persona.class, 
                                                      idPersona, 
                                                      LockMode.UPGRADE);
            } else {
                persona = (Persona)HibernateUtil.getSession()
                                                .load(Persona.class,
                                                      idPersona);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return persona;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection personas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            personas = HibernateUtil.getSession()
                                    .createCriteria(Persona.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public Collection buscarPorEjemplo(Persona persona)
            throws ExcepcionInfraestructura {


        Collection personas;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Persona.class);
            personas = criteria.add(Example.create(persona)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public void hazPersistente(Persona persona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(persona)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(persona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Persona persona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(persona)");
        }

        try {
            HibernateUtil.getSession().delete(persona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existePersona(String nombrePersona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existePersona(nombrePersona)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from Persona r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select nombre from Persona where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombrePersona);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombrePersona);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
