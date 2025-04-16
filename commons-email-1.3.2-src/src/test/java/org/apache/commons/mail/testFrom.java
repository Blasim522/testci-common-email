package org.apache.commons.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testFrom {
	private EmailConcrete email;
	private EmailConcrete fromEmail;
	private static final String TEST_FROM = "from@test.com";
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		fromEmail = new EmailConcrete();
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//Testing the setFrom function
	@Test
	public void testFrom() throws Exception{
		email.setFrom(TEST_FROM);
	}
	
}
