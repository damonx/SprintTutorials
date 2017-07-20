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

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StockCategoryId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Stock stock;
	private Category category;

	@ManyToOne
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(final Stock stock) {
		this.stock = stock;
	}

	@ManyToOne
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final StockCategoryId that = (StockCategoryId) o;

		if (this.stock != null ? !this.stock.equals(that.stock) : that.stock != null) {
			return false;
		}
		if (this.category != null ? !this.category.equals(that.category) : that.category != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = (this.stock != null ? this.stock.hashCode() : 0);
		result = 31 * result + (this.category != null ? this.category.hashCode() : 0);
		return result;
	}

}
