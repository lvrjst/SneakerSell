package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.PostDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware {
	private Map<String,Object>session;

	private String SUCCESS;
	private int sqlBranch;

	private String userId ;
	private String name;
	private String email;
	private String player;
	private String message;

	public String execute() throws SQLException{
		String result = SUCCESS;

		PostDAO postDAO = new PostDAO();
		LoginDTO loginDTO = new LoginDTO();

		try{
			if(session.containsKey("LoginDTO")){
				loginDTO = (LoginDTO)session.get("LoginDTO");
				userId = loginDTO.getLoginId();
				sqlBranch = 0;
			}else{
				userId = session.get("tempUserId").toString();
				sqlBranch = 1;
			}

			postDAO.Post(userId,name,email,player,message,sqlBranch);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	return result;
	}

	public String getUserId(){
	return userId;
	}
	public void setUserId(String userId){
	this.userId = userId;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session =session;
	}

}