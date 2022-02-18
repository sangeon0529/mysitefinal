package com.poscoict.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.mysite.vo.GalleryVo;

@Repository
public class GalleryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean savaImage(GalleryVo vo) {
		return sqlSession.insert("gallery.saveimage",vo) == 1;
		
	}

	public List<GalleryVo> getImages() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gallery.getimages");
	}

	public boolean removeImage(Long no) {
		// TODO Auto-generated method stub
		return sqlSession.delete("gallery.removeimage", no) == 1;
	}

}
