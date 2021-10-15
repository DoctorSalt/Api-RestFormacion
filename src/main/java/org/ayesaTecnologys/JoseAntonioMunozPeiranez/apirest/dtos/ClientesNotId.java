package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos;

import lombok.Data;

@Data
public class ClientesNotId {
	
	private String nombre;
	private String tlf;
	
	public ClientesNotId(String nombreR, String tlfR) {		
		this.nombre=nombreR;
		this.tlf=tlfR;
	}
	public ClientesNotId() {		
		this.nombre="";
		this.tlf="";
	}
	
}
