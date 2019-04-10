/*
* @author Peter Alagna
*/ 

package com.revature.service;

import static com.revature.util.FinalUtil.EMPTY;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.InvalidFormException;
import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

@Service("heroService")
public class HeroServiceAlpha implements HeroService {
	
	private static Logger logger = Logger.getLogger(HeroServiceAlpha.class);

	@Autowired
	private HeroRepository heroRepository;
	
	public HeroServiceAlpha() {
		logger.trace("Constructor Injection (no-args)");
	}

	public boolean registerHero(Hero hero) {
		if(hero.getName().equals(EMPTY)) {
			throw new InvalidFormException("Hero name can't be empty.");
		}
			
		heroRepository.save(hero);
		return hero.getId() != 0;
	}

	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}

	public Hero getHero(String name) {
		return heroRepository.findByName(name);
	}
}
