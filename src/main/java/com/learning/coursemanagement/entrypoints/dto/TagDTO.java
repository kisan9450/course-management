package com.learning.coursemanagement.entrypoints.dto;

public class TagDTO {

	private String tagId;

	private String tagName;

	private String active;

	public TagDTO(String tagId, String tagName, String active) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.active = active;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
