package com.oraclejava.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oraclejava.mvc.model.Member;
import com.oraclejava.mvc.service.MemberService;
import com.oraclejava.mvc.service.MemberServiceImpl;

@Controller
@RequestMapping("/account")	// url routing
public class AccountController {
	
	@Autowired
	private MemberService memberService;
	
	// .../account/login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Map<String, Object> model) {
		model.put("memberForm", new MemberForm());
		
		return "account/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Map<String, Object> model,
			HttpSession session,MemberForm form) {
		
		String memberId = form.getMemberid();
		String passwd = form.getPasswd();
		
		Member member = memberService.selectMemberByIdAndPassword(memberId, passwd);
		
		if(member != null)
		{
			session.setAttribute("loginUser", member);
			return "redirect:/";
		} else {
			model.put("fail", "login fail");
			return "account/login";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registMember(Map<String, Object> model) {
		model.put("memberForm", new MemberForm());
		return "account/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registMember(MemberForm form) throws Exception {
		Member member = new Member();
		member.setMemberid(form.getMemberid());
		member.setPasswd(form.getPasswd());
		member.setEmail(form.getEmail());
		member.setUsertype("user");
		member.setActive("1");
		
		memberService.insertMember(member);
		
		return "redirect:/account/login";
	}
}
