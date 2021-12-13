package com.mz.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mz.hr.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
	
	public Member findByName( String name );
	
}
