package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ObservationDaoImp;
import com.ty.hospital_app.dto.Observation;

public class ObservationService {
	public void saveObservation(int eid,Observation observation) {
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		Observation observation2=observationDaoImp.saveObservation(eid, observation);
		if(observation2!=null) {
			System.out.println("data saved");
		}
		System.out.println("data not saved");
	}
	public Observation getObservationById(int oid) {
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		Observation observation2=observationDaoImp.getObservationId(oid);
		if(observation2!=null) {
			return observation2;
		}
		return null;
	}
	public void deleteObservationById(int oid) {
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		boolean flag=observationDaoImp.deleteObservationId(oid);
		if(flag) {
			System.out.println("data delted");
		}
		System.out.println("data not deleted");
	}
	public List<Observation> getAllObservation(){
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		List<Observation> list =observationDaoImp.getAllObservatio();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<Observation> getObservationByDoctorName(String name){
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		List<Observation> list =observationDaoImp.getObservationByDoctorName(name);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public Observation updateObservation(int oid,Observation observation) {
		ObservationDaoImp observationDaoImp=new ObservationDaoImp();
		Observation observation2=observationDaoImp.updateObservation(oid, observation);
		if(observation2!=null) {
			return observation2;
		}
		return null;
	}
}
