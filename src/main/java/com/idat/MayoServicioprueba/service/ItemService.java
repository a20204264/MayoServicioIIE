package com.idat.MayoServicioprueba.service;

import java.util.List;

import com.idat.MayoServicioprueba.Model.Item;
import com.idat.MayoServicioprueba.dto.ItemDTORequest;
import com.idat.MayoServicioprueba.dto.ItemDTOResponse;


public interface ItemService {
	
	void guardarItem(ItemDTORequest item);
	void actualizarItem(ItemDTORequest item);
	void eliminarItem(Integer id);
	List<ItemDTOResponse> listarItems();
	ItemDTOResponse obtenerItemId(Integer id);

}
