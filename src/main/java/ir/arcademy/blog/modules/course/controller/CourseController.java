package ir.arcademy.blog.modules.course.controller;



import java.io.IOException;

import ir.arcademy.blog.modules.course.entity.Course;
import ir.arcademy.blog.modules.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;






@Controller
@RequestMapping("/course/")
public class CourseController {
	
	private CourseService courseService;

	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService=courseService;

	}
	
	
	@GetMapping("list")
	public String showListStudent(Model model) {
		model.addAttribute("course", courseService.findAllCourse());
		return "course/bookpage";
	}
	@GetMapping("register")
	public String registerPage(Model model) {
		model.addAttribute("course", new Course());
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
