package com.logicq.logicq.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.criteriamanager.BaseEntity;

public class AbstractDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	
/**
 * 
 * @return
 */
	public Session getCurrentSession() {
		Session l_session = sessionFactory.getCurrentSession();
		if (null == l_session) {
			l_session = sessionFactory.openSession();
		}
		return l_session;
	}
/**
 * 
 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	/**
	 * 
	 * @param p_abstractentity
	 * @param p_session
	 */
	public void save(T p_abstractentity, Session p_session) {
		
		Session l_session=p_session;
		if (null == l_session) {
			 l_session = getSession();
		}
		l_session.persist(p_abstractentity);
	}
	
/**
 * 
 * @param p_abstractentity
 * @param p_session
 */
	public void update(T p_abstractentity, Session p_session)  {
		Session l_session = p_session;
		if (null == p_session) {
			l_session = getSession();
		}
		l_session.update(p_abstractentity);
	}
	



/**
 * 	
 * @param p_abstractentity
 * @param p_session
 */
	public void delete(T p_abstractentity, Session p_session) {
		Session l_session=p_session;
		if (null == p_session) {
			 l_session = getSession();
		}
        if(null != p_abstractentity){
        	l_session.delete(p_abstractentity);
        }
	}
	
	/**
	 * @return
	 */
	public Transaction beginTransaction() {
		Session session = sessionFactory.openSession();
		Transaction l_txn = null;
		l_txn = session.beginTransaction();
		return l_txn;
	}

	/**
	 * @param p_transaction
	 */
	public void commitTransaction(Transaction p_transaction) {

		if (null != p_transaction) {
			p_transaction.commit();
		}
	}
/**
 * 
 * @param query
 * @param paramMap
 * @return
 */
	public List<? extends BaseEntity> executeNamedQuery(String query, Map<String, Object> paramMap) {
		Session session = getSession();
		Query qry = session.getNamedQuery(query);
		bindParameters(qry, paramMap);
		return qry.list();
	}
/**
 * 
 * @param qry
 * @param paramMap
 */
	private void bindParameters(Query qry, Map<String, Object> paramMap) {

		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			if (entry.getValue() instanceof Collection) {
				qry.setParameterList(entry.getKey(), (Collection) entry.getValue());
			} else {
				qry.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}
/**
 * 
 * @param clazz
 * @param id
 * @return
 */
	public Object load(Class<T> clazz, Serializable id) {
		Session session = getCurrentSession();
		return session.load(clazz, id);
	}
/**
 * 
 * @param clazz
 * @return
 */
	public List<? extends BaseEntity> loadClass(Class<T> clazz) {

		Session session = getCurrentSession();
		Query qry = session.createQuery("from " + clazz.getName());
		return qry.list();
	}
/**
 * 
 * @param query
 * @param paramMap
 * @return
 */
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
/**
 * 
 * 
 * @param clazz
 * @param params
 * @return
 */
	public List<? extends BaseEntity> executeCriteriaForSingleColumn(Class<T> clazz, Object[] params) {

		Session session = getSession();
		Criteria criteria = session.createCriteria(clazz);
		 for (Object columnName : params) {
			criteria.setProjection(Projections.property(String.valueOf(columnName)));
		} 
		return criteria.list();
	}
}
