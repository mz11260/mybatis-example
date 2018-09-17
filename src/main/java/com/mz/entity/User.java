package com.mz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhang on 2018/7/17.<br/>
 * Description:
 *
 * 用户
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private Date birthday;
    private String gender;
    private String address;

    private String deptId;

    private Dept dept;
}
