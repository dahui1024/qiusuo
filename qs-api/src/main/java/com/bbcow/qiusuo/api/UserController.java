package com.bbcow.qiusuo.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbcow.qiusuo.service.TestService;

@Controller
public class UserController {
	@Autowired
	private TestService testService;
		
	
	@RequestMapping(path = "/")
	public @ResponseBody Object index() {
		testService.test();
		return new ArrayList<>();
	}
}
