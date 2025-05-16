package com.example.web.dao;

import com.example.web.entities.Auditorium;
import com.example.web.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("SELECT l FROM Lesson l WHERE l.time BETWEEN :startTime AND :endTime")
    List<Lesson> findScheduleByTimeInterval(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT l FROM Lesson l")
    List<Lesson> findAllLessons();

    @Query(value = "SELECT a " +
            "FROM auditoriums a " +
            "WHERE NOT EXISTS (" +
            "    SELECT 1 " +
            "    FROM lessons l " +
            "    WHERE l.auditorium_id = a.auditorium_id " +
            "    AND ( " +
            "        (l.time >= :startTime AND l.time < :endTime) OR " +
            "        (l.time + INTERVAL '1 hour' > :startTime AND l.time < :endTime) " +
            "    )" +
            ")",
            nativeQuery = true)
    List<Auditorium> findFreeAuditoriums(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
