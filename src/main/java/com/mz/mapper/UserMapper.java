package com.mz.mapper;

import com.mz.entity.Dept;
import com.mz.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/9/17.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    @Results({
            /*@Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "address", property = "address"),
            @Result(column = "dept_id", property = "deptId"),*/
            @Result(column = "dept_id", property = "dept", javaType = Dept.class,
                    one = @One(select = "com.mz.mapper.UserMapper.findDeptById")),
    })
    User findUserDetail(@Param("id") int id);

    @Select("select * from dept where dept_id = #{deptId}")
    Dept findDeptById(@Param("deptId") String deptId);
}
