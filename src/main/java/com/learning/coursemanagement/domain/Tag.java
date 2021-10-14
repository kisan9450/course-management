package com.learning.coursemanagement.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Entity Class representing Tag
 */
@Document("tag")
public class Tag {

	@Id
	private String id;

	private String tagId;

	private String tagName;

	private String active;

	public Tag(String tagId, String tagName, String active) {
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
