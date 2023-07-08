package com.blog.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
private final JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String emailUsername;
	
	@Value("${spring.mail.password}")
	private String emailPassword;
	
	
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendRegistrationEmail(String mail, String username) throws MessagingException{
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(mail);
		helper.setSubject("Account Registered");
		helper.setText("Dear " + username + ",\n\nThank you for registering an account.");
		
		javaMailSender.send(message);
	}
	
}
