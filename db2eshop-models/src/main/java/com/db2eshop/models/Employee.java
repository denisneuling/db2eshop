package com.db2eshop.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Employee class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Employee extends AbstractModel<Employee> implements Serializable {
	private static final long serialVersionUID = 8135335874077911975L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String first_name;

	/**
	 * <p>
	 * Constructor for Employee.
	 * </p>
	 */
	public Employee() {
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
	 * <p>
	 * Getter for the field <code>name</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>
	 * Setter for the field <code>name</code>.
	 * </p>
	 *
	 * @param name
	 *            a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>
	 * Getter for the field <code>vorname</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFirst_Name() {
		return first_name;
	}

	/**
	 * <p>
	 * Setter for the field <code>first_name</code>.
	 * </p>
	 *
	 * @param vorname
	 *            a {@link java.lang.String} object.
	 */
	public void setVorname(String first_name) {
		this.first_name = first_name;
	}
}
