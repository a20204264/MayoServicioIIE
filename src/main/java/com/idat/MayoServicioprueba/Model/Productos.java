package com.idat.MayoServicioprueba.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Productos")
@Entity
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private int stock;
	
	//RELACION DE UNO A UNO CON LA TABLA PROVEEDOR
	@OneToOne
	@JoinColumn(name="idproveedor",
				nullable = false,
				unique = true,
				foreignKey = @ForeignKey(foreignKeyDefinition ="foreign key (idproveedor) references Proveedor(idproveedor)"))
	private Proveedor proveedor;
	
	
	
	//RELACION DE UNO A MUCHOS CON LA TABLA CLIENTE
	@ManyToMany(cascade = {CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(
			name="productos_clientes",
			
			joinColumns = @JoinColumn(
					name="idcliente", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreing key (idcliente) references cliente(idcliente)")
			),
			
			inverseJoinColumns = @JoinColumn(
					name="idproducto", nullable = false, unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos(id_producto)")
			)
			
						
	)	
	
	private List<Cliente> cliente = new ArrayList<>();
	
	
	
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

}
