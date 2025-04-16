package org.apache.commons.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeaderTest {
	private EmailConcrete email;
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//Test for seeing if both name and value work
	@Test
	public void testAddHeader() throws Exception{
		email.addHeader("Name", "value");
	}
	//test for seeing if null name and a value for value works
	@Test
	public void testAddEmptyNameHeader() throws Exception{
		email.addHeader(null, "value");
	}
	//test for seeing if a value for name and null for value works
	@Test
	public void testAddEmptyValueHeader() throws Exception{
		email.addHeader("Name", null);
	}
}
