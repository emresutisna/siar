package com.emresutisna.siar.commons.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.lang.Class;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.emresutisna.siar.commons.BasicDao;

@SuppressWarnings("rawtypes")
public class BasicDaoImpl<T> implements BasicDao<T> {
	protected Class domainClass;
	
	public BasicDaoImpl(){
		this.domainClass = (Class) ((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	@Override
	public void add(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		return (T)sessionFactory.getCurrentSession().get(domainClass, id);
	}

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
