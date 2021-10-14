package com.learning.coursemanagement.dataproviders;

import com.learning.coursemanagement.common.exceptions.DatabaseFailureException;
import com.learning.coursemanagement.dataproviders.mongo.VideoMongoRepository;
import com.learning.coursemanagement.domain.Video;
import com.learning.coursemanagement.domain.repositories.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class VideoRepositoryImpl implements VideoRepository {

	private static final Logger log = LoggerFactory.getLogger(VideoRepositoryImpl.class);

	private VideoMongoRepository videoMongoRepository;

	private MongoTemplate mongoTemplate;

	public VideoRepositoryImpl(VideoMongoRepository videoMongoRepository, MongoTemplate mongoTemplate) {
		this.videoMongoRepository = videoMongoRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Video addVideo(Video video) {
		try {
			return videoMongoRepository.save(video);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Video updateVideo(String videoId, Video video) {
		try {
			return videoMongoRepository.save(video);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Video deleteVideo(String videoId) {

		List<Video> video = null;
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("videoId").is(videoId));
			Update update = new Update();
			update.set("active", "false");
			mongoTemplate.updateMulti(query, update, Video.class);
			video = mongoTemplate.find(query, Video.class);
			return video.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Video getVideo(String videoId) {

		List<Video> video = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("videoId").is(videoId));
			query.addCriteria(Criteria.where("active").is("true"));
			video = mongoTemplate.find(query, Video.class);

			if (video != null) {
				int views = Integer.parseInt(video.get(0).getViews()) + 1;
				Update update = new Update();
				update.set("views", Integer.toString(views));
				mongoTemplate.updateMulti(query, update, Video.class);
				video = mongoTemplate.find(query, Video.class);
			}

			return video.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public List<Video> getVideoAnalytics() {
		List<Video> video = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("active").is("true"));
			video = mongoTemplate.find(query, Video.class);
			video.sort(Comparator.comparing(Video::getViews, Comparator.reverseOrder()));
			return video;
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

}
