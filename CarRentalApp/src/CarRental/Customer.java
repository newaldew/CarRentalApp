package CarRental;

import java.util.*;

public class Customer {
	private String CustID;
	private String name;
	
	public Customer(String CustID, String name) {
		this.CustID=CustID;
		this.name=name;
	}
	
	public String getCustID() {
		return CustID;
	}
	public String getname() {
		return name;
	}
}
