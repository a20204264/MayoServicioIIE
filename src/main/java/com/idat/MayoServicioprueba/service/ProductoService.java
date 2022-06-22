package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Productos;
import com.idat.MayoServicioprueba.dto.ProductoDTORequest;
import com.idat.MayoServicioprueba.dto.ProductoDTOResponse;

public interface ProductoService {
	
	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listarProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);
	
}
