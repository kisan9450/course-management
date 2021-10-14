package com.learning.coursemanagement.entrypoints.response.common;

import com.learning.coursemanagement.common.UtilFunctions;
import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.common.exceptions.InvalidDataException;
import com.learning.coursemanagement.common.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Common Failure Response Composer class for Course Management response construction.
 */
public class FailureResponseComposer {

	public static final Logger log = LoggerFactory.getLogger(FailureResponseComposer.class);

	private FailureResponseComposer() {
	}

	private static ResponseEntity.BodyBuilder handleFailure(CourseManagementException ex, Object object) {
		UtilFunctions.logError(ex, object);
		if (ex instanceof InvalidDataException) {
			return compose400BadRequestResponse();
		}
		else if (ex instanceof ResourceNotFoundException) {
			return compose404RequestNotFoundResponse();
		}
		else {
			return compose500FailureResponse();
		}
	}

	private static ResponseEntity.BodyBuilder compose400BadRequestResponse() {
		return ResponseEntity.badRequest();
	}

	private static ResponseEntity.BodyBuilder compose500FailureResponse() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private static ResponseEntity.BodyBuilder compose404RequestNotFoundResponse() {
		return (ResponseEntity.BodyBuilder) ResponseEntity.notFound();
	}

	public static ResponseEntity<String> composeFailureResponse(CourseManagementException ex, Object object) {
		log.error(" Exception In Request body/ parameters");
		ResponseEntity.BodyBuilder responseEntity = handleFailure(ex, object);
		RestResponse response = new RestResponse<>();
		response.setErrors(ex.getErrors());

		String respStr = UtilFunctions.createJSONStringForResponse(response);
		return responseEntity.body(respStr);
	}

}
