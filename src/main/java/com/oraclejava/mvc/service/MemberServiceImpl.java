package com.oraclejava.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.mvc.mapper.MemberMapper;
import com.oraclejava.mvc.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	// 내부적으로 트랜잭션처리 (root-context.xml에 tx:annotation-driven 등록 후 사용)
	@Transactional(readOnly=false, rollbackFor = Exception.class) 
	@Override
	public void insertMember(Member member) throws Exception {
		memberMapper.insertMember(member);
		
		int count = 1;
		if(count == 1) {
			throw new RuntimeException("Roll~~back");
		}
	}

}
