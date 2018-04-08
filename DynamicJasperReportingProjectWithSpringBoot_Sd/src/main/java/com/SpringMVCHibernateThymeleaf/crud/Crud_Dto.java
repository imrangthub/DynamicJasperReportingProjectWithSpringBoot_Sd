package com.SpringMVCHibernateThymeleaf.crud;

public class Crud_Dto {

	private String name;
	private String value;
	public Crud_Dto() {
		
	}
	public Crud_Dto(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Crud_Dto [name=" + name + ", value=" + value + ", getName()=" + getName() + ", getValue()=" + getValue()
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
