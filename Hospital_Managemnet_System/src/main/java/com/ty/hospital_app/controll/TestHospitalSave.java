package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestHospitalSave {

	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		HospitalService service=new HospitalService();
		hospital.setName("kle");
		hospital.setWebsite("www.kle.com");
		
		service.saveHospital(hospital);
	}

}
