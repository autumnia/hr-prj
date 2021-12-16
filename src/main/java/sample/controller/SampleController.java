package com.mz.hr.sample.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mz.hr.constant.UserRoleStatus;
import com.mz.hr.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/sample")
@Controller
public class SampleController {

	@GetMapping("ex06")
	public String ex06(Model model)  throws Exception {
		
		return "sample/ex06";
	}			
	
	@GetMapping("ex05")
	public String ex05(Model model)  throws Exception {
		List<MemberDto> memberList = new ArrayList();
		
		for( int i=1; i<=10; i++ ) {
			MemberDto memberDto = new MemberDto();
			memberDto.setId( new Long(i) );
			memberDto.setName("김가을" + i);
			memberDto.setEmail("kke" + i + "@mz.co.kr");
			memberDto.setRole(UserRoleStatus.USER);
			memberDto.setCreatedAt(LocalDateTime.now());
			memberList.add( memberDto );
		}
		
		model.addAttribute("memberList", memberList);
		return "sample/ex05";
	}		
	
	@GetMapping("ex04")
	public String ex04(Model model)  throws Exception {
		List<MemberDto> memberList = new ArrayList();
		
		for( int i=1; i<=10; i++ ) {
			MemberDto memberDto = new MemberDto();
			memberDto.setId( new Long(i) );
			memberDto.setName("김가을" + i);
			memberDto.setEmail("kke" + i + "@mz.co.kr");
			memberDto.setRole(UserRoleStatus.USER);
			memberDto.setCreatedAt(LocalDateTime.now());
			memberList.add( memberDto );
		}
		
		model.addAttribute("memberList", memberList);
		return "sample/ex04";
	}			
	
	@GetMapping("ex03")
	public String ex03(Model model)  throws Exception {
		List<MemberDto> memberList = new ArrayList();
		
		for( int i=1; i<=10; i++ ) {
			MemberDto memberDto = new MemberDto();
			memberDto.setId( new Long(i) );
			memberDto.setName("김가을" + i);
			memberDto.setEmail("kke" + i + "@mz.co.kr");
			memberDto.setRole(UserRoleStatus.USER);
			memberDto.setCreatedAt(LocalDateTime.now());
			memberList.add( memberDto );
		}
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("errorMsg", "에러야");
		return "sample/ex03";
	}			
	
	@GetMapping("ex02")
	public String ex02(Model model)  throws Exception {
		MemberDto memberDto = new MemberDto();
		memberDto.setId( 1L );
		memberDto.setName("김가을");
		memberDto.setEmail("kke@mz.co.kr");
		memberDto.setRole(UserRoleStatus.USER);
		memberDto.setCreatedAt(LocalDateTime.now());
		
		model.addAttribute("memberDto", memberDto);
		return "sample/ex02";
	}			
	
	//  타임리스 연습
	@GetMapping("/ex01")
	public String ex01(Model model)  throws Exception {
		model.addAttribute("data", "타임리프 예제 입니다.");
		return "sample/ex01";
	}
	


}
