package com.oraclejava.mvc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.oraclejava.mvc.model.Member;

public interface MemberMapper {
	// Mapper.xml에서 Query 처리시
	void insertMember(Member member);
	
	// Annotation으로 Query 처리시
	@Select("SELECT * FROM members WHERE MEMBERID = #{memberid} AND PASSWD = #{passwd}")
	// Member Bean에서 찾아 Bind
	//Member selectMemberByIdAndPassword(String memberId, String passwd);
	
	// Param과 Select Annotation Bind하는 경우
	Member selectMemberByIdAndPassword(@Param("memberid") String memberid, @Param("passwd") String passwd);
	
	
}
