package com.spring.hibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private Class<?> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;
	
	public AbstractDao() {
		this.persistentClass = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T getByKey(PK key)
	{
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persist(T entity)
	{
		getSession().persist(entity);
	}
	
	public void delete(T entity)
	{
		getSession().delete(entity);
	}
	
	public Criteria createEntityCriteria()
	{
		return getSession().createCriteria(persistentClass);
	}
}
