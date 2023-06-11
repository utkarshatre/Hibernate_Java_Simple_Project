package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestHospitalUpdate {

	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		HospitalService service=new HospitalService();
		hospital.setName("me");
		hospital.setWebsite("www.me.com");
		service.updateHospitalById(2, hospital);
	}

}
