package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Course;

public interface CourseService {
	public abstract List<Course> getAllCourse();
	public abstract Course addCourse(Course course);
	public abstract int deleteCourse(int id);
	public abstract Course updateCourse(Course course);
}
