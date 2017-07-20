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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog = "mkyongdb")
public class Category implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);

	public Category() {
	}

	public Category(final String name, final String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Category(final String name, final String desc, final Set<StockCategory> stockCategories) {
		this.name = name;
		this.desc = desc;
		this.stockCategories = stockCategories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(final Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "NAME", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Column(name = "[DESC]", nullable = false)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category")
	public Set<StockCategory> getStockCategories() {
		return this.stockCategories;
	}

	public void setStockCategories(final Set<StockCategory> stockCategories) {
		this.stockCategories = stockCategories;
	}

}

