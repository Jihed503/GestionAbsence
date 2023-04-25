package com.example.sms.controller;

import com.example.sms.entity.Groupe;
import com.example.sms.entity.Student;
import com.example.sms.repository.GroupeRepository;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.GroupeService;
import com.example.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupeController {
    private GroupeService groupeService;

    @Autowired
    private GroupeRepository groupeRepo;

    private StudentRepository studentRepo;

    private StudentService studentService;

    public GroupeController(GroupeService groupeService, GroupeRepository groupeRepo,
                            StudentRepository studentRepo, StudentService studentService) {
        super();
        this.groupeService = groupeService;
        this.groupeRepo = groupeRepo;
        this.studentRepo = studentRepo;
        this.studentService = studentService;
    }

//	add groupe
    @GetMapping("/groupes/new")
    public String createGroupeForm(Model model) {

        // created groupe object to hold groupe form data
        Groupe groupe = new Groupe();
        model.addAttribute("groupe", groupe);
        return "create_groupe";
    }

//	save groupe
    @PostMapping("/groupes")
    public String saveGroupe(@ModelAttribute("groupe") Groupe groupe) {
        groupeService.saveGroupe(groupe);
        return "redirect:/groupes";
    }

//	List all groupes
    /*
    @GetMapping("/groupes")
    public String listGroupes(Model model) {
        model.addAttribute("groupes", groupeService.getAllGroupes());
        List<Student> students = new ArrayList<>();
        model.addAttribute("students", students);
        return "groupes";
    }

    @PostMapping("/groupes")
    public String groupStudents(Model model, @RequestParam("groupe") String groupe) {
        // Add the list of groups to the model
        List<Groupe> groupes = groupeService.getAllGroupes();
        model.addAttribute("groupes", groupes);

        // Get the list of students belonging to the selected group
        List<Student> students = studentRepo.findByClasse(groupe);
        model.addAttribute("students", students);

        return "groupes";
    }
    */

    @GetMapping("/groupes")
    public String getGroup(@RequestParam(value = "groupe", required = false) String groupName, Model model) {
        model.addAttribute("groupes", groupeService.getAllGroupes());

        List<Student> students;

        if(groupName!="") {
            students = studentRepo.findByClasse(groupName);
        }

        else {
            students = studentService.getAllStudents();
        }

        model.addAttribute("groupe", groupName);
        model.addAttribute("students", students);
        return "groupes";
    }

    @GetMapping("/manageGroupe")
    public String getGroup(Model model) {
        model.addAttribute("groupes", groupeService.getAllGroupes());
        return "manage_groupe";
    }

//	update groupe from page
    @GetMapping("/groupes/edit/{id}")
    public String editGroupe(@PathVariable Long id, Model model) {
        Groupe existingGroupe = groupeService.getGroupeById(id);
        model.addAttribute("groupe", existingGroupe);
        return "edit_groupe";
    }


//	update student actual
    @PostMapping("/groupes/{id}")
    public String updateGroupe(@PathVariable Long id,
                                @ModelAttribute("groupe") Groupe groupe,
                                Model model) {
        // Get Groupe details from database
        Groupe existingGroupe = groupeService.getGroupeById(id);
        existingGroupe.setId(groupe.getId());
        existingGroupe.setName(groupe.getName());

        // save updated groupe object
        groupeService.updateGroupe(existingGroupe);

        return "redirect:/manageGroupe";
    }

//	delete student
    @GetMapping("/groupes/{id}")
    public String deleteGroupe(@PathVariable Long id) {
        groupeService.deleteGroupe(id);
        return "redirect:/manageGroupe";
    }

}
