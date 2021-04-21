package com.tutorialspoint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import com.tutorialspoint.model.StudentEntity;
import com.tutorialspoint.model.StudentEntity.Gender;
import com.tutorialspoint.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String listStudents(ModelMap model) {
		// ModelMap is a subclasses of LinkedHashMap
		return "student";
	}

	@RequestMapping(value = "/formpath", params = "addStudent")
	public String addStudent(@Valid StudentEntity studentEntity,
			BindingResult result, ModelMap model, SessionStatus status) {
		if (result.hasErrors()) {
			return "student";
		} else {
			studentService.addStudent(studentEntity);
			status.setComplete();
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/formpath", params = "searchall")
	public String searchAllStudents(ModelMap model) {
		model.addAttribute("studentList", studentService.getAllStudents());
		return "searchall";
	}

	@RequestMapping(value = "/formpath", params = "search")
	public String searchStudent(ModelMap model, HttpServletRequest request) {
		String studentId = request.getParameter("id");
		List<StudentEntity> list = new ArrayList<StudentEntity>();
		list.add(studentService.getStudent(new Integer(studentId)));
		model.addAttribute("studentList", list);
		return "searchall";
	}

	@RequestMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Integer studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/";
	}

	@RequestMapping(value = "/edit")
	public String edit(
			@ModelAttribute("studentEntity") StudentEntity studentEntity,
			BindingResult result, Map<String, Object> map) {
		// set student details to command object
		map.put("studentEntity",
				studentService.getStudent(studentEntity.getId()));
		return "student";
	}

	// Provide a list of data for HTML components, like checkbox, radio button
	// or select options.
	@ModelAttribute("cityNames")
	public Set<String> populateCityNamesList() {
		// Data referencing for cityNames select box
		Set<String> cityNames = new TreeSet<String>();
		cityNames.add("Hyderabad");
		cityNames.add("Vijayavada");
		cityNames.add("Chennai");
		return cityNames;
	}

	@ModelAttribute("hobbies")
	public List<String> populateHobbiesList() {
		// Data referencing for Hobbies check box
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Reading");
		hobbies.add("Drawing");
		return hobbies;
	}

	// to set a default selected values for HTML components, like checkbox ,
	// radio button or select options.
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(ModelMap model) {
		StudentEntity std = new StudentEntity();
		std.setHobbies(new String[] { "Drawing" }); // Make "Drawing" as default
													// checked value
		std.setGender(Gender.MALE); // Make "MALE" as default radio button
									// selected value
		model.addAttribute("studentEntity", std); // add to command object
		return "student"; // return form view
	}
}
