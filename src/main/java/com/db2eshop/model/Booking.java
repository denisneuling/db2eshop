package com.db2eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.gui.component.io.BookingTypeInput;
import com.db2eshop.gui.component.io.DoubleInput;
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
	@UIBind(BookingTypeInput.class)
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@NotNull
	@UIBind(DoubleInput.class)
	@Column(nullable = false)	
	private Double amount = 0D;
	
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
