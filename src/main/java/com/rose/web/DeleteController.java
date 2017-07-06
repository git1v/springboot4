package com.rose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rose.web.repositories.MyDataRepository;

@Controller
public class DeleteController {

	@Autowired
	MyDataRepository repository;
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView mav){
		mav.setViewName("delete");
		mav.addObject("title","delete data");
		MyData data=repository.findById((long)id);
		mav.addObject("formModel",data);
		return mav;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@RequestParam long id, ModelAndView mav){
		repository.delete(id);
		return new ModelAndView("redirect:/");
		
	}
}
