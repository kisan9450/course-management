package com.learning.coursemanagement.domain.repositories;

import com.learning.coursemanagement.domain.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository {

	Subject addSubject(Subject subject);

	Subject updateSubject(String subjectId, Subject subject);

	Subject deleteSubject(String subjectId);

	Subject getSubject(String subjectId);

}
