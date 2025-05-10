package com.example.web.dao;

import com.example.web.Auditorium;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AuditoriumDAOTest {

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Test
    void testGetAuditoriumById() {
        Long auditoriumId = 1L;
        Optional<Auditorium> auditoriums = auditoriumDAO.getAuditoriumById(auditoriumId);
        assertThat(auditoriums).isPresent();
    }

    @Test
    void testFindByNonExistingAuditoriumId() {
        Long auditoriumId = 71L;
        Optional<Auditorium> auditoriums = auditoriumDAO.getAuditoriumById(auditoriumId);
        assertThat(auditoriums).isEmpty();
    }

    @Test
    void testFindAll() {
        List<Auditorium> auditoriums = auditoriumDAO.getAllAuditoriums();
        assertThat(auditoriums).hasSize(9);
    }
}