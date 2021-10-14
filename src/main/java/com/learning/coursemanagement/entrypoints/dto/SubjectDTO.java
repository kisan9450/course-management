package com.learning.coursemanagement.entrypoints.dto;

public class SubjectDTO {

	private String subjectId;

	private String subjectName;

	private String active;

	public SubjectDTO(String subjectId, String subjectName, String active) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.active = active;
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

}
