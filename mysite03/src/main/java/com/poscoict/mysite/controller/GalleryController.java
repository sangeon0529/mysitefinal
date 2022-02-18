package com.poscoict.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscoict.mysite.security.Auth;
import com.poscoict.mysite.service.FileUploadService;
import com.poscoict.mysite.service.GalleryService;
import com.poscoict.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GalleryVo> list = galleryService.getImages();
		model.addAttribute("list",list);
		return "gallery/index";
	}
	
	@Auth(role="ADMIN")
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no) {
		galleryService.removeImage(no);
		System.out.println("delete:" + no);
		return "redirect:/gallery";
	}

	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile multipartFile,
			GalleryVo vo,
			@RequestParam(value="comments", required= true, defaultValue="") String comments) {
		String url = fileUploadService.restore(multipartFile);
		if(url != null) {
			vo.setUrl(url);
		}
		System.out.println(url);
		galleryService.saveImage(vo);
		System.out.println("comments:" + comments);
		return "redirect:/gallery";
	}
}
