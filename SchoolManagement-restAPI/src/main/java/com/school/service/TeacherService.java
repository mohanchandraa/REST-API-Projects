package com.school.service;

import java.util.List;

import com.school.entity.Teacher;
import com.school.enums.Qualification;

public interface TeacherService {
	
	Teacher addNewTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    Teacher updateTeacherById(Long id, Teacher teacher);
    void deleteTeacherById(Long id);
    Teacher patchUpdateTeacherById(Long id, Teacher teacher);
    
    List<Teacher> getByQualification(Qualification qualification);
    List<Teacher> getByExperienceGreaterThan(int experience);
    
    
    List<Object[]> getTeacherNamesAndQualifications();
    List<Object[]> countTeachersByQualification();
}
