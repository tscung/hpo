package sg.com.stellarstudios.imser.helper;

/*
Some SMTP servers require a username and password authentication before you
can use their Server for Sending mail. This is most common with couple
of ISP's who provide SMTP Address to Send Mail.

This Program gives any example on how to do SMTP Authentication
(User and Password verification)

This is a free source code and is provided as it is without any warranties and
it can be used in any your code for free.

Author : Sudhir Ancha
 */

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sg.com.stellarstudios.imser.common.ServiceLocator;

public class MailSender {
	private String host;
	private String username;
	private String password;
	private String emailFrom;

	public void sendMail(final String subject, final String recipients[], final String message) {
		new Thread(new Runnable() {
			public void run() {
				try {
					boolean debug = false;

					//Set the host smtp address
					Properties props = new Properties();
					props.put("mail.smtp.host", getHost());
					props.put("mail.smtp.auth", "true");		
					props.put("mail.smtp.port", 587);
					props.put("mail.smtp.starttls.enable","true");	

					Authenticator auth = new SMTPAuthenticator();
					Session session = Session.getDefaultInstance(props, auth);

					session.setDebug(debug);

					// create a message
					Message msg = new MimeMessage(session);

					// set the from and to address
					InternetAddress addressFrom = new InternetAddress(emailFrom);
					msg.setFrom(addressFrom);

					InternetAddress[] addressTo = new InternetAddress[recipients.length];
					for (int i = 0; i < recipients.length; i++) {
						addressTo[i] = new InternetAddress(recipients[i]);
					}
					msg.setRecipients(Message.RecipientType.BCC, addressTo);

					// Setting the Subject and Content Type
					msg.setSubject(subject);
					msg.setContent(message, "text/html");
					Transport.send(msg);
				}
				catch (Exception e) {
					ServiceLocator.getInstance().getLogHelper().error(e);
				}
			}
		}).run();
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication
	 * when the SMTP server requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = getUsername();
			String password = getPassword();
			return new PasswordAuthentication(username, password);
		}
	}

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
}