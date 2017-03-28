package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TUserDAO userDAO;
	
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql = "from TUser where userDel='no' order by userId desc";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}

}
