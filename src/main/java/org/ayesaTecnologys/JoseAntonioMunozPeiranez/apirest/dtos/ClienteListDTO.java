package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos;

import java.util.List;

import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.modelos.Cliente;

import lombok.Data;

@Data
public class ClienteListDTO {
	private Boolean errors;
	private List <Cliente> data;
	private String message;
	
	public ClienteListDTO(Boolean errorR, List <Cliente> dataR, String messageR) {
		this.errors=errorR;
		this.data=dataR;
		this.message=messageR;
	}
}
