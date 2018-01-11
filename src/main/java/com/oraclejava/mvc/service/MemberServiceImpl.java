package com.oraclejava.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.oraclejava.mvc.mapper.MemberMapper;
import com.oraclejava.mvc.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	// 내부적으로 트랜잭션처리 (root-context.xml에 tx:annotation-driven 등록 후 사용)
	//@Transactional(readOnly=false, rollbackFor = Exception.class) 
	@Override
	public void insertMember(Member member) throws Exception {
		
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			memberMapper.insertMember(member);
			
/*
			// 강제 rollback 처리
			int count = 1;
			if(count == 1) {
				throw new RuntimeException("Roll~~~back!");
			}		
*/			
			transactionManager.commit(status);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("롤백처리됩니다.");
			throw e;
		}
		
	}

	@Override
	public Member selectMemberByIdAndPassword(String memberid, String passwd) {
		return memberMapper.selectMemberByIdAndPassword(memberid, passwd);
	}

}
