package com.db2eshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Import class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Import extends AbstractModel<Import> implements Serializable {
	private static final long serialVersionUID = -8663449394006905708L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Integer count;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	/**
	 * <p>Constructor for Import.</p>
	 */
	public Import() {
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>Getter for the field <code>count</code>.</p>
	 *
	 * @return a int.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a int.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * <p>Getter for the field <code>date</code>.</p>
	 *
	 * @return a int.
	 */
	public int getDate() {
		return count;
	}

	/**
	 * <p>Setter for the field <code>date</code>.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Import other = (Import) obj;
		if (count != other.count)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Import [id=" + id + ", count=" + count + ", date=" + date + "]";
	}
}
