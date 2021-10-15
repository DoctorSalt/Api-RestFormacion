package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos;

import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.modelos.Cliente;
import lombok.Data;


@Data
public class ClientesDTO {
	
	private Boolean errors;
	private Cliente data;
	private String message;
	
	public ClientesDTO(Boolean errorR, Cliente dataR, String messageR) {
		this.errors=errorR;
		this.data=dataR;
		this.message=messageR;
	}
	
}