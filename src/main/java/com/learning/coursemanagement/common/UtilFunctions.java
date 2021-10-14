package com.learning.coursemanagement.common;

import com.google.gson.Gson;
import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.response.common.RestResponse;

public class UtilFunctions {

	private UtilFunctions() {

	}

	/**
	 * Return the String JSON representation of the response object.
	 * @param response
	 * @return String
	 */
	public static <T> String createJSONStringForResponse(RestResponse<T> response) {
		Gson j = new Gson();
		return j.toJson(response);
	}

	public static void logError(CourseManagementException ex, Object object) {

		Throwable causeException = ex.getCause();
		if (causeException != null) {
			if (ex.getErrors() != null) {
				if (FailureResponseComposer.log.isErrorEnabled()) {
					FailureResponseComposer.log.error(" {} Error : {} for object : {} ", causeException.getMessage(),
							ex.getErrors(), object, causeException);
				}
			}
			else
				FailureResponseComposer.log.error("Error for object : {} for exception {} ", object,
						causeException.getMessage());

		}
		else {
			FailureResponseComposer.log.error("Error in execution ", ex);
		}
	}

}
