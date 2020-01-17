package com.magic.mapper;

import com.magic.dto.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}