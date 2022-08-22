package com.swamy.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.swamy.entity.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();

				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "root");

				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.FORMAT_SQL, "true");
				properties.put(Environment.HBM2DDL_AUTO, "create");
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(Employee.class);

				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return sessionFactory;
	}

}
