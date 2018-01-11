package com.oraclejava.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.oraclejava.mvc.model.Bbs;
import com.oraclejava.mvc.model.BbsFile;
import com.oraclejava.mvc.service.BbsService;
import com.oraclejava.mvc.service.MemberService;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpSession session, Map<String, Object> model) {
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/account/login";
		} 
		
		model.put("bbsList", bbsService.selectBbs());
		
		return "bbs/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(HttpSession session, Map<String, Object> model) {
		model.put("bbsForm", new BbsForm());
		return "bbs/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpSession session, Map<String, Object> model,
			BbsForm bbsForm) throws IllegalStateException, IOException {
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/account/login";
		}
		
		CommonsMultipartFile[] files = bbsForm.getFiles();
		for(CommonsMultipartFile file : files) {
			String savedFileName = Instant.now().toString().replace(":", "") + "-" + file.getOriginalFilename();
			File uploadFile = new File("c:/upload/", savedFileName);
			file.transferTo(uploadFile);
		
			FileItem item = new FileItem();
			item.setSavedfilename(savedFileName);
			item.setUserfilename(file.getOriginalFilename());
			
			bbsForm.getFileItems().add(item);
		}
		
		bbsService.writeBbs(bbsForm);
		
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/detail/{bbsno}", method=RequestMethod.GET)
	public String detail(@PathVariable("bbsno") int bbsno,
			HttpSession session, Map<String, Object> model) {
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/account/login";
		}
		
		BbsForm bbsform = bbsService.detailBbs(bbsno);
		
		model.put("bbsform", bbsform);
		
		return "bbs/detail";
	}
}
