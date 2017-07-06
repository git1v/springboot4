package com.rose.web;

import javax.annotation.PostConstruct;

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
	
	@PostConstruct
	public void init(){
		MyData d1=new MyData();
		d1.setName("tuyano");
		d1.setAge(123);
		d1.setMail("abc@ccc.com");
		d1.setMemo("This is memo by tuyano");
		repository.saveAndFlush(d1);
		MyData d2=new MyData();
		d2.setName("yamada");
		d2.setAge(34);
		d2.setMail("yama@ttt.com");
		d2.setMemo("How are you ?");
		repository.saveAndFlush(d2);
		MyData d3=new MyData();
		d3.setName("maya");
		d3.setAge(15);
		d3.setMail("rose@ttt.com");
		d3.setMemo("you are kidding me");
		repository.saveAndFlush(d3);
	}
	
}
