package kz.bitlab.techorda.techboot2.controller;


import kz.bitlab.techorda.techboot2.db.DBManager;
import kz.bitlab.techorda.techboot2.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Student> studentsArray= DBManager.getStudents();
        model.addAttribute("student", studentsArray);
        return "index";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student){
        assignMark(student);
        DBManager.addStudents(student);
        return "redirect:/";
    }
    private void assignMark(Student student) {
        int examScore = student.getExam();
        if (examScore >= 90) {
            student.setMark("A");
        } else if (examScore >= 75) {
            student.setMark("B");
        } else if (examScore >= 60) {
            student.setMark("C");
        } else if (examScore >= 50) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model){
        return "addstudent";
    }

    @GetMapping(value = "/student-details")
    public String getStudent(@RequestParam(name = "studentId") int id, Model model){
        Student student=DBManager.getStudent(id);
        model.addAttribute("student", student);
        return "details";
    }
}
