package com.logicq.mlm.dao.user;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.profile.ContactDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.profile.WalletDetails;

@Repository
public class UserProfileDAO extends AbstractDAO<UserProfile> implements IUserDAO{

	@Override
	public UserProfile fetchUser(UserProfile user) {
		user.setFirstname("Sudhanshu");
		user.setLastname("Lenka");
		user.setDateofbirth(new Date());
		user.setGender("MALE");
		user.setConatctDetails(new ContactDetails());
		user.getConatctDetails().setAddressText("ABC XYZ");
		user.getConatctDetails().setDistrict("Balasore");
		user.getConatctDetails().setEmail("asd@gmail.com");
		user.getConatctDetails().setMobilenumber("91-7057014118");
		user.getConatctDetails().setPincode("44575");
		user.setLogindetails(user.getLogindetails());
		user.setNetworkinfo(new NetworkInfo());
		user.getNetworkinfo().setDateofjoin(new Date());
		user.getNetworkinfo().setMemberlevel("Level-1");
		user.setWalletdetails(new WalletDetails());
		user.getWalletdetails().setWalletid("SL1154585");
		return user;
		
	}

	@Override
	public void deleteUser(UserProfile user) {
		delete(user);
		
	}

	@Override
	public void saveUser(UserProfile user) {
		saveOrUpdate(user);
		
	}

	@Override
	public void updateUser(UserProfile user) {
		saveOrUpdate(user);
	}

}
