package com.db2eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Customer class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Customer extends AbstractModel<Customer> implements Serializable {
	private static final long serialVersionUID = 2121359969444535875L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Integer count;

	@Column
	private String city;

	@Column
	private String telephone;

	@Column
	private String preName;

	@Column
	private String birthday;

	@Column
	private String zipCode;

	@Column
	private String street;

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
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return a {@link java.lang.String} object.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * <p>Setter for the field <code>birthday</code>.</p>
	 *
	 * @param birthday a {@link java.lang.String} object.
	 */
	public void setBirthday(String birthday) {
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
	 * <p>Setter for the field <code>street</code>.</p>
	 *
	 * @param street a {@link java.lang.String} object.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + count;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (count != other.count)
			return false;
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
		return "Customer [id=" + id + ", name=" + name + ", count=" + count + ", city=" + city + ", telephone=" + telephone + ", preName=" + preName + ", birthday=" + birthday + ", zipCode=" + zipCode + ", street=" + street + "]";
	}
}
