package com.logicq.logicq.conversion.user;

import java.util.HashSet;
import java.util.Set;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.user.Facility;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserConversion {

	private static UserConversion instance;

	public static UserConversion getInstance() {

		if (null == instance) {
			instance = new UserConversion();
		}
		return instance;
	}

	/**
	 * @param userVO
	 * @param user
	 * @return
	 */
	public User conversionFromVOtoEntity(UserVO userVO, User user) {

		user.setEmailId(userVO.getEmailId());
		user.setFirstName(userVO.getName());
		user.setLastName(userVO.getSurname());
		user.setPassword(userVO.getPassword());
		user.setGender(userVO.getGender());
		user.setDateOfBirth("1989-10-19");
		user.setMobileNo(userVO.getMobileNo());
		user.setIsEmailVerified(false);
		user.setIsMobileVerified(false);
		user.setIsUserVerified(false);
		Role role = new Role();
		role.setRoleid(Long.valueOf(5));
		role.setRole("Common Role");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		Facility facility = new Facility();
		Set<Facility> facilities = new HashSet<Facility>();
		facility.setFacilityId(Long.valueOf(10));
		facility.setFacilityName("Default facility");
		facilities.add(facility);
		user.setFacilities(facilities);
		return user;
	}

	public UserVO conversionFromEntitytoVO(User user, UserVO userVO) {

		userVO.setName(user.getFirstName());
		userVO.setSurname(user.getLastName());
		userVO.setDateOfBirth(user.getDateOfBirth());
		userVO.setGender(user.getGender());
		userVO.setMobileNo(user.getMobileNo());
		userVO.setEmailId(user.getEmailId());
		userVO.setPassword(user.getPassword());
		return userVO;
	}

	public User handleConversionVOtoEntityWithContext(UserVO p_uservo) {

		User userentity = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			userentity = LogicqContextProvider.getApplicationContext().getBean(User.class);
		}
		if (null == userentity) {
			userentity = new User();
		}
		return conversionFromVOtoEntity(p_uservo, userentity);
	}
}
