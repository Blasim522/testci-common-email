package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testDate {
	private EmailConcrete email;
	private Date date;
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		date = new Date();
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	@Test // Test for setting and getting the data and then checking if they are equal
	public void testGetDate() throws Exception{
		email.setSentDate(date);
		assertEquals(date, email.getSentDate());
	}
}
