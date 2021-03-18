package com.htdp1.integrhttpspring.emp.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
    @Qualifier("emp_send_channel")
    MessageChannel getSendChannel;
 
    @Autowired
    @Qualifier("emp_receive_channel")
    PollableChannel getReceiveChannel;

    @GetMapping("/gateway")
	public JSONObject gatewayOld() {
		Message message = MessageBuilder.withPayload("").build();
		getSendChannel.send(message);

        log.debug(message.toString());

		JSONObject res = (JSONObject) JSONValue.parse(getReceiveChannel.receive().getPayload().toString());

		return res;
	}
    
}
