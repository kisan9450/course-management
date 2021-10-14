package com.learning.coursemanagement.entrypoints;

import com.learning.coursemanagement.common.exceptions.CourseManagementException;
import com.learning.coursemanagement.entrypoints.dto.TagDTO;
import com.learning.coursemanagement.entrypoints.response.common.CourseInstructorComposer;
import com.learning.coursemanagement.entrypoints.response.common.FailureResponseComposer;
import com.learning.coursemanagement.entrypoints.validators.CourseManagementInputValidator;
import com.learning.coursemanagement.services.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TagEntryPoint for tag handling
 */
@RestController
class TagEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(TagEntryPoint.class);

	private final TagService tagService;

	private final CourseManagementInputValidator courseManagementInputValidator;

	/**
	 * Constructor for {@link LessonEntryPoint}
	 * @param tagService injects {@link TagService}
	 * @param courseManagementInputValidator injects
	 * {@link CourseManagementInputValidator}
	 */
	public TagEntryPoint(TagService tagService, CourseManagementInputValidator courseManagementInputValidator) {
		this.tagService = tagService;
		this.courseManagementInputValidator = courseManagementInputValidator;

	}

	/**
	 * Entry point for creating new {@link com.learning.coursemanagement.domain.Tag}
	 * @param isInstructor the user
	 * @param tagDTO the DTO with tagDTO data
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(value = "/v1/is_instructor/{isInstructor}/tag", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createTag(@PathVariable(name = "isInstructor") String isInstructor,
			@RequestBody TagDTO tagDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Tag creation ");
			return new CourseInstructorComposer().tagActionResponse(tagService.createTagRequest(tagDTO));
		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in  creating Tag.");
			return FailureResponseComposer.composeFailureResponse(ex, tagDTO);
		}
	}

	/**
	 * Entry point for updating {@link com.learning.coursemanagement.domain.Tag}
	 * @param isInstructor the user
	 * @param tagId the requested tagId
	 * @param tagDTO the DTO with tagDTO data
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/v1/is_instructor/{isInstructor}/tag/{tagId}", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTag(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "tagId") String tagId, @RequestBody TagDTO tagDTO) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Tag update ");
			return new CourseInstructorComposer().tagActionResponse(tagService.updateTagRequest(tagId, tagDTO));

		}
		catch (CourseManagementException ex) {
			LOGGER.error("ERROR: Failure in updating tag for id {} :", tagId);
			return FailureResponseComposer.composeFailureResponse(ex, tagId);
		}
	}

	/**
	 * Entry point for deleting {@link com.learning.coursemanagement.domain.Tag}
	 * @param isInstructor the user
	 * @param tagId the requested tagId
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/v1/is_instructor/{isInstructor}/tag/{tagId}", produces = "application/json")
	public ResponseEntity<String> deleteTag(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "tagId") String tagId) {
		try {
			courseManagementInputValidator.validatePermission(isInstructor);
			LOGGER.info("Permission validated proceeding for Tag deletion ");
			return new CourseInstructorComposer().tagActionResponse(tagService.deleteTagRequest(tagId));
		}
		catch (CourseManagementException ex) {
			return FailureResponseComposer.composeFailureResponse(ex, tagId);
		}
	}

	/**
	 * Entry point for fetching {@link com.learning.coursemanagement.domain.Tag}
	 * @param isInstructor the user
	 * @param tagId the requested tagId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/v1/tag/{tagId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchTag(@PathVariable(name = "isInstructor") String isInstructor,
			@PathVariable(name = "tagId") String tagId) {

		try {
			LOGGER.info("Fetching tag details for id {} :", tagId);
			return new CourseInstructorComposer().tagActionResponse(tagService.getTagRequest(tagId));
		}
		catch (CourseManagementException ex) {

			return FailureResponseComposer.composeFailureResponse(ex, tagId);
		}
	}

}