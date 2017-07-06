package com.rose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rose.web.repositories.MyDataRepository;

@Controller
public class EditController {
	@Autowired
	MyDataRepository repository;
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute MyData mydata,
			@PathVariable int id, 
			ModelAndView mav){
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata");
		MyData data=repository.findById((long)id);
		mav.addObject("formModel",data);
		return mav;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute MyData mydata,
			ModelAndView mav){
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}
}
