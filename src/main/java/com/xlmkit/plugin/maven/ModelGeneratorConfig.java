package com.xlmkit.plugin.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ModelGeneratorConfig extends JDBCConfig {

	private String tableCondition = "1 = 1";
	private String packageName;
	private File distDirectory;
	private boolean booleanGetterStartWidthIS = true;

	@Override
	public void validate() {
		Assert.isTrue(!StringUtils.isEmpty(packageName), "[packageName] is empty!");
		Assert.isTrue(!StringUtils.isEmpty(distDirectory), "[distDirectory] is empty!");
		Assert.isTrue(!StringUtils.isEmpty(distDirectory), "[distDirectory] is null!");
		Assert.isTrue(!StringUtils.isEmpty(tableCondition), "[tableCondition] is empty!");
		super.validate();
	}

}
