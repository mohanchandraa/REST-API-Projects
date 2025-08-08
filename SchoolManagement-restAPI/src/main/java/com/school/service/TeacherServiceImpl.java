package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Teacher;
import com.school.enums.Qualification;
import com.school.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@Override
    public Teacher addNewTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher updateTeacherById(Long id, Teacher teacher) {
        Teacher existing = teacherRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTeacherName(teacher.getTeacherName());
            existing.setTeacherAddress(teacher.getTeacherAddress());
            existing.setQualification(teacher.getQualification());
            existing.setAge(teacher.getAge());
            existing.setDob(teacher.getDob());
            existing.setExperience(teacher.getExperience());
            return teacherRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher patchUpdateTeacherById(Long id, Teacher teacher) {
        Teacher existing = teacherRepository.findById(id).orElse(null);
        if (existing != null) {
            if (teacher.getTeacherName() != null) existing.setTeacherName(teacher.getTeacherName());
            if (teacher.getTeacherAddress() != null) existing.setTeacherAddress(teacher.getTeacherAddress());
            if (teacher.getQualification() != null) existing.setQualification(teacher.getQualification());
            if (teacher.getAge() != 0) existing.setAge(teacher.getAge());
            if (teacher.getDob() != null) existing.setDob(teacher.getDob());
            if (teacher.getExperience() != 0) existing.setExperience(teacher.getExperience());
            return teacherRepository.save(existing);
        }
        return null;
    }
    
    
    @Override
    public List<Teacher> getByQualification(Qualification qualification) {
        return teacherRepository.findByQualification(qualification);
    }

    @Override
    public List<Teacher> getByExperienceGreaterThan(int experience) {
        return teacherRepository.findByExperienceGreaterThan(experience);
    }

    @Override
    public List<Object[]> getTeacherNamesAndQualifications() {
        return teacherRepository.getTeacherNamesAndQualifications();
    }

    @Override
    public List<Object[]> countTeachersByQualification() {
        return teacherRepository.countTeachersByQualification();
    }
}
