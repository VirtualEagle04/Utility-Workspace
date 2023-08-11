package co.edu.unbosque.controller;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Controller {
	
	private String emailFrom;
	private String passwordFrom;
	private String emailTo;
	private String subject;
	private String content;
	
	private Properties prop;
	private Session session;
	private MimeMessage mimeMessage;
	
	public Controller() {
		emailFrom = "automatonJavaSender@gmail.com";
		passwordFrom = "lmnxukpiduqypaur";
		emailTo = "jmezam@unbosque.edu.co";
		subject = "Java Email Sender Test";
		content = "Email sent successfully!";
		prop = new Properties();
		
	}
	
	public void createEmail() throws AddressException, MessagingException {
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.port", "587");
		prop.setProperty("mail.smtp.user", emailFrom );
		prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.setProperty("mail.smtp.auth", "true");
	
		session = Session.getDefaultInstance(prop);
		
		mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(emailFrom));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
		mimeMessage.setSubject(subject);
		
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(content, "text/html; charset=utf-8");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		
		mimeMessage.setContent(multipart);
		
	}
	
	public void sendEmail() throws MessagingException {
		Transport transport = session.getTransport("smtp");
		transport.connect(emailFrom, passwordFrom);
		transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
		transport.close();
		
		System.out.println("Correo enviado!");
	}
	
	public void run() throws AddressException, MessagingException{
		createEmail();
		sendEmail();
	}
}
