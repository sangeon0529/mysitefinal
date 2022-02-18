package com.poscoict.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.mysite.repository.GalleryRepository;
import com.poscoict.mysite.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;
	
	public List<GalleryVo> getImages() {
		
		return galleryRepository.getImages();
	}

	public void saveImage(GalleryVo vo) {
		galleryRepository.savaImage(vo);
		
	}

	public boolean removeImage(Long no) {
		// TODO Auto-generated method stub
		return galleryRepository.removeImage(no);
	}

}