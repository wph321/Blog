package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBowenDAO;
import com.dao.TPinglunDAO;
import com.dao.TUserDAO;
import com.model.TBowen;
import com.model.TPinglun;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bowenAction
{
    private int id;
	private String title;
	private String content;
	
	private TBowenDAO bowenDAO;
	private TUserDAO userDAO;
	private TPinglunDAO pinglunDAO;
	
	private String message;
	private String path;
	
	public String bowenMana()
	{
        Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
				
		String sql="from TBowen where del='no' and userId="+user.getUserId();
		List bowenList=bowenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<bowenList.size();i++)
		{
			TBowen bowen=(TBowen)bowenList.get(i);
			String s="from TPinglun where bowenId="+bowen.getId();
			List pinglunList=pinglunDAO.getHibernateTemplate().find(s);
			bowen.setPinglunShu(pinglunList.size());
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bowenList", bowenList);
		return ActionSupport.SUCCESS;
	}
	
	public String bowenAdd()
	{
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
		
		TBowen bowen=new TBowen();
		bowen.setTitle(title);
		bowen.setContent(content);
		bowen.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		bowen.setUserId(user.getUserId());
		bowen.setDel("no");
		
		bowenDAO.save(bowen);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "博文发布成功");
		return "msg";
	}
	
	
	
	
	public String bowenDel()
	{
		TBowen bowen=bowenDAO.findById(id);
		bowen.setDel("yes");
		bowenDAO.getHibernateTemplate().update(bowen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "博文删除成功");
		return "msg";
	}
	
	public String pinglunMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from TPinglun where bowenId="+Integer.parseInt(request.getParameter("bowenId"));
		List pinglunList=pinglunDAO.getHibernateTemplate().find(s);
		request.setAttribute("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}
	
	public String pinglunDel()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="delete from TPinglun where id="+Integer.parseInt(request.getParameter("id"));
		bowenDAO.getHibernateTemplate().bulkUpdate(sql);
		
		request.setAttribute("msg", "评论删除成功");
		return "msg";
	}
	
	
	public String pinglunAll()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from TPinglun where bowenId="+Integer.parseInt(request.getParameter("bowenId"));
		List pinglunList=pinglunDAO.getHibernateTemplate().find(s);
		request.setAttribute("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}

	public String pinglunAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		TPinglun pinglun=new TPinglun();
		pinglun.setContent(request.getParameter("content"));
		pinglun.setShjian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		pinglun.setBowenId(Integer.parseInt(request.getParameter("bowenId")));
		
		pinglunDAO.save(pinglun);
		request.setAttribute("msg", "写评论成功");
		return "msg";
	}
	
	
	public String bowenAll()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		TUser user=userDAO.findById(Integer.parseInt(request.getParameter("userId")));
		user.setFangwenliang(user.getFangwenliang()+1);
		userDAO.getHibernateTemplate().update(user);
		request.setAttribute("user", user);
		
		String sql="from TBowen where del='no' and userId="+Integer.parseInt(request.getParameter("userId"));
		List bowenList=bowenDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<bowenList.size();i++)
		{
			TBowen bowen=(TBowen)bowenList.get(i);
			String s="from TPinglun where bowenId="+bowen.getId();
			List pinglunList=pinglunDAO.getHibernateTemplate().find(s);
			bowen.setPinglunShu(pinglunList.size());
		}
		
		request.setAttribute("bowenList", bowenList);
		
		return ActionSupport.SUCCESS;
	}

	
	
	public String bowenMana_admin()
	{
		String sql="from TBowen where del='no'";
		List bowenList=bowenDAO.getHibernateTemplate().find(sql);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("bowenList", bowenList);
		return ActionSupport.SUCCESS;
		
	}
	
	public String bowenDel_admin()
	{
		TBowen bowen=bowenDAO.findById(id);
		bowen.setDel("yes");
		bowenDAO.getHibernateTemplate().update(bowen);
		
		this.setMessage("操作成功");
		this.setPath("bowenMana_admin.action");
		return "succeed";
	}
	
	public String bowenDetail()
	{
		TBowen bowen=bowenDAO.findById(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("bowen", bowen);
		return ActionSupport.SUCCESS;
	}
	
	public String pinglunMana_admin()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String s="from TPinglun where bowenId="+Integer.parseInt(request.getParameter("bowenId"));
		List pinglunList=pinglunDAO.getHibernateTemplate().find(s);
		request.setAttribute("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}
	
	public String pinglunDel_admin()
	{
        HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="delete from TPinglun where id="+Integer.parseInt(request.getParameter("id"));
		bowenDAO.getHibernateTemplate().bulkUpdate(sql);
		
		request.setAttribute("msg", "评论删除成功");
		return "msg";
	}
	
	public TBowenDAO getBowenDAO()
	{
		return bowenDAO;
	}

	public void setBowenDAO(TBowenDAO bowenDAO)
	{
		this.bowenDAO = bowenDAO;
	}

	public String getContent()
	{
		return content;
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




	public void setPath(String path)
	{
		this.path = path;
	}




	public void setContent(String content)
	{
		this.content = content;
	}

	public TPinglunDAO getPinglunDAO()
	{
		return pinglunDAO;
	}


	public void setPinglunDAO(TPinglunDAO pinglunDAO)
	{
		this.pinglunDAO = pinglunDAO;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
}
