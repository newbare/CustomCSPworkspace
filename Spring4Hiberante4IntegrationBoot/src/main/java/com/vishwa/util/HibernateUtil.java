package com.vishwa.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vishwa.entity.Employee;

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
        //return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();
    	return sessionFactory.getCurrentSession().createCriteria(entityClass).addOrder(Order.asc("name")).list(); 
    }
  
	@SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query) { 
        return sessionFactory.getCurrentSession().createSQLQuery(query).list(); 
    }
	
	@SuppressWarnings("unchecked")
	public  List<Employee> fetchAllBy(String searchName) { 
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		Criterion salary = Restrictions.like("name", "%"+searchName+"%");
		Criterion name = Restrictions.like("email","%"+searchName+"%");
		LogicalExpression orExp = Restrictions.or(salary, name);
		criteria.add(orExp);
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
	public <T>  T fetchById(Serializable id, Class<T> entityClass) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }
    
    
	
}
