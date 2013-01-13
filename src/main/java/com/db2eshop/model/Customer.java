package com.db2eshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.DateInput;
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.TextInput;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Customer class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Customer extends AbstractModel<Customer> implements Serializable {
	private static final long serialVersionUID = 2121359969444535875L;

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String surName;

	@UIBind(TextInput.class)
	@Column
	private String telephone;

	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String preName;

	@UIBind(DateInput.class)
	@Temporal(TemporalType.DATE)
	@Column
	private Date birthday;

	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String street;

	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String city;

	@UIBind(TextInput.class)
	@Column
	private String zipCode;

	@UIHide
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Sale> sales = new LinkedList<Sale>();

	/**
	 * <p>
	 * Constructor for Customer.
	 * </p>
	 */
	public Customer() {
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
	 * <p>Getter for the field <code>surName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * <p>Setter for the field <code>surName</code>.</p>
	 *
	 * @param surName a {@link java.lang.String} object.
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * <p>Getter for the field <code>city</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <p>Setter for the field <code>city</code>.</p>
	 *
	 * @param city a {@link java.lang.String} object.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <p>Getter for the field <code>telephone</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * <p>Setter for the field <code>telephone</code>.</p>
	 *
	 * @param telephone a {@link java.lang.String} object.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * <p>Getter for the field <code>preName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPreName() {
		return preName;
	}

	/**
	 * <p>Setter for the field <code>preName</code>.</p>
	 *
	 * @param preName a {@link java.lang.String} object.
	 */
	public void setPreName(String preName) {
		this.preName = preName;
	}

	/**
	 * <p>Getter for the field <code>birthday</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * <p>Setter for the field <code>birthday</code>.</p>
	 *
	 * @param birthday a {@link java.util.Date} object.
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * <p>Getter for the field <code>zipCode</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * <p>Setter for the field <code>zipCode</code>.</p>
	 *
	 * @param zipCode a {@link java.lang.String} object.
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * <p>Getter for the field <code>street</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <p>
	 * Setter for the field <code>street</code>.
	 * </p>
	 *
	 * @param street
	 *            a {@link java.lang.String} object.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * <p>Getter for the field <code>sales</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Sale> getSales() {
		return sales;
	}

	/**
	 * <p>Setter for the field <code>sales</code>.</p>
	 *
	 * @param sales a {@link java.util.List} object.
	 */
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((preName == null) ? 0 : preName.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Customer other = (Customer) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (preName == null) {
			if (other.preName != null)
				return false;
		} else if (!preName.equals(other.preName))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return id + " " + preName + " " + surName;
	}
}
