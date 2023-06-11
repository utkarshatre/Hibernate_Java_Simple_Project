package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.AddressDaoImp;
import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;

public class AddressService {
	public void saveAddress(int bid,Address address ) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.saveAddress(bid,address);
		if(address2!=null) {
			System.out.println("data saved succesfully");
		}
		else {
			System.out.println("data not saved");
		}
	}
	public Address getAddress(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.getAddress(aid);
		if(address2!=null) {
			return address2;
		}
		else {
			return null;
		}
	}
	public void deleteAddress(int aid) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		boolean flag=addressDaoImp.deleteAddressId(aid);
		if(flag) {
			System.out.println("data deleted succesfully");
		}
		else {
			System.out.println("data not deleted");
		}

	}
	public List<Address> getAllAddress() {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		List<Address> list=addressDaoImp.getAllAddress();
		if(list!=null) {
			return list;
		}

		else {
			return null;
		}
	}
	public Address updateAddressById(int aid,Address address) {
		AddressDaoImp addressDaoImp=new AddressDaoImp();
		Address address2=addressDaoImp.updateAddress(aid, address);
		if(address2!=null) {
			return address2;
		}
		else {
			return null;
		}
	}
}
