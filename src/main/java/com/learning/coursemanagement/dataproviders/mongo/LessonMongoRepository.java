package com.learning.coursemanagement.dataproviders.mongo;

import com.learning.coursemanagement.domain.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonMongoRepository extends MongoRepository<Lesson, String> {

}