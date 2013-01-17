/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

import com.db2eshop.exception.ValidationException;
import com.db2eshop.model.support.AbstractModel;

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

	@Autowired(required = false)
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
	 * {@inheritDoc}
	 *
	 * <p>
	 * delete.
	 * </p>
	 */
	@Override
	public void delete(T entity) {
		log.debug("Deleting " + entity.getClass());

		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * deleteAll.
	 * </p>
	 */
	@Override
	public void deleteAll() {
		log.debug("Deleting all of " + this.clazz.getName());

		this.getHibernateTemplate().deleteAll(this.getHibernateTemplate().loadAll(this.clazz));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * evict.
	 * </p>
	 */
	@Override
	public void evict(T entity) {
		this.getHibernateTemplate().evict(entity);
	}

	/**
	 * <p>
	 * getCurrentSession.
	 * </p>
	 *
	 * @return a {@link org.hibernate.Session} object.
	 */
	public Session getCurrentSession() {
		return getSession();
	}

	/**
	 * <p>
	 * findAllIds.
	 * </p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Long> findAllIds() {
		org.hibernate.Query q = this.getSession().createQuery("Select id from " + this.clazz.getName());
		List<Long> ids = q.list();
		return ids;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * findAll.
	 * </p>
	 */
	@Override
	public List<T> findAll() {
		log.debug("Loading all Rows of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName());
	}

	/** {@inheritDoc} */
	@Override
	public List<T> findBy(String field, Object value) {
		log.debug("Finding by " + field + " = " + value.toString() + " of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field + "=?", value);
	}

	/** {@inheritDoc} */
	@Override
	public List<T> findBy(String field1, String field2, Object value1, Object value2) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " of " + this.clazz.getName());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field1 + "=? and " + field2 + "=?", value1, value2);
	}

	/** {@inheritDoc} */
	@Override
	public List<T> findBy(String field1, String field2, String field3, Object value1, Object value2, Object value3) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " and " + field3 + " = " + value3.toString() + "of " + this.clazz.getName());

		String query = "from " + this.clazz.getName() + " " + "where " + field1 + "=? " + "and " + field2 + "=? " + "and " + field3 + "=?";
		return this.getHibernateTemplate().find(query, value1, value2, value3);
	}

	/** {@inheritDoc} */
	@Override
	public T findById(Serializable id) {
		log.debug("Loading " + this.clazz.getName() + " by ID");
		if (id == null) {
			return null;
		}
		return ((T) this.getHibernateTemplate().get(this.clazz.getName(), id));
	}

	/** {@inheritDoc} */
	@Override
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
	@Override
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
	@Override
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
	 * {@inheritDoc}
	 *
	 * <p>
	 * flush.
	 * </p>
	 */
	@Override
	public void flush() {
		log.debug("Flushing Hibernate Session");

		this.getHibernateTemplate().flush();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * merge.
	 * </p>
	 */
	@Override
	public T merge(T entity) {
		return this.getHibernateTemplate().merge(entity);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * persist.
	 * </p>
	 */
	@Override
	public void persist(T entity) {
		this.getHibernateTemplate().persist(entity);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * refresh.
	 * </p>
	 */
	@Override
	public void refresh(T entity) {
		this.getHibernateTemplate().refresh(entity);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * rowCount.
	 * </p>
	 */
	@Override
	public int rowCount() {
		return this.findAll().size();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * save.
	 * </p>
	 */
	@Override
	public Serializable save(T entity) {
		log.debug("Saving " + entity.getClass());

		this.validate(entity);
		Serializable id = this.getHibernateTemplate().save(entity);
		entity.setId((Long) id);
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void saveAll(Collection<T> ts) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : ts) {
			this.save(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * saveAll.
	 * </p>
	 */
	@Override
	public void saveAll(T... entities) {
		log.debug("Saving Collection of Entities");

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
	 * {@inheritDoc}
	 *
	 * <p>
	 * saveOrUpdate.
	 * </p>
	 */
	@Override
	public void saveOrUpdate(T entity) {
		log.debug("Saving or updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().saveOrUpdate(entity);
		this.refresh(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void saveOrUpdateAll(Collection<T> ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
			this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * saveOrUpdateAll.
	 * </p>
	 */
	@Override
	public void saveOrUpdateAll(T... ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
			this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setReadOnly(T t, boolean readOnly) {
		log.debug((readOnly ? "S" : "Uns") + "etting " + this.clazz.getName() + " readonly");

		this.getSession().setReadOnly(t, readOnly);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * update.
	 * </p>
	 */
	@Override
	public void update(T entity) {
		log.debug("Updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().update(entity);
		this.refresh(entity);
	}

	/** {@inheritDoc} */
	@Override
	public void updateAll(Collection<T> entities) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * updateAll.
	 * </p>
	 */
	@Override
	public void updateAll(T... entities) {
		log.debug("Saving Collection of " + this.clazz.getName());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * validate.
	 * </p>
	 */
	@Override
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
