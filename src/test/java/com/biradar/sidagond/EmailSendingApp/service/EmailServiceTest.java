package com.biradar.sidagond.EmailSendingApp.service;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

	@Autowired
	private EmailService emailService;

//	@Test
//	void sendEmailTest() {
//		emailService.sendEmail("abiradar814@gmail.com", "Testing email send api using J unit Test class",
//				"Mail from test class");
//	}
//
//	String[] to = { "abiradar814@gmail.com", "biradarsida@gmail.com" };
//
//	@Test
//	void sendEmailToMultipleUsers() {
//		emailService.sendEmailToMultipleUsers(to, "Testing email send api using J unit Test class",
//				"Mail from test class");
//	}
//	
//	@Test
//	void sendEmailWithHtml() {
//		String htmlContent=""+"<h1 style='color:yellow;border:1px solid green;'>Hi I am Sending Test email</h1>"+"";
//		emailService.sendEmailWithHtml("abiradar814@gmail.com", "Testing email api with html content", htmlContent);
//	}
//	
	@Test
	void sendEmailWithFile() {
		emailService.sendEmailWithFile("abiradar814@gmail.com", "Email Testing with file", "Helllllllew", new File("C:\\Users\\sidagond\\OneDrive\\Desktop\\Ecommerce\\EmailSendingApp\\src\\main\\resources\\static\\Sidagond_Biradar_CV (2).docx"));
	}
}
