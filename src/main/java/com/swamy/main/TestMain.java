package com.swamy.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.swamy.entity.Employee;
import com.swamy.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		Transaction transaction = null;
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Employee employee = Employee.builder().empName("SWAMY").empSal(56000.00).build();
			session.save(employee);
			transaction.commit();
			System.out.println("Employee Data Saved Successfully : " + employee);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
