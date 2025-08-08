package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Teacher;
import com.school.enums.Qualification;
import com.school.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
    private TeacherService teacherService;

    @PostMapping("/addNewTeacher")
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {
        return teacherService.addNewTeacher(teacher);
    }

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/updateTeacherById/{id}")
    public Teacher updateTeacherById(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacherById(id, teacher);
    }

    @DeleteMapping("/deleteTeacherById/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @PatchMapping("/patchUpdateTeacherById/{id}")
    public Teacher patchUpdateTeacherById(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.patchUpdateTeacherById(id, teacher);
    }
    
    
    //Custom methods and native sql queries
    @GetMapping("/getByQualification/{qualification}")
    public List<Teacher> getByQualification(@PathVariable Qualification qualification) {
        return teacherService.getByQualification(qualification);
    }

    @GetMapping("/getByExperienceGreaterThan/{years}")
    public List<Teacher> getByExperienceGreaterThan(@PathVariable int years) {
        return teacherService.getByExperienceGreaterThan(years);
    }

    @GetMapping("/getTeacherNamesAndQualifications")
    public List<Object[]> getTeacherNamesAndQualifications() {
        return teacherService.getTeacherNamesAndQualifications();
    }

    @GetMapping("/countTeachersByQualification")
    public List<Object[]> countTeachersByQualification() {
        return teacherService.countTeachersByQualification();
    }
}
