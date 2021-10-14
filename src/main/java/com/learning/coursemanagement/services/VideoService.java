package com.learning.coursemanagement.services;

import com.learning.coursemanagement.domain.Course;
import com.learning.coursemanagement.domain.Video;
import com.learning.coursemanagement.domain.repositories.VideoRepository;
import com.learning.coursemanagement.entrypoints.dto.CourseDTO;
import com.learning.coursemanagement.entrypoints.dto.VideoDTO;
import com.learning.coursemanagement.entrypoints.response.VideoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * New Video Instructor application service.
 */
@Service
public class VideoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

	/**
	 * The Video Instructor Repository for storing the entities.
	 */
	private VideoRepository videoRepository;

	/**
	 * Constructor for {@link VideoService}
	 * @param videoRepository injects {@link VideoRepository}
	 */
	public VideoService(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public VideoResponse createVideoRequest(VideoDTO videoDTO) {
		Video video = new Video(videoDTO.getVideoId(), videoDTO.getVideoName(), videoDTO.getLink(), videoDTO.getTags(),
				videoDTO.getViews(), videoDTO.getActive());
		video = videoRepository.addVideo(video);
		return VideoResponse.createInstance(video);

	}

	public VideoResponse updateVideoRequest(String videoId, VideoDTO videoDTO) {
		Video video = new Video(videoDTO.getVideoId(), videoDTO.getVideoName(), videoDTO.getLink(), videoDTO.getTags(),
				videoDTO.getViews(), videoDTO.getActive());
		video = videoRepository.updateVideo(videoId, video);
		return VideoResponse.createInstance(video);

	}

	public VideoResponse deleteVideoRequest(String videoId) {
		Video video = videoRepository.deleteVideo(videoId);
		return VideoResponse.createInstance(video);

	}

	public VideoResponse getVideoRequest(String videoId) {
		Video video = videoRepository.getVideo(videoId);
		return VideoResponse.createInstance(video);

	}

	public List<VideoDTO> getVideoAnalytics() {
		List<Video> course = videoRepository.getVideoAnalytics();
		return course.stream().map(VideoService::createVideoDTO).collect(Collectors.toList());

	}

	private static VideoDTO createVideoDTO(Video course) {
		VideoDTO videoDTO = new VideoDTO();
		BeanUtils.copyProperties(course, videoDTO);
		return videoDTO;
	}

}