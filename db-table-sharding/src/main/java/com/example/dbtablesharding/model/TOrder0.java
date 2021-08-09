package com.example.dbtablesharding.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class TOrder0 {

	@Id
	private long order_id;
	private long user_id;
	private String status;

	public long getOrderId() {
		return order_id;
	}

	public void setOrderId(long orderId) {
		this.order_id = orderId;
	}

	public long getUserId() {
		return user_id;
	}

	public void setUserId(long userId) {
		this.user_id = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
