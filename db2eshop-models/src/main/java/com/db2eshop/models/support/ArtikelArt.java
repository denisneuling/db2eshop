package com.db2eshop.models.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ArtikelArt extends AbstractModel<ArtikelArt> {
	private static final long serialVersionUID = -9004421460842418357L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	public ArtikelArt(){
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
}
