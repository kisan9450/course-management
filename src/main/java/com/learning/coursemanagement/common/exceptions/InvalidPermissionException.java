package com.learning.coursemanagement.common.exceptions;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.Errors;
import com.learning.coursemanagement.common.errors.base.TargetTypes;

/**
 * Class for Invalid Permission Exception.
 */
public class InvalidPermissionException extends CourseManagementException {

	private static final long serialVersionUID = 1L;

	public InvalidPermissionException(Exception ex) {
		super(ex, null);
	}

	public InvalidPermissionException(Exception ex, Errors errors) {
		super(ex, errors);
	}

	public static InvalidPermissionException permissionException(Exception ex) {
		return new InvalidPermissionException(ex,
				ErrorFactory.permissionDeniedForTheActivity(TargetTypes.GENERIC_ERROR));
	}

}
