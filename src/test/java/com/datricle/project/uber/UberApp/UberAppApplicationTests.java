package com.datricle.project.uber.UberApp;

import com.datricle.project.uber.UberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail(
				"nohas67470@chansd.com",
				"This is the testing mail",
				"Body of my mail"
		);
	}

	@Test
	void sendMultipleEmails(){
		String emails[] = {
				"smridhi106@gmail.com",
				"charvikhurana01@gmail.com",
				"deepanshusehgal.112@gmail.com",
				"nohas67470@chansd.com",
		};

		emailSenderService.sentEmail(
				emails,
				"Uber-Application Testing Mail",
				"Body of my mail"
		);
	}

}
