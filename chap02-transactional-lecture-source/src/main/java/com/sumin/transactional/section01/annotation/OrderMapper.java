package com.sumin.transactional.section01.annotation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void registOrder(Order order);
}
