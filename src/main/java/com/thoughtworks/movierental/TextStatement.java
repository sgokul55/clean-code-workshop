package com.thoughtworks.movierental;

public class TextStatement {
	
	public String statement(Rentals rentals, String customerName  ) {
		String result = "Rental Record for " + customerName + "\n";
		for (Rental each : rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
		}
		// add footer lines result
		result += "Amount owed is " + String.valueOf(rentals.getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(rentals.getFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

}
