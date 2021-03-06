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
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.IdForm;
import com.db2eshop.gui.component.io.LongForm;
import com.db2eshop.gui.component.io.TextForm;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Shipping class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Shipping extends AbstractModel<Shipping> implements Serializable {
	private static final long serialVersionUID = 5311617211485240660L;

	@UIBind(IdForm.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	@Length(max = 255)
	@UIBind(TextForm.class)
	@Column(nullable = false, unique = true)
	private String name;

	@NotNull
	@NotEmpty
	@Length(max = 255)
	@UIBind(TextForm.class)
	@Column(nullable = false)
	private String city;

	@NotNull
	@Min(0)
	@UIBind(LongForm.class)
	@Column(nullable = false)
	private Long zipCode;

	@NotNull
	@NotEmpty
	@Length(max = 255)
	@UIBind(TextForm.class)
	@Column(nullable = false)
	private String telephone;

	@UIHide
	@OneToMany(mappedBy = "shipping", fetch = FetchType.LAZY)
	private List<Sale> sales = new LinkedList<Sale>();

	/**
	 * <p>
	 * Constructor for Shipping.
	 * </p>
	 */
	public Shipping() {
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
	 * Getter for the field <code>city</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <p>
	 * Setter for the field <code>city</code>.
	 * </p>
	 *
	 * @param city
	 *            a {@link java.lang.String} object.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <p>
	 * Getter for the field <code>zipCode</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Long getZipCode() {
		return zipCode;
	}

	/**
	 * <p>
	 * Setter for the field <code>zipCode</code>.
	 * </p>
	 *
	 * @param zipCode
	 *            a {@link java.lang.Integer} object.
	 */
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * <p>
	 * Getter for the field <code>telephone</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * <p>
	 * Setter for the field <code>telephone</code>.
	 * </p>
	 *
	 * @param telephone
	 *            a {@link java.lang.String} object.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * <p>
	 * Getter for the field <code>sales</code>.
	 * </p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Sale> getSales() {
		return sales;
	}

	/**
	 * <p>
	 * Setter for the field <code>sales</code>.
	 * </p>
	 *
	 * @param sales
	 *            a {@link java.util.List} object.
	 */
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Shipping other = (Shipping) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return name + " " + city;
	}

}
