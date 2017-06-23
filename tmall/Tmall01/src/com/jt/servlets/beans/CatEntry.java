package com.jt.servlets.beans;

import java.io.Serializable;

public class CatEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer id;
	private String name;
	
	public CatEntry(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public CatEntry() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CatEntry [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
