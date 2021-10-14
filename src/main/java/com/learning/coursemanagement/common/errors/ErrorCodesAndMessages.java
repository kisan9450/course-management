package com.learning.coursemanagement.common.errors;

/**
 * Class containing list of available error code and respective messages.
 */
public class ErrorCodesAndMessages {

	private ErrorCodesAndMessages() {
	}

	// generic error
	public static final String GENERIC_ERROR = "Faced some error";

	public static final int GENERIC_ERROR_CODE = 18000;

	public static final String DATABASE_FAILURE_ERROR_MSG = "Database failure during saving data: ";

	public static final int DATABASE_FAILURE_ERROR_CODE = 90001;

	public static final String INVALID_DATA_ERROR_MSG = "Invalid data";

	public static final int INVALID_DATA_ERROR_CODE = 90002;

	public static final String INVALID_ID_ERROR_MSG = "Invalid entity id ";

	public static final int INVALID_ID_ERROR_CODE = 90003;

	public static final String PERMISSION_DENIED_ERROR_MSG = "You don't have permission for the activity because you are a student";

	public static final int PERMISSION_DENIED_ERROR_CODE = 90003;

}