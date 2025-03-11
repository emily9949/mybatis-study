package com.sumin.section01.xml;

import java.util.List;

/* 설명.
*   SQL 실행 후 결과를 List<MenuDTO> 형태로 반환
*   SQL 문은 mapper.xml에서 정의됨.
*   mapper.xml과 연결되어 자동으로 SQL을 실행함.
* */
public interface MenuMapper {
    List<MenuDTO> selectMenuByPrice(int maxPrice);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);
    }

