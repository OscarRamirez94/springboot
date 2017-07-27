package com.proyecto.serviceImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.controller.CourseController;
import com.proyecto.entity.Course;
import com.proyecto.repository.CourseJpaRepository;
import com.proyecto.service.CourseService;
@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	private final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class); 
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository ;
	@Override
	public List<Course> getAllCourse() {
		LOGGER.info("Se ah llamado " + " getAllCourse" + " serviceCourseImpl" );
		return courseJpaRepository.findAll();
		
	}

	@Override
	public Course addCourse(Course course) {
		LOGGER.info("Se ah llamado " + " addCourse" + " serviceCourseImpl" + course.toString() );
		return courseJpaRepository.save(course);
	}

	

	@Override
	public int deleteCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return  courseJpaRepository.save(course);
		
	}

}
