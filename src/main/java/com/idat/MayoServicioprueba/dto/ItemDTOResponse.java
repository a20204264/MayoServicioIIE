package com.idat.MayoServicioprueba.dto;

public class ItemDTOResponse {
	
	private Integer iditem;
	private String item;
	private Integer cantidad;
	private Double total;
	
	
	public Integer getIditem() {
		return iditem;
	}
	public void setIditem(Integer iditem) {
		this.iditem = iditem;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	

}
