package com.innominds.tutorial;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.innominds.model.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public RestController() {
		
		persons.put("Harsha", new Person("Harsha", "sri", "cse", "USA"));
		persons.put("Dhoni", new Person("Dhoni", "msd", "civil", "USA"));
		persons.put("Kohli", new Person("Kohli", "virat", "mech", "USA"));
		
		
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "status";
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Person> getAllPersons() {
		logger.info("Inside getAllIssuers() method...");
		
		return persons;
	}
	
	@RequestMapping(value="/person/{firstName}", method=RequestMethod.GET)
	@ResponseBody
	public Person getPersonByFirstName(@PathVariable("firstName") String firstName) {
		Person myPerson = persons.get(firstName); 
		
		if (myPerson != null) {
			logger.info("Inside getIssuerByTicker, returned: " + myPerson.toString());
		} else {
			logger.info("Inside getIssuerByTicker, ticker: " + firstName + ", NOT FOUND!");
		}
		return myPerson; 
	}

	@RequestMapping(value="/person/delete/{firstName}", method=RequestMethod.GET)
	@ResponseBody
	public Person deletePersonByFirstName(@PathVariable("firstName") String firstName) {
		Person myPerson = persons.remove(firstName); 
		
		if (myPerson != null) {
			logger.info("Inside deleteIssuerByTicker, deleted: " + myPerson.toString());
		} else {
			logger.info("Inside deleteIssuerByTicker, ticker: " + firstName + ", NOT FOUND!");
		}
		return myPerson;
	}

	@RequestMapping(value="/person/create", method=RequestMethod.GET)
	public ModelAndView addPerson() {
		
		return new ModelAndView("addPerson", "command", new Person ());
	}
	
	@RequestMapping(value="/person/addPerson", method=RequestMethod.POST)
	@ResponseBody
	public Person addPerson(@ModelAttribute("person") Person person) {
		
		if (person != null) {
			logger.info("Inside addIssuer, adding: " + person.toString());
		} else {
			logger.info("Inside addIssuer...");
		}
		persons.put(person.getFirstName(), person);
		return person;
		
	}
	
}
