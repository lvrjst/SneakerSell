package com.internousdev.ecsite.action;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String result = SUCCESS;

	public String execute() throws NoSuchAlgorithmException, SQLException{
	 if (!(session.containsKey("LoginDTO")) && !(session.containsKey("tempUserId"))) {

		 byte[] randomByte = new byte[64];

		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

		sr.nextBytes(randomByte);

		StringBuffer sb = new StringBuffer();

		//128桁のランダムな文字列を発行
		for(byte RB : randomByte){

			sb.append(String.format("%02x", RB));

		}


		String tempUserId = sb.toString();
		session.put("tempUserId", tempUserId);
	 }
		return result;
	}
	public Map<String, Object>getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session =session;
	}

}
