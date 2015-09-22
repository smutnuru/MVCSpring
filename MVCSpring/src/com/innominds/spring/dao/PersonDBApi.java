package com.innominds.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.innominds.spring.model.Person;

public class PersonDBApi {

	
	public  boolean addPerson(Person person){
		try{
			SessionFactory  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.persist(person);
			trans.commit();
			return true;
		}catch(Exception e ){
			
		}
		return false;
	}
	
	public List<Person> getAllPersons(){
		SessionFactory  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query  = session.createQuery("from Person");
		List<Person> personList  = query.list();
		return personList;
	}
}
