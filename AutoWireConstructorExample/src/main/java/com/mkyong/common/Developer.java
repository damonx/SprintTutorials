package com.mkyong.common;

public class Developer {
	private Language language1;

	public Developer(Language language1) {
		this.language1 = language1;
	}

	@Override
	public String toString() {
		return "Developer [language=" + language1 + "]";
	}

}