package com.poscoict.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscoict.mysite.service.SiteService;
import com.poscoict.mysite.vo.SiteVo;

@Controller
public class MainController {
	@Autowired
	@RequestMapping({"", "/main"})
	public String index() {
		return "main/index";
	}
}