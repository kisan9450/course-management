package com.learning.coursemanagement.common.exceptions;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.Errors;

/**
 * Class for Invalid Data Exception.
 */
public class InvalidDataException extends CourseManagementException {

	private static final long serialVersionUID = 1L;

	public InvalidDataException(String val) {
		super(ErrorFactory.createError(val));
	}

	public InvalidDataException(Exception ex, Errors errors) {
		super(ex, errors);
	}

}
