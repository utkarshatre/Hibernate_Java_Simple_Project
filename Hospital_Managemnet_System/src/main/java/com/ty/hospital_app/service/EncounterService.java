package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService {
	public void saveEncounter(int bid,Encounter encounter) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter2=encounterDaoImp.saveEncounter(bid, encounter);
		if(encounter2!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("data not saved");
		}
	}
	public Encounter getEncounter(int eid) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter=encounterDaoImp.getEncounterId(eid);
		if(encounter!=null) {
			return encounter;
		}
		return null;
	}
	public void deleteEncounter(int eid) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		boolean flag=encounterDaoImp.deleteEncounterId(eid);
		if(flag) {
			System.out.println("data deleted");
		}
		System.out.println("data not deleted");
	}
	public List<Encounter> getAllEncounter(){
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		List<Encounter> list=encounterDaoImp.getAllEncounter();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public Encounter updateEncounter(int eid,Encounter encounter) {
		EncounterDaoImp encounterDaoImp=new EncounterDaoImp();
		Encounter encounter1=encounterDaoImp.updateEncounter(eid, encounter);
		if(encounter1!=null) {
			return encounter;
		}
		return null;
	}
}

