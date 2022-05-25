package com.idat.MayoServicioprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioprueba.Model.Productos;
import com.idat.MayoServicioprueba.service.ProductoService;


@Controller
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity <List<Productos>> listar() {
		
		
		return new ResponseEntity<List<Productos>>( service.listarProductos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public  @ResponseBody Productos ObtenerProductoId(@PathVariable Integer id) {
		return service.obtenerProductoId(id);
	}
	
	@DeleteMapping("/{id}")
	public void EliminarProducto(@PathVariable Integer id) {
		service.eliminarProducto(id);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Productos productos) {
		service.guardarProducto(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Productos producto=service.obtenerProductoId(id);
		
		if(producto != null) {
			service.eliminarProducto(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Productos productos) {
		
		Productos producto=service.obtenerProductoId(productos.getIdProducto());
		
		if(producto != null) {
			service.actualizarProducto(productos);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Productos> obtenerId(@PathVariable Integer id) {
		
		Productos producto=service.obtenerProductoId(id);
		
		if(producto != null) {
			
			
			return new ResponseEntity<Productos>(service.obtenerProductoId(id), HttpStatus.OK);
		}
		return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
	}

}
