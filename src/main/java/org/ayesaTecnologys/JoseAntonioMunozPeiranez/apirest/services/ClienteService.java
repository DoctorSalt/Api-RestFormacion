package org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.services;

import java.util.List;
import java.util.Optional;

import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.dtos.ClientesNotId;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.modelos.Cliente;
import org.ayesaTecnologys.JoseAntonioMunozPeiranez.apirest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepo;
	
	public List<Cliente>getAll(){	
		return clienteRepo.findAll();
	}
	
	public Cliente save(ClientesNotId clientesSin) {
		Cliente cli= new Cliente(
				null, 
				clientesSin.getNombre(),
				clientesSin.getTlf()
				);
		return clienteRepo.save(cli);				
	}
	
	public Optional <Cliente> findById(Long id){
		return clienteRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		clienteRepo.deleteById(id);
	}
	
	public Cliente update(Cliente cli) {
		return clienteRepo.save(cli);
	}
}
