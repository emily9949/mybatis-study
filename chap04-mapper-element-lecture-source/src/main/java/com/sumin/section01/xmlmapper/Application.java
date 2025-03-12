package com.sumin.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementService es = new ElementService();

        do {
            System.out.println("======= <resultMap> 테스트 메뉴 =======");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("1. <association> 테스트");
            System.out.println("1. <collection> 테스트");
            System.out.println("메뉴 번호를 입력하세요: ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    es.selectResultMapTest();
                    break;
                case 2:
                    es.selectResultMapAssociationTest();
                    break;
                case 3:
                    es.selectResultMapCollectionTest();
                    break;
            }
        } while(true);
    }
}
