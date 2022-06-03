package com.bridgelabz.springbootemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringBootEmailDemoApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

//		senderService.sendSimpleEmail("nandiwadekarrutuja@gmail.com",
//				"subject",
//				"Hey this is rutuja nandiwadekar");

		senderService.sendEmailWithAttachment(
				"karthikmc007@gmail.com",
				"Email with Attachment",
				"This email has attachment",
				"C:\\Users\\Hp\\Downloads\\hey img.jpg");

	}

}
