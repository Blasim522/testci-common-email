package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MimeMessageTest {
	private EmailConcrete email;
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		
		
	}
	//Testing to see if will get an error if we build mime message again
	@Test(expected = RuntimeException.class)
	public void testbuildMimeMessageNullCheck() throws Exception {
		try {
			email.setHostName("localhost");
			email.setSmtpPort(1234);
			email.setFrom("a@b.com");
			email.addTo("c@d.com");
			email.setSubject("test mail");
			email.setCharset("ISO-8859-1");
			email.setContent("test content", "text/plain");
			email.addHeader("String 1", "value");
			email.addBcc("test@mail.com");
			//email.
			email.buildMimeMessage();
			
			email.buildMimeMessage();
		} catch (RuntimeException re) {
			String message = "The MimeMessage is already built.";
			assertEquals(message, re.getMessage());
			throw re;
		}
	}
	//Testing to see if the content is not null
	@Test
    public void testContentNotNullAndTextPlain() throws Exception {
		//basic set up for the test
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.setFrom("a@b.com");
		email.addTo("c@d.com");
		email.setSubject("test mail");
		email.setCharset("ISO-8859-1");
		email.setContent("test content", "text/plain");

		email.buildMimeMessage();
		MimeMessage message = email.getMimeMessage();
        assertNotNull(message);
        assertEquals("test mail", message.getSubject());
    }
	//testing Nothing from, from
	@Test
    public void testNoFrom() throws Exception {
		//basic set up for the test but we do not include the from
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.addTo("c@d.com");
		email.setSubject("test mail");
		email.setCharset("ISO-8859-1");
		email.setContent("test content", "text/plain");
		
		email.buildMimeMessage();
		
	}
	// testing the length of Cc array
	@Test
    public void testCClength() throws Exception {
		//basic set up for the test but we include email.addCc
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.addTo("c@d.com");
		email.addCc("C@c.com");
		email.setFrom("a@b.com");
		email.setSubject("test mail");
		email.setCharset("ISO-8859-1");
		email.setContent("test content", "text/plain");
		email.buildMimeMessage();
		
		MimeMessage message = email.getMimeMessage();
		assertNotNull(message);
		assertEquals(1, message.getRecipients(Message.RecipientType.CC).length);
		assertEquals(1, message.getRecipients(Message.RecipientType.TO).length);
	}
	//Testing nothing from Char
	@Test
    public void testEmptyCharSet() throws Exception {
		//basic set up for the test but we do not include email.setCharset
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.addTo("c@d.com");
		email.setFrom("a@b.com");
		email.setSubject("test mail");
		email.setContent("test content", "text/plain");
		email.buildMimeMessage();
		
		
	}
	@Test // Testing the reply and the reply size
    public void testReplyList() throws Exception {
		//basic set up but we are including addReplyTo and then checking the size of the replyList
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.addTo("c@d.com");
		email.setFrom("a@b.com");
		email.setSubject("test mail");
		email.setContent("test content", "text/plain");
		email.addReplyTo("c@d.com");
		assertEquals(1, email.replyList.size());
		email.buildMimeMessage();
	}
	@Test //testing pop before smtp
    public void testPopBeforeSmtp() throws Exception {
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.addTo("c@d.com");
		email.setFrom("a@b.com");
		email.setSubject("test mail");
		email.setContent("test content", "text/plain");
		email.setPopBeforeSmtp(true, "pop.host", "username", "password");
		email.buildMimeMessage();
		
		
	}
	
}
