package ir.arcademy.blog.modules.course.repository;

import ir.arcademy.blog.modules.course.entity.UserCourse;
import ir.arcademy.blog.modules.course.entity.UserTerm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse,Integer> {

    List<UserCourse> findAllByTerm(UserTerm term);
}
