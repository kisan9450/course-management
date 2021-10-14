package com.learning.coursemanagement.services;

import com.learning.coursemanagement.domain.Lesson;
import com.learning.coursemanagement.domain.repositories.LessonRepository;
import com.learning.coursemanagement.entrypoints.dto.LessonDTO;
import com.learning.coursemanagement.entrypoints.response.LessonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * New Course Instructor application service.
 */
@Service
public class LessonService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LessonService.class);

	/**
	 * The Course Instructor Repository for storing the entities.
	 */
	private LessonRepository lessonRepository;

	/**
	 * Constructor for {@link LessonService}
	 * @param lessonRepository injects {@link LessonRepository}
	 */
	public LessonService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	public LessonResponse createLessonRequest(LessonDTO lessonDTO) {
		Lesson lesson = new Lesson(lessonDTO.getLessonId(), lessonDTO.getLessonName(), lessonDTO.getActive());
		lesson = lessonRepository.addLesson(lesson);
		return LessonResponse.createInstance(lesson);

	}

	public LessonResponse updateLessonRequest(String lessonId, LessonDTO lessonDTO) {
		Lesson lesson = new Lesson(lessonDTO.getLessonId(), lessonDTO.getLessonName(), lessonDTO.getActive());
		lesson = lessonRepository.updateLesson(lessonId, lesson);
		return LessonResponse.createInstance(lesson);

	}

	public LessonResponse deleteLessonRequest(String courseId) {
		Lesson lesson = lessonRepository.deleteLesson(courseId);
		return LessonResponse.createInstance(lesson);

	}

	public LessonResponse getLessonRequest(String courseId) {
		Lesson lesson = lessonRepository.getLesson(courseId);
		return LessonResponse.createInstance(lesson);

	}

}