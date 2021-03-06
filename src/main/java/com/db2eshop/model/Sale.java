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
 * <p>Sale class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Sale extends AbstractModel<Sale> implements Serializable {
	private static final long serialVersionUID = -9016685368451535775L;

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
	@UIEmbedded
	@ManyToOne
	private Article article;

	@NotNull
	@UIEmbedded
	@ManyToOne
	private Customer customer;

	@UIEmbedded
	@ManyToOne
	private Shipping shipping;

	@NotNull
	@Past
    @UIBind(DateForm.class)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date = new Date();

	/**
	 * <p>
	 * Constructor for Sale.
	 * </p>
	 */
	public Sale() {
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
	 * <p>Getter for the field <code>customer</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Customer} object.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * <p>Setter for the field <code>customer</code>.</p>
	 *
	 * @param customer a {@link com.db2eshop.model.Customer} object.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * <p>Getter for the field <code>shipping</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Shipping} object.
	 */
	public Shipping getShipping() {
		return shipping;
	}

	/**
	 * <p>Setter for the field <code>shipping</code>.</p>
	 *
	 * @param shipping a {@link com.db2eshop.model.Shipping} object.
	 */
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
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

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shipping == null) ? 0 : shipping.hashCode());
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
		Sale other = (Sale) obj;
		if (count != other.count)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shipping == null) {
			if (other.shipping != null)
				return false;
		} else if (!shipping.equals(other.shipping))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return count + "x " + article + " by " + customer;
	}
}
