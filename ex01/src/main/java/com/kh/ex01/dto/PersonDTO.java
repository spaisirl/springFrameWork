package com.kh.ex01.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import lombok.Data;

@Data
public class PersonDTO {
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
}
