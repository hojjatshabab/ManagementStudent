package ir.arcademy.blog.modules.course.controller;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.entity.Term;
import ir.arcademy.blog.modules.course.entity.UserTerm;
import ir.arcademy.blog.modules.course.service.TermService;
import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.users.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/term")
public class TermController {
    private TermService termService;

    @Autowired
    public TermController(TermService termService){
        this.termService=termService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showTerm(Model model) {
        model.addAttribute("term",termService.findAllTerms());
        return "term/terms";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("term", new Term());
        return "term/registerTerms";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid Term term, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "term/registerTerms";

        termService.registerTerm(term);
        return "redirect:/term";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(Model model,@PathVariable("id") Integer id) {
        model.addAttribute("term", termService.findById(id));
        return "term/registerTerms";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePage(@PathVariable("id") Integer id) {
        termService.deleteById(id);
        return "redirect:/term";
    }
}
