package com.damonx.common;

import org.hibernate.Session;

import com.damonx.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( final String[] args )
    {
		System.out.println("Maven + Hibernate + MySQL");
		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		final Stock stock = new Stock();

		stock.setStockCode("4715");
		stock.setStockName("GENM");

		session.save(stock);
		session.getTransaction().commit();
    }
}
