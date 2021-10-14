package com.learning.coursemanagement.dataproviders;

import com.learning.coursemanagement.common.exceptions.DatabaseFailureException;
import com.learning.coursemanagement.dataproviders.mongo.SubjectMongoRepository;
import com.learning.coursemanagement.domain.Subject;
import com.learning.coursemanagement.domain.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

	private static final Logger log = LoggerFactory.getLogger(LessonRepositoryImpl.class);

	private SubjectMongoRepository subjectMongoRepository;

	private MongoTemplate mongoTemplate;

	public SubjectRepositoryImpl(SubjectMongoRepository subjectMongoRepository, MongoTemplate mongoTemplate) {
		this.subjectMongoRepository = subjectMongoRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Subject addSubject(Subject subject) {
		try {
			return subjectMongoRepository.save(subject);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Subject updateSubject(String subjectId, Subject subject) {
		try {
			return subjectMongoRepository.save(subject);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Subject deleteSubject(String subjectId) {
		List<Subject> subject = null;
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("subjectId").is(subjectId));
			Update update = new Update();
			update.set("active", "false");
			mongoTemplate.updateMulti(query, update, Subject.class);
			subject = mongoTemplate.find(query, Subject.class);
			return subject.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Subject getSubject(String subjectId) {
		List<Subject> subject = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("subjectId").is(subjectId));
			query.addCriteria(Criteria.where("active").is("true"));
			subject = mongoTemplate.find(query, Subject.class);
			return subject.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

}
