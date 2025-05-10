package com.example.web.dao;

import com.example.web.Stream_group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StreamGroupRepository extends JpaRepository<Stream_group, Long> {

    @Query("SELECT sg FROM Stream_group sg WHERE sg.id = :groupId")
    Optional<Stream_group> findStreamByGroup(Long groupId);

    @Query("SELECT sg FROM Stream_group sg WHERE sg.stream = :stream")
    List<Stream_group> findGroupByStream(Long stream);

    @Query("SELECT sg FROM Stream_group sg")
    List<Stream_group> findAll();
}