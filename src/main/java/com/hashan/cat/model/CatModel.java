package com.hashan.cat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Cats")
public class CatModel {
	@Id
	@ApiModelProperty(notes = "Id of the Cat", name = "id", required = true, value = "1" )
	private int id;
	

	@ApiModelProperty(notes = "Name of the Cat", name = "name", required = true, value = "Lorem" )
	private String name;
	
	public CatModel() {}
	
	public CatModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
