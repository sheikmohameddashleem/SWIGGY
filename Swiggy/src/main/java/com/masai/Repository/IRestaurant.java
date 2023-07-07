package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Restaurant;

public interface IRestaurant extends JpaRepository<Restaurant, Long> {

}
