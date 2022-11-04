package com.stacksimplify.restservices.Hello;

public class UserDetaills {

	private String firstname;
	private String lastname;
	private String city;
	
	//constructor
	public UserDetaills(String firstname, String lastname, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}
	
	//getters y setters
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	//to string
	@Override
	public String toString() {
		return "UserDetaills [firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + "]";
	}

	
}
