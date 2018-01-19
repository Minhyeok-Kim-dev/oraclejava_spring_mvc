package com.oraclejava.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oraclejava.mvc.model.Bbs;
import com.oraclejava.mvc.model.BbsFile;

public interface BbsMapper {
	// Bbs
	@Select("SELECT * FROM bbs ORDER BY bbsno DESC")
	List<Bbs> selectBbs();
	
	@Select("SELECT * FROM bbs WHERE BBSNO = #{bbsno}")
	Bbs selectBbsByBbsNo(int bbsNo);
	
	@Update("UPDATE bbs SET READCOUNT=(READCOUNT+1) WHERE BBSNO = #{bbsno}")
	void updateBbsReadCountByBbsNo(int bbsno);
	
	//@Insert("INSERT INTO bbs(BBSNO, TITLE, UPLOADER, CONTENT)"
	//		+ " VALUES (bbs_seq.nextval, #{title}, #{uploader}, #{content})")
	void insertBbs(Bbs bbs);
	
	
	// BbsFile
	@Select("SELECT * FROM bbsfile WHERE BBSNO = #{bbsno}")
	List<BbsFile> selectBbsFilesByBbsNo(int bbsNo);
	
	@Select("SELECT * FROM bbsfile WHERE BBSFILENO = #{bbsfileno}")
	BbsFile selectBbsFileByBbsFileNo(int bbsFileNo);
	
	@Insert("INSERT INTO bbsfile(BBSFILENO, BBSNO, SAVEDFILENAME, USERFILENAME)"
			+ "VALUES (bbsfile_seq.nextval, #{bbsno}, #{savedfilename}, #{userfilename})")
	void insertBbsFile(BbsFile file);
	
	@Update("UPDATE bbsfile SET DOWNLOADCOUNT = (DOWNLOADCOUNT + 1) WHERE BBSFILENO = #{bbsfileno}")
	void updateBbsFileDownloadCountByBbsFileNo(int bbsFileNo);
	
}
