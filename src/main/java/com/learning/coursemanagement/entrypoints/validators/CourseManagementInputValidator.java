package com.learning.coursemanagement.entrypoints.validators;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.TargetTypes;
import com.learning.coursemanagement.common.exceptions.InvalidPermissionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * CourseManagementInputValidator - validates permission for student or instructor
 *
 */

@Component
public class CourseManagementInputValidator {

	public static final Logger LOGGER = LoggerFactory.getLogger(CourseManagementInputValidator.class);

	CourseManagementInputValidator() {

	}

	public void validatePermission(String isInstructor) {
		if (isInstructor.equals("False")) {
			LOGGER.error("ERROR: Failure while doing operation");
			throw new InvalidPermissionException(new Exception("Permission Denied"),
					ErrorFactory.permissionDeniedForTheActivity(TargetTypes.PERMISSION));

		}
	}

}
