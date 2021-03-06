
package com.logicq.logicq.common.criteriamanager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * 
 * 
 * @author SudhanshuLenka
 *
 */
public class LogicqQueryHandler {
/**
 * 
 * @param session
 * @param p_query
 * @return
 */
	public Query createCriteria(Session session, String p_query) {

		return session.createQuery(p_query);
	}
/**
 * 
 * @param session
 * @param p_query
 * @param p_filterObjectList
 * @param operationType
 * @return
 */
	public int executeTransactionalQuery(Session session, String p_query, List<? extends LogicqFilterObject> p_filterObjectList, OperationType operationType) {

		Query query = createCriteria(session, p_query);
		if (operationType.equals(OperationType.INSERT)) {
			return executeQueryForInsert(session, query, p_filterObjectList);
		}
		if (operationType.equals(OperationType.DELETE)) {
			return executeQueryForDelete(session, query, p_filterObjectList);
		}
		if (operationType.equals(OperationType.UPDATE)) {
			return executeQueryForUpdate(session, query, p_filterObjectList);
		}
		return -99;
	}
/**
 * 
 * @param query
 * @param p_filterObjectList
 * @return
 */
	public List<? extends BaseEntity> executeQueryForSelect(Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		return executeQuery(p_filterObjectList, query, OperationType.SELECT);
	}
/**
 * 
 * @param query
 * @param p_filterObjectList
 * @return
 */
	public Object executeQueryForSingleSelect(Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		return executeSingleQuery(p_filterObjectList, query, OperationType.SELECT);
	}

	private int executeQueryForUpdate(Session session, Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		Transaction l_txn = session.beginTransaction();
		int result = -99;
		if (null != l_txn) {
			result = executeQueryForTransaction(p_filterObjectList, query, OperationType.UPDATE);
			l_txn.commit();
		}
		return result;
	}
/**
 * 
 * @param session
 * @param query
 * @param p_filterObjectList
 * @return
 */
	private int executeQueryForInsert(Session session, Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		return executeQueryForTransaction(p_filterObjectList, query, OperationType.INSERT);
	}
/**
 * 
 * @param session
 * @param query
 * @param p_filterObjectList
 * @return
 */
	private int executeQueryForDelete(Session session, Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		return executeQueryForTransaction(p_filterObjectList, query, OperationType.DELETE);
	}
/**
 * 
 * @param p_filterObjectList
 * @param query
 * @param operationType
 * @return
 */
	private int executeQueryForTransaction(List<? extends LogicqFilterObject> p_filterObjectList, Query query, OperationType operationType) {

		if (null != p_filterObjectList && !p_filterObjectList.isEmpty()) {
			query = buildFilterCondition(query, p_filterObjectList);
		}
		return query.executeUpdate();
	}

/**
 * 
 * @param p_filterObjectList
 * @param query
 * @param operationType
 * @return
 */
	private List<? extends BaseEntity> executeQuery(List<? extends LogicqFilterObject> p_filterObjectList,
	                                                              Query query,
	                                                              OperationType operationType) {

		if (null != p_filterObjectList && !p_filterObjectList.isEmpty()) {
			query = buildFilterCondition(query, p_filterObjectList);
		}
		return query.list();
	}
	/**
	 * 
	 * @param p_filterObjectList
	 * @param query
	 * @param operationType
	 * @return
	 */
    private Object executeSingleQuery(List<? extends LogicqFilterObject> p_filterObjectList,
	                                                              Query query,
	                                                              OperationType operationType) {

		if (null != p_filterObjectList && !p_filterObjectList.isEmpty()) {
			query = buildFilterCondition(query, p_filterObjectList);
		}
		if(!query.list().isEmpty()){
			return query.list().get(0);
				}
		return null; 
	}
	/**
	 * 
	 * @param query
	 * @param p_filterObjectList
	 * @return
	 */
	private Query buildFilterCondition(Query query, List<? extends LogicqFilterObject> p_filterObjectList) {

		for (LogicqFilterObject l_filteredobject : p_filterObjectList) {
			if (null != l_filteredobject.getFieldvalue() && null != l_filteredobject.getFieldvalue()) {
				if (l_filteredobject.getFieldvalue() instanceof String) {
					query.setString(l_filteredobject.getFieldname(), String.valueOf(l_filteredobject.getFieldvalue()));
				} else if (l_filteredobject.getFieldvalue() instanceof Integer) {
					query.setInteger(l_filteredobject.getFieldname(), (Integer) l_filteredobject.getFieldvalue());
				} else if (l_filteredobject.getFieldvalue() instanceof Boolean) {
					query.setBoolean(l_filteredobject.getFieldname(), (Boolean) l_filteredobject.getFieldvalue());
				} else if (l_filteredobject.getFieldvalue() instanceof BigDecimal) {
					query.setBigDecimal(l_filteredobject.getFieldname(), (BigDecimal) l_filteredobject.getFieldvalue());
				} else if (l_filteredobject.getFieldvalue() instanceof Double) {
					query.setDouble(l_filteredobject.getFieldname(), (Double) l_filteredobject.getFieldvalue());
				} else if (l_filteredobject.getFieldvalue() instanceof Date) {
					query.setDate(l_filteredobject.getFieldname(), (Date) l_filteredobject.getFieldvalue());
				} else if (l_filteredobject.getFieldvalue() instanceof Float) {
					query.setFloat(l_filteredobject.getFieldname(), (Float) l_filteredobject.getFieldvalue());
				}
			}
		}
		return query;
	}
}
