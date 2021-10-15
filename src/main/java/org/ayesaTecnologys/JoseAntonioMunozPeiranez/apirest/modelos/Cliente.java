package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1299569035590254332L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;

	private String nombre;
	
	private String tlf;
	
	public Cliente(Long idR, String nombreR, String tlfR) {
		this.id=idR;
		this.nombre=nombreR;
		this.tlf=tlfR;
	}
	public Cliente() {
		this.id=0L;
		this.nombre="";
		this.tlf="";
	}
	
}
