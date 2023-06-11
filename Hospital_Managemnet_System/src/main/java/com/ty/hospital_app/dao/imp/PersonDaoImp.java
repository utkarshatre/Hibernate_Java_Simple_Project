package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.Persondao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Medorders;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImp implements Persondao{

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		return null;
	}

	public Person getPersonId(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		Person person=entityManager.find(Person.class, pid);
		return person;
	}

	public boolean deletePersonId(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, pid);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Person updatePerson(int pid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person1=entityManager.find(Person.class, pid);
		if(person1!=null) {
			person1.setAge(person.getAge());
			person1.setAddress(person.getAddress());
			person1.setDob(person.getDob());
			person1.setGender(person.getGender());
			person1.setPhno(person.getPhno());
			person1.setEncounter(person.getEncounter());
			
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			return person1;
		}
		return null;

	}

	public List<Person> getAllPerson() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select p from Person p");

		List<Person> list=query.getResultList();
		return list;
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select p from Person p where p.gender=?");
		
		query.setParameter(1,gender);

		List<Person> list=query.getResultList();
		return list;

	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select p from Person p where p.age=?");
		
		query.setParameter(1,age);

		List<Person> list=query.getResultList();
		return list;
	}

	public List<Person> getPersonByPhone(long phone) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select p from Person p where p.phno=?");
		
		query.setParameter(1,phone);

		List<Person> list=query.getResultList();
		return list;
	}

}
