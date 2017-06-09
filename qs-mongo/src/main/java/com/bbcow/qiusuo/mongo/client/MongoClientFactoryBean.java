package com.bbcow.qiusuo.mongo.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoClientFactoryBean extends AbstractFactoryBean<MongoClient> {
	
	private String userName;
	private String password;
	private String dataBaseName;
	/**
	 * 表示服务器列表
	 */
	private String servers;
	
	private int connectTimeout;
	private int maxWaitTime;
	private int connectionsPerHost;
	private int maxConnectionIdleTime;
	private int maxConnectionLifeTime;
	/**
	 * mongo配置对象
	 */
	private MongoClientOptions mongoOptions;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public MongoClientOptions getMongoOptions() {
		return mongoOptions;
	}

	public void setMongoOptions(MongoClientOptions mongoOptions) {
		this.mongoOptions = mongoOptions;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public int getConnectionsPerHost() {
		return connectionsPerHost;
	}

	public void setConnectionsPerHost(int connectionsPerHost) {
		this.connectionsPerHost = connectionsPerHost;
	}

	public int getMaxConnectionIdleTime() {
		return maxConnectionIdleTime;
	}

	public void setMaxConnectionIdleTime(int maxConnectionIdleTime) {
		this.maxConnectionIdleTime = maxConnectionIdleTime;
	}

	public int getMaxConnectionLifeTime() {
		return maxConnectionLifeTime;
	}

	public void setMaxConnectionLifeTime(int maxConnectionLifeTime) {
		this.maxConnectionLifeTime = maxConnectionLifeTime;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoClient.class;
	}

	@Override
	protected MongoClient createInstance() throws Exception {
		MongoClientOptions clientOptions = MongoClientOptions.builder().connectionsPerHost(connectionsPerHost)
				.maxConnectionLifeTime(maxConnectionLifeTime).maxConnectionIdleTime(maxConnectionIdleTime)
				.maxWaitTime(maxWaitTime).connectTimeout(connectTimeout).build();
		
		MongoCredential credential = MongoCredential.createCredential(userName, dataBaseName, password.toCharArray());
		List<MongoCredential> list = new ArrayList<MongoCredential>();
		list.add(credential);
		return new MongoClient(getServerList(), list, clientOptions);
	}

	/**
	 * 获取mongo地址
	 * 
	 * @return
	 */
	private List<ServerAddress> getServerList() throws Exception {
		List<ServerAddress> serverList = new ArrayList<ServerAddress>();
		try {
			String[] serverArray = servers.split(",");
			for (String server : serverArray) {
				String[] temp = server.split(":");
				String host = temp[0];
				if (temp.length > 2) {
					throw new IllegalArgumentException("Invalid server address string:" + server);
				}
				if (temp.length == 2) {
					serverList.add(new ServerAddress(host, Integer.parseInt(temp[1])));
				} else {
					serverList.add(new ServerAddress(host));
				}
			}
			return serverList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while converting serverString to ServerAddressList", e);
		}
	}
}
