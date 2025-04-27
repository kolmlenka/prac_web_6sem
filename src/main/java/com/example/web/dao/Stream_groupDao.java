package com.example.web.dao;

import com.example.web.Stream_group;
import java.util.List;

public interface Stream_groupDao extends CommonDAO<Stream_group, Long>{
    Stream_group findStreamByGroupId(Long id);
}