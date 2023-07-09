package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NotFoundException;
import com.masai.Model.Restaurant;
import com.masai.Repository.IRestaurant;

@Service
public class RestaurantService implements IRestaurantService {

	@Autowired
	private IRestaurant restaurant;
	
	@Override
	public Restaurant create(Restaurant r) {
		// TODO Auto-generated method stub
		return restaurant.save(r);
	}

	@Override
	public Restaurant update(Restaurant r) {
		// TODO Auto-generated method stub
		Optional<Restaurant> rest=restaurant.findById(r.getRestaurantId());
		if(!rest.isPresent()) {
			throw new NotFoundException("Restaurant Not Found");
		}
		return restaurant.save(r);
	}

	@Override
	public List<Restaurant> viewAll(String field,String direction) {
		// TODO Auto-generated method stub
		return restaurant.findAll();
	}

	@Override
	public Restaurant viewById(Long id) {
		// TODO Auto-generated method stub
		return restaurant.findById(id).orElseThrow(()->new NotFoundException("No Restaurant found"));
	}

	@Override
	public Restaurant delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Restaurant> rest=restaurant.findById(id);
		if(!rest.isPresent()) {
			throw new NotFoundException("Restaurant Not Found");
		}
		restaurant.deleteById(id);
		return rest.get();
	}

}
