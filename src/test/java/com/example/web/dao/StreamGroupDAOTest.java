package com.example.web.dao;

import com.example.web.Stream_group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class StreamGroupDAOTest {

    @Autowired
    private StreamGroupDAO streamGroupDAO;

    @Test
    void testFindGroupByStream() {
        Long stream = 1L;
        List<Stream_group> ans = streamGroupDAO.getGroupNumByStream(stream);
        assertThat(ans).hasSize(3);
    }

    @Test
    void testFindGroupByNonExistingStream() {
        Long stream = 4L;
        List<Stream_group> ans = streamGroupDAO.getGroupNumByStream(stream);
        assertThat(ans).isEmpty();
    }

    @Test
    void testFindStreamByGroup() {
        Long stream = 211L;
        Optional<Stream_group> ans = streamGroupDAO.getStreamByGroupNum(stream);
        assertThat(ans).isPresent();
    }

    @Test
    void testFindStreamByNonExistingGroup() {
        Long stream = 777L;
        Optional<Stream_group> ans = streamGroupDAO.getStreamByGroupNum(stream);
        assertThat(ans).isEmpty();
    }

    @Test
    void testFindAll() {
        List<Stream_group> courses = streamGroupDAO.getAllStreamGroups();
        assertThat(courses).hasSize(6);
    }
}