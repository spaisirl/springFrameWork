package com.kh.ex01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SampleDTO {
	
	private String name;
	
	private int age;
}
