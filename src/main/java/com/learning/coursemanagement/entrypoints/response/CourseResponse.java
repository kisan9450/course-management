package com.learning.coursemanagement.entrypoints.response;

import com.learning.coursemanagement.domain.Course;

/**
 * Class for Course Management response on course creation request.
 */
public class CourseResponse {

	private String courseId;

	private String courseName;

	private String views;

	private String active;

	public CourseResponse(Course course) {
		this.courseId = course.getCourseId();
		this.courseName = course.getCourseName();
		this.views = course.getViews();
		this.active = course.getActive();
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public static CourseResponse createInstance(Course course) {
		return new CourseResponse(course);
	}

}
