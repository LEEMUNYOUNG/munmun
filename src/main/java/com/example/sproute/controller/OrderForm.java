package com.example.sproute.controller;

import java.io.Serializable;

import javax.validation.Valid;

import com.example.sproute.domain.Order;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 */
@SuppressWarnings("serial")
public class OrderForm implements Serializable {
	@Valid
	private final Order order = new Order();
	private boolean shippingAddressRequired = false;
	private boolean shippingAddressProvided = false;

	public Order getOrder() {
		return order;
	}

	public void setShippingAddressRequired(boolean shippingAddressRequired) {
		this.shippingAddressRequired = shippingAddressRequired;
	}

	public boolean isShippingAddressRequired() {
		return shippingAddressRequired;
	}

	public void setShippingAddressProvided(boolean shippingAddressProvided) {
		this.shippingAddressProvided = shippingAddressProvided;
	}

	public boolean didShippingAddressProvided() {
		return shippingAddressProvided;
	}
}
