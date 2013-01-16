package com.db2eshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.gui.component.io.BookingTypeForm;
import com.db2eshop.gui.component.io.DateForm;
import com.db2eshop.gui.component.io.DoubleForm;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Booking class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Booking extends AbstractModel<Booking>{
	private static final long serialVersionUID = 1378660349450284956L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@NotNull
	@UIBind(BookingTypeForm.class)
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@NotNull
	@UIBind(DoubleForm.class)
	@Column(nullable = false)	
	private Double amount = 0D;
	
	@NotNull
	@UIBind(DateForm.class)
//	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	/**
	 * <p>Constructor for Booking.</p>
	 */
	public Booking(){
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
	 * <p>Getter for the field <code>type</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.Booking.Type} object.
	 */
	public Type getType() {
		return type;
	}

	/**
	 * <p>Setter for the field <code>type</code>.</p>
	 *
	 * @param type a {@link com.db2eshop.model.Booking.Type} object.
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * <p>Getter for the field <code>amount</code>.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * <p>Setter for the field <code>amount</code>.</p>
	 *
	 * @param amount a {@link java.lang.Double} object.
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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

	public enum Type {
		IMPORT(0), SALE(1), SKONTO(2);
		
		private int type;
		private Type(int type){
			this.type = type;
		}
		public int getType(){
			return this.type;
		}
	}
}
