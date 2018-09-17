package com.mz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/17.
 */
@Data
public class Dept implements Serializable {

    private String deptId;
    private String name;
}
