package com.oraclejava.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oraclejava.mvc.mapper.RbbsMapper;
import com.oraclejava.mvc.model.Rbbs;

@Controller
@RequestMapping("/rbbs")
public class RbbsController {

	@Autowired
	private RbbsMapper rbbsMapper;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home(HttpSession session) {
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/account/login";
		}
		
		return "rbbs";
	}
	
	@RequestMapping(value="/getItems", method = RequestMethod.GET)
	@ResponseBody
	public RbbsResult getItems() {
		RbbsResult result = new RbbsResult();

		try {
			List<Rbbs> list = rbbsMapper.getItems();
			
			RbbsJson json = new RbbsJson();
			json.setLogs(list);
			json.setMsg("success");
		
			result.setResult(json);
		} catch (Exception e) {
			e.printStackTrace();
			
			RbbsJson json = new RbbsJson();
			json.setLogs(null);
			json.setMsg("error");

			result.setResult(json);
		}
		
		return result;
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	@ResponseBody
	public RbbsResult write(@RequestParam String name,
			@RequestParam String body) {
		
		RbbsResult result = new RbbsResult();
		
		try {
			Rbbs rbbs = new Rbbs();
			rbbs.setName(name);
			rbbs.setBody(body);
			
			rbbsMapper.write(rbbs);
			
			RbbsJson json= new RbbsJson();
			json.setId(rbbs.getBbsno());
			json.setMsg("success");
			
			result.setResult(json);
		} catch (Exception e) {
			e.printStackTrace();
			
			RbbsJson json= new RbbsJson();
			json.setMsg("error");
			
			result.setResult(json);
		}
		
		return result;
	}	
}
