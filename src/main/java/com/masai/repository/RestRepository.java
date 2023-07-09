package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Resturant;

public interface RestRepository extends JpaRepository<Resturant, Integer> {

}
