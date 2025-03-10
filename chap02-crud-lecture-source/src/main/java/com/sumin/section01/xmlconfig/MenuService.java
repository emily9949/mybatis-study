package com.sumin.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sumin.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    /* 설명. Service에 있는 메소드 하나가 쿼리문 */
    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession(); // HTTP 요청을 받을 때마다 만들어져야함. 전역변수에 선언 X

        List<MenuDTO> menuList = menuDAO.selectAllmenus(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        // 서비스 계층에서는 find -> select 로 함수명을 바꾸어서 작성하면 좋다.
        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리 (commit/rollback) */
        if (result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1?true:false;
    }
}
