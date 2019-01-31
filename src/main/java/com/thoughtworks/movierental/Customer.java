package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

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
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
		}
		// add footer lines result
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	public String htmlStatement() {
		String result = "<H1>Rental Record for <B>" + getName() + "</B></H1><BR/>";
		for (Rental each : rentals) {
			result += each.getMovie().getTitle() + " " + String.valueOf(each.getAmount()) + "<BR/>";
		}
		result += "Amount owed is <B>" + String.valueOf(getTotalAmount()) + "</B><BR/>";
		result += "You earned <B>" + String.valueOf(getFrequentRenterPoints()) + "</B> frequent renter points";
		return result;

	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : rentals) {
			totalAmount += each.getAmount();
			;
		}
		return totalAmount;
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : rentals) {
			frequentRenterPoints += each.calculateFrequentPoints(each);
		}
		return frequentRenterPoints;
	}

}
