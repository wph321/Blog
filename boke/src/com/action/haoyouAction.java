package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBowenDAO;
import com.dao.THaoyouDAO;
import com.dao.TPinglunDAO;
import com.dao.TUserDAO;
import com.model.TBowen;
import com.model.THaoyou;
import com.model.TPinglun;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class haoyouAction
{
    	
	private THaoyouDAO haoyouDAO;
	private TUserDAO userDAO;
		
	private String message;
	private String path;
	
	
	
	public String haoyouMana()
	{
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
		
		String sql="from THaoyou where userId="+user.getUserId();
		List haoyouList=haoyouDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<haoyouList.size();i++)
		{
			THaoyou haoyou=(THaoyou)haoyouList.get(i);
			haoyou.setHaoyou(userDAO.findById(haoyou.getHaoyouId()));
		}
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("haoyouList", haoyouList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String jiahaoyou()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
		
		String sql="from THaoyou where userId=? and haoyouId=?";
		Object[] c={user.getUserId(),Integer.parseInt(request.getParameter("haoyouId"))};
		List haoyouList=haoyouDAO.getHibernateTemplate().find(sql,c);
		if(haoyouList.size()>0)
		{
			request.setAttribute("msg", "改好友已经存在");
		}
		else
		{
			THaoyou haoyou=new THaoyou();
			
			haoyou.setUserId(user.getUserId());
			haoyou.setHaoyouId(Integer.parseInt(request.getParameter("haoyouId")));
			haoyou.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			
			haoyouDAO.save(haoyou);
			request.setAttribute("msg", "好友添加成功");
		}
				
		return "msg";
	}
	
	
	public String haoyouDel()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		THaoyou haoyou=haoyouDAO.findById(Integer.parseInt(request.getParameter("id")));
		haoyouDAO.delete(haoyou);
		
		request.setAttribute("msg", "好友删除成功");
		return "msg";
	}
	

	public THaoyouDAO getHaoyouDAO()
	{
		return haoyouDAO;
	}
	public void setHaoyouDAO(THaoyouDAO haoyouDAO)
	{
		this.haoyouDAO = haoyouDAO;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
}
