package com.progressive.utils;

public class AutoData {

	private String firstName;
	private String miName;
	private String lastName;
	private String dob;
	private String address;
	private String aptNo;
	private String cityName;
	private String zipCode;

	public AutoData(String firstName, String miName, String lastName, String dob, String address, String aptNo,
			String cityName, String zipCode) {

		this.firstName = firstName;
		this.miName = miName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.aptNo = aptNo;
		this.cityName = cityName;
		this.zipCode = zipCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiName() {
		return miName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getAptNo() {
		return aptNo;
	}

	public String getCityName() {
		return cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

}
