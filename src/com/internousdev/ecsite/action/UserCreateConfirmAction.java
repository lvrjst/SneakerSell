package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String loginPass;
	private String userName;
	private String name;
	private String furigana;
	private String zip;
	private String address;
	private String telephone;
	private String mailAddress;
	private String birthdayYear;
	private String birthdayMonth;
	private String birthdayDay;
	private String directMail;
	public Map<String,Object>session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;
		if(!(loginId.equals(""))
				&& !(loginPass.equals(""))
				&& !(userName.equals(""))){
			session.put("loginId", loginId);
			session.put("loginPass", loginPass);
			session.put("userName", userName);
			session.put("name", name);
			session.put("furigana", furigana);
			session.put("zip", zip);
			session.put("address", address);
			session.put("telephone", telephone);
			session.put("mailAddress", mailAddress);
			session.put("birthdayYear", birthdayYear);
			session.put("birthdayMonth", birthdayMonth);
			session.put("birthdayDay", birthdayDay);
			session.put("directMail", directMail);
		}else{
			setErrorMessage("未入力の項目があります。");
			result= ERROR;
		}
		return result;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}
	public String getLoginPass(){
		return loginPass;
	}

	public void setLoginPass(String loginPass){
		this.loginPass = loginPass;
	}
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getFurigana(){
		return furigana;
	}

	public void setFurigana(String furigana){
		this.furigana= furigana;
	}

	public String getZip(){
		return zip;
	}

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getTelephone(){
		return telephone;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	public String getMailAddress(){
		return mailAddress;
	}

	public void setMailAddress(String mailAddress){
		this.mailAddress = mailAddress;
	}

	public String getBirthdayYear(){
		return birthdayYear;
	}

	public void setBirthdayYear(String birthdayYear){
		this.birthdayYear = birthdayYear;
	}

	public String getBirthdayMonth(){
		return birthdayMonth;
	}

	public void setBirthdayMonth(String birthdayMonth){
		this.birthdayMonth = birthdayMonth;
	}

	public String getBirthdayDay(){
		return birthdayDay;
	}

	public void setBirthdayDay(String birthdayDay){
		this.birthdayDay = birthdayDay;
	}

	public String getDirectMail(){
		return directMail;
	}

	public void setDirectMail(String directMail){
		this.directMail = directMail;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
