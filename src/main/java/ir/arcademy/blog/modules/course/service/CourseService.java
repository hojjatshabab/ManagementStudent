package ir.arcademy.blog.modules.course.service;

import java.util.List;
import java.util.Optional;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.repository.CourseRepository;
import ir.arcademy.blog.modules.posts.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository=courseRepository;
	}

	@Transactional
	public Course registerCourse(Course book) {
		return this.courseRepository.save(book);
	}
	
	public List<Course> findAllCourse(){
		return (List<Course>) this.courseRepository.findAll();
	}


	public Course findById(Long id) {
		return courseRepository.getOne(id);
	}


	@Transactional
	public void deleteById(Long id) {
		courseRepository.deleteById(id);
		
	}
	

}
