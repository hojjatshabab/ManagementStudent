package ir.arcademy.blog.modules.course.service;

import java.util.List;
import java.util.Optional;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.entity.Term;
import ir.arcademy.blog.modules.course.entity.UserCourse;
import ir.arcademy.blog.modules.course.entity.UserTerm;
import ir.arcademy.blog.modules.course.repository.CourseRepository;
import ir.arcademy.blog.modules.course.repository.TermRepository;
import ir.arcademy.blog.modules.course.repository.UserCourseRepository;
import ir.arcademy.blog.modules.course.repository.UserTermRepository;
import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service
public class CourseService {
	
	private CourseRepository courseRepository;

	private TermRepository termRepository;
	private UsersRepository usersRepository;
	private UserTermRepository userTermRepository;
	private UserCourseRepository userCourseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository,
						 TermRepository termRepository,
						 UsersRepository usersRepository ,
						 UserTermRepository userTermRepository,
						 UserCourseRepository userCourseRepository) {
		this.courseRepository=courseRepository;
		this.usersRepository=usersRepository;
		this.termRepository=termRepository;
		this.userTermRepository=userTermRepository;
		this.userCourseRepository=userCourseRepository;
	}


	@Transactional
	public Course registerCourse(Course course) {
		return this.courseRepository.save(course);
	}

	public List<Course> findAllCourse(){
		return (List<Course>) this.courseRepository.findAll();
	}


	public Course findById(Long id) {
		return courseRepository.getOne(id);
	}
	@Transactional
	public List<Term> findAllTerms(){
		return this.termRepository.findAll();
	}

	@Transactional
	public Users findByEmail(String email){
		return this.usersRepository.findByEmail(email);
	}

	@Transactional
	public List<Course> courses(Term term){
		return this.courseRepository.findAllByTerm(term);
	}
	@Transactional
	public List<UserTerm> findAllUserTerms(Users users){
		return this.userTermRepository.findAllByUsers(users);
	}

	@Transactional
	public List<UserCourse> findAllUserCourse(UserTerm term){
		return this.userCourseRepository.findAllByTerm(term);
	}

	@Transactional
	public void deleteById(Long id) {
		courseRepository.deleteById(id);
		
	}
	

}
