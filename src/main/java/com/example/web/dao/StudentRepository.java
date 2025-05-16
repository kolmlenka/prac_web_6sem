package com.example.web.dao;

import com.example.web.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    void deleteById(Long id);

    @Query("SELECT s FROM Student s WHERE s.group = :groupId")
    List<Student> findByGroupId(Long groupId);
}