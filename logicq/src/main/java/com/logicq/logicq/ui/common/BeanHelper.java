package com.logicq.logicq.ui.common;

import javax.el.ELContext;
import javax.faces.context.FacesContext;



public class BeanHelper {
	
	public static <T> T getBean(final String beanName, final Class<T> clazz) {
	    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	    return (T) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, beanName);
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}

}
