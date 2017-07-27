package com.proyecto.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.proyecto.model.Person;
import com.proyecto.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService  {
	private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Mike",19));
		people.add(new Person("Juan",18));
		people.add(new Person("Oscar",23));
		people.add(new Person("Rodrigo",24));
		LOGGER.info("Hello from ExampleService");
		return people;
	}



	

}
