package com.company;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Formatter f = new Formatter();
        Calendar cal = Calendar.getInstance();
        f.format("%tr", cal);
        System.out.println(f);
        f = new Formatter();
        f.format("%tc", cal);
        System.out.println(f);
        f = new Formatter();
        f.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(f);



        String text = "asdjkasouidasoijd asdoij asdoaaaaaaaaaaaija sodij\naskdjn asdjkl\nasjldk asldkj aasd kjk\nasd";

        int menu;
        System.out.println("Введите 0 или 1 в зависимости от условия\n0-удалить введённый эелемент из текста\n1- добавить после элемента введённый элемент");
        menu = scanner.nextInt();
        switch (menu) {
            case 0:
                System.out.print("Введите символ который хотите удалить: ");
                scanner.nextLine();
                String symbol = scanner.nextLine();
                System.out.println(text.replaceAll(symbol,""));
                break;
            case 1:
                System.out.println("Введите позицию после которой хотите вставить символ и сам символ: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                symbol = scanner.nextLine();
                System.out.println(text.substring(0,index+1) + symbol + text.substring(index+1));

        }


    }
}
