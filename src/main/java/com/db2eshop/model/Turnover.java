package com.db2eshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.gui.component.io.DateForm;
import com.db2eshop.gui.component.io.DoubleForm;
import com.db2eshop.gui.component.io.IdForm;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Turnover class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Turnover extends AbstractModel<Turnover> {
	private static final long serialVersionUID = 6139702053298999338L;

	@UIBind(IdForm.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@UIBind(DateForm.class)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	@NotNull
	@UIBind(DoubleForm.class)
	@Column(nullable = false)	
	private Double turnover = 0D;

	/**
	 * <p>Constructor for Turnover.</p>
	 */
	public Turnover(){
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
	 * <p>Getter for the field <code>turnover</code>.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getTurnover() {
		return turnover;
	}

	/**
	 * <p>Setter for the field <code>turnover</code>.</p>
	 *
	 * @param turnover a {@link java.lang.Double} object.
	 */
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}
	
	

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Turnover other = (Turnover) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
