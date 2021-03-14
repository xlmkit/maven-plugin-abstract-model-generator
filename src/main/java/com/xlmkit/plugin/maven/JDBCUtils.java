package com.xlmkit.plugin.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.alibaba.fastjson.JSONObject;

import jodd.http.HttpRequest;

public class JDBCUtils {

	public static List<JSONObject> queryList(JdbcTemplate template, String sql, Object... args) throws SQLException {
		return template.query(sql, args, new RowMapper<JSONObject>() {
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {
				JSONObject object = new JSONObject();
				int count = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= count; i++) {
					try {
						Object value = rs.getObject(i);
						String name = rs.getMetaData().getColumnName(i);
						object.put(name, value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return object;
			}
		});
	}

	public static Connection create(JDBCConfig config) throws SQLException {
		return DriverManager.getConnection(//
				config.getJdbcUrl(), //
				config.getJdbcUsername(), //
				config.getJdbcPassword());
	}


	public static DataSource createDataSource(JDBCConfig config) {
		return new DriverManagerDataSource(//
				config.getJdbcUrl(), //
				config.getJdbcUsername(), //
				config.getJdbcPassword());
	}

	public static String dbName(JDBCConfig config) {
		String url = config.getJdbcUrl();
		return HttpRequest.get(url).path().substring(1);
	}

	public static JdbcTemplate createTemplate(JDBCConfig config) {
		return new JdbcTemplate(createDataSource(config));
	}

	public static void close(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
}
