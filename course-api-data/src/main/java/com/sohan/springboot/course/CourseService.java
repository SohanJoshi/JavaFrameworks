package com.sohan.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
						.forEach(courses::add);
		return courses;
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
