package com.learning.coursemanagement.dataproviders;

import com.learning.coursemanagement.common.exceptions.DatabaseFailureException;
import com.learning.coursemanagement.dataproviders.mongo.CourseMongoRepository;
import com.learning.coursemanagement.domain.Course;
import com.learning.coursemanagement.domain.repositories.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

	private static final Logger log = LoggerFactory.getLogger(CourseRepositoryImpl.class);

	private CourseMongoRepository courseMongoRepository;

	private MongoTemplate mongoTemplate;

	public CourseRepositoryImpl(CourseMongoRepository courseMongoRepository, MongoTemplate mongoTemplate) {
		this.courseMongoRepository = courseMongoRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Course addCourse(Course course) {
		try {
			return courseMongoRepository.save(course);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Course updateCourse(String courseId, Course course) {
		try {
			return courseMongoRepository.save(course);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

	@Override
	public Course deleteCourse(String courseId) {

		List<Course> course = null;
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("courseId").is(courseId));
			Update update = new Update();
			update.set("active", "false");
			mongoTemplate.updateMulti(query, update, Course.class);
			course = mongoTemplate.find(query, Course.class);
			return course.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}

	}

	@Override
	public Course getCourse(String courseId) {
		List<Course> course = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("courseId").is(courseId));
			query.addCriteria(Criteria.where("active").is("true"));
			course = mongoTemplate.find(query, Course.class);

			if (course != null) {
				int views = Integer.parseInt(course.get(0).getViews()) + 1;
				Update update = new Update();
				update.set("views", Integer.toString(views));
				mongoTemplate.updateMulti(query, update, Course.class);
				course = mongoTemplate.find(query, Course.class);
			}

			return course.get(0);
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}

	}

	@Override
	public List<Course> getCourseAnalytics() {
		List<Course> course = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("active").is("true"));
			course = mongoTemplate.find(query, Course.class);
			course.sort(Comparator.comparing(Course::getViews, Comparator.reverseOrder()));
			return course;
		}
		catch (Exception ex) {
			throw DatabaseFailureException.dataBaseFailureException(ex);
		}
	}

}
