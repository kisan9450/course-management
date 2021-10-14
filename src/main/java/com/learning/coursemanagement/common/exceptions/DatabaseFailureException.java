package com.learning.coursemanagement.common.exceptions;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.Errors;
import com.learning.coursemanagement.common.errors.base.TargetTypes;

/**
 * Class for DataBase Failure Exception.
 */
public class DatabaseFailureException extends CourseManagementException {

	private static final long serialVersionUID = 1L;

	public DatabaseFailureException(Exception ex) {
		super(ex, null);
	}

	public DatabaseFailureException(Exception ex, Errors errors) {
		super(ex, errors);
	}

	public static DatabaseFailureException dataBaseFailureException(Exception ex) {
		return new DatabaseFailureException(ex, ErrorFactory.databaseException(TargetTypes.GENERIC_ERROR));
	}

}
