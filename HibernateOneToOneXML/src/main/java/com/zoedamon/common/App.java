package com.zoedamon.common;

import java.util.Date;

import org.hibernate.Session;

import com.damonx.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(final String[] args) {
		System.out.println("Hibernate one to one (XML mapping)");
		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		final Stock stock = new Stock();

		stock.setStockCode("4715");
		stock.setStockName("GENM");

		final StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("GENTING Malaysia");
		stockDetail.setCompDesc("Best resort in the world");
		stockDetail.setRemark("Nothing Special");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
