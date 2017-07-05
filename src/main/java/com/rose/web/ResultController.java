package com.rose.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(
			@RequestParam("name")String name,
			@RequestParam("mail")String mail,
			ModelAndView mav){
		String res="Your Name= "+name+" : Your Mail= "+mail;
		mav.addObject("title","Result");
		mav.addObject("msg1",res);
		mav.setViewName("result");
		return mav;
	}
}
