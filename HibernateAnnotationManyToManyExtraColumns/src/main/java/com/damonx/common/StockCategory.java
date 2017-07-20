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

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stock_category", catalog = "mkyongdb")
@AssociationOverrides({
		@AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "STOCK_ID")),
		@AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
public class StockCategory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private StockCategoryId pk = new StockCategoryId();
	private Date createdDate;
	private String createdBy;

	public StockCategory() {
	}

	@EmbeddedId
	public StockCategoryId getPk() {
		return this.pk;
	}

	public void setPk(final StockCategoryId pk) {
		this.pk = pk;
	}

	@Transient
	public Stock getStock() {
		return getPk().getStock();
	}

	public void setStock(final Stock stock) {
		getPk().setStock(stock);
	}

	@Transient
	public Category getCategory() {
		return getPk().getCategory();
	}

	public void setCategory(final Category category) {
		getPk().setCategory(category);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", nullable = false, length = 10)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final StockCategory that = (StockCategory) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}

