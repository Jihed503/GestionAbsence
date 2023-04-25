package com.example.sms.controller;

import com.example.sms.entity.Absence;
import com.example.sms.entity.Student;
import com.example.sms.repository.AbsenceRepository;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.AbsenceService;
import com.example.sms.service.StudentService;
import com.sun.jdi.LongValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class AbsenceController {
    private AbsenceService absenceService;

    private AbsenceRepository absenceRepo;

    private StudentService studentService;

    private StudentRepository studentRepo;

    public AbsenceController(AbsenceService absenceService, AbsenceRepository absenceRepo, StudentService studentService, StudentRepository studentRepo) {
        this.absenceService = absenceService;
        this.absenceRepo = absenceRepo;
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/absence")
    public String getStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "absence";
    }

    @PostMapping("/absence")
    public String updateAttendance(@RequestParam Map<String,String> requestParams) {
        LocalDate currentDate = LocalDate.now();
        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            int cin = Integer.parseInt(entry.getKey());
            boolean present = Boolean.parseBoolean(entry.getValue());
            Student student = studentService.getStudentById(Long.valueOf(cin));
            student.setPresent(present);
            studentService.saveStudent(student);
            Absence absence = new Absence(student.getCin(), student.getName(), student.getFirstName(),
                    currentDate, student.getClasse(), !present);
            absenceService.saveAbsence(absence);
        }
        return "redirect:/absence";
    }

}
