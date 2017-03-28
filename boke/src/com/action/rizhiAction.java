package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBowenDAO;
import com.dao.TPinglunDAO;
import com.dao.TRizhiDAO;
import com.dao.TUserDAO;
import com.model.TBowen;
import com.model.TPinglun;
import com.model.TRizhi;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class rizhiAction
{
    private int id;
	private String title;
	private String content;
	
	private TRizhiDAO rizhiDAO;
	
	private String message;
	private String path;
	
	public String rizhiMana()
	{
        Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
				
		String sql="from TRizhi where userId="+user.getUserId();
		List rizhiList=rizhiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("rizhiList", rizhiList);
		return ActionSupport.SUCCESS;
	}
	
	public String rizhiAdd()
	{
		Map session=ActionContext.getContext().getSession();
        TUser user=(TUser)session.get("user");
		
		TRizhi rizhi=new TRizhi();
		rizhi.setTitle(title);
		rizhi.setContent(content);
		rizhi.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		rizhi.setUserId(user.getUserId());
		
		rizhiDAO.save(rizhi);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "日志发布成功");
		return "msg";
	}
	
	
	
	
	public String rizhiDel()
	{
		TRizhi rizhi=rizhiDAO.findById(id);
		rizhiDAO.delete(rizhi);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "日志删除成功");
		return "msg";
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public TRizhiDAO getRizhiDAO()
	{
		return rizhiDAO;
	}

	public void setRizhiDAO(TRizhiDAO rizhiDAO)
	{
		this.rizhiDAO = rizhiDAO;
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
