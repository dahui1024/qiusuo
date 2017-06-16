package com.bbcow.qiusuo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbcow.qiusuo.mongo.UserDAO;

@Service
public class TestService {
	@Autowired
	private UserDAO testDAO;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void test(){
		testDAO.test();
		logger.info("---");
		
	}
}
