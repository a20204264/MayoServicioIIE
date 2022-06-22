package com.idat.MayoServicioprueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioprueba.Model.Cliente;
import com.idat.MayoServicioprueba.Repository.ClienteRepository;
import com.idat.MayoServicioprueba.dto.ClienteDTORequest;
import com.idat.MayoServicioprueba.dto.ClienteDTOResponse;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		
		c.setCliente(cliente.getCliente());
		c.setCelular(cliente.getCelular());		
		repository.save(c);
		
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {


		Cliente c = new Cliente();
		
		c.setCliente(cliente.getCliente());
		c.setCelular(cliente.getCelular());	
		c.setIdcliente(cliente.getIdcliente());
		repository.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		List<ClienteDTOResponse> listar = new ArrayList<>();
		ClienteDTOResponse dto = null;
		List<Cliente> c = repository.findAll();
		
		for(Cliente cliente :c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setIdcliente(cliente.getIdcliente());
			dto.setCliente(cliente.getCliente());
			dto.setCelular(cliente.getCelular());
			
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {

		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto= new ClienteDTOResponse();
		
		dto.setIdcliente(cliente.getIdcliente());
		dto.setCliente(cliente.getCliente());
		dto.setCelular(cliente.getCelular());
		
		return dto;
	}

}
