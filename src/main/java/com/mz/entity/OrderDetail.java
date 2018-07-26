package com.mz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhang on 2018/7/18.<br/>
 * Description:
 *
 * 维护订单和商品关系
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int orderId;
    private int itemId;
    private int itemNum;
}
