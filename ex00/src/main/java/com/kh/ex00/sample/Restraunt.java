package com.kh.ex00.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;


@Component
@Data
@AllArgsConstructor
public class Restraunt {
	@Autowired
	private Chef chef;
}
