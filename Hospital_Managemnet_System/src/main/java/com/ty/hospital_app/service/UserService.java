package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.UserDaoImp;
import com.ty.hospital_app.dto.User;

public class UserService {
	public void saveUser(User user) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.saveUser(user);
		if(user2!=null) {
			System.out.println("data saved");
		}
		System.out.println("data not saved");
	}
	public User getUserById(int uid) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.getUserId(uid);
		if(user2!=null) {
			return user2;
		}
		return null;
	}
	public void deleteUserById(int uid) {
		UserDaoImp userDaoImp=new UserDaoImp();
		boolean flag=userDaoImp.deleteUserId(uid);
		if(flag) {
			System.out.println("data deleted");
		}
		System.out.println("data not deleted");
	}
	public List<User> getAllUser(){
		UserDaoImp userDaoImp=new UserDaoImp();
		List<User> list=userDaoImp.getAllUser();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<User> getUserByRole(String role){
		UserDaoImp userDaoImp=new UserDaoImp();
		List<User> list=userDaoImp.getUserByRole(role);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public User updateUser(int uid,User user) {
		UserDaoImp userDaoImp=new UserDaoImp();
		User user2=userDaoImp.updateUser(uid,user);
		if(user2!=null) {
			return user2;
		}
		return null;
	}
}
