package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Item;


public interface ItemService {
	
	void guardarItem(Item item);
	void actualizarItem(Item item);
	void eliminarItem(Integer id);
	List<Item> listarItems();
	Item obtenerItemId(Integer id);

}
