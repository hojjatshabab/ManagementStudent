package ir.arcademy.blog.modules.course.repository;

import ir.arcademy.blog.modules.course.entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository  extends JpaRepository<Term,Integer> {

}
