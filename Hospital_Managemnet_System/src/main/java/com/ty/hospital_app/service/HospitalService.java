package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp hospitalDaoImp=new HospitalDaoImp();
		Hospital hospital1=hospitalDaoImp.saveHospital(hospital);
		if(hospital1!=null) {
			System.out.println("Data saved");
		}
		else {
			System.out.println("Unfortunately data not saved");
		}
	}
	public Hospital getHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp=new HospitalDaoImp();
		Hospital hospital=hospitalDaoImp.getHospitalId(hid);
		if(hospital!=null) {
			return hospital;
		}
		else {
			return null;
		}
	}
	public void deleteHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp=new HospitalDaoImp();
		boolean flag=hospitalDaoImp.deleteHospitalId(hid);
		if(flag) {
			System.out.println("Data deleted");
		}
		else {
			System.out.println("Unfortunately data not deleted");
		}
	}
	public Hospital updateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp hospitalDaoImp=new HospitalDaoImp();
		Hospital hospital1=hospitalDaoImp.updateHospital(hid,hospital);
		if(hospital1!=null) {
			return hospital1;
		}
		else {
			return null;
		}
	}
}
