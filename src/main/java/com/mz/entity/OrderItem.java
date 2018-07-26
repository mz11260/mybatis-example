package com.mz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private float price;
    private String detail;
    private String pic;
    private Date createTime;
}
