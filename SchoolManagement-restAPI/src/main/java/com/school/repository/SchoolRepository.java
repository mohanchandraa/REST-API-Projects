package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
	
	
	List<School> findByAddress(String address);
	List<School> findByTeacherName(String teacherName);

	@Query(value = "SELECT school_name, teacher_name FROM school", nativeQuery = true)
	List<Object[]> fetchSchoolAndTeacherNames();

	@Query(value = "SELECT COUNT(*) FROM school WHERE address = :address", nativeQuery = true)
	int countSchoolsByAddress(@Param("address") String address);
}
