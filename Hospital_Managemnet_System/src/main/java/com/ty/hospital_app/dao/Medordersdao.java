package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Medorders;

public interface Medordersdao {
public Medorders saveMedorders(int eid,Medorders medorders);
public Medorders getMedordersId(int mid);
public boolean deleteMedordersId(int mid);
public Medorders updateMedorders(int mid,Medorders medorders);
public List<Medorders> getAllMedorders();
public List<Medorders> getMedorderByDoctorName(String name);

//public List<Medorders> getMedorderByDate(String date);
}
