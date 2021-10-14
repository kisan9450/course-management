package com.learning.coursemanagement.entrypoints.dto;

public class CourseDTO {

	private String courseId;

	private String courseName;

	private String views;

	private String active;

	public CourseDTO() {

	}

	public CourseDTO(String courseId, String courseName, String views, String active) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.views = views;
		this.active = active;
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

}
