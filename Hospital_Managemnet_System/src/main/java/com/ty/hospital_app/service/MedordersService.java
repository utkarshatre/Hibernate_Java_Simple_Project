package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.MedordersDaoImp;
import com.ty.hospital_app.dto.Medorders;

public class MedordersService {
	public void saveMedorders(int eid,Medorders medorders) {
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		Medorders medorders2=medordersDaoImp.saveMedorders(eid, medorders);
		if(medorders2!=null) {
			System.out.println("data saved");
		}
		System.out.println("data not saved");
	}
	public Medorders getMedordersById(int mid) {
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		Medorders medorders2=medordersDaoImp.getMedordersId(mid);
		if(medorders2!=null) {
			return medorders2;
		}
		return null;
	}
	public void deleteMedorders(int mid) {
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		boolean flag=medordersDaoImp.deleteMedordersId(mid);
		if(flag) {
			System.out.println("data deleted");
		}
		System.out.println("data not deleted");
	}
	public List<Medorders> getAllMedorders(){
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		List<Medorders> list=medordersDaoImp.getAllMedorders();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<Medorders> getMedordersByDoctorName(String name) {
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		List<Medorders> list=medordersDaoImp.getMedorderByDoctorName(name);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public Medorders updateMedorders(int mid,Medorders medorders) {
		MedordersDaoImp medordersDaoImp=new MedordersDaoImp();
		Medorders medorders2=medordersDaoImp.updateMedorders(mid,medorders);
		if(medorders2!=null) {
			return medorders2;
		}
		return null;
	}
}
