package com.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		
		return "nicePage/Home";
		//return "home";
		
	}
	
	
	@RequestMapping(value = "/resume", method = RequestMethod.GET)
	public String resume(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		model.addAttribute("Licence1", "워드프로세서" );
		model.addAttribute("highSchoolGradulate", "순천 제일 고등학교 졸업" );
		model.addAttribute("armyServiceDischarge", "군 전역" );
		model.addAttribute("Licence2", "컴활 1급" );
		model.addAttribute("Licence3", "정보처리기사 취득" );
		model.addAttribute("collegeGradulate", "전남대학교 졸업" );
		model.addAttribute("ChamberOfCommerenceGradulate", "상공회의소 국비교육 수료" );
		
		return "nicePage/resume";
		//return "home";
		
	}
}
