package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class DepartmentRepository {
	private SessionFactory sessionFactory;

	public DepartmentRepository() {
		sessionFactory = buildSessionFactory();
	}

	private SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
//		
		configuration.addAnnotatedClass(Department.class);
//		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Department> getAllDepartments() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Department> query = session.createQuery("FROM Department");
			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentID(short id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentName(String name) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Department> query = session.createQuery("FROM Department WHERE name =:nameParamater");
			query.setParameter("nameParamater", name);
			Department department = query.uniqueResult();
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(department);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean TestExistsByName(String name) {
		Department department = getDepartmentName(name);
		if (department == null) {
			return false;
		}
		return true;
	}
	
	public boolean TestExistsByID(short id) {
		Department department = getDepartmentID(id);
		if(department== null) {
			return false;
		}
		return true;
	}
}
