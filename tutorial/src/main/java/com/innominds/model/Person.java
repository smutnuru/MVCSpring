package com.innominds.model;

public class Person {
	private String firstName ;
	private String lastName;
	private String branch;
	private String country;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, String branch, String country) {
		setFirstName(firstName);
		setLastName(lastName);
		setBranch(branch);
		setCountry(country);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String ticker) {
		this.firstName = ticker;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String issuerName) {
		this.lastName = issuerName;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String issuerType) {
		this.branch = issuerType;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return "[" + getFirstName() 
				+ ", " + getLastName()
				+ ", " + getBranch()
				+ ", " + getCountry()
				+ "]";
	}
}
