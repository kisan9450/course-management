package com.learning.coursemanagement.dataproviders;

import com.learning.coursemanagement.common.exceptions.DatabaseFailureException;
import com.learning.coursemanagement.dataproviders.mongo.TagMongoRepository;
import com.learning.coursemanagement.domain.Tag;
import com.learning.coursemanagement.domain.repositories.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

	private static final Logger log = LoggerFactory.getLogger(TagRepositoryImpl.class);

	private TagMongoRepository tagMongoRepository;

	private MongoTemplate mongoTemplate;

	public TagRepositoryImpl(TagMongoRepository tagMongoRepository, MongoTemplate mongoTemplate) {
		this.tagMongoRepository = tagMongoRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Tag addTag(Tag tag) {
		try {
			return tagMongoRepository.save(tag);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Tag updateTag(String tagId, Tag tag) {
		try {
			return tagMongoRepository.save(tag);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Tag deleteTag(String tagId) {
		List<Tag> tag = null;
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("tagId").is(tagId));
			Update update = new Update();
			update.set("active", "false");
			mongoTemplate.updateMulti(query, update, Tag.class);
			tag = mongoTemplate.find(query, Tag.class);
			return tag.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Tag getTag(String tagId) {
		List<Tag> tag = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("tagId").is(tagId));
			query.addCriteria(Criteria.where("active").is("true"));
			tag = mongoTemplate.find(query, Tag.class);
			return tag.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

}
