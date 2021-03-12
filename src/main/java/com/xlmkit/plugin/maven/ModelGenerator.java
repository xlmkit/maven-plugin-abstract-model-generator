package com.xlmkit.plugin.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONObject;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModelGenerator {

	private ModelGeneratorConfig config;

	public ModelGenerator(ModelGeneratorConfig config) {
		super();
		this.config = config;
	}

	public void run() throws Exception {
		log.info("开始");
		config.validate();
		log.info("创建template");
		JdbcTemplate template = JDBCUtils.createTemplate(config);

		for (String tableName : config.getTableNames()) {
			log.info("{}", tableName);
			List<TypeInfo> columns = new ArrayList<TypeInfo>();
			String sql = "select * FROM information_schema.columns  where table_name=? and table_schema=?";
			List<JSONObject> list = JDBCUtils.queryList(template, sql, tableName, JDBCUtils.tableName(config));
			for (JSONObject item : list) {
				columns.add(MysqlTypeUtils.getType(config,item));
			}
			String javaModelCode = modelJavaCode(tableName, columns);
			File file = new File(//
					config.getDistDirectory(), //
					config.getPackageName().replaceAll("\\.", "/") + "/Abs" + tableName + ".java");
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileUtil.writeString(file, javaModelCode);
		}
	}

	public String modelJavaCode(String tableName, List<TypeInfo> columns) {
		XStringBuilder sb = new XStringBuilder();

		sb.append("package {};", config.getPackageName());

		sb.append("import java.util.Date;");
		sb.append("import javax.persistence.GeneratedValue;");
		sb.append("import javax.persistence.GenerationType;");
		sb.append("import javax.persistence.Id;");
		sb.append("import javax.persistence.MappedSuperclass;");
		sb.append("import javax.persistence.Version;");
		sb.append("import java.math.BigInteger;");
		sb.append("import java.math.BigDecimal;");
		sb.append("import java.util.Date;");
		sb.append("@MappedSuperclass");
		sb.append("public class Abs{} {", tableName);
		for (int i = 0; i < columns.size(); i++) {
			TypeInfo column = columns.get(i);
			if (column.getCOLUMN_NAME().equals("version")&&!column.getCOLUMN_COMMENT().contains("不生成@Version")) {
				sb.append("@Version");
			}

			sb.append("protected {}{} {}{};", //
					column.getBEFORE_CODE(), column.getJAVA_TYPE(), column.getCOLUMN_NAME(), column.getAFTER_CODE());
		}

		for (int i = 0; i < columns.size(); i++) {
			TypeInfo column = columns.get(i);
			sb.append("/**");
			sb.append("*	{}", column.getCOLUMN_COMMENT());
			sb.append("*/");
			sb.append("");
			sb.append("public {} {}(){return {};}", column.getJAVA_TYPE(), column.getGETTER_NAME(),
					column.getCOLUMN_NAME());
		}

		sb.append("}");

		return sb.toString();
	}
}
