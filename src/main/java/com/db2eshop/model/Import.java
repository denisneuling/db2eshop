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
import javax.validation.constraints.NotNull;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIEmbedded;
import com.db2eshop.gui.component.io.DateInput;
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.NumberInput;
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

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@UIBind(NumberInput.class)
	@Column(nullable = false)
	private Integer count = 0;

	@NotNull
	@UIBind(DateInput.class)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date = new Date();

	@UIEmbedded
	@ManyToOne
	private Employee employee;

	@UIEmbedded
	@ManyToOne
	private Article article;

	@UIEmbedded
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
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
