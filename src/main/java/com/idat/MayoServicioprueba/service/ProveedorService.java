package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Proveedor;



public interface ProveedorService {
	void guardarProveedor(Proveedor proveedor);
	void actualizarProveedor(Proveedor proveedor);
	void eliminarProveedor(Integer id);
	List<Proveedor> listarProveedor();
	Proveedor obtenerProveedorId(Integer id);
}
