package com.damonx.common;

import java.util.Date;

import org.hibernate.Session;

import com.damonx.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(final String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		final Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		final StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
    }
}
