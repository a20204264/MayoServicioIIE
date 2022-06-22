package com.idat.MayoServicioprueba.dto;

public class ProductoDTOResponse {

	private Integer id;
	private String nombre;
	private String descripcionproducto;
	private Double precioproducto;
	private int stockproducto;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionproducto() {
		return descripcionproducto;
	}
	public void setDescripcionproducto(String descripcionproducto) {
		this.descripcionproducto = descripcionproducto;
	}
	public Double getPrecioproducto() {
		return precioproducto;
	}
	public void setPrecioproducto(Double precioproducto) {
		this.precioproducto = precioproducto;
	}
	public int getStockproducto() {
		return stockproducto;
	}
	public void setStockproducto(int stockproducto) {
		this.stockproducto = stockproducto;
	}
	
	
	
}
