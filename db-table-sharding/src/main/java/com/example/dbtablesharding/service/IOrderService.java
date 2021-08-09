package com.example.dbtablesharding.service;

import org.springframework.stereotype.Service;

import com.example.dbtablesharding.model.TOrder0;

//@Service
public interface IOrderService {
	TOrder0 insert(TOrder0 record);

	TOrder0 selectByPrimaryKey(Long orderId);

	void deleteByPrimaryKey(Long orderId);
}
