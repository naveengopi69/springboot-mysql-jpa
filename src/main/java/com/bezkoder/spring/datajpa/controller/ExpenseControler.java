package com.bezkoder.spring.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Expense;
import com.bezkoder.spring.datajpa.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseControler {
	@Autowired
	ExpenseRepository expenseRepository;

	@PostMapping("/expenses")
	public ResponseEntity<Expense>Addexpense(@RequestBody Expense expense) {
		try {
			Expense _expense = expenseRepository
					.save(new Expense(expense.getExpenseId(), expense.getExpensetype(), expense.getDate(),
							expense.getNoOfItems(), (int) expense.getPrice(), expense.getTotal(), expense.getBywhom()));
			return new ResponseEntity<>(_expense, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//ijigjerpogherjq[qe
	@PutMapping("/expenses/{id}")
	public ResponseEntity<Expense> EditExpense(@PathVariable("id") int id, @RequestBody Expense expense) {
		Optional<Expense> expenseData = expenseRepository.findById(id);

		if (expenseData.isPresent()) {
			Expense _expense = expenseData.get();
			expense.setexpenseType(expense.getexpenseType());
			expense.setDate(expense.getDate());
			expense.setNoOfItems(expense.getNoOfItems());
			expense.setPrice(expense.getPrice());
			expense.setTotal(expense.getTotal());
			expense.setBywhom(expense.getBywhom());
			return new ResponseEntity<>(expenseRepository.save(_expense), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}
	@DeleteMapping("/expense/{id}")
	public ResponseEntity<HttpStatus> deleteExpense(@PathVariable("expenseId") int id) {
		try {
			expenseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

