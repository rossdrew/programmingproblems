package com.rox.prob.interviews.NCR.err;

import java.text.ParseException;

public class UnknownTokenException extends ParseException {

	public UnknownTokenException(String token, int errorOffset) {
		super("Unknown token '" + token + "'", errorOffset);
	}

}
