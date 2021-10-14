package com.learning.coursemanagement.entrypoints.dto;

import com.learning.coursemanagement.domain.Tag;

import java.util.List;

public class VideoDTO {

	private String videoId;

	private String videoName;

	private String link;

	private List<Tag> tags;

	private String views;

	private String active;

	public VideoDTO() {

	}

	public VideoDTO(String videoId, String videoName, String link, List<Tag> tags, String views, String active) {
		this.videoId = videoId;
		this.videoName = videoName;
		this.link = link;
		this.tags = tags;
		this.views = views;
		this.active = active;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
