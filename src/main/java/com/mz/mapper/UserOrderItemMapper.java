package com.mz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * 注解方式
 */
@Mapper
public interface UserOrderItemMapper {

    @Select("select * from user where user.id = #{userId}")
    @ResultMap("")
    void findUserOrderByUserId(@Param("userId") int userId);
}
