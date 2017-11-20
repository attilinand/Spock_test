package com.spock.poc.client;

public class CreditCardBilling {
	public void charge(Client client, double amount) {
		client.setBonus(amount>100);
	}
}
