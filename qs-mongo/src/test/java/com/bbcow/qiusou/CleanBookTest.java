package com.bbcow.qiusou;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.bbcow.qiusuo.mongo.client.DatastoreFactoryBean;

@ContextConfiguration(locations = { "/applicationContext-mongo.xml" })
public class CleanBookTest extends AbstractJUnit4SpringContextTests{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DatastoreFactoryBean datastore;
	@Test
	public void test(){
		logger.info("---");
	}
}
