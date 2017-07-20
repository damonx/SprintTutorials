package com.damonx.common;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.damonx.persistence.HibernateUtil;

public class App {
	public static void main(final String[] args) {

		System.out.println("Hibernate many to many (Annotation)");
		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		final Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		final Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		final Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

		final Set<Category> categories = new HashSet<>();
		categories.add(category1);
		categories.add(category2);

		stock.setCategories(categories);

		session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}