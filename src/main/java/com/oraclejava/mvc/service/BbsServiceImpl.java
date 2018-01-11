package com.oraclejava.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.mvc.controller.BbsForm;
import com.oraclejava.mvc.controller.FileItem;
import com.oraclejava.mvc.mapper.BbsMapper;
import com.oraclejava.mvc.model.Bbs;
import com.oraclejava.mvc.model.BbsFile;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsMapper bbsMapper;

	@Override
	public List<Bbs> selectBbs() {
		return bbsMapper.selectBbs();
	}

	@Override
	public void writeBbs(BbsForm bbsForm) {
		Bbs bbs = new Bbs();
		bbs.setTitle(bbsForm.getTitle());
		bbs.setUploader(bbsForm.getUploader());
		bbs.setContent(bbsForm.getContent());
		bbs.setReadcount(0);
		
		bbsMapper.insertBbs(bbs);
		
		BbsFile bbsFile = new BbsFile();
		
		for(FileItem file : bbsForm.getFileItems()) {
			bbsFile.setSavedfilename(file.getSavedfilename());
			bbsFile.setUserfilename(file.getUserfilename());
			bbsFile.setBbsno(bbs.getBbsno());
			bbsFile.setDownloadcount(0);
			
			bbsMapper.insertBbsFile(bbsFile);
		}
	}

	@Override
	public BbsForm detailBbs(int bbsNo) {
		// 조회수 증가
		bbsMapper.updateBbsReadCountByBbsNo(bbsNo);
		
		BbsForm bbsform = new BbsForm();
		Bbs bbs = bbsMapper.selectBbsByBbsNo(bbsNo);
		
		bbsform.setBbsno(bbs.getBbsno());
		bbsform.setTitle(bbs.getTitle());
		bbsform.setContent(bbs.getContent());
		bbsform.setReadcount(bbs.getReadcount());
		bbsform.setUploader(bbs.getUploader());
		bbsform.setRegdate(bbs.getRegdate());
		
		List<BbsFile> files = bbsMapper.selectBbsFilesByBbsNo(bbsNo);
		for(BbsFile file : files) { 
			FileItem item = new FileItem();
			item.setSavedfilename(file.getSavedfilename());
			item.setUserfilename(file.getUserfilename());
			item.setBbsfileno(file.getBbsfileno());
			item.setDownloadcount(file.getDownloadcount());
			
			bbsform.getFileItems().add(item);
		}
		
		return bbsform;
	}

	@Override
	public BbsFile selectBbsFile(int bbsFileNo) {
		return bbsMapper.selectBbsFileByBbsFileNo(bbsFileNo);
	}

}
