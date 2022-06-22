package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Cliente;
import com.idat.MayoServicioprueba.dto.ClienteDTORequest;
import com.idat.MayoServicioprueba.dto.ClienteDTOResponse;

public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest clientes);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id); 

}
