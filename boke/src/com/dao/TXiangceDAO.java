package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXiangce;

/**
 * Data access object (DAO) for domain model class TXiangce.
 * 
 * @see com.model.TXiangce
 * @author MyEclipse Persistence Tools
 */

public class TXiangceDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXiangceDAO.class);

	// property constants
	public static final String NAME = "name";

	public static final String USER_ID = "userId";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXiangce transientInstance)
	{
		log.debug("saving TXiangce instance");
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

	public void delete(TXiangce persistentInstance)
	{
		log.debug("deleting TXiangce instance");
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

	public TXiangce findById(java.lang.Integer id)
	{
		log.debug("getting TXiangce instance with id: " + id);
		try
		{
			TXiangce instance = (TXiangce) getHibernateTemplate().get(
					"com.model.TXiangce", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXiangce instance)
	{
		log.debug("finding TXiangce instance by example");
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
		log.debug("finding TXiangce instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXiangce as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TXiangce instances");
		try
		{
			String queryString = "from TXiangce";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXiangce merge(TXiangce detachedInstance)
	{
		log.debug("merging TXiangce instance");
		try
		{
			TXiangce result = (TXiangce) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXiangce instance)
	{
		log.debug("attaching dirty TXiangce instance");
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

	public void attachClean(TXiangce instance)
	{
		log.debug("attaching clean TXiangce instance");
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

	public static TXiangceDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXiangceDAO) ctx.getBean("TXiangceDAO");
	}
}