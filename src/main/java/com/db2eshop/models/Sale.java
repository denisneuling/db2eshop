package com.db2eshop.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Sale class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Sale extends AbstractModel<Sale> implements Serializable {
	private static final long serialVersionUID = -9016685368451535775L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int count;

//	@ManyToOne
//	private Set<Article> articles;

	@Column
	private Customer customer;

	@Column
	private Shipping shipping;

	public Sale() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

//	public Set<Article> getArticles() {
//		return articles;
//	}
//
//	public void setArticles(Set<Article> articles) {
//		this.articles = articles;
//	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
}
