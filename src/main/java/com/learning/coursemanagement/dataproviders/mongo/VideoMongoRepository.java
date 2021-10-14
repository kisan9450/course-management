package com.learning.coursemanagement.dataproviders.mongo;

import com.learning.coursemanagement.domain.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMongoRepository extends MongoRepository<Video, String> {

}