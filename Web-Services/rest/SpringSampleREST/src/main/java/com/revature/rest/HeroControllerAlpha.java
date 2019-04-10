/*
* @author Peter Alagna
*/ 

package com.revature.rest;

import static com.revature.util.ClientMessageUtil.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;
import com.revature.model.HeroList;
import com.revature.service.HeroService;

/**
 * @RequestMapping(value="/register.app", method=RequestMethod.POST)
 * Is the same as we have downstairs.
 * 
 * * path = /something generalizes our URIs a little bit more.
 * ** For this controller, now we have to perform /hero/register for example.
 * * produces tells Spring that we can marshal specific mediatypes.
 * ** if the client now sends us a header saying: Accept="application/xml", he will get XML.
 * 
 * @ResponseBody marshal our POJOS into JSON with Jackson (because we have the dependency).
 * 
 * @RequestBody unmarshals JSON available in the request body into our POJO.
 * 
 * @CrossOrigin is a security feature of the browser. We must allow explicitly each client.
 */
@Controller("heroController")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/hero", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class HeroControllerAlpha implements HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@PostMapping("/register")
	public @ResponseBody ResponseEntity<ClientMessage> registerHero(@RequestBody Hero hero) {
		return (heroService.registerHero(hero)) ? 
				new ResponseEntity<>(REGISTRATION_SUCCESSFUL, HttpStatus.OK) : 
				new ResponseEntity<>(INVALID_DATA, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/find")
	public @ResponseBody ResponseEntity<Object> findHero(@RequestBody Hero hero, HttpServletRequest request) {
		Hero foundHero = heroService.getHero(hero.getName());
		
		if(foundHero != null) {
			return new ResponseEntity<>(foundHero, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HERO_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	public @ResponseBody ResponseEntity<HeroList> findAllHeroes() {
		return new ResponseEntity<>(new HeroList(heroService.getAllHeroes()), HttpStatus.OK);
	}
}
