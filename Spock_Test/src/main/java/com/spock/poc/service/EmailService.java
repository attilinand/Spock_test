package com.spock.poc.service;

public interface EmailService {
	void sendInvoice(Invoice invoice, String email);
}
