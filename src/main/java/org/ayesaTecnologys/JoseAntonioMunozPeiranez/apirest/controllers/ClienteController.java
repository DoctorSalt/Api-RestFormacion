package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos.ClienteListDTO;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos.ClientesDTO;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos.ClientesNotId;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.modelos.Cliente;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService cliSer;
	
	@GetMapping("/api/clientes")
	public ClienteListDTO getAll() {
		List <Cliente> listadoClientes = cliSer.getAll();
		if(listadoClientes == null) {
			return new ClienteListDTO(true, null, "Ha habido un problema con la BBDD");
		}
		return new ClienteListDTO(false, listadoClientes, "");
	}
	
	@PostMapping("/api/clientes")
	public ClientesDTO postDato(@RequestBody @Valid ClientesNotId cliS) {
		Cliente cli = cliSer.save(cliS);
		if (cli == null){
			return new  ClientesDTO(true, null, "Problema al añadir");
		}
		return new ClientesDTO(false, cli, "");
	}
	
	@GetMapping("/api/clientes/{id}")
	public ClientesDTO getById(@PathVariable Long id) {
		try {
			Cliente cli = cliSer.findById(id).get();
			return new ClientesDTO(false, cli, "");
		}catch (NoSuchElementException e){
			return new ClientesDTO(true, null, "Objeto no encontrado");
		}
	}
	
	@PutMapping("/api/clientes/{id}")
	public ClientesDTO updateById(@PathVariable Long id,
			 @RequestBody @Valid Cliente cliR			
			) {
		try {
			Cliente cli = cliSer.findById(id).get();
			cli.setNombre(cliR.getNombre());
			cli.setTlf(cliR.getTlf());
			cliSer.update(cli);
			return new ClientesDTO(false,cli, "");
		}catch(NoSuchElementException e) {
			return new ClientesDTO(true, null, "Objeto no encontrado");
		}	
	}
	
	@DeleteMapping("/api/clientes/{id}")
	public ClientesDTO deleteById(@PathVariable Long id) {
		try {
			Cliente cli = cliSer.findById(id).get();
			cliSer.deleteById(id);
			return new ClientesDTO(false, cli, "");
		}catch(NoSuchElementException e) {
			return new ClientesDTO(true, null, "Objeto no encontrado");
		}	
	}
}
