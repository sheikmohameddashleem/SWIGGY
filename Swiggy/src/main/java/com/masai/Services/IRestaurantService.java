package com.masai.Services;

import java.util.List;

import com.masai.Model.Restaurant;

public interface IRestaurantService {
	

	public Restaurant create(Restaurant r);
	public Restaurant update(Restaurant r);
	public List<Restaurant> viewAll(String field,String direction);
	public Restaurant viewById(Long id);
	public Restaurant delete(Long id);
}
