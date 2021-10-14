package com.learning.coursemanagement.entrypoints;

import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.dto.SubjectDTO;
import com.learning.coursemanagement.entrypoints.response.common.CourseInstructorComposer;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.validators.CourseManagementInputValidator;
import com.learning.coursemanagement.services.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SubjectEntryPoint for subject handling
 */
@RestController
class SubjectEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectEntryPoint.class);

	private final SubjectService subjectService;

	private final CourseManagementInputValidator courseManagementInputValidator;

	/**
	 * Constructor for {@link SubjectEntryPoint}
	 * @param subjectService injects {@link SubjectService}
	 * @param courseManagementInputValidator injects
	 * {@link CourseManagementInputValidator}
	 */
	public SubjectEntryPoint(SubjectService subjectService,
			CourseManagementInputValidator courseManagementInputValidator) {
		this.subjectService = subjectService;
		this.courseManagementInputValidator = courseManagementInputValidator;

	}

	/**
	 * Entry point for creating new {@link com.learning.coursemanagement.domain.Subject}
	 * @param isInstructor the user
	 * @param subjectDTO the DTO with subjectDTO data
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/v1/is_instructor/{isInstructor}/subject", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createSubject(@PathVariable(name = "isInstructor") String isInstructor,
			@RequestBody SubjectDTO subjectDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Subject creation ");
			return new CourseInstructorComposer()
					.subjectActionResponse(subjectService.createSubjectRequest(subjectDTO));
		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in  creating subject.");
			return FailureResponseComposer.composeFailureResponse(ex, subjectDTO);
		}
	}

	/**
	 * Entry point for updating {@link com.learning.coursemanagement.domain.Subject}
	 * @param isInstructor the user
	 * @param subjectId the requested subjectId
	 * @param subjectDTO the DTO with subjectDTO data
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/v1/is_instructor/{isInstructor}/subject/{subjectId}",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSubject(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "subjectId") String subjectId, @RequestBody SubjectDTO subjectDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Subject update ");
			return new CourseInstructorComposer()
					.subjectActionResponse(subjectService.updateSubjectRequest(subjectId, subjectDTO));

		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in updating subject for id {} :", subjectId);
			return FailureResponseComposer.composeFailureResponse(ex, subjectId);
		}
	}

	/**
	 * Entry point for deleting {@link com.learning.coursemanagement.domain.Subject}
	 * @param isInstructor the user
	 * @param subjectId the requested subjectId
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/v1/is_instructor/{isInstructor}/subject/{subjectId}", produces = "application/json")
	public ResponseEntity<String> deleteSubject(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "subjectId") String subjectId) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Subject deletion ");
			return new CourseInstructorComposer().subjectActionResponse(subjectService.deleteSubjectRequest(subjectId));
		}
		catch (CourseManagementException ex) {
			return FailureResponseComposer.composeFailureResponse(ex, subjectId);
		}
	}

	/**
	 * Entry point for fetching {@link com.learning.coursemanagement.domain.Subject}
	 * @param isInstructor the user
	 * @param subjectId the requested subjectId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/subject/{subjectId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchSubject(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "subjectId") String subjectId) {

		try {
			LOGGER.info("Fetching subject data for id {} :", subjectId);
			return new CourseInstructorComposer().subjectActionResponse(subjectService.getSubjectRequest(subjectId));
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, subjectId);
		}
	}

}