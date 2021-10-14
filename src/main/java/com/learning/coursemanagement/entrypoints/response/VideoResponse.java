package com.learning.coursemanagement.entrypoints.response;

import com.learning.coursemanagement.domain.Tag;
import com.learning.coursemanagement.domain.Video;

import java.util.List;

/**
 * Class for Course Management response on video creation request.
 */
public class VideoResponse {

	private String videoId;

	private String videoName;

	private String link;

	private List<Tag> tags;

	private String views;

	private String active;

	public VideoResponse(Video video) {
		this.videoId = video.getVideoId();
		this.videoName = video.getVideoName();
		this.link = video.getLink();
		this.tags = video.getTags();
		this.views = video.getViews();
		this.active = video.getActive();
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

	public static VideoResponse createInstance(Video video) {
		return new VideoResponse(video);
	}

}
