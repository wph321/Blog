package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.THaoyou;

/**
 * Data access object (DAO) for domain model class THaoyou.
 * 
 * @see com.model.THaoyou
 * @author MyEclipse Persistence Tools
 */

public class THaoyouDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(THaoyouDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(THaoyou transientInstance)
	{
		log.debug("saving THaoyou instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(THaoyou persistentInstance)
	{
		log.debug("deleting THaoyou instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public THaoyou findById(java.lang.Integer id)
	{
		log.debug("getting THaoyou instance with id: " + id);
		try
		{
			THaoyou instance = (THaoyou) getHibernateTemplate().get(
					"com.model.THaoyou", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(THaoyou instance)
	{
		log.debug("finding THaoyou instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding THaoyou instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from THaoyou as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all THaoyou instances");
		try
		{
			String queryString = "from THaoyou";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public THaoyou merge(THaoyou detachedInstance)
	{
		log.debug("merging THaoyou instance");
		try
		{
			THaoyou result = (THaoyou) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(THaoyou instance)
	{
		log.debug("attaching dirty THaoyou instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(THaoyou instance)
	{
		log.debug("attaching clean THaoyou instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static THaoyouDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (THaoyouDAO) ctx.getBean("THaoyouDAO");
	}
}