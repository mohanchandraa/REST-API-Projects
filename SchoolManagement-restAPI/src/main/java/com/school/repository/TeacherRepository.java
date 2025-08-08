package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.Teacher;
import com.school.enums.Qualification;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	List<Teacher> findByQualification(Qualification qualification);
	
	List<Teacher> findByExperienceGreaterThan(int experience);
	
	@Query(value = "SELECT teacher_name, qualification FROM teacher", nativeQuery = true)
	List<Object[]> getTeacherNamesAndQualifications();
	
	@Query(value = "SELECT qualification, COUNT(*) FROM teacher GROUP BY qualification", nativeQuery = true)
	List<Object[]> countTeachersByQualification();



}
