package com.progressive.utils;


public enum DataMap {
	
	ZipCode("Zip Code"),FirstName("First Name"),MiName("Mi Name"),LastName("Last Name"),
	DOB("DOB"),Address("Address"),AptNo("Apt No"),City("City");
	
	private String value;
	
	
	private DataMap(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
		
	}
	
	

}
