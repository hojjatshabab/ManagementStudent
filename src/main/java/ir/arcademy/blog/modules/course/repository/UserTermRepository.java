package ir.arcademy.blog.modules.course.repository;

import ir.arcademy.blog.modules.course.entity.UserTerm;
import ir.arcademy.blog.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTermRepository extends JpaRepository<UserTerm,Integer> {

    List<UserTerm> findAllByUsers(Users users);
}
