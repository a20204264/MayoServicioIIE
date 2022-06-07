package com.idat.MayoServicioprueba.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iditem;
	private String item;
	private Integer cantidad;
	private Double total;
	
	//SE CREA LA RELACION Y SE CREA UNA COLUMNA CON JOINCOLUM:
	@ManyToOne
	@JoinColumn(
			name="idcliente",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idcliente) references Cliente(idcliente)")
			)
	private Cliente cliente;
	
	
	
	
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
