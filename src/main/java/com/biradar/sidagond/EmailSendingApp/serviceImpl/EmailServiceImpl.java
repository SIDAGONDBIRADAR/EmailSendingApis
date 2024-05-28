package com.biradar.sidagond.EmailSendingApp.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biradar.sidagond.EmailSendingApp.helper.Messages;
import com.biradar.sidagond.EmailSendingApp.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String to, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("sidagondbiradar777@gmail.com");
		mailSender.send(simpleMailMessage);
	}

	@Override
	public void sendEmailToMultipleUsers(String[] to, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("sidagondbiradar777@gmail.com");
		mailSender.send(simpleMailMessage);
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String message) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("sidagondbiradar777@gmail.com");
			helper.setText(message, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("sidagondbiradar777@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message);
			FileSystemResource fileResource = new FileSystemResource(file);
			helper.addAttachment(fileResource.getFilename(), file);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendEmailWithFileInputStream(String to, String subject, String message, InputStream is) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("sidagondbiradar777@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message);
			File file = new File("src/main/resources/email/Sidagond_biradar_CV (2).docx");
			Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			FileSystemResource fileResource = new FileSystemResource(file);
			helper.addAttachment(fileResource.getFilename(), file);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
