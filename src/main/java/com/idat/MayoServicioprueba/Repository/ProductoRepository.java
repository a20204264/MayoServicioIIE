package com.idat.MayoServicioprueba.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioprueba.Model.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {
	
	
	

}
