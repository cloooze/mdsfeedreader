package com.ericsson.mdsfeedreader.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailSender {
	
	private static final Logger logger = Logger.getLogger(MailSender.class);
	
	private static final String from = MdsProperties.getDefinition("mds.system.mail.from");
	private static final String to = MdsProperties.getDefinition("mds.system.mail.to");
	private static final String host = MdsProperties.getDefinition("mds.system.mail.host");
	private static final String port = MdsProperties.getDefinition("mds.system.mail.port");
	private static final String username = MdsProperties.getDefinition("mds.system.mail.username");
	private static final String password = MdsProperties.getDefinition("mds.system.mail.password");
	
	private static final String enable = MdsProperties.getDefinition("mds.system.mail.enable");
	
	public static void sendEmail(String subject, String message) {
		
		if (!"true".equalsIgnoreCase(enable) ) {
			return;
		}
		
		Properties properties = System.getProperties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
		
//		Session session = Session.getDefaultInstance(properties);
		
		Session session = Session.getInstance(properties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		try{
			MimeMessage msg = new MimeMessage(session);
			
			msg.setFrom(new InternetAddress(from));
			
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			msg.setSubject(subject);
			
			msg.setText(message);
			
			Transport.send(msg);

			logger.error("Email alarm succesfully sent");
		}catch (MessagingException e) {
			logger.error("Could not send email alarm");
			logger.debug(e, e);
		}
	}
}