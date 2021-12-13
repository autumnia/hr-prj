package com.mz.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.hr.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class HomeController {
	
	@GetMapping(value={"/portal", ""})
	public String home()  throws Exception {

		return "/portal/index";
	}
	
}
