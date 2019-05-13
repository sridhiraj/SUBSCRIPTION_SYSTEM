package com.hcl.bss.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bss.notification.dto.CustomerDto;
import com.hcl.bss.notification.email.service.EmailService;
import com.hcl.bss.notification.repository.SubscriptionRepository;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
public class NotificationController {
	@Autowired
	EmailService emailService;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@ApiOperation(value="Get Details of a Subscription", response= CustomerDto.class)
	@RequestMapping(value="/emailSubscriptionDetail", produces = { "application/json" }, method = RequestMethod.GET)
	
	public void emailSubscriptionDetail(@RequestParam(value = "subscriptionId", required = true) String subId) throws Exception{
	
		try {
		emailService.emailSubscriptionDetail(subId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
