package com.idat.MayoServicioprueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.MayoServicioprueba.Model.Proveedor;
import com.idat.MayoServicioprueba.service.ProveedorService;


@Controller
@RequestMapping("/proveedor/v1")
public class ProveedorController {
	
	@Autowired
	private ProveedorService service;
	
	
	//LISTAR TODO
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity <List<Proveedor>> listar() {
			
			
			return new ResponseEntity<List<Proveedor>>( service.listarProveedor(), HttpStatus.OK);
		}
		
		//OBTENER POR ID:
		@GetMapping("/{id}")
		public  @ResponseBody Proveedor ObtenerProveedorId(@PathVariable Integer id) {
			return service.obtenerProveedorId(id);
		}
		
		
		//ELIMINAR
		@DeleteMapping("/{id}")
		public void EliminarProveedor(@PathVariable Integer id) {
			service.eliminarProveedor(id);
		}
		
		
		//GUARDAR
		@RequestMapping(path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody Proveedor proveedor) {
			service.guardarProveedor(proveedor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		
		//ELIMINAR
		@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
			
			Proveedor proveedor=service.obtenerProveedorId(id);
			
			if(proveedor != null) {
				service.eliminarProveedor(id);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//ACTUALIZAR
		@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody Proveedor proveedor) {
			
			Proveedor proveedores=service.obtenerProveedorId(proveedor.getIdproveedor());
			
			if(proveedor != null) {
				service.actualizarProveedor(proveedor);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		//LISTAR POR ID
		@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<Proveedor> obtenerId(@PathVariable Integer id) {
			
			Proveedor proveedor=service.obtenerProveedorId(id);
			
			if(proveedor != null) {
				
				
				return new ResponseEntity<Proveedor>(service.obtenerProveedorId(id), HttpStatus.OK);
			}
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}


}
