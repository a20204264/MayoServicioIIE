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

import com.idat.MayoServicioprueba.Model.Item;
import com.idat.MayoServicioprueba.dto.ItemDTORequest;
import com.idat.MayoServicioprueba.dto.ItemDTOResponse;
import com.idat.MayoServicioprueba.service.ItemService;

@Controller
@RequestMapping("/item/v1")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	//LISTAR TODO
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity <List<ItemDTOResponse>> listar() {
			
			
			return new ResponseEntity<List<ItemDTOResponse>>( service.listarItems(), HttpStatus.OK);
		}
		
		//OBTENER POR ID:
		@GetMapping("/{id}")
		public  @ResponseBody ItemDTOResponse ObtenerItemId(@PathVariable Integer id) {
			return service.obtenerItemId(id);
		}
		
		
		//ELIMINAR
		@DeleteMapping("/{id}")
		public void EliminarItem(@PathVariable Integer id) {
			service.eliminarItem(id);
		}
		
		
		//GUARDAR
		@RequestMapping(path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody ItemDTORequest item) {
			service.guardarItem(item);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
		
		//ELIMINAR
		@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
			
			ItemDTOResponse item=service.obtenerItemId(id);
			
			if(item != null) {
				service.eliminarItem(id);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		//ACTUALIZAR
		@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody ItemDTORequest item) {
			
			ItemDTOResponse items=service.obtenerItemId(item.getIditem());
			
			if(items != null) {
				service.actualizarItem(item);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		//LISTAR POR ID
		@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<ItemDTOResponse> obtenerId(@PathVariable Integer id) {
			
			ItemDTOResponse items=service.obtenerItemId(id);
			
			if(items != null) {
				
				
				return new ResponseEntity<ItemDTOResponse>(service.obtenerItemId(id), HttpStatus.OK);
			}
			return new ResponseEntity<ItemDTOResponse>(HttpStatus.NOT_FOUND);
		}

	

}
