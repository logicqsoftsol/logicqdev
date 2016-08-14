package com.issuetraker.common.criteriamanager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class LogicqCriteriaHandler {

	public static Criteria createCriteria(Session session, Class p_class) {
		return session.createCriteria(p_class,p_class.getSimpleName().toLowerCase());
	}

	public List<?> executeCriteria(Criteria criteria,
			List<? extends LogicqFilterObject> p_filterObjectList,
			DataFetchType p_dataFetchType) {
		return executeCriteriaDetails(p_filterObjectList, p_dataFetchType,
				criteria);
	}

	public List<?> executeCriteria(Session session,
			List<? extends LogicqFilterObject> p_filterObjectList,
			DataFetchType p_dataFetchType, Class p_class) {
		return executeCriteriaDetails(p_filterObjectList,
				p_dataFetchType, createCriteria(session,p_class));
	}

	public List<? > executeCriteriaDetails(
			List<? extends LogicqFilterObject> p_filterObjectList,
			DataFetchType p_dataFetchType, Criteria criteria) {
		criteria = createFiltedQuery(criteria, p_filterObjectList);
		if (p_dataFetchType.equals(DataFetchType.LIST_RECORD)) {
			return (List<? extends BaseEntity>) findListObject(criteria);
		}
		return null;
	}

	public static List<? > findListObject(Criteria criteria) {
		return criteria.list();
	}

	private Criteria createFiltedQuery(Criteria p_criteria,
			List<? extends LogicqFilterObject> p_filterObjectList) {
		for (LogicqFilterObject p_filterObject : p_filterObjectList) {
			if (p_filterObject.getRestricationtype().equals(
					LogicqRestrictions.EQUALS)) {
				p_criteria.add(Restrictions.eq(p_filterObject.getFieldname(),
						p_filterObject.getFieldvalue()));
			}else if (p_filterObject.getRestricationtype().equals(
					LogicqRestrictions.BETWEEN)) {
			   }
		}

		return p_criteria;
	}
	
	
}