package com.idat.MayoServicioprueba.Repository;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Productos;

public interface ProductoRepository {
	
	void guardarProducto(Productos producto);
	void actualizarProducto(Productos producto);
	void eliminarProducto(Integer id);
	List<Productos> listarProductos();
	Productos obtenerProductoId(Integer id);
	

}
