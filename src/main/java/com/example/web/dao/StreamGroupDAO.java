package com.example.web.dao;

import com.example.web.entities.Stream_group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StreamGroupDAO {

    private final StreamGroupRepository streamGroupRepository;

    @Autowired
    public StreamGroupDAO(StreamGroupRepository streamGroupRepository) {
        this.streamGroupRepository = streamGroupRepository;
    }

    public List<Stream_group> getAllStreamGroups() {
        return streamGroupRepository.findAll();
    }

    public List<Stream_group> getGroupNumByStream(Long Num) {
        return streamGroupRepository.findGroupByStream(Num);
    }

    public Optional<Long> getStreamByGroupNum(Long id) {
        return streamGroupRepository.findStreamByGroup(id);
    }
}