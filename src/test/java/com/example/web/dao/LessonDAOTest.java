package com.example.web.dao;

import com.example.web.entities.Auditorium;
import com.example.web.entities.Lesson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class LessonDAOTest {

    @Autowired
    private LessonDAO lessonDAO;

    @Test
    void testFindAll() {
        List<Lesson> ans = lessonDAO.getAllLessons();
        assertThat(ans).hasSize(8);
    }

    @Test
    void testGetScheduleByTimeInterval() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 44);
        LocalDateTime start = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        LocalDateTime end = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        List<Lesson> schedule = lessonDAO.getScheduleByTimeInterval(start, end);
        assertThat(schedule).hasSize(4);
    }

    @Test
    void testGetFreeAuditoriums() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 45);
        LocalDateTime start = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 5);

        LocalDateTime end = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        List<Auditorium> freeAuditoriums = lessonDAO.getFreeAuditoriums(start, end);

        assertThat(freeAuditoriums).hasSize(6);
    }
}