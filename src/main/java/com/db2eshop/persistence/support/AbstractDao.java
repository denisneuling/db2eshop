package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.db2eshop.model.support.AbstractModel;
import com.db2eshop.persistence.exception.ValidationException;

/**
 * <p>
 * Abstract AbstractDao class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
@SuppressWarnings({ "unchecked" })
public abstract class AbstractDao<T extends AbstractModel<T>> extends HibernateDaoSupport implements GenericDaoCrudOperations<T>, GenericDaoOperations<T> {
	protected final Logger log = Logger.getLogger(getClass());

	@Autowired
	(required = false)
	protected LocalValidatorFactoryBean validator;

	protected Class<T> clazz;

	/**
	 * <p>
	 * Constructor for AbstractDao.
	 * </p>
	 */
	public AbstractDao() {
	}

	/**
	 * <p>
	 * Constructor for AbstractDao.
	 * </p>
	 *
	 * @param sessionFactory
	 *            a {@link org.hibernate.SessionFactory} object.
	 * @param clazz
	 *            a {@link java.lang.Class} object.
	 */
	public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
		this.setSessionFactory(sessionFactory);
		this.clazz = clazz;
	}

	/**
	 * <p>
	 * delete.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void delete(T entity) {
		log.debug("Deleting " + entity.getClass());

		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * <p>
	 * deleteAll.
	 * </p>
	 */
	public void deleteAll() {
		log.debug("Deleting all of " + this.clazz.getName());

		this.getHibernateTemplate().deleteAll(this.getHibernateTemplate().loadAll(this.clazz));
	}

	/**
	 * <p>
	 * evict.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void evict(T entity) {
		this.getHibernateTemplate().evict(entity);
	}

	/**
	 * <p>getCurrentSession.</p>
	 *
	 * @return a {@link org.hibernate.Session} object.
	 */
	public Session getCurrentSession() {
		return getSession();
	}

	/**
	 * <p>findAllIds.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Long> findAllIds() {
		org.hibernate.Query q = this.getSession().createQuery("Select id from " + this.clazz.getName());
		List<Long> ids = q.list();
		return ids;
	}

	/**
	 * <p>
	 * findAll.
	 * </p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<T> findAll() {
		log.debug("Loading all Rows of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName());
	}

	/** {@inheritDoc} */
	public List<T> findBy(String field, Object value) {
		log.debug("Finding by " + field + " = " + value.toString() + " of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field + "=?", value);
	}

	/** {@inheritDoc} */
	public List<T> findBy(String field1, String field2, Object value1, Object value2) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field1 + "=? and " + field2 + "=?", value1, value2);
	}

	/** {@inheritDoc} */
	public List<T> findBy(String field1, String field2, String field3, Object value1, Object value2, Object value3) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " and " + field3 + " = " + value3.toString() + "of " + this.clazz.getName());

		String query = "from " + this.clazz.getName() + " " + "where " + field1 + "=? " + "and " + field2 + "=? " + "and " + field3 + "=?";
		return this.getHibernateTemplate().find(query, value1, value2, value3);
	}

	/** {@inheritDoc} */
	public T findById(Serializable id) {
		log.debug("Loading " + this.clazz.getName() + " by ID");
		if(id == null){
			return null;
		}
		return ((T) this.getHibernateTemplate().get(this.clazz.getName(), id));
	}

	/** {@inheritDoc} */
	public T findUniqueBy(String field, Object value) {
		log.debug("Finding unique by " + field + " = " + value.toString() + " of " + this.clazz.getName());

		String query = "from " + this.clazz.getName() + " " + "where " + field + "=?";

		List<T> entities = this.getHibernateTemplate().find(query, value);

		if (entities == null || entities.size() == 0) {
			return null;
		} else if (entities.size() == 1) {
			return entities.get(0);
		} else {
			throw new RuntimeException("The field " + field + " is not unique");
		}
	}

	/** {@inheritDoc} */
	public T findUniqueBy(String field1, String field2, Object value1, Object value2) {
		log.debug("Finding unique by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " of " + this.clazz.getName());

		String query = "from " + this.clazz.getName() + " " + "where " + field1 + "=? " + "and " + field2 + "=?";

		List<T> entities = this.getHibernateTemplate().find(query, value1, value2);

		if (entities == null || entities.size() == 0) {
			return null;
		} else if (entities.size() == 1) {
			return entities.get(0);
		} else {
			throw new RuntimeException("The field " + field1 + " or " + field2 + " is not unique");
		}
	}

	/** {@inheritDoc} */
	public T findUniqueBy(String field1, String field2, String field3, Object value1, Object value2, Object value3) {
		log.debug("Finding unique by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " and " + field3 + " = " + value3.toString() + "of " + this.clazz.getName());

		String query = "from " + this.clazz.getName() + " " + "where " + field1 + "=? " + "and " + field2 + "=? " + "and " + field3 + "=? ";

		List<T> entities = this.getHibernateTemplate().find(query, value1, value2, value3);

		if (entities == null || entities.size() == 0) {
			return null;
		} else if (entities.size() == 1) {
			return entities.get(0);
		} else {
			throw new RuntimeException("The field " + field1 + " or " + field2 + " is not unique");
		}
	}

	/**
	 * <p>
	 * flush.
	 * </p>
	 */
	public void flush() {
		log.debug("Flushing Hibernate Session");

		this.getHibernateTemplate().flush();
	}

	/**
	 * <p>
	 * merge.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 * @return a T object.
	 */
	public T merge(T entity) {
		return this.getHibernateTemplate().merge(entity);
	}

	/**
	 * <p>
	 * persist.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void persist(T entity) {
		this.getHibernateTemplate().persist(entity);
	}

	/**
	 * <p>
	 * refresh.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void refresh(T entity) {
		this.getHibernateTemplate().refresh(entity);
	}

	/**
	 * <p>
	 * rowCount.
	 * </p>
	 *
	 * @return a int.
	 */
	public int rowCount() {
		return this.findAll().size();
	}

	/**
	 * <p>
	 * save.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 * @return a {@link java.io.Serializable} object.
	 */
	public Serializable save(T entity) {
		log.debug("Saving " + entity.getClass());

		this.validate(entity);
		Serializable id = this.getHibernateTemplate().save(entity);
		entity.setId((Long) id);
		return id;
	}

	/** {@inheritDoc} */
	public void saveAll(Collection<T> ts) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : ts) {
			this.save(entity);
		}
	}

	/**
	 * <p>
	 * saveAll.
	 * </p>
	 *
	 * @param entities
	 *            a T object.
	 */
	public void saveAll(T... entities) {
		log.debug("Saving Collection of untyped Entities");

		for (T entity : entities) {
			this.save(entity);
		}
	}

	/**
	 * Attention! THIS is not tested.
	 * <p>
	 * saveAndFlush.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 * @return a {@link java.io.Serializable} object.
	 */
	@Lazy(value = false)
	public Serializable saveAndFlush(T entity) {
		Serializable id = this.save(entity);
		this.flush();
		return id;
	}

	/**
	 * <p>
	 * saveOrUpdate.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void saveOrUpdate(T entity) {
		log.debug("Saving or updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().saveOrUpdate(entity);
		this.refresh(entity);
	}

	/** {@inheritDoc} */
	public void saveOrUpdateAll(Collection<T> ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
			// this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	/**
	 * <p>
	 * saveOrUpdateAll.
	 * </p>
	 *
	 * @param ts
	 *            a T object.
	 */
	public void saveOrUpdateAll(T... ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
			this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	/** {@inheritDoc} */
	public void setReadOnly(T t, boolean readOnly) {
		log.debug((readOnly ? "S" : "Uns") + "etting " + this.clazz.getName() + " readonly");

		this.getSession().setReadOnly(t, readOnly);
	}

	/**
	 * <p>
	 * update.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void update(T entity) {
		log.debug("Updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().update(entity);
		this.refresh(entity);
	}

	/** {@inheritDoc} */
	public void updateAll(Collection<T> entities) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	/**
	 * <p>
	 * updateAll.
	 * </p>
	 *
	 * @param entities
	 *            a T object.
	 */
	public void updateAll(T... entities) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	/**
	 * <p>
	 * validate.
	 * </p>
	 *
	 * @param entity
	 *            a T object.
	 */
	public void validate(T entity) {
		log.debug("Validating " + entity.getClass());
		if (validator != null) {

			Set<ConstraintViolation<T>> constraintViolations = this.validator.validate(entity);
			if (constraintViolations.size() > 0) {
				throw new ValidationException(constraintViolations);
			}
		}
	}

}
