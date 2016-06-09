package com.logicq.logicq.service.verification;

import com.logicq.logicq.ui.verification.vo.UserVerificationDTO;

public interface IUserVerificationService {

	public Boolean verifyUserEmail(UserVerificationDTO userVerificationDTO);

	public void verifySMS(UserVerificationDTO userVerificationDTO);
}
