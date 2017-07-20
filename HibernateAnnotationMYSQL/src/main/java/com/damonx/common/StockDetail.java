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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "stock_detail", catalog = "tutorials")
public class StockDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;

	public StockDetail() {
	}

	public StockDetail(final Stock stock, final String compName, final String compDesc,
			final String remark, final Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(final Integer stockId) {
		this.stockId = stockId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(final Stock stock) {
		this.stock = stock;
	}

	@Column(name = "COMP_NAME", nullable = false, length = 100)
	public String getCompName() {
		return this.compName;
	}

	public void setCompName(final String compName) {
		this.compName = compName;
	}

	@Column(name = "COMP_DESC", nullable = false)
	public String getCompDesc() {
		return this.compDesc;
	}

	public void setCompDesc(final String compDesc) {
		this.compDesc = compDesc;
	}

	@Column(name = "REMARK", nullable = false)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(final String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE", nullable = false, length = 10)
	public Date getListedDate() {
		return this.listedDate;
	}

	public void setListedDate(final Date listedDate) {
		this.listedDate = listedDate;
	}

}

