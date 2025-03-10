package com.sumin.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllmenus(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllmenus"); // XMl 파일에서 selectAllMenus 쿼리 불러오기
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }
}
