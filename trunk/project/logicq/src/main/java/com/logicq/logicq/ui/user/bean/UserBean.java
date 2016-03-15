package com.logicq.logicq.ui.user.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

/**
 * User Bean
 * 
 * @author SudhanshuL
 * @since 11 Dec 2012
 * @version 1.0.0
 */
@ManagedBean(name = "userMB")
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String firstname;
	private String lastname;
	private String age;
	private String dob;
	private String sex;
	private String email;
	private String password;
	private String confirmpassword;
	private String addUser;
	private String agreeterms;
	private String mobilenumber;
	private String otpformrender = "false";
	private String otppassword;
	private String rendersignupform = "true";
	private String searchlocation;
	private String spcification;
	private String fullname;
	private String exprience;
	private List<ProfileBean> profiles;

	public List<ProfileBean> getProfiles() {
		profiles=new ArrayList<ProfileBean>();
		ProfileBean l_profile=new ProfileBean();
		l_profile.setExprience("10");
		l_profile.setFacilityDetails("Family doctor");
		l_profile.setFeedback("100");
		l_profile.setFess("400");
		l_profile.setFullname("Test For each");
		l_profile.setLocation("Pune");
		l_profile.setRecomendation("200");
		l_profile.setSpcification("Phd");
		profiles.add(l_profile);
		l_profile=new ProfileBean();
		l_profile.setExprience("11");
		l_profile.setFacilityDetails("Family doctor1");
		l_profile.setFeedback("101");
		l_profile.setFess("401");
		l_profile.setFullname("Test For each1");
		l_profile.setLocation("Pune1");
		l_profile.setRecomendation("201");
		l_profile.setSpcification("Phd1");
		profiles.add(l_profile);
		return profiles;
	}



	public void setProfiles(List<ProfileBean> profiles) {

		this.profiles = profiles;
	}

	@ManagedProperty(value = "#{profile}")
	private ProfileBean profile;

	public ProfileBean getProfile() {
		System.out.println("Test");
		return profile;
	}


	public void setProfile(ProfileBean profile) {

		this.profile = profile;
	}

	public String getExprience() {

		return exprience;
	}

	public void setExprience(String exprience) {

		this.exprience = exprience;
	}




	public String getFullname() {

		return fullname;
	}




	public void setFullname(String fullname) {

		this.fullname = fullname;
	}



	public String getSpcification() {

		return spcification;
	}



	public void setSpcification(String spcification) {

		this.spcification = spcification;
	}



	public String getSearchlocation() {

		return searchlocation;
	}

	public void setSearchlocation(String searchlocation) {

		this.searchlocation = searchlocation;
	}

	public String getOtpformrender() {

		return otpformrender;
	}

	public void setOtpformrender(String otpformrender) {

		this.otpformrender = otpformrender;
	}

	public String getOtppassword() {

		return otppassword;
	}

	public void setOtppassword(String otppassword) {

		this.otppassword = otppassword;
	}

	public String getRendersignupform() {

		return rendersignupform;
	}

	public void setRendersignupform(String rendersignupform) {

		this.rendersignupform = rendersignupform;
	}

	@NotNull
	private String entity = null;

	public String getFirstname() {

		return firstname;
	}

	public void setFirstname(String firstname) {

		this.firstname = firstname;
	}

	public String getLastname() {

		return lastname;
	}

	public void setLastname(String lastname) {

		this.lastname = lastname;
	}

	public String getAge() {

		return age;
	}

	public void setAge(String age) {

		this.age = age;
	}

	public String getDob() {

		return dob;
	}

	public void setDob(String dob) {

		this.dob = dob;
	}

	public String getSex() {

		return sex;
	}

	public void setSex(String sex) {

		this.sex = sex;
	}

	public String getConfirmpassword() {

		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {

		this.confirmpassword = confirmpassword;
	}

	public String getMobilenumber() {

		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {

		this.mobilenumber = mobilenumber;
	}

	private List<String> entities;
	private String login;
	private String forgetPassword;
	private String facebooklogin;
	private String gmaillogin;
	private String acesscode;

	public String getAcesscode() {

		return acesscode;
	}

	public void setAcesscode(String acesscode) {

		this.acesscode = acesscode;
	}

	public String loginfromFacebook() {

		System.out.println("facebooklogin");
		return facebooklogin;
	}

	public String loginfromGmail() {

		System.out.println("gmaillogin");
		return gmaillogin;
	}

	public String getFacebooklogin() {

		return facebooklogin;
	}

	public void setFacebooklogin(String facebooklogin) {

		this.facebooklogin = facebooklogin;
	}

	public String getGmaillogin() {

		return gmaillogin;
	}

	public void setGmaillogin(String gmaillogin) {

		this.gmaillogin = gmaillogin;
	}

	public String getForgetPassword() {

		return forgetPassword;
	}

	public void setForgetPassword(String forgetPassword) {

		this.forgetPassword = forgetPassword;
	}

	public String getEntity() {

		return entity;
	}

	public void setEntity(String entity) {

		this.entity = entity;
	}

	public List<String> getEntities() {

		return entities;
	}

	public void setEntities(List<String> entities) {

		entities = Arrays.asList("FAMILY DOCTOR", "BEAUTY CARE", "ADVOCATE", "PLUMBER", "ELECTRICIAN", "GROCERY", "ADVOCATE", "CARPENTER", "TUTOR", "MASON");
		this.entities = entities;
	}

	private String reset;

	public String getAddUser() {

		return addUser;
	}

	public void setAddUser(String addUser) {

		this.addUser = addUser;
	}

	public String getReset() {

		return reset;
	}

	public void setReset(String reset) {

		this.reset = reset;
	}

	public String processLogin() {

		System.out.println("Login Process");
		return login;
	}

	public String getLogin() {

		return login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public String addUser() {

		UserManagedBean userManagedBean = LogicqContextProvider.getApplicationContext().getBean(UserManagedBean.class);
		UserRegistrationResponse response = userManagedBean.addUser(this);
		rendersignupform = "false";
		otpformrender = "true";
		return "register";
	}

	public String reset() {

		UserManagedBean userManagedBean = LogicqContextProvider.getApplicationContext().getBean(UserManagedBean.class);
		userManagedBean.reset();
		return "sucess";
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {

		return firstname;
	}

	public void setName(String name) {

		this.firstname = name;
	}

	public String getSurname() {

		return lastname;
	}

	public void setSurname(String surname) {

		this.lastname = surname;
	}

	private String searchText;

	public String getSearchText() {

		return searchText;
	}

	public void setSearchText(String searchText) {

		this.searchText = searchText;
	}



	public String getAgreeterms() {

		return agreeterms;
	}

	public void setAgreeterms(String agreeterms) {

		this.agreeterms = agreeterms;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}



	public void searchEntity() {

	}

	public String processForgetPassword() {

		return forgetPassword;
	}

	public String validateOTP() {

		return null;
	}

	public String selectedEntity() {

		return "entity";
	}
	
	public String entitynavigation(){
		return null;
	}
}