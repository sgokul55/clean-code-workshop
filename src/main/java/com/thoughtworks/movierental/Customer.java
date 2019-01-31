package com.thoughtworks.movierental;

public class Customer {
	private String name;
	private Rentals rentals = new Rentals();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		return new TextStatement().statement(rentals, getName());
	}

	public String htmlStatement() {
		String result = "<H1>Rental Record for <B>" + getName() + "</B></H1><BR/>";
		for (Rental each : rentals) {
			result += each.getMovie().getTitle() + " " + String.valueOf(each.getAmount()) + "<BR/>";
		}
		result += "Amount owed is <B>" + String.valueOf(rentals.getTotalAmount()) + "</B><BR/>";
		result += "You earned <B>" + String.valueOf(rentals.getFrequentRenterPoints()) + "</B> frequent renter points";
		return result;

	}

}
