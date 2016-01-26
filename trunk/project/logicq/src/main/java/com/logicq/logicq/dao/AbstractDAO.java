package com.logicq.logicq.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public class AbstractDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = false)
	public void save(T p_abstractobject, Session p_session) {

		if (null == p_session) {
			Session session = getSessionFactory().openSession();
			Transaction l_txn = null;
			try {
				l_txn = session.beginTransaction();
				session.save(p_abstractobject);
				l_txn.commit();
			} catch (Exception l_ex) {
				if (l_txn != null)
					l_txn.rollback();
			} finally {
				session.close();
			}
		} else {
			p_session.save(p_abstractobject);
		}
	}

	@Transactional(readOnly = false)
	public void update(T p_entity, Session p_session) {

		if (null == p_session) {
			Session session = sessionFactory.openSession();
			Transaction l_txn = null;
			try {
				l_txn = session.beginTransaction();
				session.update(p_entity);
				l_txn.commit();
			} catch (Exception l_ex) {
				if (l_txn != null)
					l_txn.rollback();
			} finally {
				session.close();
			}
		} else {
			p_session.update(p_entity);
		}
	}

	@Transactional(readOnly = false)
	public void delete(T p_abstractobject, Session p_session) {

		if (null == p_session) {
			Session session = sessionFactory.openSession();
			Transaction l_txn = null;
			try {
				l_txn = session.beginTransaction();
				session.delete(p_abstractobject);
				l_txn.commit();
			} catch (Exception l_ex) {
				if (l_txn != null)
					l_txn.rollback();
			} finally {
				session.close();
			}
		} else {
			p_session.update(p_abstractobject);
		}
	}

	public Session getSession() {

		return sessionFactory.openSession();
	}

	/**
	 * @return
	 */
	public Transaction beginTransaction() {

		Session session = sessionFactory.openSession();
		Transaction l_txn = null;
		try {
			l_txn = session.beginTransaction();
		} catch (Exception l_ex) {
			// need to Add logicq exception handling
		}
		return l_txn;
	}

	/**
	 * @param p_transaction
	 */
	public void commitTransaction(Transaction p_transaction) {

		if (null != p_transaction) {
			try {
				p_transaction.commit();
			} catch (Exception l_ex) {
				if (null != p_transaction) {
					p_transaction.rollback();
				}
			}
		}
	}

	public List executeNamedQuery(String query, Map<String, Object> paramMap) {

		Session session = getSession();
		Query qry = session.getNamedQuery(query);
		bindParameters(qry, paramMap);
		List list = qry.list();
		return list;
	}

	private void bindParameters(Query qry, Map<String, Object> paramMap) {

		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			if (entry.getValue() instanceof Collection) {
				qry.setParameterList(entry.getKey(), (Collection) entry.getValue());
			} else {
				qry.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}

	public Object load(Class clazz, Serializable id) {

		Object obj = null;
		Session session = getSession();
		obj = session.load(clazz, id);
		return obj;
	}

	public List loadClass(Class clazz) {

		Session session = getSession();
		Query qry = session.createQuery("from " + clazz.getName());
		List list = qry.list();
		return list;
	}

	public Object executeNamedQueryForSingleRow(String query, Map<String, Object> paramMap) {

		Session session = getSession();
		Query qry = session.getNamedQuery(query);
		bindParameters(qry, paramMap);
		List list = qry.list();
		if (list != null && !list.isEmpty() && (list.size() > 0)) {
			return list.get(0);
		}
		return null;
	}

	public List executeCriteriaForSingleColumn(Class clazz, Object[] params) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		for (Object o : params) {
			criteria.setProjection(Projections.property(String.valueOf(o)));
		}
		List list = criteria.list();
		return list;
	}
}
