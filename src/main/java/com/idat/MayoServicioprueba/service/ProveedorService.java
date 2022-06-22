package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Proveedor;
import com.idat.MayoServicioprueba.dto.ProveedorDTORequest;
import com.idat.MayoServicioprueba.dto.ProveedorDTOResponse;



public interface ProveedorService {
	void guardarProveedor(ProveedorDTORequest proveedor);
	void actualizarProveedor(ProveedorDTORequest proveedor);
	void eliminarProveedor(Integer id);
	List<ProveedorDTOResponse> listarProveedor();
	ProveedorDTOResponse obtenerProveedorId(Integer id);
}
