package com.idat.MayoServicioprueba.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcliente;
	private String cliente;
	private String celular;
	
	
	@ManyToMany(mappedBy="cliente", cascade = {CascadeType.ALL,CascadeType.MERGE})
	private List<Productos> productos= new ArrayList<>();
	
	
	//RELACIONAMOS CON LA TABLA ITEM:
	@OneToMany(mappedBy="cliente")
	private List<Item> item=new ArrayList<>();
	
	
	
	
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	

}
