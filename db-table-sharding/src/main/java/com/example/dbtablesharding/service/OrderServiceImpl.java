package com.example.dbtablesharding.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbtablesharding.model.TOrder0;
import com.example.dbtablesharding.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	OrderRepository repository;

	public TOrder0 insert(TOrder0 record) {
		return repository.save(record);
	}

	public TOrder0 selectByPrimaryKey(Long orderId) {
		Optional<TOrder0> array = repository.findById(orderId);
		if (array != null)
			return array.get();
		return null;
	}

	public void deleteByPrimaryKey(Long orderId) {
		repository.deleteById(orderId);
	}

}