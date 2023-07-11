package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        customer.setCustomerId(customerId);

        System.out.println("Enter Name: ");
        String name = scanner.next();
        customer.setName(name);

        System.out.println("Enter Place: ");
        String place = scanner.next();
        customer.setPlace(place);

        System.out.println("Enter PAN: ");
        String pan = scanner.next();
        customer.setPan(pan);

        session.save(customer);
        tx.commit();

        System.out.println("Data inserted successfully");
    }

}
