package com.logicq.logicq.service.verification.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.conversion.user.UserConversion;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.service.verification.IUserVerificationService;
import com.logicq.logicq.ui.user.vo.UserVO;
import com.logicq.logicq.ui.verification.vo.UserVerificationDTO;

@Service
@Transactional
public class UserVerificationService implements IUserVerificationService {

	@Autowired
	IUserService userService;
	UserConversion userConversion = UserConversion.getInstance();

	public Boolean verifyUserEmail(UserVerificationDTO userVerificationDTO) {

		if (userVerificationDTO != null) {
			EmailVerificationService emailVerificationService = new EmailVerificationService();
			Boolean isEmailVerified = emailVerificationService.verifyEmail(userVerificationDTO);
			if (isEmailVerified) {
				updateUserForVerification(userVerificationDTO.getUserId());
				return isEmailVerified;
			}
		}
		return false;
	}

	private void updateUserForVerification(Long userId) {

		UserVO userVO = LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
		userVO = userService.getUserById(userId);
		userVO.setIsEmailVerified(true);
		if (userVO.getIsMobileVerified().equals(true)) {
			userVO.setIsUserVerified(true);
		}
		userService.updateUser(userVO);
	}

	public void verifySMS(UserVerificationDTO userVerificationDTO) {

	}
}
