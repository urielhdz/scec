package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Ciudad;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class CiudadDAO {

    private Log log = LogFactory.getLog(CiudadDAO.class);

    public CiudadDAO() {
    }


    public Ciudad buscarPorId(Long idCiudad, boolean bloquear)
            throws ExcepcionInfraestructura {

        Ciudad ciudad = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idCiudad + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                ciudad = (Ciudad)HibernateUtil.getSession()
                                                .load(Ciudad.class, 
                                                      idCiudad, 
                                                      LockMode.UPGRADE);
            } else {
                ciudad = (Ciudad)HibernateUtil.getSession()
                                                .load(Ciudad.class,
                                                      idCiudad);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return ciudad;
    }
    public Ciudad buscarPorNombre(String nombre)
            throws ExcepcionInfraestructura {

        Ciudad ciudad = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombre(" + nombre + ")");
        }

        try {
            ciudad = (Ciudad) HibernateUtil.getSession()
                                    .createQuery("from Ciudad where nombre = :nombre")
                                    .setParameter("nombre",nombre)
                                    .list().iterator().next();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return ciudad;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection ciudades;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            ciudades = HibernateUtil.getSession()
                                    .createCriteria(Ciudad.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return ciudades;
    }


    public Collection buscarPorEjemplo(Ciudad ciudad)
            throws ExcepcionInfraestructura {


        Collection ciudades;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Ciudad.class);
            ciudades = criteria.add(Example.create(ciudad)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return ciudades;
    }


    public void hazPersistente(Ciudad ciudad)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(ciudad)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(ciudad);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Ciudad ciudad)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(ciudad)");
        }

        try {
            HibernateUtil.getSession().delete(ciudad);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeCiudad(String nombreCiudad)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
			String hql = "select nombre from Ciudad where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreCiudad);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombreCiudad);
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
    public Collection buscarPorCadena(String cadena) throws ExcepcionInfraestructura {
        Collection ciudades;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            ciudades = HibernateUtil.getSession()
                                    .createQuery("from Ciudad where nombre LIKE :nombre")
                                    .setParameter("nombre","%"+cadena+"%")
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list   ");                                 
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return ciudades;

    }


}
