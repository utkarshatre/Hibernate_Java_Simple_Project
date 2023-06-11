package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.Medordersdao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Medorders;

public class MedordersDaoImp implements Medordersdao {

	public Medorders saveMedorders(int eid, Medorders medorders) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medorders);
			entityTransaction.commit();
			return medorders;
		}
		return null;
	}

	public Medorders getMedordersId(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		Medorders medorders=entityManager.find(Medorders.class, mid);
		return medorders;
	}

	public boolean deleteMedordersId(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Medorders medorders=entityManager.find(Medorders.class, mid);
		if(medorders!=null) {
			entityTransaction.begin();
			entityManager.remove(medorders);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Medorders updateMedorders(int mid, Medorders medorders) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Medorders medorders1=entityManager.find(Medorders.class, mid);
		if(medorders1!=null) {
			medorders1.setEncounter(medorders.getEncounter());
			medorders1.setOrderdate(medorders.getOrderdate());
			medorders1.setItem(medorders.getItem());
			medorders1.setTotal(medorders.getTotal());
			
			entityTransaction.begin();
			entityManager.merge(medorders1);
			entityTransaction.commit();
			return medorders1;
		}
		return null;
	}

	public List<Medorders> getAllMedorders() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select m from Medorders m");

		List<Medorders> list=query.getResultList();
		return list;
	}

	public List<Medorders> getMedorderByDoctorName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select m from Medorders m where e.dname=?");
		
		query.setParameter(1,name);

		List<Medorders> list=query.getResultList();
		return list;
	}

}
