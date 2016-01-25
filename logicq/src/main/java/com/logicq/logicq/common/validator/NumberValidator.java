package com.logicq.logicq.common.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("numberValidator")
public class NumberValidator implements Validator {

	private static final String NUMBER_PATTERN = "^[0-9]*$";

	private Pattern pattern;
	private Matcher matcher;

	public NumberValidator() {
		pattern = Pattern.compile(NUMBER_PATTERN);
	}
	
	public void validate(FacesContext context, UIComponent component,Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("Invalid Number");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
		
	}
}
