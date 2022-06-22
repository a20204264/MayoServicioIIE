package com.idat.MayoServicioprueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioprueba.Model.Proveedor;
import com.idat.MayoServicioprueba.Repository.ItemRepository;
import com.idat.MayoServicioprueba.Repository.ProveedorRepository;
import com.idat.MayoServicioprueba.dto.ClienteDTOResponse;
import com.idat.MayoServicioprueba.dto.ProveedorDTORequest;
import com.idat.MayoServicioprueba.dto.ProveedorDTOResponse;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;
	
	
	@Override
	public void guardarProveedor(ProveedorDTORequest proveedor) {

		Proveedor p = new Proveedor();
		
		p.setProveedor(proveedor.getProveedor());
		p.setDireccion(proveedor.getDireccion());
		
		repository.save(p);
	}

	@Override
	public void actualizarProveedor(ProveedorDTORequest proveedor) {
		Proveedor p = new Proveedor();
		
		p.setProveedor(proveedor.getProveedor());
		p.setDireccion(proveedor.getDireccion());
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProveedor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<ProveedorDTOResponse> listarProveedor() {

		List<ProveedorDTOResponse> listar = new ArrayList<>();
		ProveedorDTOResponse dto = null;
		List<Proveedor> p = repository.findAll();
		
		for(Proveedor proveedor: p) {
			dto = new ProveedorDTOResponse();
			
			dto.setIdproveedor(proveedor.getIdproveedor());
			dto.setProveedor(proveedor.getProveedor());
			dto.setDireccion(proveedor.getDireccion());
			
			listar.add(dto);
			
		}
		
		return listar;
	}

	@Override
	public ProveedorDTOResponse obtenerProveedorId(Integer id) {

		Proveedor proveedor = repository.findById(id).orElse(null);
		ProveedorDTOResponse dto = new ProveedorDTOResponse();
		
		dto = new ProveedorDTOResponse();
		
		dto.setIdproveedor(proveedor.getIdproveedor());
		dto.setProveedor(proveedor.getProveedor());
		dto.setDireccion(proveedor.getDireccion());
		
		
		return dto;
	}

}
