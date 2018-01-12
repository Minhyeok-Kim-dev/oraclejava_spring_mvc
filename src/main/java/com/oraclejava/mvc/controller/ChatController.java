package com.oraclejava.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("/chat")
public class ChatController {
	// 전체 채팅메시지 보관
	private final List<DeferredResult<ChatMessage>> chatRequestData = 
			new ArrayList<DeferredResult<ChatMessage>>();
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home(HttpSession session) {
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/account/login";
		}
		
		return "chat";
	}
	
	// 메시지 수신
	@RequestMapping(value="/polling", method=RequestMethod.GET)
	@ResponseBody
	public DeferredResult<ChatMessage> getMessage() {
		// 타임아웃(30초)이 발생할 경우 빈 채팅 메시지를 전달해서 판단 (jQuery에서 타임아웃 판단시 사용)
		final DeferredResult<ChatMessage> deferredResult = 
				new DeferredResult<ChatMessage>(1000*30L, new ChatMessage("", ""));
		this.chatRequestData.add(deferredResult);
		
		// 데이터가 들어온 경우
		deferredResult.onCompletion(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("데이터 수신완료...");
				chatRequestData.remove(deferredResult);
			}
		});
		
		return deferredResult;
	}
	
	// 메시지 송신
	@RequestMapping(value="/push", method=RequestMethod.POST)
	@ResponseBody
	public void postMessage(@RequestParam String name, 
			@RequestParam String body) {
		// 접속중인 모든 리퀘스트 메시지 설정
		for(DeferredResult<ChatMessage> item : this.chatRequestData) {
			System.out.println("메시지 설정중...");
			item.setResult(new ChatMessage(name, body));
		}
	}
}
