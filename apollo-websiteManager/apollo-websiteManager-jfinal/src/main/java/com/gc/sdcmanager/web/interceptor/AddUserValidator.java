package com.gc.sdcmanager.web.interceptor;

import org.apache.commons.lang3.StringUtils;

import com.gc.jfinal.ext.render.SpiderRender;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class AddUserValidator extends Validator {
	protected void validate(Controller c) {
		validateRequiredString("username", "unMsg", "请输入用户名");
		validateRequiredString("password", "pwdMsg", "请输入密码");
	}

	protected void handleError(Controller c) {
		String errMsg = "";
		errMsg += StringUtils.defaultString(c.getAttrForStr("unMsg"));
		errMsg += StringUtils.defaultString(c.getAttrForStr("pwdMsg"));
		c.render(SpiderRender.error(errMsg));
	}
}