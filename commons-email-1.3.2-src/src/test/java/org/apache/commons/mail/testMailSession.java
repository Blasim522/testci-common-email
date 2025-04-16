package org.apache.commons.mail;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMailSession {
    private EmailConcrete email;
    private Session aSession;
    private Properties mockProperties;
    private static int EXPECTED_VALUE = 60000;
    private static int EXPECTED_VALUE_CONNECTION = 30000;
    private static String TEST_EMAIL = "test@test.com";
    @Before
    public void setUpEmailTest() throws Exception {
        email = new EmailConcrete();
        mockProperties = new Properties();
        mockProperties.put("mail.smtp.host", "smtp.example.com");
        mockProperties.put("mail.smtp.port", "587");
        aSession = Session.getDefaultInstance(mockProperties, null);
    }

    @After
    public void tearDownEmailTest() throws Exception {
        email = null;
        mockProperties = null;
        aSession = null;
    }

	@Test(expected = EmailException.class)
	public void testGetMailSessionMissingHostName() throws Exception {
    	// Clear hostName and system property to simulate missing hostName
    	email.setHostName(null);
    	System.clearProperty("mail.smtp.host");

    	email.getMailSession(); // Should throw EmailException
	}
	@Test // testing a null session
	public void nullSession() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSmtpPort(587);
    	email.setAuthenticator(new DefaultAuthenticator("user", "password"));

    	Session session = email.getMailSession();
    	assertNull(session);
	}
	@Test
	//testing the authenticator
	public void testAuthenticator() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSmtpPort(587);
    	email.setAuthenticator(new DefaultAuthenticator("user", "password"));

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals("true", session.getProperty("mail.smtp.auth"));
	}

	@Test // Test the SSL
	public void testSSL() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSslSmtpPort("465");
    	email.setSSLOnConnect(true);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals("465", session.getProperty("mail.smtp.port"));
    	assertEquals("465", session.getProperty("mail.smtp.socketFactory.port"));
    	assertEquals("javax.net.ssl.SSLSocketFactory", session.getProperty("mail.smtp.socketFactory.class"));
    	assertEquals("false", session.getProperty("mail.smtp.socketFactory.fallback"));
	}

	@Test //testing the TLS
	public void testTLS() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setStartTLSEnabled(true);
    	email.setStartTLSRequired(true);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals("true", session.getProperty("mail.smtp.starttls.enable"));
    	assertEquals("true", session.getProperty("mail.smtp.starttls.required"));
	}

	@Test // testing the bounce address
	public void testBounceAddress() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setBounceAddress(TEST_EMAIL);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals(TEST_EMAIL, email.bounceAddress);
	}

	@Test // testing the socket timeout and the socket connection timeout
	public void testSocketTimeouts() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSocketTimeout(EXPECTED_VALUE);
    	email.setSocketConnectionTimeout(EXPECTED_VALUE_CONNECTION);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals(EXPECTED_VALUE, email.getSocketTimeout());
    	assertEquals(EXPECTED_VALUE_CONNECTION, email.getSocketConnectionTimeout());
	}

	@Test // testing the send partial boolean
	public void testSendPartial() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSendPartial(true);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals("true", session.getProperty("mail.smtp.sendpartial"));
    	assertEquals("true", session.getProperty("mail.smtps.sendpartial"));
	}

	@Test // check to see if the SSL connection is try and then check to see if the server identity is true
	public void testServerIdentity() throws Exception {
    	email.setHostName("smtp.example.com");
    	email.setSSLOnConnect(true);
    	email.setSSLCheckServerIdentity(true);

    	Session session = email.getMailSession();
    	assertNotNull(session);
    	assertEquals("true", session.getProperty("mail.smtp.ssl.checkserveridentity"));
	}

	

}