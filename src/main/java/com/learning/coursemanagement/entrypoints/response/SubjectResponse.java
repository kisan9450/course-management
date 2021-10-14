package com.learning.coursemanagement.entrypoints.response;

import com.learning.coursemanagement.domain.Subject;

/**
 * Class for Course Management response on course subject request.
 */
public class SubjectResponse {

	private String subjectId;

	private String subjectName;

	private String active;

	public SubjectResponse(Subject subject) {
		this.subjectId = subject.getSubjectId();
		this.subjectName = subject.getSubjectName();
		this.active = subject.getActive();
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public static SubjectResponse createInstance(Subject subject) {
		return new SubjectResponse(subject);
	}

}
