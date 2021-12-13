package com.mz.hr.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mz.hr.constant.UserRoleStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Entity(name="member")
public class Member {
	@Id 
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="member_id")
	private Long id;
	
	@Column( nullable=false)
	private String email;
	
	@Column( nullable = false )
	private String name;
	
	@Enumerated(EnumType.STRING)
	private UserRoleStatus role;
	
	private LocalDateTime createdAt;
}
