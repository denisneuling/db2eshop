package com.db2eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIEmbedded;
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.NumberInput;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Sale class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Sale extends AbstractModel<Sale> implements Serializable {
	private static final long serialVersionUID = -9016685368451535775L;

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@UIBind(NumberInput.class)
	@Column(nullable = false)
	private Integer count = 0;

	@UIEmbedded
	@NotNull
	@ManyToOne(optional = false)
	private Article article;

	@UIEmbedded
	@NotNull
	@ManyToOne(optional = false)
	private Customer customer;

	@UIEmbedded
	@ManyToOne
	private Shipping shipping;

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
	public Integer getCount() {
		return count;
	}

	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a {@link java.lang.Integer} object.
	 */
	public void setCount(Integer count) {
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

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
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
