package com.learning.coursemanagement.services;

import com.learning.coursemanagement.domain.Course;
import com.learning.coursemanagement.domain.repositories.CourseRepository;
import com.learning.coursemanagement.entrypoints.dto.CourseDTO;
import com.learning.coursemanagement.entrypoints.response.CourseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * New Course Instructor application service.
 */
@Service
public class CourseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseService.class);

	/**
	 * The Course Instructor Repository for storing the entities.
	 */
	private CourseRepository courseRepository;

	/**
	 * Constructor for {@link CourseService}
	 * @param courseRepository injects {@link CourseRepository}
	 */
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public CourseResponse createCourseRequest(CourseDTO courseDTO) {
		Course course = new Course(courseDTO.getCourseId(), courseDTO.getCourseName(), courseDTO.getViews(),
				courseDTO.getActive());

		course = courseRepository.addCourse(course);
		return CourseResponse.createInstance(course);

	}

	public CourseResponse updateCourseRequest(String courseId, CourseDTO courseDTO) {
		Course course = new Course(courseDTO.getCourseId(), courseDTO.getCourseName(), courseDTO.getViews(),
				courseDTO.getActive());
		course = courseRepository.updateCourse(courseId, course);
		return CourseResponse.createInstance(course);

	}

	public CourseResponse deleteCourseRequest(String courseId) {
		Course course = courseRepository.deleteCourse(courseId);
		return CourseResponse.createInstance(course);

	}

	public CourseResponse getCourseRequest(String courseId) {
		Course course = courseRepository.getCourse(courseId);
		return CourseResponse.createInstance(course);

	}

	public List<CourseDTO> getCourseAnalytics() {
		List<Course> course = courseRepository.getCourseAnalytics();
		return course.stream().map(CourseService::createCourseDTO).collect(Collectors.toList());

	}

	private static CourseDTO createCourseDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		BeanUtils.copyProperties(course, courseDTO);
		return courseDTO;
	}

}