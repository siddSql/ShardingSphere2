package com.example.dbtablesharding.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbtablesharding.model.TOrder0;
import com.example.dbtablesharding.service.IOrderService;
import com.example.dbtablesharding.service.OrderServiceImpl;

@RestController
public class HelloController {

	@Autowired
	OrderServiceImpl orderService;

	@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
	public String hello(@PathVariable long id) {
		TOrder0 order0 = new TOrder0();
		order0.setOrderId(id);
		order0.setStatus("test");
		long userId = new Random().nextLong();
		order0.setUserId(Math.abs(userId));
		orderService.insert(order0);

		return "";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		TOrder0 order0 = new TOrder0();
		// order0.setOrderId(id);
		order0.setStatus("test");
		long userId = new Random().nextLong();
		order0.setUserId(Math.abs(userId));
		orderService.insert(order0);

		return Long.toString(Math.abs(userId));
	}
}