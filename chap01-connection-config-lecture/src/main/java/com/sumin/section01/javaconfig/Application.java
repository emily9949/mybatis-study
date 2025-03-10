package com.sumin.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/menudb";
    private static String user = "root";
    private static String password = "449966";

    public static void main(String[] args) {

        /* 설명.
        *   JdbcTransactionFactory : 수동 커밋
        *   ManagedTransactionFactory : 자동 커밋
        *   -----------------------------------
        *   PooledDataSource : ConnectionPool 사용
        *   UnPooledDataSource : ConnectionPool 미사용
        * */

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password)
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        /* 설명.
        *   SqlSessionFactory : SqlSession 객체를 생성하ㅣ 위한 팩토리 역할의 인터페이스
        *   SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *   build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java방식) 혹은 외부 설정 파일과 연결된
        *             stream을 매개변수로 전달(xml방식) 하면  SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession(false); // false 를 작성해야 수동커밋 완성
        // session : 커넥션 객체

        Mapper mapper = session.getMapper(Mapper.class);

        java.util.Date date = mapper.selectNow();
        System.out.println("date = " + date);

        session.close(); // 커넥션 객체 자원 반납


    }
}
