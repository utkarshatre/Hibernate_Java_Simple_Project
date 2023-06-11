package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.PersonDaoImp;
import com.ty.hospital_app.dto.Person;

public class PersonService {
	public void savePerson(int eid,Person person) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.savePerson(eid, person);
		if(person2!=null) {
			System.out.println("data saved");
		}
		System.out.println("data not saved");
	}
	public Person getPersonById(int pid) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.getPersonId(pid);
		if(person2!=null) {
			return person2;
		}
		return null;
	}
	public void deletePersonById(int pid) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		boolean flag=personDaoImp.deletePersonId(pid);
		if(flag) {
			System.out.println("data deleted");
		}
		System.out.println("data not deleted");
	}
	public List<Person> getAllPerson(){
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person> list=personDaoImp.getAllPerson();
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<Person> getPersonByAge(int age){
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person> list=personDaoImp.getPersonByAge(age);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<Person> getPersonByGender(String gender){
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person> list=personDaoImp.getPersonByGender(gender);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public List<Person> getPersonByPhone(long phone){
		PersonDaoImp personDaoImp=new PersonDaoImp();
		List<Person> list=personDaoImp.getPersonByPhone(phone);
		if(list!=null) {
			return list;
		}
		return null;
	}
	public Person updatePerson(int pid,Person person) {
		PersonDaoImp personDaoImp=new PersonDaoImp();
		Person person2=personDaoImp.updatePerson(pid, person);
		if(person2!=null) {
			return person2;
		}
		return null;
	}
}
