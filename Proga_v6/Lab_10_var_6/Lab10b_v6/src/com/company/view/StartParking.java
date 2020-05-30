package com.company.view;

import com.company.exceptions.OutOfListException;
import com.company.models.Car;
import com.company.models.Parking;
import com.company.testView.Test;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class StartParking {
        private Parking parking;
        private Test test;

        public void start() {
            Scanner scanner = new Scanner(System.in);
            int n;
            System.out.print("Введите количество мест на парковке: ");
            n = scanner.nextInt();
            parking = new Parking(n);
            test = new Test();

            String menu;
            while (true) {
                System.out.println("Parking: ");
                System.out.println("1. Увидеть все места");
                System.out.println("2. Вывезти мащину с парковки");
                System.out.println("3. Запарковать машину");
                System.out.println("4. Закрыть парковку");
                System.out.println("5. Запарковать машину на конкретное место");
                System.out.println("0. Exit");
                scanner.nextLine();
                menu = scanner.nextLine();
                if (test.test(menu)) {
                    if (Integer.parseInt(menu) == 0) {
                        break;
                    }

                    switch (Integer.parseInt(menu)) {
                        case (1):
                            System.out.println(parking.toString());
                            break;
                        case (2):
                            try {
                                System.out.print("Введите индекс машины которую хотите вывезти: ");
                                int index = scanner.nextInt();
                                if (!(parking.getCar(index) == null)) {
                                    parking.deleteCar(index);
                                } else {
                                    System.out.println("На данном парковочном месте нет машины");
                                }
                            } catch (OutOfListException e) {
                                System.out.println("Данного места не существует ");
                            }
                            break;
                        case (3):
                            System.out.println("Введите данные машины: ");
                            System.out.print("Введите модель машины: ");
                            String model = scanner.nextLine();
                            System.out.print("Введите номера: ");
                            String number = scanner.nextLine();
                            System.out.print("Укажите цвет машины: ");
                            String colour = scanner.nextLine();
                            parking.setPlace(new Car(model, number, colour));
                            break;
                        case (4):
                            parking.deleteAll();
                            break;
                        case (5):
                            try {
                                System.out.println("Введите место на которое хотите запарковать машину");
                                String k = scanner.nextLine();
                                if (test.test(k) && parking.getCar(Integer.parseInt(k)) == null) {
                                    System.out.println("Введите данные машины: ");
                                    System.out.print("Введите модель машины: ");
                                    model = scanner.nextLine();
                                    System.out.print("Введите номера: ");
                                    number = scanner.nextLine();
                                    System.out.print("Укажите цвет машины: ");
                                    colour = scanner.nextLine();
                                    parking.setPlace(Integer.parseInt(k), new Car(model, number, colour));
                                } else {
                                    System.out.println("Введены не корректные данные или парковочное место занято");
                                }
                            } catch (OutOfListException e) {
                                System.out.println("Данного места не существует ");
                            }
                            break;

                    }
                }
            }
        }
}

