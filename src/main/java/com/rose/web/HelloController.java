package com.rose.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		mav.addObject("title","申込フォーム");
		mav.addObject("msg1","名前とメールアドレスを入力して下さい。");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam("name")String name,
			@RequestParam("mail")String mail,
			ModelAndView mav){
		String res="Your Name= "+name+" : Your Mail= "+mail;
		mav.addObject("title","Result");
		mav.addObject("msg1",res);
		mav.setViewName("index");
		return new ModelAndView("forward:/result");
	}
}
