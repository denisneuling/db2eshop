package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Article class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Article extends AbstractModel<Article> {
	private static final long serialVersionUID = 6709110157288379399L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private int count;

	@Column
	private String description;

	/**
	 * <p>
	 * Constructor for Article.
	 * </p>
	 */
	public Article() {
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
	 * Getter for the field <code>count</code>.
	 * </p>
	 *
	 * @return a int.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <p>
	 * Setter for the field <code>count</code>.
	 * </p>
	 *
	 * @param count
	 *            a int.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * <p>
	 * Getter for the field <code>description</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>
	 * Setter for the field <code>description</code>.
	 * </p>
	 *
	 * @param description
	 *            a {@link java.lang.String} object.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
