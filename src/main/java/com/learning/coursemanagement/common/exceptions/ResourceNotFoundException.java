package com.learning.coursemanagement.common.exceptions;

import com.learning.coursemanagement.common.errors.ErrorFactory;
import com.learning.coursemanagement.common.errors.base.Errors;
import com.learning.coursemanagement.common.errors.base.TargetTypes;

/**
 * Class for Resource Not Present Exception.
 */
public class ResourceNotFoundException extends CourseManagementException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Exception ex) {
		super(ex, null);
	}

	public ResourceNotFoundException(Exception ex, Errors errors) {
		super(ex, errors);
	}

	public static ResourceNotFoundException forNoRequestedIdFound(String id) {
		throw new ResourceNotFoundException(new Exception("Entity not found for given id" + id),
				ErrorFactory.requestedResourceNotFoundException(TargetTypes.ENTITY, id));
	}

}
