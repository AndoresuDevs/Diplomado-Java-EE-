package com.personal.MyAplicationChida;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idpersona;
	
	private String nombre;
	private String paterno;
	public Persona(Integer idpersona, String nombre, String paterno) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.paterno = paterno;
	}
	
	public Persona() {
		
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	
	
}
