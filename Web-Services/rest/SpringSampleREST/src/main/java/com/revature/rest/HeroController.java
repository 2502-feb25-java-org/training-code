package com.revature.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;
import com.revature.model.HeroList;

public interface HeroController {
	ResponseEntity<ClientMessage> registerHero(Hero hero);
	ResponseEntity<Object> findHero(Hero hero, HttpServletRequest request);
	ResponseEntity<HeroList> findAllHeroes();
}
