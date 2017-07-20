/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package com.damonx.common;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "mkyongdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<Category> categories = new HashSet<>(0);

	public Stock() {
	}

	public Stock(final String stockCode, final String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(final String stockCode, final String stockName, final Set<Category> categories) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(final Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(final String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(final String stockName) {
		this.stockName = stockName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_category", catalog = "mkyongdb", joinColumns = {
			@JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(final Set<Category> categories) {
		this.categories = categories;
	}

}