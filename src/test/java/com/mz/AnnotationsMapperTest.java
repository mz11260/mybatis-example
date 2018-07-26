package com.mz;

import com.mz.mapper.UserOrderItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationsMapperTest {

    UserOrderItemMapper orderItemMapper;
    @Autowired
    public void setOrderItemMapper(UserOrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Test
    public void test1() {
        orderItemMapper.findUserOrderByUserId(1);
    }
}
