package com.vti.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = null;
		
			session = buildSessionFactory().openSession();
			session.beginTransaction();
//		Insert	
			TestingCategory testingCategory = new TestingCategory();
			testingCategory.setName("Category Test");
			
			session.save(testingCategory);
			System.out.println("Success");
			Query<TestingCategory> query = session.createQuery("FROM TestingCategory");
			List<TestingCategory> listResul = query.list();
			for (TestingCategory testingCategory2 : listResul) {
				System.out.println(testingCategory2.getId() +" "+ testingCategory2.getName());
			}
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(TestingCategory.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
