package com.bezkoder.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Adress;

public interface AdressRepository extends JpaRepository <Adress, Integer> {
              
}
