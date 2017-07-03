package com.study.run;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private ComboPooledDataSource cpd = null;
	private String jdbcUrl;
	private String user;
	private String password;
	private int initialPoolSize;
	private int maxPoolSize;
	private String driverClass;
	private int minPoolSize;
	private int acquireIncrement;
	private int maxIdleTime;
	
	public DBUtil(){
		try {
			cpd.setJdbcUrl(jdbcUrl);
			cpd.setDriverClass(driverClass);
			cpd.setUser(user);;
			cpd.setPassword(password);
			cpd.setInitialPoolSize(initialPoolSize);
			cpd.setMaxPoolSize(maxPoolSize);
			cpd.setMinPoolSize(minPoolSize);
			cpd.setAcquireIncrement(acquireIncrement);
			cpd.setMaxIdleTime(maxIdleTime);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public int getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public int getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}
}
