package com.learning.coursemanagement.dataproviders;

import com.learning.coursemanagement.common.exceptions.DatabaseFailureException;
import com.learning.coursemanagement.dataproviders.mongo.LessonMongoRepository;
import com.learning.coursemanagement.domain.Lesson;
import com.learning.coursemanagement.domain.repositories.LessonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepositoryImpl implements LessonRepository {

	private static final Logger log = LoggerFactory.getLogger(LessonRepositoryImpl.class);

	private LessonMongoRepository lessonMongoRepository;

	private MongoTemplate mongoTemplate;

	public LessonRepositoryImpl(LessonMongoRepository lessonMongoRepository, MongoTemplate mongoTemplate) {
		this.lessonMongoRepository = lessonMongoRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Lesson addLesson(Lesson lesson) {
		try {
			return lessonMongoRepository.save(lesson);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Lesson updateLesson(String lessonId, Lesson lesson) {
		try {
			return lessonMongoRepository.save(lesson);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}

	}

	@Override
	public Lesson deleteLesson(String lessonId) {
		List<Lesson> lesson = null;
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("lessonId").is(lessonId));
			Update update = new Update();
			update.set("active", "false");
			mongoTemplate.updateMulti(query, update, Lesson.class);
			lesson = mongoTemplate.find(query, Lesson.class);
			return lesson.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}

	}

	@Override
	public Lesson getLesson(String lessonId) {

		List<Lesson> lesson = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("lessonId").is(lessonId));
			query.addCriteria(Criteria.where("active").is("true"));
			lesson = mongoTemplate.find(query, Lesson.class);
			return lesson.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

}
