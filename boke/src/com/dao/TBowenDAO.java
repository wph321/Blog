package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBowen;

/**
 * Data access object (DAO) for domain model class TBowen.
 * 
 * @see com.model.TBowen
 * @author MyEclipse Persistence Tools
 */

public class TBowenDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TBowenDAO.class);

	// property constants
	public static final String TITLE = "title";

	public static final String CONTENT = "content";

	public static final String SHIJIAN = "shijian";

	public static final String USER_ID = "userId";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TBowen transientInstance)
	{
		log.debug("saving TBowen instance");
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

	public void delete(TBowen persistentInstance)
	{
		log.debug("deleting TBowen instance");
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

	public TBowen findById(java.lang.Integer id)
	{
		log.debug("getting TBowen instance with id: " + id);
		try
		{
			TBowen instance = (TBowen) getHibernateTemplate().get(
					"com.model.TBowen", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBowen instance)
	{
		log.debug("finding TBowen instance by example");
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
		log.debug("finding TBowen instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TBowen as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title)
	{
		return findByProperty(TITLE, title);
	}

	public List findByContent(Object content)
	{
		return findByProperty(CONTENT, content);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
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
		log.debug("finding all TBowen instances");
		try
		{
			String queryString = "from TBowen";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBowen merge(TBowen detachedInstance)
	{
		log.debug("merging TBowen instance");
		try
		{
			TBowen result = (TBowen) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBowen instance)
	{
		log.debug("attaching dirty TBowen instance");
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

	public void attachClean(TBowen instance)
	{
		log.debug("attaching clean TBowen instance");
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

	public static TBowenDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TBowenDAO) ctx.getBean("TBowenDAO");
	}
}