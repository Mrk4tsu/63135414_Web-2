package thiGK.ntu63135414.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thiGK.ntu63135414.models.Student;
import thiGK.ntu63135414.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentService();

    @GetMapping("/students/list")
    public String listStudents(Model model) {
        studentService = new StudentService();
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }

    @GetMapping("/students/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String id, Model model) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "students/search";
    }
}
