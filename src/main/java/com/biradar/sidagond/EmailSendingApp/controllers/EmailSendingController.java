package com.biradar.sidagond.EmailSendingApp.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biradar.sidagond.EmailSendingApp.dto.EmailDto;
import com.biradar.sidagond.EmailSendingApp.helper.CustomResponse;
import com.biradar.sidagond.EmailSendingApp.service.EmailService;

@RestController
@RequestMapping("/v1/email/api")
public class EmailSendingController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailDto emailDto){
		emailService.sendEmailWithHtml(emailDto.getTo(),emailDto.getSubject(),emailDto.getMessage());
		return ResponseEntity.ok(new CustomResponse("Email Sent Successfully", HttpStatus.OK, true));
	}
	
	@PostMapping("/sendEmailWithFile")
	public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestPart EmailDto emailDto,@RequestPart MultipartFile file)throws IOException{
		emailService.sendEmailWithFileInputStream(emailDto.getTo(), emailDto.getSubject(),emailDto.getMessage(), file.getInputStream());
		return ResponseEntity.ok(new CustomResponse("Email Sent Successfully", HttpStatus.OK, true));
	}
}
