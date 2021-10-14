package com.learning.coursemanagement.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 * Entity Class representing Video
 */
@Document("video")
public class Video {

	@Id
	private String id;

	private String videoId;

	private String videoName;

	private String link;

	private List<Tag> tags;

	private String views;

	private String active;

	public Video(String videoId, String videoName, String link, List<Tag> tags, String views, String active) {
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
