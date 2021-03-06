package com.zoedamon.common;

// Generated Jan 19, 2010 4:08:57 PM by Hibernate Tools 3.2.5.Beta

import java.util.Date;

/**
 * StockDetail generated by hbm2java
 */
public class StockDetail implements java.io.Serializable {

	/**
	 *
	 */
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

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(final Integer stockId) {
		this.stockId = stockId;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(final Stock stock) {
		this.stock = stock;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(final String compName) {
		this.compName = compName;
	}

	public String getCompDesc() {
		return this.compDesc;
	}

	public void setCompDesc(final String compDesc) {
		this.compDesc = compDesc;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(final String remark) {
		this.remark = remark;
	}

	public Date getListedDate() {
		return this.listedDate;
	}

	public void setListedDate(final Date listedDate) {
		this.listedDate = listedDate;
	}

}
