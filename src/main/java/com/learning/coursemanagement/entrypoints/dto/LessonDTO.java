package com.learning.coursemanagement.entrypoints.dto;

public class LessonDTO {

	private String lessonId;

	private String lessonName;

	private String active;

	public LessonDTO(String lessonId, String lessonName, String active) {
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.active = active;
	}

	public String getLessonId() {
		return lessonId;
	}

	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
