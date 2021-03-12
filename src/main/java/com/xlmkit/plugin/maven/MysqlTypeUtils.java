package com.xlmkit.plugin.maven;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

public class MysqlTypeUtils {
    public static Map<String, String> TYPE_MAP = new HashMap<>();
    static {
        TYPE_MAP.put("BIT", "Boolean");
        TYPE_MAP.put("TINYINT", "Integer");
        TYPE_MAP.put("BOOL", "Boolean");
        TYPE_MAP.put("BOOLEAN", "Boolean");
        TYPE_MAP.put("SMALLINT", "Integer");
        TYPE_MAP.put("MEDIUMINT", "Integer");
        TYPE_MAP.put("INT", "Integer");
        TYPE_MAP.put("INTEGER", "Integer");
        TYPE_MAP.put("BIGINT", "Long");
        TYPE_MAP.put("FLOAT", "Float");
        TYPE_MAP.put("DOUBLE", "Double");
        TYPE_MAP.put("DECIMAL", "BigDecimal");
        TYPE_MAP.put("DATE", "Date");
        TYPE_MAP.put("DATETIME", "Date");
        TYPE_MAP.put("TIMESTAMP", "Date");
        TYPE_MAP.put("TIME", "Date");
        TYPE_MAP.put("YEAR", "String");
        TYPE_MAP.put("CHAR", "String");
        TYPE_MAP.put("VARCHAR", "String");
        TYPE_MAP.put("BINARY", "byte[]");
        TYPE_MAP.put("VARBINARY", "byte[]");
        TYPE_MAP.put("TINYBLOB", "byte[]");
        TYPE_MAP.put("TINYTEXT", "String");
        TYPE_MAP.put("BLOB", "byte[]");
        TYPE_MAP.put("TEXT", "String");
        TYPE_MAP.put("MEDIUMBLOB", "byte[]");
        TYPE_MAP.put("MEDIUMTEXT", "String");
        TYPE_MAP.put("LONGBLOB", "byte[]");
        TYPE_MAP.put("LONGTEXT", "String");
        TYPE_MAP.put("ENUM", "String");
        TYPE_MAP.put("SET", "String");
        // Boolean Integer Boolean Long Float Double BigDecimal Date byte[]
    }

    public static TypeInfo getType(ModelGeneratorConfig config, JSONObject object) {
        TypeInfo info = object.toJavaObject(TypeInfo.class);
        String type = StringUtils.isEmpty(info.getDATA_TYPE())?info.COLUMN_TYPE:info.getDATA_TYPE();
        info.JAVA_TYPE = TYPE_MAP.get(type.toUpperCase());
        if (info.getIS_NULLABLE().equals("NO")) {
            info.initNotNull();
        }
        if ("PRI".equals(info.COLUMN_KEY)) {
        	if("auto_increment".equals(info.getEXTRA())) {
        		info.BEFORE_CODE = "@Id @GeneratedValue(strategy = GenerationType.IDENTITY) ";
        	}else {
        		info.BEFORE_CODE = "@Id  ";
        	}
            
        }
        info.GETTER_NAME = info.COLUMN_NAME;
        if(config.isBooleanGetterStartWidthIS()) {
        	if (info.GETTER_NAME.length() >= 3 && info.GETTER_NAME.startsWith("is")
                    && !info.GETTER_NAME.substring(0, 3).equals(info.GETTER_NAME.substring(0, 3).toLowerCase())) {
                info.GETTER_NAME = "is" + info.GETTER_NAME.substring(2);
            } else if (info.GETTER_NAME.length() == 1) {
                info.GETTER_NAME = "get" + info.GETTER_NAME.toUpperCase();
            } else {
                info.GETTER_NAME = "get" + info.GETTER_NAME.substring(0, 1).toUpperCase() + info.GETTER_NAME.substring(1);
            }
        }else {
        	if (info.GETTER_NAME.length() == 1) {
                info.GETTER_NAME = "get" + info.GETTER_NAME.toUpperCase();
            } else {
                info.GETTER_NAME = "get" + info.GETTER_NAME.substring(0, 1).toUpperCase() + info.GETTER_NAME.substring(1);
            }
        }
        
        if(info.getCOLUMN_COMMENT()==null) {
        	info.setCOLUMN_COMMENT("");
        }
        return info;
    }


}
