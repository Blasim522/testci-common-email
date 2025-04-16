package org.apache.commons.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReplyToTest {
	private EmailConcrete email;
	private static final String TEST_EMAIL = "test@test.com";
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//test to add reply to a string
	@Test
	public void addReplyToString() throws Exception{
		email.addReplyTo(TEST_EMAIL);
		email.addReplyTo(TEST_EMAIL, "Blake");
	}
}
