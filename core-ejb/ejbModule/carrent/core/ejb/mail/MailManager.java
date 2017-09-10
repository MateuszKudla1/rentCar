package carrent.core.ejb.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Stateless
public class MailManager {
	String addressFrom = "carrentproject@wp.pl";
	String subject = "CarRent registration token.";

	public void send(String login, String token, String email) throws AddressException, MessagingException {
		String messageContent = "Welcome, " + login
				+ ". Enter this site if you want authorize your new account:http://localhost:8180/core-web/token/tokenAuthorization?token="
				+ token;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.wp.pl");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("carrentproject@wp.pl"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject(subject);
		message.setText(messageContent);

		Transport.send(message);
	}

	public void sendInvoice(String login, String email) throws AddressException, MessagingException {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.wp.pl");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("carrentproject@wp.pl"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject("Car Rent order invoice");

        MimeBodyPart messageBodyPart = new MimeBodyPart();      
        String filename = "C:/Users/Mateusz/Desktop/Projekt java ee/invoice.pdf";    
        DataSource source = new FileDataSource(filename);    
        messageBodyPart.setDataHandler(new DataHandler(source));    
        messageBodyPart.setFileName(filename); 
        
        Multipart multipart = new MimeMultipart();     
        multipart.addBodyPart(messageBodyPart);      

        //6) set the multiplart object to the message object    
        message.setContent(multipart );        


		Transport.send(message);
}
	
	
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			try {
				String username = "carrentproject@wp.pl";
				String password = "carrent123";
				return new PasswordAuthentication(username, password);
			} catch (Exception e) {
			}
			return null;
		}
	}
}
