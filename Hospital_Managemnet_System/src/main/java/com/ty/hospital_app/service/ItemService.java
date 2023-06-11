package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ItemDaoImp;
import com.ty.hospital_app.dto.Item;

public class ItemService {
	public void saveItem(int mid,Item item) {
		ItemDaoImp itemDaoImp=new ItemDaoImp();
		Item item2=itemDaoImp.saveItem(mid, item);
		if(item2!=null) {
			System.out.println("data saved");
		}
		System.out.println("data not saved");
	}
	public Item getItemById(int iid) {
		ItemDaoImp itemDaoImp=new ItemDaoImp();
		Item item2=itemDaoImp.getItemId(iid);
		if(item2!=null) {
			return item2;
		}
		return null;
	}
	public void deleteItemById(int iid) {
		ItemDaoImp itemDaoImp=new ItemDaoImp();
		boolean flag =itemDaoImp.deleteItemId(iid);
		if(flag) {
			System.out.println("data deleted");
		}
		System.out.println("data not deleted");
	}
	public List<Item> getAllItem(){
		ItemDaoImp itemDaoImp=new ItemDaoImp();
		List<Item> list=itemDaoImp.getAllItem();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public Item updateItem(int iid,Item item) {
		ItemDaoImp itemDaoImp=new ItemDaoImp();
		Item item2=itemDaoImp.updateItem(iid, item);
		if(item2!=null) {
			return item2;
		}
		return null;
	}
}
