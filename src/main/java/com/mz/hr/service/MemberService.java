package com.mz.hr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mz.hr.constant.UserRoleStatus;
import com.mz.hr.entity.Member;
import com.mz.hr.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public String getMember() {
		return "";
	}
	
	public void saveMember() throws Exception {
		Member aMember = new Member();
		aMember.setEmail("autumnya@gamil.com");
		aMember.setName("김가을");
		aMember.setRole(UserRoleStatus.USER);
		aMember.setCreatedAt(LocalDateTime.now());		
		
		this.memberRepository.save( aMember );
	}

	public void getMember(String value) {
		Member result = this.memberRepository.findByName( value );
		log.debug( result.toString() );
	}

	public List<Member> getMemberList(String string) {
		List<Member> members = this.memberRepository.findAll();
		return members;
	}
}
