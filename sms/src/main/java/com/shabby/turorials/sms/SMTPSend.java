package com.shabby.turorials.sms;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author shabby
 *
 */
public class SMTPSend {

	public SMTPSend() {
	}
	/**
	 * method to send sms
	 */

	public void msgsend() {
		/**
		 * IPIPI USERNAME
		 */
		String username = "******";
		/**
		 * IPIPI PASSWORD
		 */
		String password = "******";
		String smtphost = "ipipi.com";
		String compression = "Compression Option goes here - find out more";
		/**
		 * YOUR_IPIPI_USERNAME@ipipi.com
		 */
		String from = "******@ipipi.com";
		/**
		 * COUNTRYCODE_MOBILENUMBER@sms.ipipi.com
		 */
		String to = "+91******@sms.ipipi.com";
		/**
		 * TEXT BODY
		 */
		String body = "hello world";
		Transport tr = null;

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");

			// Get a Session object
			Session mailSession = Session.getDefaultInstance(props, null);

			// construct the message
			Message msg = new MimeMessage(mailSession);

			// Set message attributes
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(compression);
			msg.setText(body);
			msg.setSentDate(new Date());

			tr = mailSession.getTransport("smtp");
			tr.connect(smtphost, username, password);
			msg.saveChanges();
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param argv
	 */
	public static void main(String[] argv) {
		SMTPSend smtpSend = new SMTPSend();
		smtpSend.msgsend();
	}
}