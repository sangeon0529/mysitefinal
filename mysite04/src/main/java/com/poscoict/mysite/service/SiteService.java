package com.poscoict.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.mysite.repository.SiteRepository;
import com.poscoict.mysite.vo.SiteVo;

@Service
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;
	
	
	public SiteVo getSite() {
		// TODO Auto-generated method stub
		return siteRepository.findAll();
	}


	public boolean update(SiteVo vo) {
		int count = siteRepository.update(vo);
		return count == 1;
	}

}
