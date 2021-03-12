package com.xlmkit.plugin.maven;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class JDBCConfig {

	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;
	public void validate() {
		Assert.isTrue(!StringUtils.isEmpty(jdbcUrl), "[jdbcUrl] is empty!");
		Assert.isTrue(!StringUtils.isEmpty(jdbcUsername), "[jdbcUsername] is empty!");
		Assert.isTrue(!StringUtils.isEmpty(jdbcPassword), "[jdbcPassword] is null!");
	}
	
}
