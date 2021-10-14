package com.learning.coursemanagement.common.errors;

import com.learning.coursemanagement.common.errors.base.Errors;
import com.learning.coursemanagement.common.errors.base.TargetTypes;

/**
 * Factory Class For Creating Error Objects.
 */
public class ErrorFactory {

	private ErrorFactory() {
	}

	public static Errors createGenericError() {
		return new Errors(TargetTypes.GENERIC_ERROR.name(), ErrorCodesAndMessages.GENERIC_ERROR,
				ErrorCodesAndMessages.GENERIC_ERROR_CODE);
	}

	public static Errors createError(String message) {
		return new Errors(TargetTypes.GENERIC_ERROR.name(), message, ErrorCodesAndMessages.GENERIC_ERROR_CODE);
	}

	public static Errors databaseException(TargetTypes targetTypes) {
		return new Errors(targetTypes.name(), ErrorCodesAndMessages.DATABASE_FAILURE_ERROR_MSG,
				ErrorCodesAndMessages.DATABASE_FAILURE_ERROR_CODE);
	}

	public static Errors requestedResourceNotFoundException(TargetTypes targetTypes, String id) {
		return new Errors(targetTypes.name(), ErrorCodesAndMessages.INVALID_ID_ERROR_MSG + id,
				ErrorCodesAndMessages.INVALID_ID_ERROR_CODE);
	}

	public static Errors invalidDataError(TargetTypes targetTypes) {
		return new Errors(targetTypes.name(), ErrorCodesAndMessages.INVALID_DATA_ERROR_MSG,
				ErrorCodesAndMessages.INVALID_DATA_ERROR_CODE);
	}

	public static Errors permissionDeniedForTheActivity(TargetTypes targetTypes) {
		return new Errors(targetTypes.name(), ErrorCodesAndMessages.PERMISSION_DENIED_ERROR_MSG,
				ErrorCodesAndMessages.PERMISSION_DENIED_ERROR_CODE);
	}

}
