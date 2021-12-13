package com.mz.hr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.hr.entity.Member;
import com.mz.hr.service.MemberService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
	private final MemberService memberService;

//	@GetMapping(value={"/list"})
//	public String getMemberList() throws Exception {
//		List<Member> members = this.memberService.getMemberList("김가을");
//		
//		return "/member/list";
//	}	
	
	@GetMapping(value={"/one"})
	public String getMember() throws Exception {
		this.memberService.getMember("김가을");
		
		return "/member/one";
	}	
	
	@GetMapping(value="/join")
	public String saveMember() throws Exception {
		this.memberService.saveMember();
		
		return "/member/join";
	}
}
