package com.springboot.demo.transactional.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public void insert(@Param("username") String username, @Param("password") String password, @Param("nickname") String nickname);
}