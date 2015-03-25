package com.bgmagar.service.impl;

import org.springframework.stereotype.Service;

import com.bgmagar.domain.Person;
import com.bgmagar.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	public Person getPerson(int id) {
		Person p = new Person();
		p.setId(id);
		p.setName("name Test " + id);
		p.setLocation("Location test" + id);
		return p;
	}

}
