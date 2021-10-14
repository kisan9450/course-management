package com.learning.coursemanagement.entrypoints;

import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.dto.CourseDTO;
import com.learning.coursemanagement.entrypoints.response.common.CourseInstructorComposer;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.validators.CourseManagementInputValidator;
import com.learning.coursemanagement.services.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CourseEntryPoint for course handling
 */
@RestController
class CourseEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseEntryPoint.class);

	private final CourseService courseService;

	private final CourseManagementInputValidator courseManagementInputValidator;

	/**
	 * Constructor for {@link CourseEntryPoint}
	 * @param courseService injects {@link CourseService}
	 * @param courseManagementInputValidator injects
	 * {@link CourseManagementInputValidator}
	 */
	public CourseEntryPoint(CourseService courseService,
			CourseManagementInputValidator courseManagementInputValidator) {
		this.courseService = courseService;
		this.courseManagementInputValidator = courseManagementInputValidator;

	}

	/**
	 * Entry point for creating new {@link com.learning.coursemanagement.domain.Course}
	 * @param isInstructor the user
	 * @param courseDTO the DTO with course data
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/v1/is_instructor/{isInstructor}/course", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCourse(@PathVariable(name = "isInstructor") String isInstructor,
			@RequestBody CourseDTO courseDTO) {
		try {

			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for course creation ");
			return new CourseInstructorComposer().courseActionResponse(courseService.createCourseRequest(courseDTO));
		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in  creating course file.");
			return FailureResponseComposer.composeFailureResponse(ex, courseDTO);
		}
	}

	/**
	 * Entry point for updating {@link com.learning.coursemanagement.domain.Course}
	 * @param isInstructor the user
	 * @param courseId the requested courseId
	 * @param courseDTO the DTO with course data
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/v1/is_instructor/{isInstructor}/course/{courseId}",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCourse(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "courseId") String courseId, @RequestBody CourseDTO courseDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for course update ");
			return new CourseInstructorComposer()
					.courseActionResponse(courseService.updateCourseRequest(courseId, courseDTO));

		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in updating course status for id {} :", courseId);
			return FailureResponseComposer.composeFailureResponse(ex, courseId);
		}
	}

	/**
	 * Entry point for deleting {@link com.learning.coursemanagement.domain.Course}
	 * @param isInstructor the user
	 * @param courseId the requested courseId
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/v1/is_instructor/{isInstructor}/course/{courseId}", produces = "application/json")
	public ResponseEntity<String> deleteCourse(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "courseId") String courseId) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for course deletion ");
			return new CourseInstructorComposer().courseActionResponse(courseService.deleteCourseRequest(courseId));
		}
		catch (CourseManagementException ex) {
			return FailureResponseComposer.composeFailureResponse(ex, courseId);
		}
	}

	/**
	 * Entry point for fetching {@link com.learning.coursemanagement.domain.Course}
	 * @param isInstructor the user
	 * @param courseId the requested courseId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/course/{courseId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchCourse(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "courseId") String courseId) {

		try {
			LOGGER.info("Fetching course details for id {} :", courseId);
			return new CourseInstructorComposer().courseActionResponse(courseService.getCourseRequest(courseId));
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, courseId);
		}
	}

	/**
	 * Entry point for fetching analytics of
	 * {@link com.learning.coursemanagement.domain.Course}
	 * @param isInstructor the user
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/course/analytics",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchCourseAnalytics(@PathVariable(name = "isInstructor") String isInstructor) {

		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for course analytics ");
			return new CourseInstructorComposer().composeCourseAnalyticsResponse(courseService.getCourseAnalytics());
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, isInstructor);
		}
	}

}