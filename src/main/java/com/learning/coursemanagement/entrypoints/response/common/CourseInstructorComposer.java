package com.learning.coursemanagement.entrypoints.response.common;

import com.google.gson.Gson;
import com.learning.coursemanagement.entrypoints.dto.CourseDTO;
import com.learning.coursemanagement.entrypoints.dto.VideoDTO;
import com.learning.coursemanagement.entrypoints.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Common Response Composer class for Course Management response construction.
 */
@Component
public class CourseInstructorComposer {

	/**
	 * Method for export create response construction.
	 * @param courseResponse
	 * @return
	 */
	public ResponseEntity<String> courseActionResponse(CourseResponse courseResponse) {

		RestResponse<CourseResponse> response = ResponseComposer.createRestResponse(Arrays.asList(courseResponse));

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseComposer.createJSONStringForResponse(response));
	}

	public static ResponseEntity<String> composeCourseAnalyticsResponse(List<CourseDTO> courses) {
		RestResponse<CourseDTO> response = new RestResponse<>();
		response.setData(courses);
		Gson j = new Gson();
		return ResponseEntity.ok(j.toJson(response));
	}

	public static ResponseEntity<String> composeVideoAnalyticsResponse(List<VideoDTO> videos) {
		RestResponse<VideoDTO> response = new RestResponse<>();
		response.setData(videos);
		Gson j = new Gson();
		return ResponseEntity.ok(j.toJson(response));
	}

	/**
	 * Method for export create response construction.
	 * @param lessonResponse
	 * @return
	 */
	public ResponseEntity<String> lessonActionResponse(LessonResponse lessonResponse) {

		RestResponse<LessonResponse> response = ResponseComposer.createRestResponse(Arrays.asList(lessonResponse));

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseComposer.createJSONStringForResponse(response));
	}

	/**
	 * Method for export create response construction.
	 * @param subjectResponse
	 * @return
	 */
	public ResponseEntity<String> subjectActionResponse(SubjectResponse subjectResponse) {

		RestResponse<SubjectResponse> response = ResponseComposer.createRestResponse(Arrays.asList(subjectResponse));

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseComposer.createJSONStringForResponse(response));
	}

	/**
	 * Method for export create response construction.
	 * @param tagResponse
	 * @returt
	 */
	public ResponseEntity<String> tagActionResponse(TagResponse tagResponse) {

		RestResponse<TagResponse> response = ResponseComposer.createRestResponse(Arrays.asList(tagResponse));

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseComposer.createJSONStringForResponse(response));
	}

	/**
	 * Method for export create response construction.
	 * @param videoResponse
	 * @return
	 */
	public ResponseEntity<String> videoActionResponse(VideoResponse videoResponse) {

		RestResponse<VideoResponse> response = ResponseComposer.createRestResponse(Arrays.asList(videoResponse));

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseComposer.createJSONStringForResponse(response));
	}

}
