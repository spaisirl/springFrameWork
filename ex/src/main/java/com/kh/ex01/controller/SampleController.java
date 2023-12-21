package com.kh.ex01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.vo.ProductVO;

@Controller
public class SampleController {
	
	@RequestMapping(value="/doA", method = RequestMethod.GET)
	public void doA() {
		// 반환타입이 void : 요청경로.jsp로 포워딩
		System.out.println("doA");
	}
	@RequestMapping(value="/doB", method = RequestMethod.GET)
	public String doB() {
		// 반환타입이 String : // WEB-INF/views/반환값.jsp로 포워딩
		System.out.println("doB");
		return "dooB";
	}
	
	@RequestMapping(value="/doC", method = RequestMethod.GET)
	public String doC(String msg) {
		System.out.println("msg: " + msg);
		return "doC";
	}
	
	@RequestMapping(value="/doD", method = RequestMethod.GET)
	public String doD(@RequestParam("message") String msg) {
		System.out.println("msg: " + msg);
		return "doD";
	}
	
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public String doE(String msg, String name, Model model) {
		System.out.println("msg:" + msg);
		System.out.println("name:" + name);
		String greeting = name + "님, " + msg;
		// view로 전달할 데이터 바구니
		model.addAttribute("greeting", greeting);
		return "doE";
	}
	
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
	public String doF(Model model) {

		ProductVO vo = new ProductVO("iPhone", 10000);
		//model.addAttribute(vo);
		//키가 생략되면, "productVO" - 키
		// model.addAttribute("productVO", vo);
		
		model.addAttribute("vo", vo);
		
		return "doF";
	}
	
	@RequestMapping(value = "/doG", method = RequestMethod.GET)
	public String doG(RedirectAttributes rttr) {
		
		System.out.println("doG");
		rttr.addFlashAttribute("result", "success");
		return "redirect:/doF"; // doF로 리다이렉트
	}
	
	@RequestMapping(value = "/doH", method = RequestMethod.GET)
	@ResponseBody 
	public List<ProductVO> doH(Model model) {
		// @ResponseBody : JSONArray, JSONObject를 쓸 수 있다.
		List<ProductVO> list = new ArrayList<>();
		for (int i = 1; i <=10; i++) {
			ProductVO vo = new ProductVO("갤럭시-" + i, 20000 * i);
			list.add(vo);
		}
		return list;
	}
}
