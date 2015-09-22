package com.innominds.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innominds.spring.dao.PersonDBApi;
import com.innominds.spring.model.Person;

@Controller
public class PersonController {

	
	@RequestMapping(value="/showHome.do")
	public ModelAndView showHome(){
		return new ModelAndView("homepage");
	}
	
	@RequestMapping(value="/addPerson.do")
	public ModelAndView addPerson(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		Person person = new Person();
		person.setName(name);
		person.setCountry(country);
		
		if(new PersonDBApi().addPerson(person)){
			//success page
		}else{
			//error page
		}
		List<Person> personList = new PersonDBApi().getAllPersons();
		Map<String, List> model  = new HashMap<String, List>();
		model.put("personList", personList);
		return new ModelAndView("homepage",model);
	}
	
	@RequestMapping(value="/showAllPersons.do")
	public ModelAndView showAllPersons(){
		
		List<Person> personList = new PersonDBApi().getAllPersons();
		Map<String, List> model  = new HashMap<String, List>();
		model.put("personList", personList);
		return new ModelAndView("homepage",model);
	}
	
}

