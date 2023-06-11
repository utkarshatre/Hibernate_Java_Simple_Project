package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface Addressdao {

	public Address saveAddress(int bid,Address address );
	public Address getAddress(int aid);
	public boolean deleteAddressId(int aid);
	public Address updateAddress(int aid,Address address);
	public List<Address> getAllAddress();
}
