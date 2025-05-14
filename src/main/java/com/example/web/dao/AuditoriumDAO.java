package com.example.web.dao;

import com.example.web.entities.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuditoriumDAO {

    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumDAO(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAllAuditoriums();
    }

    public Optional<Auditorium> getAuditoriumById(Long id) {
        return auditoriumRepository.findById(id);
    }
}
