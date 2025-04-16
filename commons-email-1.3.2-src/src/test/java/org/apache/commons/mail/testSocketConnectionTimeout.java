package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testSocketConnectionTimeout {
	private EmailConcrete email;
	private static final int SOCKET_TIME = 53832025;
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//Testing the socket connection timeout. 
	@Test
	public void testSocketTimeout() throws Exception{
		email.setSocketConnectionTimeout(SOCKET_TIME);
		assertEquals(SOCKET_TIME, email.getSocketConnectionTimeout());
	}
}
