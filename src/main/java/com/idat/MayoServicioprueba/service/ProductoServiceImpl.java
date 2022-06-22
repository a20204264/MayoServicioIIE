package com.idat.MayoServicioprueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioprueba.Model.Productos;
import com.idat.MayoServicioprueba.Repository.ProductoRepository;
import com.idat.MayoServicioprueba.dto.ProductoDTORequest;
import com.idat.MayoServicioprueba.dto.ProductoDTOResponse;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	

	@Override
	public void guardarProducto(ProductoDTORequest producto) {

		Productos p = new Productos();
		
		p.setNombreProducto(producto.getNombre());
		p.setDescripcion(producto.getDescripcionproducto());
		p.setPrecio(producto.getPrecioproducto());
		p.setStock(producto.getStockproducto());
		repository.save(p);

	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Productos p = new Productos();
		p.setIdProducto(producto.getId());
		p.setNombreProducto(producto.getNombre());
		p.setDescripcion(producto.getDescripcionproducto());
		p.setPrecio(producto.getPrecioproducto());
		p.setStock(producto.getStockproducto());
		
		repository.saveAndFlush(p);

	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		
		List<ProductoDTOResponse> listar = new ArrayList<>();
		ProductoDTOResponse dto = null;
		List<Productos> p = repository.findAll();
		
		for(Productos productos:p) {
			dto = new ProductoDTOResponse();
			dto.setDescripcionproducto(productos.getDescripcion());
			dto.setNombre(productos.getNombreProducto());
			dto.setPrecioproducto(productos.getPrecio());
			dto.setStockproducto(productos.getStock());
			dto.setId(productos.getIdProducto());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		
		Productos productos = repository.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto = new ProductoDTOResponse();
		dto.setDescripcionproducto(productos.getDescripcion());
		dto.setNombre(productos.getNombreProducto());
		dto.setPrecioproducto(productos.getPrecio());
		dto.setStockproducto(productos.getStock());
		dto.setId(productos.getIdProducto());
		
		return dto;
	}

}
