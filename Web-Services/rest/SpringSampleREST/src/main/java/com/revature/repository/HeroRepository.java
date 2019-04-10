package com.revature.repository;

import java.util.List;

import com.revature.model.Hero;

public interface HeroRepository {
	void save(Hero hero);
	List<Hero> findAll();
	Hero findByName(String name);
}
