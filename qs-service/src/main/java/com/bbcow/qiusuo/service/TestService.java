package com.bbcow.qiusuo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbcow.qiusuo.mongo.TestDAO;

@Service
public class TestService {
	@Autowired
	private TestDAO testDAO;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void test(){
		testDAO.test();
		logger.info("---");
		
	}
}
