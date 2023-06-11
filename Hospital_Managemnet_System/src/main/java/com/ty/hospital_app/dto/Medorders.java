package com.ty.hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Medorders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int mid;
private String dname;
private String orderdate;
private double total;
@OneToMany(mappedBy = "medorders")
private List<Item> item;
@ManyToOne
@JoinColumn
private Encounter encounter;
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getOrderdate() {
	return orderdate;
}
public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public List<Item> getItem() {
	return item;
}
public void setItem(List<Item> item) {
	this.item = item;
}
public Encounter getEncounter() {
	return encounter;
}
public void setEncounter(Encounter encounter) {
	this.encounter = encounter;
}
@Override
public String toString() {
	return "Medorders [mid=" + mid + ", dname=" + dname + ", orderdate=" + orderdate + ", total=" + total + ", item="
			+ item + ", encounter=" + encounter + "]";
}

}
