package com.learning.coursemanagement.entrypoints;

import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.dto.VideoDTO;
import com.learning.coursemanagement.entrypoints.response.common.CourseInstructorComposer;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.validators.CourseManagementInputValidator;
import com.learning.coursemanagement.services.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * VideoEntryPoint for video handling
 */
@RestController
class VideoEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoEntryPoint.class);

	private final VideoService videoService;

	private final CourseManagementInputValidator courseManagementInputValidator;

	/**
	 * Constructor for {@link LessonEntryPoint}
	 * @param videoService injects {@link VideoService}
	 * @param courseManagementInputValidator injects
	 * {@link CourseManagementInputValidator}
	 */
	public VideoEntryPoint(VideoService videoService, CourseManagementInputValidator courseManagementInputValidator) {
		this.videoService = videoService;
		this.courseManagementInputValidator = courseManagementInputValidator;

	}

	/**
	 * Entry point for creating new {@link com.learning.coursemanagement.domain.Video}
	 * @param isInstructor the user
	 * @param videoDTO the DTO with videoDTO data
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/v1/is_instructor/{isInstructor}/video", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createVideo(@PathVariable(name = "isInstructor") String isInstructor,
			@RequestBody VideoDTO videoDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Video creation ");
			return new CourseInstructorComposer().videoActionResponse(videoService.createVideoRequest(videoDTO));
		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in  creating video.");
			return FailureResponseComposer.composeFailureResponse(ex, videoDTO);
		}
	}

	/**
	 * Entry point for updating {@link com.learning.coursemanagement.domain.Video}
	 * @param isInstructor the user
	 * @param videoId the requested videoId
	 * @param videoDTO the DTO with videoDTO data
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/v1/is_instructor/{isInstructor}/video/{videoId}", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateVideo(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "videoId") String videoId, @RequestBody VideoDTO videoDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Video update ");
			return new CourseInstructorComposer()
					.videoActionResponse(videoService.updateVideoRequest(videoId, videoDTO));

		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in updating video for id {} :", videoId);
			return FailureResponseComposer.composeFailureResponse(ex, videoId);
		}
	}

	/**
	 * Entry point for deleting {@link com.learning.coursemanagement.domain.Video}
	 * @param isInstructor the user
	 * @param videoId the requested videoId
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/v1/is_instructor/{isInstructor}/video/{videoId}", produces = "application/json")
	public ResponseEntity<String> deleteVideo(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "videoId") String videoId) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Video deletion ");
			return new CourseInstructorComposer().videoActionResponse(videoService.deleteVideoRequest(videoId));
		}
		catch (CourseManagementException ex) {
			return FailureResponseComposer.composeFailureResponse(ex, videoId);
		}
	}

	/**
	 * Entry point for fetching {@link com.learning.coursemanagement.domain.Video}
	 * @param isInstructor the user
	 * @param videoId the requested videoId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/video/{videoId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchVideo(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "videoId") String videoId) {

		try {
			return new CourseInstructorComposer().videoActionResponse(videoService.getVideoRequest(videoId));
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, videoId);
		}
	}

	/**
	 * Entry point for fetching analytics of new
	 * {@link com.learning.coursemanagement.domain.Video}
	 * @param isInstructor the user
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/is_instructor/{isInstructor}/video/analytics", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchCourseAnalytics(@PathVariable(name = "isInstructor") String isInstructor) {

		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Video analytics ");
			return new CourseInstructorComposer().composeVideoAnalyticsResponse(videoService.getVideoAnalytics());
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, isInstructor);
		}
	}

}