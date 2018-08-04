package com.mz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by zhang on 2018/7/18.<br/>
 * Description:
 *
 * 商品
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMode {

    private int id = 1233;
    private String name = "不知道啊";
    private float price = 89.98F;
    private String detail = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
    private String pic = "4234321432";
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
