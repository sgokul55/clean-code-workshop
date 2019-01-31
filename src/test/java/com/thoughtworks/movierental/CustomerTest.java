package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void simple_test() {

		String expectedValue = "Rental Record for Customer A\n\tMovie One\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points";
		Movie movie = new Movie("Movie One", Movie.REGULAR);
		Rental rental = new Rental(movie, 1);

		Customer customer = new Customer("Customer A");
		customer.addRental(rental);

		Assert.assertEquals("Failed", expectedValue, customer.statement());
	}

	@Test
	public void multiple_rental_test() {

		String expectedValue = "Rental Record for Customer A\n" + "	Movie One	2.0\n" + "	Movie One	2.0\n"
				+ "	Movie One	2.0\n" + "Amount owed is 6.0\n" + "You earned 3 frequent renter points";
		Rental rental_1 = new Rental(new Movie("Movie One", Movie.REGULAR), 1);
		Rental rental_2 = new Rental(new Movie("Movie One", Movie.REGULAR), 1);
		Rental rental_3 = new Rental(new Movie("Movie One", Movie.REGULAR), 1);

		Customer customer = new Customer("Customer A");
		customer.addRental(rental_1);
		customer.addRental(rental_2);
		customer.addRental(rental_3);

		Assert.assertEquals("Failed", expectedValue, customer.statement());
	}

	public void multiple_rental_with_diff_movies_test() {

		String expectedValue = "Rental Record for Customer A\n" + "	Movie One	2.0\n" + "	Movie One	2.0\n"
				+ "	Movie One	2.0\n" + "Amount owed is 6.0\n" + "You earned 3 frequent renter points";
		Rental rental_1 = new Rental(new Movie("Movie One", Movie.REGULAR), 1);
		Rental rental_2 = new Rental(new Movie("Movie One", Movie.NEW_RELEASE), 2);
		Rental rental_3 = new Rental(new Movie("Movie One", Movie.CHILDRENS), 3);

		Customer customer = new Customer("Customer A");
		customer.addRental(rental_1);
		customer.addRental(rental_2);
		customer.addRental(rental_3);

		Assert.assertEquals("Failed", expectedValue, customer.statement());
	}

	@Test
	public void simple_rental_with_no_movie_test() {

		boolean expectedValue = false;
		Rental rental = new Rental(null, 1);

		Customer customer = new Customer("Customer A");
		customer.addRental(rental);
		try {
			customer.statement();
		} catch (NullPointerException e) {
			expectedValue = true;
		}
		Assert.assertTrue(expectedValue);
	}

	@Test
	public void simple_html_test() {

		String expectedValue = "<H1>Rental Record for <B>Customer A</B></H1><BR/>Movie One 2.0<BR/>Amount owed is <B>2.0</B><BR/>You earned <B>1</B> frequent renter points";
		Movie movie = new Movie("Movie One", Movie.REGULAR);
		Rental rental = new Rental(movie, 1);

		Customer customer = new Customer("Customer A");
		customer.addRental(rental);

		Assert.assertEquals("Failed", expectedValue, customer.htmlStatement());
	}

}