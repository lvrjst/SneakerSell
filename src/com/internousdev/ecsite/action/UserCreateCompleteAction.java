package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String SUCCESS;
	public Map<String,Object>session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute()throws SQLException{
		String result = SUCCESS;

		userCreateCompleteDAO.createUser(
		session.get("loginId").toString(),
		session.get("loginPass").toString(),
		session.get("userName").toString(),
		session.get("name").toString(),
		session.get("furigana").toString(),
		session.get("zip").toString(),
		session.get("addres").toString(),
		session.get("telephone").toString(),
		session.get("mailAddress").toString(),
		session.get("birthdayYear").toString(),
		session.get("birthdayMonth").toString(),
		session.get("birthdayDay").toString(),
		session.get("directMail").toString());

		return result;
	}


	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}

}