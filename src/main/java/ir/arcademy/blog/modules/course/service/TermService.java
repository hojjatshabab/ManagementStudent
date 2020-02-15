package ir.arcademy.blog.modules.course.service;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.entity.Term;
import ir.arcademy.blog.modules.course.repository.TermRepository;
import ir.arcademy.blog.modules.posts.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Transactional
public class TermService {

    private TermRepository termRepository;

    @Autowired
    public TermService(TermRepository termRepository){
        this.termRepository=termRepository;
    }

    public Term registerTerm(Term term) {
        return this.termRepository.save(term);
    }

    public List<Term> findAllTerms(){
        return this.termRepository.findAll();
    }

    public Term findById(Integer id) {
        return termRepository.getOne(id);
    }

    public void deleteById(Integer id) {
        termRepository.deleteById(id);

    }
}
