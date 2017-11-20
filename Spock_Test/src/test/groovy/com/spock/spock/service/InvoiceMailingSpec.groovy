package com.spock.spock.service

import spock.lang.*

import com.spock.poc.service.Customer
import com.spock.poc.service.EmailService
import com.spock.poc.service.FinalInvoiceStep
import com.spock.poc.service.Invoice
import com.spock.poc.service.PrinterService

class InvoiceMailingSpec extends spock.lang.Specification{ 
 
	def "electronic invoices to active email addresses"() { 
		given:"an invoice, a customer, a mail server and a printer"
		PrinterService printerService = Mock(PrinterService) 
		EmailService emailServicee = Mock(EmailService)
		Customer customer = new Customer()
		FinalInvoiceStep finalInvoiceStep = new FinalInvoiceStep(printerService, emailService)
		Invoice invoice = new Invoice()
 
		when: "customer is normal and has an email inbox" 
		customer.hasEmail("nanda@example.com")
		finalInvoiceStep.handleInvoice(invoice, customer)
 
		then: "nothing should be printed. Only an email should be sent"
		0 * printerService.printInvoice(invoice) 
		1 * emailService.sendInvoice(invoice,"nanda@example.com")
	}
} 

