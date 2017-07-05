package com.rose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rose.web.repositories.MyDataRepository;

@Controller
public class HelloController {

	@Autowired
	MyDataRepository repository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("formModel")MyData mydata,
			ModelAndView mav){
		mav.addObject("title","申込フォーム");
		mav.addObject("msg1","this is sample content.");
		Iterable<MyData>list=repository.findAll();
		mav.addObject("datalist",list);
		mav.setViewName("index");
		return mav;
	}	
}
