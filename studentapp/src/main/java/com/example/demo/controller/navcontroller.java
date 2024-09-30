package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navcontroller {

//	 @GetMapping("/viewStudentDetails")
//	    public String viewStudentDetails() {
//	        return "viewinfo.html";
//	    }

	    @GetMapping("/addStudent")
	    public String addStudent() {
	        return "addStudent.html";
	    }

	    @GetMapping("/updateStudent")
	    public String updateStudent() {
	        return "updatestudent.html";
	    }

	  
	   
}
