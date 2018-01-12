package com.oraclejava.mvc.mapper;

import java.util.List;

import com.oraclejava.mvc.model.Rbbs;

public interface RbbsMapper {
	// 날짜 역순으로 목록 불러오기
	List<Rbbs> getItems();
	
	// 글쓰기
	void write(Rbbs b);
}
