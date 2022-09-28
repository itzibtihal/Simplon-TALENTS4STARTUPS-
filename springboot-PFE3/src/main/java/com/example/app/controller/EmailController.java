package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.app.service.EmailSenderService;

public class EmailController {
	@Autowired
	private EmailSenderService senderService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		senderService.sendEmail( "ibtihalboukhanchouch@gmail.com", "Consultation", "urgent please !");
	}
	

}
