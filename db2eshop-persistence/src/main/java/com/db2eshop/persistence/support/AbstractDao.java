package com.db2eshop.persistence.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.db2eshop.models.support.AbstractModel;
import com.db2eshop.persistence.exception.ValidationException;


@SuppressWarnings({ "unchecked" })
@Component
public abstract class AbstractDao<T extends AbstractModel<T>> extends HibernateDaoSupport implements GenericDaoCrudOperations<T>, GenericDaoOperations<T> {
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	protected LocalValidatorFactoryBean validator;

	protected Class<T> clazz;

	public AbstractDao() {
	}

	public AbstractDao(SessionFactory sessionFactory, Class<T> clazz) {
		this.setSessionFactory(sessionFactory);
		this.clazz = clazz;
	}

	public void delete(T entity) {
		log.debug("Deleting " + entity.getClass());

		this.getHibernateTemplate().delete(entity);
	}

	public void deleteAll() {
		log.debug("Deleting all of " + this.clazz.getClass());

		this.getHibernateTemplate().deleteAll(this.getHibernateTemplate().loadAll(this.clazz));
	}

	public void evict(T entity) {
		this.getHibernateTemplate().evict(entity);
	}

	public List<T> findAll() {
		log.debug("Loading all Rows of " + this.clazz.getClass());

		return this.getHibernateTemplate().loadAll(this.clazz);
	}

	public List<T> findBy(String field, Object value) {
		log.debug("Finding by " + field + " = " + value.toString() + " of " + this.clazz.getClass());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field + "=?", value);
	}

	public List<T> findBy(String field1, String field2, Object value1, Object value2) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " of " + this.clazz.getClass());

		return this.getHibernateTemplate().find("from " + this.clazz.getName() + " where " + field1 + "=? and " + field2 + "=?", value1, value2);
	}

	public List<T> findBy(String field1, String field2, String field3, Object value1, Object value2, Object value3) {
		log.debug("Finding by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " and " + field3 + " = " + value3.toString() + "of " + this.clazz.getClass());

		String query = "from " + this.clazz.getName() + " " + "where " + field1 + "=? " + "and " + field2 + "=? " + "and " + field3 + "=?";
		return this.getHibernateTemplate().find(query, value1, value2, value3);
	}

	public T findById(Serializable id) {
		log.debug("Loading " + this.clazz.getClass() + " by ID");

		return ((T) this.getHibernateTemplate().load(this.clazz, id));
	}

	public T findUniqueBy(String field, Object value) {
		log.debug("Finding unique by " + field + " = " + value.toString() + " of " + this.clazz.getClass());

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

	public T findUniqueBy(String field1, String field2, Object value1, Object value2) {
		log.debug("Finding unique by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " of " + this.clazz.getClass());

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

	public T findUniqueBy(String field1, String field2, String field3, Object value1, Object value2, Object value3) {
		log.debug("Finding unique by " + field1 + " = " + value1.toString() + " and " + field2 + " = " + value2.toString() + " and " + field3 + " = " + value3.toString() + "of " + this.clazz.getClass());

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

	public void flush() {
		log.debug("Flushing Hibernate Session");

		this.getHibernateTemplate().flush();
	}

	public T merge(T entity) {
		return this.getHibernateTemplate().merge(entity);
	}

	public void persist(T entity) {
		this.getHibernateTemplate().persist(entity);
	}

	public void refresh(T entity) {
		this.getHibernateTemplate().refresh(entity);
	}

	public int rowCount() {
		return this.findAll().size();
	}

	public Serializable save(T entity) {
		log.debug("Saving " + entity.getClass());

		this.validate(entity);
		Serializable id = this.getHibernateTemplate().save(entity);
		/*
		 * refreshing all save actions might be evil
		 */
		// this.refresh(entity);
		return id;
	}

	public void saveAll(Collection<T> ts) {
		log.debug("Saving Collection of " + this.clazz.getClass());

		for (T entity : ts) {
			this.save(entity);
		}
	}

	public void saveAll(T... entities) {
		log.debug("Saving Collection of untyped Entities");

		for (T entity : entities) {
			this.save(entity);
		}
	}

	/*
	 * Attention! THIS is not tested.
	 * 
	 * @param t
	 * 
	 * @return
	 */
	@Lazy(value = false)
	public Serializable saveAndFlush(T entity) {
		Serializable id = this.save(entity);
		this.flush();
		return id;
	}

	public void saveOrUpdate(T entity) {
		log.debug("Saving or updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().saveOrUpdate(entity);
		this.refresh(entity);
	}

	public void saveOrUpdateAll(Collection<T> ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
//			this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	public void saveOrUpdateAll(T... ts) {
		log.debug("Saving or updating collection");

		for (T entity : ts) {
			this.validate(entity);
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	public void setReadOnly(T t, boolean readOnly) {
		log.debug((readOnly ? "S" : "Uns") + "etting " + this.clazz.getClass() + " readonly");

		this.getSession().setReadOnly(t, readOnly);
	}

	public void update(T entity) {
		log.debug("Updating " + entity.getClass());

		this.validate(entity);
		this.getHibernateTemplate().update(entity);
		this.refresh(entity);
	}

	public void updateAll(Collection<T> entities) {
		log.debug("Saving Collection of " + this.clazz.getClass());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	public void updateAll(T... entities) {
		log.debug("Saving Collection of " + this.clazz.getClass());

		for (T entity : entities) {
			this.validate(entity);
			this.update(entity);
		}
	}

	public void validate(T entity) {
		log.debug("Validating " + entity.getClass());

		Set<ConstraintViolation<T>> constraintViolations = this.validator.validate(entity);
		if (constraintViolations.size() > 0) {
			throw new ValidationException(constraintViolations);
		}
	}
	
}