package com.company;

import dbutil.DBUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
        Scanner in = new Scanner(System.in);

        System.out.println("Type option from 1 to 6:");
        int option = in.nextInt();

        switch (option) {
            case 1:
                System.out.println(dbUtils.getOrderById(4).toString());
                break;
            case 2:
                dbUtils.getOrdersByMaxPriceAndGoodTypesAmount(3100, 1).forEach(order -> {
                    System.out.println(order.getOrderCode());
                });
                break;
            case 3:
                dbUtils.getOrderCodesByGoodName("Vit'ba").forEach(System.out::println);
                break;
            case 4:
                dbUtils.getSentTodayOrderCodesNotContainingGood("Alenka").forEach(System.out::println);
                break;
            case 5:
                dbUtils.sendOrderConsistingOfTodayGoods();
                break;
            case 6:
                dbUtils.deleteOrdersWithGoodAndItsAmount("Alenka", 3);
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
        System.out.println("----------");

        dbUtils.closeConnection();
    }
}
