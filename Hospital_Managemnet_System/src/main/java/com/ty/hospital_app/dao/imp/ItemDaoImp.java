package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.Itemdao;
import com.ty.hospital_app.dto.Item;
import com.ty.hospital_app.dto.Medorders;

public class ItemDaoImp implements Itemdao{

	public Item saveItem(int mid, Item item) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Medorders medorders=entityManager.find(Medorders.class, mid);
		if(medorders!=null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return item;
		}
		return null;
	}

	public Item getItemId(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		Item item=entityManager.find(Item.class, iid);
		return item;	
	}

	public boolean deleteItemId(int iid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Item item=entityManager.find(Item.class, iid);
		if(item!=null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Item updateItem(int iid, Item item) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Item item1=entityManager.find(Item.class, iid);
		if(item1!=null) {
			item1.setMedorders(item.getMedorders());
			item1.setQuantity(item.getQuantity());
			item1.setCost(item.getCost());
			
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			return item1;
		}
		return null;

	}

	public List<Item> getAllItem() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select i from Item i");

		List<Item> list=query.getResultList();
		return list;

	}

}
