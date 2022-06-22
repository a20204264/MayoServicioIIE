package com.idat.MayoServicioprueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioprueba.Model.Item;
import com.idat.MayoServicioprueba.Repository.ItemRepository;
import com.idat.MayoServicioprueba.dto.ItemDTORequest;
import com.idat.MayoServicioprueba.dto.ItemDTOResponse;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	
	@Override
	public void guardarItem(ItemDTORequest item) {

		Item i = new Item();
		
		i.setItem(item.getItem());
		i.setCantidad(item.getCantidad());
		i.setTotal(item.getTotal());
		repository.save(i);
		
	}

	@Override
	public void actualizarItem(ItemDTORequest item) {
		Item i = new Item();
		
		i.setItem(item.getItem());
		i.setCantidad(item.getCantidad());
		i.setTotal(item.getTotal());
		
		repository.saveAndFlush(i);
		
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ItemDTOResponse> listarItems() {
		
		List<ItemDTOResponse> listar = new ArrayList<>();
		ItemDTOResponse dto = null;
		List<Item> i = repository.findAll();
		
		for(Item item : i) {
			dto = new ItemDTOResponse();
			
			dto.setItem(item.getItem());
			dto.setCantidad(item.getCantidad());
			dto.setTotal(item.getTotal());
			
			listar.add(dto);
		}
			
		return listar;
	}

	@Override
	public ItemDTOResponse obtenerItemId(Integer id) {
		
		Item item = repository.findById(id).orElse(null);
		ItemDTOResponse dto = new ItemDTOResponse();
		
		dto = new ItemDTOResponse();
		
		dto.setIditem(item.getIditem());
		dto.setItem(item.getItem());
		dto.setCantidad(item.getCantidad());
		dto.setTotal(item.getTotal());
		
		
		return dto;
	}

}
