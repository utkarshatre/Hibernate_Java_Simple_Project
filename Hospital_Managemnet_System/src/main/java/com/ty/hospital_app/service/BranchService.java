package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;


public class BranchService {
	public void saveBranch(int hid,Branch branch) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.saveBranch(hid,branch);
		if(branch2!=null) {
			System.out.println("data saved succesfully");
		}
		else {
			System.out.println("data not saved");
		}
	}
	public Branch getBranch(int bid) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.getBranch(bid);
		if(branch2!=null) {
			return branch2;
		}
		else {
			return null;
		}
	}
	public void deleteBranch(int bid) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		 boolean flag=branchDaoImp.deleteBranchId(bid);
		if(flag) {
			System.out.println("data deleted succesfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}
	public List<Branch> getAllBranch() {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		List<Branch> list=branchDaoImp.getAllBranch();
		if(list!=null) {
			return list;
		}
		else {
			return null;
		}
	}
	public Branch updateBranchById(int bid,Branch branch) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch2=branchDaoImp.updateBranch(bid, branch);
		if(branch2!=null) {
			return branch2;
		}
		return null;
	}
}
