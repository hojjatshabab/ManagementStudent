package ir.arcademy.blog.modules.course.controller;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.List;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.entity.Term;
import ir.arcademy.blog.modules.course.entity.UserCourse;
import ir.arcademy.blog.modules.course.entity.UserTerm;
import ir.arcademy.blog.modules.course.service.CourseService;
import ir.arcademy.blog.modules.course.service.TermService;
import ir.arcademy.blog.modules.posts.model.Posts;
import ir.arcademy.blog.modules.users.model.Users;
import ir.arcademy.blog.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/course/")
public class CourseController {
	
	private CourseService courseService;
	private TermService termService;
	private UsersService usersService;


	
	@Autowired
	public CourseController(CourseService courseService,TermService termService,UsersService usersService) {
		this.courseService=courseService;
		this.termService=termService;
		this.usersService = usersService;

	}
	
	
	@GetMapping("list")
	public String showListStudent(Model model, @AuthenticationPrincipal Principal principal) {
		model.addAttribute("course", courseService.findAllCourse());
		Users users= this.courseService.findByEmail(principal.getName());

		List<Term> terms = this.courseService.findAllTerms();
		if ( terms.size()>0 &&  terms.get(0)!=null) {
			List<Course> courses = this.courseService.courses(terms.get(0));
			System.out.println(courses);
		}
		List<UserTerm> userTerms = this.courseService.findAllUserTerms(users);
		System.out.println(terms);

		System.out.println("=======================");
		System.out.println(userTerms);
		return "course/bookpage";
	}
	@RequestMapping(value = "userunit", method = RequestMethod.POST)
	public String userunitPage(Model model) {
		model.addAttribute("userCourse", new UserCourse());
		return "selectunit/userunit";
	}
    @RequestMapping(value = "userunit/{id}", method = RequestMethod.GET)
	public String userunit(Model model,@PathVariable("id") Integer id) {
		UserTerm termId = this.courseService.findByIdUserTerm(id);
		List<UserCourse> courses = this.courseService.findAllUserCourse(termId);
		this.courseService.addCourseToUserTerm(courses,termId.getId());
		return "redirect:selectunit/userunit";
	}

	@RequestMapping(value = "selectunit", method = RequestMethod.GET)
	public String showAllUnit(Model model) {
		model.addAttribute("course", courseService.findAllCourse());
		return "selectcourse/selectcourse";
	}


	@RequestMapping(value = "selectuserterm", method = RequestMethod.POST)
	public String selectUserTerm(Model model,Principal principal) {
		UserTerm userTerm = new UserTerm();
		UserTerm resultUserTerm = this.courseService.createUserTerm(userTerm,principal.getName() );
		return "redirect:/course/selectunit";
	}

	@RequestMapping(value = "selectuserterm", method = RequestMethod.GET)
	public String selectUserTermPage(Model model) {
		model.addAttribute("term", termService.findAllTerms());
		return "selectTerm/registerTerms";
	}

	@GetMapping("register")
	public String registerPage(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("term", termService.findAllTerms());
		return "course/registerBook";
	}
	@PostMapping("register")
	public String register(@ModelAttribute Course course){
		courseService.registerCourse(course);
		return "redirect:/course/list";
	}

	
	@GetMapping("edit/{id}")
	public String editPage(Model model,@PathVariable("id") Long id) {
		model.addAttribute("course", courseService.findById(id));
		return "course/registerBook";
	}
	
	
	@GetMapping("delete/{id}")
	public String deletePage(@PathVariable("id") Long id) {
		courseService.deleteById(id);
		return "redirect:/course/list";
	}
	
	
	
}
