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
 * 订单
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int userId;
    private String number;
    private Date createTime;
    private String note;
}
