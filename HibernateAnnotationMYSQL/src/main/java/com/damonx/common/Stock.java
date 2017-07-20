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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "tutorials", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;

	public Stock() {
	}

	public Stock(final String stockCode, final String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(final String stockCode, final String stockName, final StockDetail stockDetail) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return this.stockDetail;
	}

	public void setStockDetail(final StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

}