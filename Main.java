package com.onetoonemapping;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// Create Scanner Object to Get User Input
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of Customer Transection");
		int number = scanner.nextInt();

		for (int i = 1; i <= number; i++) {

			System.out.println("Enter  First Name");
			String firstName = scanner.next();

			System.out.println("Enter Mobile Number");
			String mobileNumber = scanner.next();

			// Create an Object of Customer Class
			Customer customer = new Customer();

			customer.setFirstName(firstName);
			customer.setMobileNumber(mobileNumber);

			System.out.println("Enter Total Amount");
			int total = scanner.nextInt();

			// Create an Object of Transection Class
			Transection transection = new Transection();

			transection.setDate(new Date());
			transection.setTotal(total);

			customer.setTransection(transection);

			session.save(customer);

		}
		scanner.close();
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
