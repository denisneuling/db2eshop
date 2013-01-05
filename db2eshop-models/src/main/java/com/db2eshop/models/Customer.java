package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Customer class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Customer extends AbstractModel<Customer> {
	private static final long serialVersionUID = ;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private int count;

	@Column
	private String city;
	
	@Column
	private String telephone;
	
	@Column
	private String first_name;

	@Column
	private String birthday;
	
	@Column
	private String zip_code;
	
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
	 * @param first_name
	 *            a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <p>
	 * Getter for the field <code>first_name</code>.
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
	 * @param name
	 *            a {@link java.lang.String} object.
	 */
	public void setFirst_Name(String first_name) {
		this.first_name = first_name;
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
	 * Getter for the field <code>birthday</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * <p>
	 * Setter for the field <code>birthday</code>.
	 * </p>
	 *
	 * @param birthday
	 *            a {@link java.lang.String} object.
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}

	/**
	 * <p>
	 * Getter for the field <code>zip_code</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getZip_Code() {
		return zip_code;
	}
	
	/**
	 * <p>
	 * Setter for the field <code>zip_code</code>.
	 * </p>
	 *
	 * @param zip_code
	 *            a {@link java.lang.String} object.
	 */
	public void setZip_Code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	/**
	 * <p>
	 * Getter for the field <code>street</code>.
	 * </p>
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
}