package com.model;

/**
 * TBowen generated by MyEclipse Persistence Tools
 */

public class TBowen implements java.io.Serializable
{

	// Fields

	private Integer id;

	private String title;

	private String content;

	private String shijian;

	private Integer userId;

	private String del;
	
	private int pinglunShu;

	// Constructors

	/** default constructor */

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return this.content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getShijian()
	{
		return this.shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public Integer getUserId()
	{
		return this.userId;
	}

	public int getPinglunShu()
	{
		return pinglunShu;
	}

	public void setPinglunShu(int pinglunShu)
	{
		this.pinglunShu = pinglunShu;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}


}