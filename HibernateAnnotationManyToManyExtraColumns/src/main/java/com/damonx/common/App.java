package com.damonx.common;

import java.util.Date;

import org.hibernate.Session;

import com.damonx.persistence.HibernateUtil;

public class App {
	public static void main(final String[] args) {

		System.out.println("Hibernate many to many (Annotation)");
		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		final Stock stock = new Stock();
		stock.setStockCode("7059");
		stock.setStockName("Odd");

		final Category newCategory = new Category("CUSTOMER", "ORION HEALTH");
		// final Category category1 = (Category) session.get(Category.class, 1);
		// new category, need save to get the id first
		session.save(newCategory);

		final StockCategory stockCategory = new StockCategory();
		stockCategory.setStock(stock);
		stockCategory.setCategory(newCategory);
		stockCategory.setCreatedDate(new Date()); // extra column
		stockCategory.setCreatedBy("admin"); // extra column

		stock.getStockCategories().add(stockCategory);

		session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}