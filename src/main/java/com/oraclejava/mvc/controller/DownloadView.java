package com.oraclejava.mvc.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

// Controller내 작업이 필요한 내용을 View를 두어서 작업분리
public class DownloadView implements View {

	private final String filename;
	private final String contentType;
	
	public DownloadView(String filename, String contentType) {
		this.filename = filename;
		this.contentType = contentType;
	}

	@Override
	public String getContentType() {
		return this.contentType;
	}

	@Override
	// Map<String, ?> model -> GENERIC형식 
	public void render(Map<String, ?> model,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		// HelloBoard DownloadServlet 참고
		try {
			String filename = URLEncoder.encode(this.filename, "UTF-8");
			
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			response.setContentType("application/octet-stream;charset=UTF-8");
					
			byte[] b = new byte[4096];
			
			FileInputStream fileInputStream = new FileInputStream("c:/upload/" + filename);
			
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			int numRead;
			while((numRead = fileInputStream.read(b, 0, b.length)) != -1) {
				servletOutputStream.write(b, 0, numRead);
			}
			
			servletOutputStream.flush();
			servletOutputStream.close();
			fileInputStream.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

}
