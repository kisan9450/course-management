package com.learning.coursemanagement.domain.repositories;

import com.learning.coursemanagement.domain.Course;
import com.learning.coursemanagement.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository {

	Video addVideo(Video video);

	Video updateVideo(String videoId, Video video);

	Video deleteVideo(String videoId);

	Video getVideo(String videoId);

	List<Video> getVideoAnalytics();

}
