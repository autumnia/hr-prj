package com.mz.hr.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mz.hr.constant.HolidayStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Entity(name="holiday")
public class Holiday {
	@Id 
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="holiday_id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private HolidayStatus holidayStatus;
	
	@Column(name="startAt", nullable=false)
	private LocalDateTime startAt;
	
	@Column(name="endAt", nullable=false)
	private LocalDateTime endAt;
	
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	// 연관관계
	
	
	// 연관관계 함수
	
}
