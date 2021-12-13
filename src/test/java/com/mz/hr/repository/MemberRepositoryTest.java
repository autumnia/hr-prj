package com.mz.hr.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mz.hr.constant.UserRoleStatus;
import com.mz.hr.entity.Member;
import com.mz.hr.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class MemberRepositoryTest {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	MemberRepository memberRepository;

	private void createMemberList(int size) {
		for ( int i=1; i<=size; i++ ) {
			Member member = new Member();
			member.setEmail("autumnya" + i + "@gamil.com");
			member.setName("김가을" + i );
			member.setRole(UserRoleStatus.USER);
			member.setCreatedAt(LocalDateTime.now());
			
			this.memberRepository.save( member ) ;
		}
	}		
	
	private Member createMember() {
		Member member = new Member();
		member.setEmail("autumnya@gamil.com");
		member.setName("김가을");
		member.setRole(UserRoleStatus.USER);
		member.setCreatedAt(LocalDateTime.now());
		
		return member;
	}	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
//	@Test
//	@DisplayName("단체입력  테스트")
//	void listTest() {
//		createMemberList(10);
//		
//		List<Member> members = this.memberRepository.findAll();
//		for ( Member member: members) {
//			log.debug( "시작: {}", member.toString() );
//		}
//	}

//	@Test
//	@DisplayName("입력 테스트")
//	void insertTest() {
//		Member newMember = this.createMember();
//		Member savedMember = this.memberRepository.save( newMember ) ;
//		
//		log.debug( savedMember.toString() );
//	}

//	@Test
//	@DisplayName("querydsl 테스트")	
//	void queryDSLTest() {
//		this.createMemberList(10);
//		
//		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//		QMember qMember = QMember.member;
//		
//		JPAQuery<Member> query = queryFactory.selectFrom(qMember)
//				.where(qMember.role.eq(UserRoleStatus.USER)  )
//				.where(qMember.name.like("%" + "김가을2" +"%"))
//				.orderBy(qMember.name.asc());
//		
//		List<Member> members = query.fetch();
//
//		for ( Member member: members ) {
//			log.debug("결과: {}", member.toString());
//		}
//	}
	
	@Test
	@DisplayName("querydsl paging 테스트 ")	
	void queryDSLPagingTest() {
		this.createMemberList(30);
		
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		BooleanBuilder bBuilder = new BooleanBuilder();
		
		QMember qMember = QMember.member;
		bBuilder.and( qMember.role.eq(UserRoleStatus.USER) );
//			.and( qMember.name.like("%" + "김가을9" +"%") );
		
		Pageable pageable = PageRequest.of(0, 5);
		Page<Member> members = memberRepository.findAll(bBuilder, pageable);
		
		log.debug("전체멤버수: {}", members.getTotalElements() );
		
		List<Member> lists = members.getContent();
		for ( Member member: lists) {
			log.debug( "데이타: {}", member.toString());
		}

	}	
	

}
