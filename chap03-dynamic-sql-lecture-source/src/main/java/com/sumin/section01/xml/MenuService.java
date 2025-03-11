package com.sumin.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sumin.section01.xml.Template.getSqlSession;

/* 설명.
*   MenuMapper를 사용하여 DB에서 메뉴를 조회하는 서비스 클래스.
*   MyBatis의 SqlSession을 이용해 SQL을 실행.
* */
public class MenuService {
    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession(); // 세션 생성
        MenuMapper mapper =
                sqlSession.getMapper(MenuMapper.class);

        //  MyBatis가 SQL을 실행하고, 결과를 MenuDTO 객체 리스트로 반환함
        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice); // 가격 조건에 맞는 메뉴 조회
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        System.out.println("===== Service Layer");
        menus.forEach(System.out::println);

        sqlSession.close();
    }
}
