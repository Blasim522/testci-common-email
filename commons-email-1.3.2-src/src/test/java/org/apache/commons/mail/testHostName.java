package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Properties;

import javax.mail.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testHostName {
	private static final String HOST_NAME = "Blake";
	private EmailConcrete email;
	private Session aSession;
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		Properties mockProperties = new Properties();
        mockProperties.put("mail.smtp.host", "smtp.example.com");
        mockProperties.put("mail.smtp.port", "587");
        aSession = Session.getDefaultInstance(mockProperties, null);
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//Testing setting and getting the host name and then seeing if they are equal
	@Test
	public void testGetHostName() throws Exception{
		email.setHostName(HOST_NAME);
		email.getHostName();
		assertEquals(HOST_NAME, email.getHostName());
	}
	
	@Test //testing for returning the properties
	public void testReturnProperties() throws Exception{;
		Properties properties = new Properties();
	    properties.setProperty(EmailConstants.MAIL_HOST, HOST_NAME);
	    Session session = Session.getInstance(properties);
	
	    email.setMailSession(session);
	
	    assertEquals(HOST_NAME, email.getHostName());

	}
	//Testing getting null as a host
	@Test
	public void testReturnHostNull() throws Exception{
		assertNull(email.getHostName());
	}
	
}
