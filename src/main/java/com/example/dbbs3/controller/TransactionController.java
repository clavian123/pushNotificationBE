package com.example.dbbs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.entity.Transaction;
import com.example.dbbs3.service.TransactionService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/saveNewTransaction", method = RequestMethod.POST)
	@ResponseBody
	public Transaction saveNewTransaction(@RequestBody ObjectNode newTransaction) {
		int accNumberSender = newTransaction.get("accNumberSender").asInt();
		int accNumberReceiver = newTransaction.get("accNumberReceiver").asInt();
		int amount = newTransaction.get("amount").asInt();
		String type = newTransaction.get("type").asText();
		String note = newTransaction.get("note").asText();
		return transactionService.saveNewTransaction(accNumberSender, accNumberReceiver, amount, type, note);
	}
}
