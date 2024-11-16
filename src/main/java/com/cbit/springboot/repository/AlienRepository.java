package com.cbit.springboot.repository;

import com.cbit.springboot.model.Alien;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlienRepository extends MongoRepository<Alien, String> 
{
	
}

