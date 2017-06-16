package com.bbcow.qiusuo.mongo.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

@Entity(noClassnameStored = true, value = "user_token")
public class UserToken {
	@Id
	private ObjectId id;
	private ObjectId user_id;
	@Indexed(options = @IndexOptions(unique = true))
	private String token;
	private Date refresh_time;
	private Date expired_time;
	private int is_valid;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getUser_id() {
		return user_id;
	}

	public void setUser_id(ObjectId user_id) {
		this.user_id = user_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getRefresh_time() {
		return refresh_time;
	}

	public void setRefresh_time(Date refresh_time) {
		this.refresh_time = refresh_time;
	}

	public Date getExpired_time() {
		return expired_time;
	}

	public void setExpired_time(Date expired_time) {
		this.expired_time = expired_time;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

}
