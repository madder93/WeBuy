package com.madder.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.madder.dao.BaseDao;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	protected SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object save(Object obj) {
		return (T) this.getSession().save(obj);
	}

	@Override
	public void delete(Object obj) {
		this.getSession().delete(obj);
	}

	@Override
	public void update(Object obj) {
		this.getSession().update(obj);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		this.getSession().saveOrUpdate(obj);
	}

	@Override
	public void saveAll(Collection<?> obj) {
		Iterator<?> it = obj.iterator();
		while(it.hasNext()){
			Object entity = it.next();
			this.getSession().save(entity);
		}
	}

	@Override
	public void deleteAll(Collection<?> obj) {
		Iterator<?> it = obj.iterator();
		while(it.hasNext()){
			Object entity = it.next();
			this.getSession().delete(entity);
		}
	}

	@Override
	public void updateAll(Collection<?> obj) {
		Iterator<?> it = obj.iterator();
		while(it.hasNext()){
			Object entity = it.next();
			this.getSession().update(entity);
		}
	}

	@Override
	public void saveorUpdateAll(Collection<?> obj) {
		Iterator<?> it = obj.iterator();
		while(it.hasNext()){
			Object entity = it.next();
			this.getSession().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(String className, Serializable id) {
		return (T) this.getSession().get(className, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T get(String sqlString, Object... params) {
		Query query = this.getSession().createQuery(sqlString);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		List list = query.setMaxResults(1).list();
		if(list.isEmpty()){
			return null;
		}
		return (T) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String sqlString, Object... params) {
		Query query = this.getSession().createQuery(sqlString);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPage(int start, int count, String sqlString,
			Object... params) {
		Query query = this.getSession().createQuery(sqlString);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult(start).setMaxResults(count).list();
	}

	@Override
	public int count(String sqlString, Object... params) {
		Query query = this.getSession().createQuery(sqlString);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.list().size();
	}

}
