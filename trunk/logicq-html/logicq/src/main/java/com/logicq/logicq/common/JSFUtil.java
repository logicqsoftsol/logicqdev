package com.logicq.logicq.common;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class JSFUtil {


	public static void handleNavigation(String navigationcontext){
		 FacesContext context = FacesContext.getCurrentInstance();
		 NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
		 navigationHandler.handleNavigation(context, null, navigationcontext);
	}
	
}
