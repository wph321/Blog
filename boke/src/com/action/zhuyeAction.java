package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBowenDAO;
import com.dao.TPinglunDAO;
import com.dao.TUserDAO;
import com.model.TBowen;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class zhuyeAction
{
	
	public String gerenzhuye()
	{
		return ActionSupport.SUCCESS;
	}
	
	
	public String tarenzhuye()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("userId", request.getParameter("userId"));
		return ActionSupport.SUCCESS;
	}
	
}
