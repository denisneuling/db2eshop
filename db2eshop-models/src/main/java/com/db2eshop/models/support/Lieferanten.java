package com.db2eshop.models.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lieferanten extends AbstractModel<Lieferanten> implements Serializable{
	private static final long serialVersionUID = -1171168614829706963L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@Column
	private String telefon;
	
	public Lieferanten(){
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
