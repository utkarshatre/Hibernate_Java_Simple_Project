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
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eid;
private String dateofjoin;
private String discharge;
@OneToMany(mappedBy = "encounter")
private List<Observation> observation;
@ManyToOne
@JoinColumn
private Branch branch;
@OneToMany(mappedBy = "encounter")
private List<Medorders> medorders;
@ManyToOne
@JoinColumn
private Person person;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getDob() {
	return dateofjoin;
}
public void setDob(String dob) {
	this.dateofjoin = dob;
}
public String getDischarge() {
	return discharge;
}
public void setDischarge(String discharge) {
	this.discharge = discharge;
}
public List<Observation> getObservation() {
	return observation;
}
public void setObservation(List<Observation> observation) {
	this.observation = observation;
}
public Branch getBranch() {
	return branch;
}
public void setBranch(Branch branch) {
	this.branch = branch;
}
public List<Medorders> getMedorders() {
	return medorders;
}
public void setMedorders(List<Medorders> medorders) {
	this.medorders = medorders;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
@Override
public String toString() {
	return "Encounter [eid=" + eid + ", dob=" + dateofjoin + ", discharge=" + discharge + ", observation=" + observation
			+ ", branch=" + branch + ", medorders=" + medorders + ", person=" + person + "]";
}

}
