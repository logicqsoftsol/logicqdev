package com.logicq.logicq.conversion.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.constant.ComunicationAddress;
import com.logicq.logicq.constant.ContactType;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.model.address.Address;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.facility.Facility;
import com.logicq.logicq.ui.user.vo.FacilityVO;
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
		user.setEntityType(EntityType.DOCTOR);
		Role role = new Role();
		role.setRoleid(Long.valueOf(5));
		role.setRole("Common Role");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRole(roles);
		Facility facility = new Facility();
		Facility facility1 = new Facility();
		facility1.setFacilityId(Long.valueOf(15));
		facility1.setFacilityName("Doctor facility");
		Set<Facility> facilities = new HashSet<Facility>();
		facility.setFacilityId(Long.valueOf(10));
		facility.setFacilityName("Default facility");
		facilities.add(facility);
		facilities.add(facility1);
		user.setFacilities(facilities);
		Set<Address> addresses = setUserAddress(userVO, user);
		user.setAddresses(addresses);
		return user;
	}

	private Set<Address> setUserAddress(UserVO userVO, User user) {

		Set<Address> addresses = new HashSet<Address>();
		Address address = new Address();
		address.setHousenumber("I601");
		address.setFloornumber("6");
		address.setLocalityname("shankar kalat nagar");
		address.setStreetname("Wakad Road");
		address.setLandmarkname("near Costa Rica");
		address.setCity("Pune");
		address.setCommunicationaddress(ComunicationAddress.HOME);
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("411057");
		address.setDefaultAddressFlag(true);
		address.setContactType(ContactType.HOME);
		address.setContactNumber("0226541");
		address.setUser(user);
		addresses.add(address);
		return addresses;
	}

	public UserVO conversionFromEntitytoVO(User user, UserVO userVO) {

		userVO.setName(user.getFirstName() + " " + user.getLastName());
		userVO.setSurname(user.getLastName());
		userVO.setDateOfBirth(user.getDateOfBirth());
		userVO.setGender(user.getGender());
		userVO.setMobileNo(user.getMobileNo());
		userVO.setEmailId(user.getEmailId());
		userVO.setPassword(user.getPassword());
		Set<Facility> facilities = user.getFacilities();
		List<FacilityVO> facilityVOs = new ArrayList<FacilityVO>();
		for (Facility facility : facilities) {
			FacilityVO facilityVO = LogicqContextProvider.getApplicationContext().getBean(FacilityVO.class);
			facilityVO.setFacilityImagePath(facility.getFacilityImagePath());
			facilityVO.setFacilityName(facility.getFacilityName());
			facilityVOs.add(facilityVO);
		}
		userVO.setFacilities(facilityVOs);
		return userVO;
	}

	public User handleConversionVOtoEntityWithContext(UserVO p_uservo) {
		User userentity = new User();
		return conversionFromVOtoEntity(p_uservo, userentity);
	}
}
