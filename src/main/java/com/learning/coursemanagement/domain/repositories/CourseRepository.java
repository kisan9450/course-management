package com.learning.coursemanagement.domain.repositories;

import com.learning.coursemanagement.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {

	Course addCourse(Course courseInstructor);

	Course updateCourse(String courseId, Course courseInstructor);

	Course deleteCourse(String courseId);

	Course getCourse(String courseId);

	List<Course> getCourseAnalytics();

}
