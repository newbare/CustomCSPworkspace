package com.websystique.springmvc.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
@Repository
public class HibernateUtil {
	
	@Autowired
    private SessionFactory sessionFactory;
		
    public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);        
    }
    
    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);   
        return entity;
    }
    
	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}
    
    @SuppressWarnings("unchecked")	
    public <T> List<T> fetchAll(Class<T> entityClass) {        
        return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();        
    }
  
    @SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query) {        
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
    }
    
    @SuppressWarnings("unchecked")
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }
    /*@SuppressWarnings("unchecked")
	public <T> List<T> fetchByName(String name, Class<T> entityClass) {
     return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("name", name)).list();
    }*/
    @SuppressWarnings("unchecked")
	public <T> T fetchByName(String name, Class<T> entityClass) {
     return (T) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("name", name)).uniqueResult();
    }
    
	
}
