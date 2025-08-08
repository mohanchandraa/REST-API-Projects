package com.school.service;

import java.util.List;

import com.school.entity.School;

public interface SchoolService {

	School addNewSchool(School school);

	List<School> getAllSchools();

	School getSchoolById(Long id);

    School updateSchoolById(Long id, School school);

    String deleteSchoolById(Long id);

    School patchUpdateSchoolById(Long id, School school);
    
    List<School> getSchoolsByAddress(String address);
    List<School> getSchoolsByTeacherName(String teacherName);


    List<Object[]> getSchoolAndTeacherNames();
    int getSchoolCountByAddress(String address);
}
