package com.bgmagar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bgmagar.domain.Person;
import com.bgmagar.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	List<Person> pList = new ArrayList<Person>();
	
	/**
	 * @return list of person
	 */
	@RequestMapping(value="/person", method=RequestMethod.GET)
	private List<Person> getPerson() {
		
		return pList;
	}
	
	/**
	 * Add person to the list
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value="/person", method=RequestMethod.POST)
	private ResponseEntity<Person> setPerson(@RequestBody Person person) {
		
		pList.add(person);
		
		return new ResponseEntity<Person>(HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return person associated with @param id
	 */
	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	private Person getPerson(@PathVariable int id) {
		 
		return personService.getPerson(id);
		
	}
	
	/**
	 * 
	 * @param id
	 * Update detail of person associated with @param id
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value="/person/{id}", method=RequestMethod.POST)
	private ResponseEntity<Person> updatePerson(@PathVariable int id) {
		
		return new ResponseEntity<Person>(HttpStatus.OK);
		
	}

}
