package com.idat.MayoServicioprueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.MayoServicioprueba.Model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
