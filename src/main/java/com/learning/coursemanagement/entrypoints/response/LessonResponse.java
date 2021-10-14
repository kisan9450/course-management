package com.learning.coursemanagement.entrypoints.response;

import com.learning.coursemanagement.domain.Lesson;

/**
 * Class for Course Management response on lesson creation request.
 */
public class LessonResponse {

	private String lessonId;

	private String lessonName;

	private String active;

	public LessonResponse(Lesson lesson) {
		this.lessonId = lesson.getLessonId();
		this.lessonName = lesson.getLessonName();
		this.active = lesson.getActive();
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

	public static LessonResponse createInstance(Lesson lesson) {
		return new LessonResponse(lesson);
	}

}
