package com.learning.coursemanagement.dataproviders.mongo;

import com.learning.coursemanagement.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMongoRepository extends MongoRepository<Course, String> {

}