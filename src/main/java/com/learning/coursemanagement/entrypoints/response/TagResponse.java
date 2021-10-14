package com.learning.coursemanagement.entrypoints.response;

import com.learning.coursemanagement.domain.Tag;

/**
 * Class for Course Management response on course tag request.
 */
public class TagResponse {

	private String tagId;

	private String tagName;

	private String active;

	public TagResponse(Tag tag) {
		this.tagId = tag.getTagId();
		this.tagName = tag.getTagName();
		this.active = tag.getActive();
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

	public static TagResponse createInstance(Tag tag) {
		return new TagResponse(tag);
	}

}
