package com.logicq.mlm.service.messaging;

import com.logicq.mlm.model.message.EmailDetails;

public interface IEmailService {
	
	boolean sendEmail(EmailDetails emaildetails) throws Exception;

}
