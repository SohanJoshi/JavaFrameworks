package com.sohan.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sohan.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourse(@PathVariable String topicId) {
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "" , ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{courseId}/courses/{courseId}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
}
