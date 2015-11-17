package com.mkyong.common;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {

	private List lists;
	private Set sets;
	private Map maps;
	Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map getMaps() {
		return maps;
	}

	public void setMaps(Map maps) {
		this.maps = maps;
	}

	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}
	
	

	public Set getSets() {
		return sets;
	}

	public void setSets(Set sets) {
		this.sets = sets;
	}

	@Override
	public String toString() {
		return "Customer [lists=" + lists + ", sets=" + sets + ", maps=" + maps + ", date=" + date + "]";
	}
	
	

}