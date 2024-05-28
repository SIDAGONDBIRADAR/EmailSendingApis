package com.biradar.sidagond.EmailSendingApp.service;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

	public void sendEmail(String to, String subject, String message);

	public void sendEmailToMultipleUsers(String[] to, String subject, String message);

	public void sendEmailWithHtml(String to, String subject, String message);

	public void sendEmailWithFile(String to, String subject, String message, File file);
	
	public void sendEmailWithFileInputStream(String to, String subject, String message,InputStream is);
	
	
}
