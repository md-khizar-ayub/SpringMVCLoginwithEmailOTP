package com.mka.sendmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

public class SendMail {
	String email ;
	String otp;
	public SendMail(String email,int otp) {
		this.email = email;
		this.otp = String.valueOf(otp);
	}
	public boolean send()
	   {   
	      // email ID of Recipient.
	      String recipient = email;
	 
	      // email ID of  Sender.
	      String sender = "mka.private007@gmail.com";
	 
	      // using host as localhost
	      String host = "smtp.gmail.com";
	 
	      // Getting system properties
	      Properties properties = System.getProperties();
	 
	      // Setting up mail server
	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "587");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true"); 
	      // creating session object to get properties
	      Session session = Session.getDefaultInstance(properties,new Authenticator() {
	          public PasswordAuthentication getPasswordAuthentication() {
	        	  //please change the username () and Password with respect to your Gamil (^_^)!
	              return new PasswordAuthentication("mka.private@gmail.com", "yqmkotacyayzezmq");
	          }
	      });
	 
	      try
	      {
	         // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));
	 
	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	 
	         // Set Subject: subject of the email
	         message.setSubject("MKA PVT LTD otp verification");

	         
			// set body of the email.
	         message.setText("Please find below otp \n "+" \n"
	         		+ otp);
	         
	         // Send email.
	         Transport.send(message);
	         System.out.println("Mail successfully sent");
	         return true;
	         
	      }
	      catch (MessagingException mex)
	      {
	         mex.printStackTrace();
	      }
		return false;
	   }
	
}
