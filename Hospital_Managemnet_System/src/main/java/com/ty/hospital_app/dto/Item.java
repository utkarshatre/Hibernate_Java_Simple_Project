package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iid;
	private String name;
	private double cost;
	private int quantity;
	@ManyToOne
	@JoinColumn
	private Medorders medorders;
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Medorders getMedorders() {
		return medorders;
	}
	public void setMedorders(Medorders medorders) {
		this.medorders = medorders;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + ", medorders="
				+ medorders + "]";
	}

}
