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

import com.school.entity.School;
import com.school.service.SchoolService;

@RestController
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;


    @PostMapping("/addNewSchool")
    public School addNewSchool(@RequestBody School school) {
        return schoolService.addNewSchool(school);
    }

    @GetMapping("/getAllSchools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("getSchoolById/{id}")
    public School getSchoolById(@PathVariable Long id) {
    	return schoolService.getSchoolById(id);
    }
    
    @PutMapping("/updateSchoolById/{id}")
    public School updateSchoolById(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchoolById(id, school);
    }
    
    @DeleteMapping("/deleteSchoolById/{id}")
    public String deleteSchool(@PathVariable Long id) {
        return schoolService.deleteSchoolById(id);
    }
    
    @PatchMapping("/patchUpdateSchoolById/{id}")
    public School patchUpdateById(@PathVariable Long id, @RequestBody School school) {
        return schoolService.patchUpdateSchoolById(id, school);
    }
    
    
    @GetMapping("/getSchoolByAddress/{address}")
    public List<School> getSchoolsByAddress(@PathVariable String address) {
        return schoolService.getSchoolsByAddress(address);
    }

    //Custom methods and Native SQL queries
    @GetMapping("/getSchoolByTeacher/{teacherName}")
    public List<School> getSchoolsByTeacherName(@PathVariable String teacherName) {
        return schoolService.getSchoolsByTeacherName(teacherName);
    }

    @GetMapping("/getSchoolAndTeacherNames")
    public List<Object[]> getSchoolAndTeacherNames() {
        return schoolService.getSchoolAndTeacherNames();
    }

    @GetMapping("/countSchoolsByAddress/{address}")
    public int countSchoolsByAddress(@PathVariable String address) {
        return schoolService.getSchoolCountByAddress(address);
    }
    
    //Implement pagenation
}
