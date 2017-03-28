package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBowenDAO;
import com.dao.TPinglunDAO;
import com.dao.TUserDAO;
import com.dao.TXiangceDAO;
import com.dao.TZhaopianDAO;
import com.model.TBowen;
import com.model.TPinglun;
import com.model.TUser;
import com.model.TXiangce;
import com.model.TZhaopian;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class xiangceAction
{
    private int id;
	private String name;
	
	private TUserDAO userDAO;
	private TXiangceDAO xiangceDAO;
	private TZhaopianDAO zhaopianDAO;
	
	public String xiangceAdd()
	{
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
		
		TXiangce xiangce=new TXiangce();
		xiangce.setName(name);
		xiangce.setUserId(user.getUserId());
		xiangce.setDel("no");
		xiangceDAO.save(xiangce);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "相册新建成功");
		return "msg";
	}
	
	
	public String xiangceMana()
	{
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
        
		String sql="from TXiangce where del='no' and userId="+user.getUserId();
		List xiangceList=xiangceDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xiangceList.size();i++)
		{
			TXiangce xiangce=(TXiangce)xiangceList.get(i);
			String s="from TZhaopian where del='no' and xiangceId="+xiangce.getId();
			List zhaopianList=zhaopianDAO.getHibernateTemplate().find(s);
			xiangce.setZhaopianList(zhaopianList);
		}
		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiangceList", xiangceList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String xiangceDel()
	{
		String sql="update TXiangce set del='yes' where id="+id;
		xiangceDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "相册删除成功");
		return "msg";
	}
	
	
	public String zhaopianAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		TZhaopian zhaopian=new TZhaopian();
		zhaopian.setTitle(request.getParameter("title"));
		zhaopian.setFujian(request.getParameter("fujian"));
		zhaopian.setXiangceId(Integer.parseInt(request.getParameter("xiangceId")));
		zhaopian.setDel("no");
		zhaopianDAO.save(zhaopian);
		
		request.setAttribute("msg", "上传图片成功");
		return "msg";
	}
	
	public String zhaopianDel()
	{
		String sql="update TZhaopian set del='yes' where id="+id;
		xiangceDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "照片删除成功");
		return "msg";
	}
	
	public String xiangceAll()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		String sql="from TXiangce where del='no' and userId="+userId;
		List xiangceList=xiangceDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xiangceList.size();i++)
		{
			TXiangce xiangce=(TXiangce)xiangceList.get(i);
			String s="from TZhaopian where del='no' and xiangceId="+xiangce.getId();
			List zhaopianList=zhaopianDAO.getHibernateTemplate().find(s);
			xiangce.setZhaopianList(zhaopianList);
		}
		
		request.setAttribute("xiangceList", xiangceList);
		
		TUser user=userDAO.findById(userId);
		request.setAttribute("user", user);
		
		
		return ActionSupport.SUCCESS;
	}
	
	public String xiangceMana_admin()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TXiangce where del='no'";
		List xiangceList=xiangceDAO.getHibernateTemplate().find(sql);
		
		request.put("xiangceList", xiangceList);
		
		return ActionSupport.SUCCESS;
	}
	
	public String zhaopianMana_admin()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from TZhaopian where del='no' and xiangceId="+Integer.parseInt(request.getParameter("xiangceId"));
		List zhaopianList=zhaopianDAO.getHibernateTemplate().find(s);
		
		request.setAttribute("zhaopianList", zhaopianList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhaopianDel_admin()
	{
		String sql="update TZhaopian set del='yes' where id="+id;
		xiangceDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "照片删除成功");
		return "msg";
	}

	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public TXiangceDAO getXiangceDAO()
	{
		return xiangceDAO;
	}


	public void setXiangceDAO(TXiangceDAO xiangceDAO)
	{
		this.xiangceDAO = xiangceDAO;
	}


	public TZhaopianDAO getZhaopianDAO()
	{
		return zhaopianDAO;
	}


	public void setZhaopianDAO(TZhaopianDAO zhaopianDAO)
	{
		this.zhaopianDAO = zhaopianDAO;
	}
	
}
