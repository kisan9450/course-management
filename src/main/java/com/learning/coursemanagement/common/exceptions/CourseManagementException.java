package com.learning.coursemanagement.common.exceptions;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.Errors;

/**
 * Base for of Course Management extending Runtime Exception.
 */
public class CourseManagementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Errors errors;

	public CourseManagementException(Errors errors) {
		super(errors.getMessage());
		this.errors = errors;
	}

	public CourseManagementException(Exception ex, Errors errors) {
		super(ex);
		if (errors == null) {
			errors = ErrorFactory.createGenericError();
		}
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

}
