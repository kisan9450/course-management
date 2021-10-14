package com.learning.coursemanagement.entrypoints;

import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.dto.LessonDTO;
import com.learning.coursemanagement.entrypoints.response.common.CourseInstructorComposer;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.validators.CourseManagementInputValidator;
import com.learning.coursemanagement.services.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * LessonEntryPoint for lesson handling
 */
@RestController
class LessonEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LessonEntryPoint.class);

	private final LessonService lessonService;

	private final CourseManagementInputValidator courseManagementInputValidator;

	/**
	 * Constructor for {@link LessonEntryPoint}
	 * @param lessonService injects {@link LessonService}
	 * @param courseManagementInputValidator injects
	 * {@link CourseManagementInputValidator}
	 */
	public LessonEntryPoint(LessonService lessonService,
			CourseManagementInputValidator courseManagementInputValidator) {
		this.lessonService = lessonService;
		this.courseManagementInputValidator = courseManagementInputValidator;

	}

	/**
	 * Entry point for creating new {@link com.learning.coursemanagement.domain.Lesson}
	 * @param isInstructor the user
	 * @param lessonDTO the DTO with lesson data
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/v1/is_instructor/{isInstructor}/lesson", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createLesson(@PathVariable(name = "isInstructor") String isInstructor,
			@RequestBody LessonDTO lessonDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for lesson creation ");
			return new CourseInstructorComposer().lessonActionResponse(lessonService.createLessonRequest(lessonDTO));
		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in  creating lesson.");
			return FailureResponseComposer.composeFailureResponse(ex, lessonDTO);
		}
	}

	/**
	 * Entry point for updating {@link com.learning.coursemanagement.domain.Lesson}
	 * @param isInstructor the user
	 * @param lessonId the requested lessonId
	 * @param lessonDTO the DTO with lesson data
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/v1/is_instructor/{isInstructor}/lesson/{lessonId}",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateLesson(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "lessonId") String lessonId, @RequestBody LessonDTO lessonDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for lesson update ");
			return new CourseInstructorComposer()
					.lessonActionResponse(lessonService.updateLessonRequest(lessonId, lessonDTO));

		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in updating lesson for id {} :", lessonId);
			return FailureResponseComposer.composeFailureResponse(ex, lessonId);
		}
	}

	/**
	 * Entry point for deleting {@link com.learning.coursemanagement.domain.Lesson}
	 * @param isInstructor the user
	 * @param lessonId the requested lessonId
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/v1/is_instructor/{isInstructor}/lesson/{lessonId}", produces = "application/json")
	public ResponseEntity<String> deleteLesson(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "lessonId") String lessonId) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for lesson deletion ");
			return new CourseInstructorComposer().lessonActionResponse(lessonService.deleteLessonRequest(lessonId));
		}
		catch (CourseManagementException ex) {
			return FailureResponseComposer.composeFailureResponse(ex, lessonId);
		}
	}

	/**
	 * Entry point for fetching {@link com.learning.coursemanagement.domain.Lesson}
	 * @param isInstructor the user
	 * @param lessonId the requested lessonId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/lesson/{lessonId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchLesson(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "lessonId") String lessonId) {

		try {
			return new CourseInstructorComposer().lessonActionResponse(lessonService.getLessonRequest(lessonId));
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, null);
		}
	}

}