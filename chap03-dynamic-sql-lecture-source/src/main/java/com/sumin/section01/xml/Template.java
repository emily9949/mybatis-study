package com.sumin.section01.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/* 설명.
*   MyBatis의 SqlSessionFactory를 생성하고 관리
*   DB 연결을 생성하고 반환하는 역할 수행
* */

// getSqlSession()을 호출하면 MyBatis DB 연결을 가져올 수 있음
public class Template {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}