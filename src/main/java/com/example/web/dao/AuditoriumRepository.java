package com.example.web.dao;

import com.example.web.entities.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

    @Query("SELECT a FROM Auditorium a")
    List<Auditorium> findAllAuditoriums();
}