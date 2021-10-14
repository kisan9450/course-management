package com.learning.coursemanagement.dataproviders.mongo;

import com.learning.coursemanagement.domain.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMongoRepository extends MongoRepository<Subject, String> {

}