package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.Observationdao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Medorders;
import com.ty.hospital_app.dto.Observation;

public class ObservationDaoImp implements Observationdao{

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		return null;
	}

	public Observation getObservationId(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		Observation observation=entityManager.find(Observation.class, oid);
		return observation;

	}

	public boolean deleteObservationId(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation=entityManager.find(Observation.class, oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Observation updateObservation(int oid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation1=entityManager.find(Observation.class, oid);
		if(observation1!=null) {
			observation1.setDname(observation.getDname());
			observation1.setEncounter(observation.getEncounter());
			observation1.setRobservation(observation.getRobservation());
			
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			return observation1;
		}
		return null;
	}

	public List<Observation> getAllObservatio() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select o from Observation o");

		List<Observation> list=query.getResultList();
		return list;
	}

	public List<Observation> getObservationByDoctorName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select o from Observation o where o.dname=?");
		
		query.setParameter(1,name);

		List<Observation> list=query.getResultList();
		return list;
	}

}
