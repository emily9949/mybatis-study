package com.sumin.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    @Select("SELECT NOW()") // 쿼리랑 메소드의 매핑
    Date selectNow();
}
