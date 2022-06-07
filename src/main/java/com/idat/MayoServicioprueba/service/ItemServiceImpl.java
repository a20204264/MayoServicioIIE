package com.idat.MayoServicioprueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioprueba.Model.Item;
import com.idat.MayoServicioprueba.Repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;
	
	
	@Override
	public void guardarItem(Item item) {
		// TODO Auto-generated method stub
		repository.save(item);
		
	}

	@Override
	public void actualizarItem(Item item) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(item);
		
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Item> listarItems() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Item obtenerItemId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
