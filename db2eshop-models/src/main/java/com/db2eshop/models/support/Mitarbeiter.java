package com.db2eshop.models.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mitarbeiter extends AbstractModel<Mitarbeiter> implements Serializable{
	private static final long serialVersionUID = 8135335874077911975L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@Column
	private String vorname;
	
	public Mitarbeiter(){
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

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
