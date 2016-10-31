package com.digitalplay.network.ireader.domain.sys;

public class JCaptchaCodeNotMatchException extends UserException {

	public JCaptchaCodeNotMatchException() {
		  super("user.jcaptchacode.not.match", null);
	}

}
