package com.chouse.biz.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Products")

public class Product {
	@Id // primaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrmental
	private Long sku;
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "Product_Customer", 
			joinColumns = @JoinColumn(name = "customer_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
			)
	private List<Cliente> clientes = new ArrayList<>();

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", Nombre=" + nombre + ", clientes=" + clientes + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
