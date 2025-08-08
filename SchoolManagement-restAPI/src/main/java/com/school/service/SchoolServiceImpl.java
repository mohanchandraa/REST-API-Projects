package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.School;
import com.school.repository.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public School addNewSchool(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public List<School> getAllSchools() {
		return schoolRepository.findAll();
	}
	
	@Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    public School updateSchoolById(Long id, School updatedSchool) {
        Optional<School> optional = schoolRepository.findById(id);
        if (optional.isPresent()) {
            School existing = optional.get();
            existing.setSchoolName(updatedSchool.getSchoolName());
            existing.setSchoolAddress(updatedSchool.getSchoolAddress());
            existing.setTeacherId(updatedSchool.getTeacherId());
            return schoolRepository.save(existing);
        } else {
            return null;
        }
    }

    @Override
    public String deleteSchoolById(Long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return "School with ID " + id + " deleted successfully.";
        } else {
            return "School with ID " + id + " not found.";
        }
    }
    
    @Override
    public School patchUpdateSchoolById(Long id, School updatedSchool) {
        School existingSchool = schoolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("School with ID " + id + " not found"));

        if (updatedSchool.getSchoolName() != null) {
            existingSchool.setSchoolName(updatedSchool.getSchoolName());
        }
        if (updatedSchool.getSchoolAddress() != null) {
            existingSchool.setSchoolAddress(updatedSchool.getSchoolAddress());
        }
        if (updatedSchool.getTeacherId() != null) {
            existingSchool.setTeacherId(updatedSchool.getTeacherId());
        }

        return schoolRepository.save(existingSchool);
    }
    
    
    @Override
    public List<School> getSchoolsByAddress(String address) {
        return schoolRepository.findByAddress(address);
    }

    @Override
    public List<School> getSchoolsByTeacherName(String teacherName) {
        return schoolRepository.findByTeacherName(teacherName);
    }

    @Override
    public List<Object[]> getSchoolAndTeacherNames() {
        return schoolRepository.fetchSchoolAndTeacherNames();
    }

    @Override
    public int getSchoolCountByAddress(String address) {
        return schoolRepository.countSchoolsByAddress(address);
    }  
}
