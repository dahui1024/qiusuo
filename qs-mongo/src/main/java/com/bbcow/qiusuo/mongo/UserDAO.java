package com.bbcow.qiusuo.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbcow.qiusuo.mongo.entity.User;

@Component
public class UserDAO extends BasicDAO<User, ObjectId> {
	
	protected UserDAO(@Autowired Datastore datastore) {
		super(datastore);
	}

	public void test(){
		System.out.println("----------------"+this.count());
	}
}
