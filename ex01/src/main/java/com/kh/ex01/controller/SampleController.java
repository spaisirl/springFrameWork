package com.kh.ex01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.dto.PersonDTO;
import com.kh.ex01.dto.SampleDTO;
import com.kh.ex01.dto.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic", method = RequestMethod.GET)
	public void basicGet() {
		log.info("basicGet....");
	}
	
	@GetMapping("/basic2")
	public void basicGet2() {
		System.out.println("basicGet2");
	}
	
	// sample/daA?=age20%name=hong
	@GetMapping("/doA")
	public String doA(String name, int age) {
		System.out.println("name " + name);
		System.out.println("age " + age);
		return "doA";
	}
	
	@GetMapping("/doB")
	public String doB(SampleDTO sampleDTO) {
		//커맨드 객체
		System.out.println("sampleDTO:" + sampleDTO);
		return "doB";
	}
	
	@GetMapping("/doC")
	public void doC(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println("ids:" + ids);
	}
	
	// http://localhost/sample/doD?ids=1&ids=2&ids=3
	@GetMapping("/doD")
	public void doD(@RequestParam("ids") ArrayList<Integer> ids) {
		System.out.println("ids:" + ids);
	}
	
	// 인코딩 문자 - > [ : %5B, ] : %5D
	// http://localhost/sample/doE?list[0].name=hong&list[0].age=20
	//	&list[1].name=kim&list[1].age=30
	@GetMapping("/doE")
	public void doE(SampleDTOList list) {
		System.out.println("list:" + list); 
	}
	
	//http://localhost/sample/doF?name=hong&birth=2000-01-01
	@GetMapping("/doF")
	public void doF(PersonDTO personDTO) {
		System.out.println("personDTO: " + personDTO);
	}
	
	//http://localhost/sample/doG?name=hong&age=20&page=1
	@GetMapping("/doG")
	public String doG(SampleDTO sampleDTO, 
			@ModelAttribute("page") int page) {
		System.out.println("sampleDTO: " + sampleDTO);
		System.out.println("page: " + page);
		return "doG";
	}
	
	@GetMapping("/doH")
	public String doH(RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", "success");
		return "redirect:/sample/doI";
	}
	
	@GetMapping("/doI")
	public String doI(RedirectAttributes rttr) {
		
		return "/doI";
	}
	
	@GetMapping("/doJ")
	public void doJ() {
		// 반환타입 void
		// 메서드 명 x, 요청 경로 명 o
		// /WEB-INF/view/sample/doJ.jsp
		
	}
	
	@GetMapping("/doK")
	@ResponseBody
	public SampleDTO doK() {
		// SampleDTO dto = new SampleDTO();
		SampleDTO dto = SampleDTO.builder()
				.name("홍길동")
				.age(20)
				.build();
		return dto;
	}
	
	@GetMapping("/doL")
	@ResponseBody
	public List<SampleDTO> doL() {
		List<SampleDTO> list = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			SampleDTO dto = SampleDTO.builder()
					.name("홍길동" + i)
					.age(20 + i)
					.build();
			list.add(dto);
		}
		return list;
	}
	
	@GetMapping("/doM")
	@ResponseBody
	public ResponseEntity<String> doM() {
		//String msg = "hello";
		// 못 받아 올 것, 단 @ResponseBody를 붙이면 나온다.
		String msg = "{\"name\" : \"홍길동\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		ResponseEntity<String> entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
	}
	
	@PostMapping("/exUploadPost")
	public void upload(ArrayList<MultipartFile> files) {
		log.info("files:"+files);
		for (MultipartFile file : files) {
//			log.info("file: " + file);
			String fileName = file.getOriginalFilename();
			long size = file.getSize();
			log.info(size + ":" + fileName);
		}
	}
}
