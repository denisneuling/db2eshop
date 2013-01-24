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
package com.db2eshop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIEmbedded;
import com.db2eshop.gui.component.io.DateForm;
import com.db2eshop.gui.component.io.IdForm;
import com.db2eshop.gui.component.io.LongForm;
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

	@UIBind(IdForm.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Min(0)
	@UIBind(LongForm.class)
	@Column(nullable = false)
	private Long count = 0L;

	@NotNull
	@Past
	@UIBind(DateForm.class)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date = new Date();

	@UIEmbedded
	@NotNull
	@ManyToOne
	private Employee employee;

	@UIEmbedded
	@NotNull
	@ManyToOne
	private Article article;

	@UIEmbedded
	@NotNull
	@ManyToOne
	private Supplier supplier;

	/**
	 * <p>
	 * Constructor for Import.
	 * </p>
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
	 * @return a {@link java.lang.Integer} object.
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a {@link java.lang.Integer} object.
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * <p>Getter for the field <code>date</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <p>Setter for the field <code>date</code>.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * <p>Getter for the field <code>employee</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Employee} object.
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * <p>Setter for the field <code>employee</code>.</p>
	 *
	 * @param employee a {@link com.db2eshop.model.Employee} object.
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * <p>Getter for the field <code>article</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Article} object.
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * <p>Setter for the field <code>article</code>.</p>
	 *
	 * @param article a {@link com.db2eshop.model.Article} object.
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * <p>Getter for the field <code>supplier</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Supplier} object.
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * <p>Setter for the field <code>supplier</code>.</p>
	 *
	 * @param supplier a {@link com.db2eshop.model.Supplier} object.
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		return id + " " + date;
	}
}
