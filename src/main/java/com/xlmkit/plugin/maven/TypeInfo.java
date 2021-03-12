package com.xlmkit.plugin.maven;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class TypeInfo {

    void initNotNull() {
        if (JAVA_TYPE.equals("Boolean")) {
            JAVA_TYPE = "boolean";
            AFTER_CODE = " = " + "b'1'".equals(COLUMN_DEFAULT);
        }
        if (JAVA_TYPE.equals("Integer")) {
            JAVA_TYPE = "int";
            String def = COLUMN_DEFAULT == null ? "0" : COLUMN_DEFAULT;
            AFTER_CODE = " = " + def;
        }
        if (JAVA_TYPE.equals("Long")) {
            JAVA_TYPE = "long";
            String def = COLUMN_DEFAULT == null ? "0" : COLUMN_DEFAULT;
            AFTER_CODE = " = " + def;
        }
        if (JAVA_TYPE.equals("Float")) {
            JAVA_TYPE = "float";
            AFTER_CODE = " = " + (COLUMN_DEFAULT == null ? "0F" : "Float.parseFloat(\"" + COLUMN_DEFAULT + "\"");
        }
        if (JAVA_TYPE.equals("Double")) {
            JAVA_TYPE = "double";
            AFTER_CODE = " = " + (COLUMN_DEFAULT == null ? "0D" : COLUMN_DEFAULT);
        }
        if (JAVA_TYPE.equals("BigDecimal")) {
            JAVA_TYPE = "BigDecimal";
            AFTER_CODE = " = "
                    + (COLUMN_DEFAULT == null ? "BigDecimal.ZERO" : "new BigDecimal(" + COLUMN_DEFAULT + ")");
        }
        if (JAVA_TYPE.equals("Date")) {

        }
        if (JAVA_TYPE.equals("String")) {
            AFTER_CODE = " = \"" + (COLUMN_DEFAULT == null ? "" : COLUMN_DEFAULT) + "\"";
        }
        if (JAVA_TYPE.equals("byte[]")) {
            AFTER_CODE = " = new byte[] {}";
        }
    }


    @JSONField(name = "JAVA_TYPE")
    String JAVA_TYPE = "";

    @JSONField(name = "GETTER_NAME")
    String GETTER_NAME = "";

    @JSONField(name = "AFTER_CODE")
    String AFTER_CODE = "";

    @JSONField(name = "BEFORE_CODE")
    String BEFORE_CODE = "";

    @JSONField(name = "COLUMN_COMMENT")
    String COLUMN_COMMENT;// ":"1",

    @JSONField(name = "COLUMN_KEY")
    String COLUMN_KEY;// ":"",

    @JSONField(name = "COLUMN_NAME")
    String COLUMN_NAME;// ":"channel_id",

    @JSONField(name = "COLUMN_TYPE")
    String COLUMN_TYPE;// ":"bigint(20)",

    @JSONField(name = "DATA_TYPE")
    String DATA_TYPE;// ":"bigint",

    @JSONField(name = "EXTRA")
    String EXTRA;// ":"",

    @JSONField(name = "IS_NULLABLE")
    String IS_NULLABLE;// ":"YES",

    @JSONField(name = "NUMERIC_PRECISION")
    Integer NUMERIC_PRECISION;// ":19,

    @JSONField(name = "NUMERIC_SCALE")
    Integer NUMERIC_SCALE;// ":0,

    @JSONField(name = "ORDINAL_POSITION")
    Integer ORDINAL_POSITION;// ":2,

    @JSONField(name = "COLUMN_DEFAULT")
    String COLUMN_DEFAULT;
}