package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.h@c.org","abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	private static final String[] TEST_EMPTY_EMAILS = { };
	private static final String TEST_EMAIL = "test@test.com";
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	@Test // test for adding to Bcc
	public void testAddBcc() throws Exception {
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}
	@Test//test to see if Bcc is empty
	public void testEmptyAddBcc() throws Exception {
		email.addBcc(TEST_EMPTY_EMAILS);
		
		assertEquals(0, email.getBccAddresses().size());
	}
	@Test // test to addCC
	public void testAddCc() throws Exception {
		email.addCc(TEST_EMAILS);
		
	}
	@Test // test to see if Cc is null
	public void testAddNullCc() throws Exception {
		email.addCc(TEST_EMAIL);
		
        assertEquals(1, email.getCcAddresses().size());
	}
	@Test // test to see if Cc is null
	public void testEmptyAddCc() throws Exception {
		email.addCc(TEST_EMPTY_EMAILS);
		
		assertEquals(0, email.getBccAddresses().size());
	}
	
}
