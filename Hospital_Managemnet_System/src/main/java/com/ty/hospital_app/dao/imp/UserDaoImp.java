package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.Userdao;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

public class UserDaoImp implements Userdao {

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User getUserId(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		User user=entityManager.find(User.class, uid);
		return user;
	}

	public boolean deleteUserId(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		User user=entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public User updateUser(int uid, User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		User user1=entityManager.find(User.class, uid);
		if(user1!=null) {
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setRole(user.getRole());
			user1.setPhone(user.getPhone());
	
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			return user1;
		}
		return null;
	}

	public List<User> getAllUser() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select u from User u");
		
		List<User> list=query.getResultList();
		return list;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dj");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("Select u from User u where u.role=?");
		
		query.setParameter(1,role);

		List<User> list=query.getResultList();
		return list;
	}

}
