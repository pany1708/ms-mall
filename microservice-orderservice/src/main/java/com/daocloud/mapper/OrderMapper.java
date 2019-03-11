package com.daocloud.mapper;

import com.daocloud.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
	@Insert("{insert into tb_order(number,userid,createtime) values(#{number},#{userid},#{createtime})}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
	int saveOrder(Order order);
    @Select("select * from tb_order where userid =#{userid}")
    List<Order> selectOrder(Integer userid);
}