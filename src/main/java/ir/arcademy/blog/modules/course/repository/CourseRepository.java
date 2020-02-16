package ir.arcademy.blog.modules.course.repository;

import java.util.List;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.entity.Term;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    
    List<Course> findByName(String name);

    Course getOne(Long id);

    List<Course> findAllByTerm(Term term);
}
