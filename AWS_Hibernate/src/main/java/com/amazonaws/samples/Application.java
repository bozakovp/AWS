package com.amazonaws.samples;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setId(2);
		person.setName("Bozakov1");
		Configuration conf = new Configuration().configure().addAnnotatedClass(Person.class);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(sr);

	    Session session1 = sf.openSession();
	    Query q1 = session1.createQuery("from Person");
	    q1.setCacheable(true);
	    session1.beginTransaction();
	    //session.save(person);
	    //session.getTransaction().commit();
	    //Person p = session.get(Person.class,1);
	    System.out.println(q1.getResultList());
	    session1.close();
	    Session session2 = sf.openSession();
	    Query q2 = session2.createQuery("from Person");
	    q2.setCacheable(true);
	    session2.beginTransaction();
	    //session.save(person);
	    //session.getTransaction().commit();
	    //Person p = session.get(Person.class,1);
	    System.out.println(q2.getResultList());
	    session2.close();
	}

}
