package com.bezkoder.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
