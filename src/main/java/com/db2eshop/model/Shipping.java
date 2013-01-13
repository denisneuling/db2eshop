package com.db2eshop.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.NumberInput;
import com.db2eshop.gui.component.io.TextInput;
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

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@NotEmpty
	@UIBind(TextInput.class)
	@Column(nullable = false, unique = true)
	private String name;

	@NotNull
	@NotEmpty
	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String city;

	@NotNull
	@UIBind(NumberInput.class)
	@Column(nullable = false)
	private Integer zipCode;

	@NotNull
	@NotEmpty
	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String telephone;

	@UIHide
	@OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
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
