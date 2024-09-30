package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;
  

    @GetMapping("/viewStudentDetails")
    public String fetchAllStudents(Model model) {
        model.addAttribute("students", studentService.fetchAllStudents());
        return "redirect:/viewinfo";
    }

    @GetMapping("/viewinfo")
    public String viewInfo(Model model) {
        model.addAttribute("students", studentService.fetchAllStudents());
        return "viewinfo";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        String message = studentService.addStudent(student);
        System.out.println(message);
        return "redirect:addStudent";
    }

    @GetMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/viewinfo";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentdetails(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "updatestudent";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        studentService.updateStudent(existingStudent);
        return "redirect:/viewStudentDetails";
    }

    @GetMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("error", "An unexpected error occurred.");
        return "error";
    }
}