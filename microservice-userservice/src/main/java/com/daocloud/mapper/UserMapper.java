package com.daocloud.mapper;

import com.daocloud.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Insert("insert into tb_user(username,address) values(#{username},#{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
	int saveUser(User user);
    @Select("select * from tb_user where username =#{username}")
    User selectUser(String username);
    @Select("select * from tb_user where id =#{id}")
    User selectUserById(int id);
}