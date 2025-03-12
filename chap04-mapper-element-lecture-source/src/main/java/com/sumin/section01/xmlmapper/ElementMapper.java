package com.sumin.section01.xmlmapper;

import java.util.List;

public interface ElementMapper {
    List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
