package com.learning.coursemanagement.dataproviders.mongo;

import com.learning.coursemanagement.domain.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMongoRepository extends MongoRepository<Tag, String> {

}