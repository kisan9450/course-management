package com.learning.coursemanagement.domain.repositories;

import com.learning.coursemanagement.domain.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository {

	Lesson addLesson(Lesson lesson);

	Lesson updateLesson(String lessonId, Lesson lesson);

	Lesson deleteLesson(String lessonId);

	Lesson getLesson(String lessonId);

}
