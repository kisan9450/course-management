package com.learning.coursemanagement.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Entity Class representing course
 */
@Document("course")
public class Course {

	@Id
	private String id;

	private String courseId;

	private String courseName;

	private String views;

	private String active;

	public Course(String courseId, String courseName, String views, String active) {
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
