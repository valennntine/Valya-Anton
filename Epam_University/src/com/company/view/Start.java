package com.company.view;

import com.company.model.*;
import com.company.service.*;

import javax.jws.soap.SOAPBinding;
import javax.naming.spi.ResolveResult;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    AdminService adminService;
    UserService userService;
    RestaurantService restaurantService;
    CafeService cafeService;
    BookService bookService;

    public Start() {
        adminService = new AdminService();
        userService = new UserService();
        restaurantService = new RestaurantService();
        cafeService = new CafeService();
        bookService = new BookService();

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (true) {
            System.out.println("Choose object: ");
            System.out.println("1. Cafe");
            System.out.println("2. Restaurant");
            System.out.println("3. Admin");
            System.out.println("4. User");
            System.out.println("0. Exit");
            k = scanner.nextInt();
            if (k == 0) {
                break;
            }
            switch (k) {
                case 1:
                    while (true) {
                        System.out.println("Choose, what you want to do: ");
                        System.out.println("1. Create ");
                        System.out.println("2. Read ");
                        System.out.println("3. Delete ");
                        System.out.println("4. Update ");
                        System.out.println("5. Read all ");
                        System.out.println("6. Delete все ");
                        System.out.println("0. Exit ");
                        k = scanner.nextInt();
                        if (k == 0) {
                            break;
                        }
                        switch (k) {
                            case 1:
                                System.out.println("Info:");
                                System.out.print("Enter id of Cafe: ");
                                long id = scanner.nextLong();
                                System.out.print("Enter the name of Cafe: ");
                                String name = scanner.nextLine();
                                name = scanner.nextLine();
                                System.out.print("Enter Address: ");
                                String address = scanner.nextLine();
                                System.out.print("Enter the number: ");
                                String number = scanner.nextLine();
                                System.out.print("Enter average bill: ");
                                double avgbill = scanner.nextDouble();
                                cafeService.createCafe(new Cafe(id, name, address, number, avgbill));
                                break;
                            case 2:
                                System.out.println("Enter id of Cafe: ");
                                id = scanner.nextLong();
                                System.out.println(cafeService.readCafe(id));
                                break;
                            case 3:
                                System.out.println("Enter id of Cafe : ");
                                id = scanner.nextLong();
                                cafeService.deleteCafe(id);
                                break;
                            case 4:
                                System.out.println("Enter id of Cafe : ");
                                long idOld = scanner.nextLong();
                                System.out.println(cafeService.readCafe(idOld));
                                if (cafeService.readCafe(idOld) != null) {
                                    System.out.println("Enter the date for update");
                                    System.out.print("Enter id: ");
                                    long idNew = scanner.nextLong();
                                    System.out.print("Enter name: ");
                                    name = scanner.nextLine();
                                    name = scanner.nextLine();
                                    System.out.print("Enter address: ");
                                    address = scanner.nextLine();
                                    System.out.print("Enter the number: ");
                                    number = scanner.nextLine();
                                    System.out.print("Enter average bill: ");
                                    avgbill = scanner.nextDouble();
                                    cafeService.updateCafe(new Cafe(idNew, name, address, number, avgbill), idOld);
                                }
                                break;
                            case 5:
                                System.out.println(cafeService.readAll());
                                break;
                            case 6:
                                cafeService.deleteAll();
                                break;

                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Choose, what you want to do: ");
                        System.out.println("1. Create ");
                        System.out.println("2. Read ");
                        System.out.println("3. Delete ");
                        System.out.println("4. Update ");
                        System.out.println("5. Read all ");
                        System.out.println("6. Delete все ");
                        System.out.println("7. Create book");
                        System.out.println("8. Delete book");
                        System.out.println("9. Update book");
                        System.out.println("10. Check book");
                        System.out.println("0. Exit ");
                        k = scanner.nextInt();
                        if (k == 0) {
                            break;
                        }
                        switch (k) {
                            case 1:
                                System.out.println("Info: ");
                                System.out.print("Enter id: ");
                                long id = scanner.nextLong();
                                System.out.print("Enter name: ");
                                String name = scanner.nextLine();
                                name = scanner.nextLine();
                                System.out.print("Enter address: ");
                                String address = scanner.nextLine();
                                System.out.print("Enter the number: ");
                                String number = scanner.nextLine();
                                System.out.print("Enter average bill: ");
                                double avgbill = scanner.nextDouble();
                                restaurantService.createRestaurant(new Restaurant(id, name, address, number, avgbill));
                                break;
                            case 2:
                                System.out.println("Enter id of Restaurant: ");
                                id = scanner.nextLong();
                                System.out.println(restaurantService.readRestaurant(id));
                                break;
                            case 3:
                                System.out.println("Enter id of Restaurant: ");
                                id = scanner.nextLong();
                                restaurantService.deleteRestaurant(id);
                                break;
                            case 4:
                                System.out.println("Enter id of Restaurant: ");
                                long idOld = scanner.nextLong();
                                System.out.println(restaurantService.readRestaurant(idOld));
                                if (restaurantService.readRestaurant(idOld) != null) {
                                    System.out.println("Enter the data for update");
                                    System.out.print("Enter id of Restaurant: ");
                                    long idNew = scanner.nextLong();
                                    System.out.print("Enter Name: ");
                                    name = scanner.nextLine();
                                    name = scanner.nextLine();
                                    System.out.print("Enter Address: ");
                                    address = scanner.nextLine();
                                    System.out.print("Enter Number: ");
                                    number = scanner.nextLine();
                                    System.out.print("Enter average bill: ");
                                    avgbill = scanner.nextDouble();
                                    restaurantService.updateRestaurant(new Restaurant(idNew, name, address, number, avgbill), idOld);
                                }
                                break;
                            case 5:
                                System.out.println(restaurantService.readAll());
                                break;
                            case 6:
                                restaurantService.deleteAll();
                                break;
                            case 7:
                                System.out.print("Enter id of Restaurant for booking: ");
                                long idOfRestaurant = scanner.nextLong();
                                if (restaurantService.readRestaurant(idOfRestaurant) != null) {
                                    System.out.println("Restaurant:");
                                    System.out.println(restaurantService.readRestaurant(idOfRestaurant));
                                    System.out.print("Enter id of Book: ");
                                    long idOfBook = scanner.nextLong();
                                    System.out.print("Enter date and time: ");
                                    String dateAndTime = scanner.nextLine();
                                    dateAndTime = scanner.nextLine();
                                    System.out.print("Enter number if people: ");
                                    int numberOfPeople = scanner.nextInt();
                                    System.out.print("Enter code word: ");
                                    String codeWord = scanner.nextLine();
                                    bookService.createBook(new Book(restaurantService.readRestaurant(idOfRestaurant), idOfBook, dateAndTime, numberOfPeople, codeWord));
                                }
                                break;
                            case 8:
                                System.out.print("Enter id of book: ");
                                long idOfBook = scanner.nextLong();
                                bookService.deleteBook(idOfBook);
                                break;
                            case 9:
                                System.out.print("Enter old id of book: ");
                                long idOfOldBook = scanner.nextLong();
                                if (bookService.readBook(idOfOldBook) != null) {
                                    System.out.println(bookService.readBook(idOfOldBook));
                                    System.out.print("Enter id of Book: ");
                                    idOfBook = scanner.nextLong();
                                    System.out.print("Enter date and time: ");
                                    String dateAndTime = scanner.nextLine();
                                    dateAndTime = scanner.nextLine();
                                    System.out.print("Enter number if people: ");
                                    int numberOfPeople = scanner.nextInt();
                                    System.out.print("Enter code word: ");
                                    String codeWord = scanner.nextLine();
                                    bookService.updateBook(new Book(restaurantService.readRestaurant(bookService.readBook(idOfOldBook).getId()),idOfOldBook,dateAndTime,numberOfPeople,codeWord),idOfBook);

                                }
                                break;
                            case 10:
                                System.out.print("Enter id of book: ");
                                idOfBook = scanner.nextLong();
                                System.out.println(bookService.readBook(idOfBook));
                                break;

                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("Выберете действие: ");
                        System.out.println("1. Create ");
                        System.out.println("2. Read ");
                        System.out.println("3. Delete ");
                        System.out.println("4. Update ");
                        System.out.println("5. Read all ");
                        System.out.println("6. Delete all ");
                        System.out.println("0. Exit ");
                        k = scanner.nextInt();
                        if (k == 0) {
                            break;
                        }
                        switch (k) {
                            case 1:
                                System.out.println("Введите данные для добавления Администратора в базу");
                                System.out.print("Введите id Администратора: ");
                                long id = scanner.nextLong();
                                System.out.print("Введите email администратора: ");
                                String email = scanner.nextLine();
                                email = scanner.nextLine();
                                System.out.print("Введите пароль администратора: ");
                                String password = scanner.nextLine();
                                adminService.createAdmin(new Admin(id, email, password));
                                break;
                            case 2:
                                System.out.println("Введите id администратора, которое хотите Read : ");
                                id = scanner.nextLong();
                                System.out.println(adminService.readAdmin(id));
                                break;
                            case 3:
                                System.out.println("Введите id администратора, которое хотите Delete : ");
                                id = scanner.nextLong();
                                adminService.deleteAdmin(id);
                                break;
                            case 4:
                                System.out.println("Введите id администратора, которое хотите Update : ");
                                long idOld = scanner.nextLong();
                                System.out.println(adminService.readAdmin(idOld));
                                if (adminService.readAdmin(idOld) != null) {
                                    System.out.println("Введите данные для обновления администратора");
                                    System.out.print("Введите id администратора: ");
                                    long idNew = scanner.nextLong();
                                    System.out.print("Введите email администратора: ");
                                    email = scanner.nextLine();
                                    email = scanner.nextLine();
                                    System.out.print("Введите пароль администратора: ");
                                    password = scanner.nextLine();
                                    adminService.updateAdmin(new Admin(idNew, email, password), idOld);
                                }
                                break;
                            case 5:
                                System.out.println(adminService.readAll());
                                break;
                            case 6:
                                adminService.deleteAll();
                                break;

                        }
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("Выберете действие: ");
                        System.out.println("1. Create ");
                        System.out.println("2. Read ");
                        System.out.println("3. Delete ");
                        System.out.println("4. Update ");
                        System.out.println("5. Read all ");
                        System.out.println("6. Delete все ");
                        System.out.println("0. Exit ");
                        k = scanner.nextInt();
                        if (k == 0) {
                            break;
                        }
                        switch (k) {
                            case 1:
                                System.out.println("Введите данные для добавления Пользователя в базу");
                                System.out.print("Введите id пользователя: ");
                                long id = scanner.nextLong();
                                System.out.print("Введите email пользователя: ");
                                String email = scanner.nextLine();
                                email = scanner.nextLine();
                                System.out.print("Введите пароль пользователя: ");
                                String password = scanner.nextLine();
                                System.out.print("Введите имя пользователя: ");
                                String username = scanner.nextLine();
                                System.out.print("Введите номер телефона пользователя: ");
                                String phonenumber = scanner.nextLine();
                                userService.createUser(new User(id, email, password, username, phonenumber));
                                break;
                            case 2:
                                System.out.println("Введите id пользователя, которое хотите Read : ");
                                id = scanner.nextLong();
                                System.out.println(userService.readUser(id));
                                break;
                            case 3:
                                System.out.println("Введите id пользователя, которое хотите Delete : ");
                                id = scanner.nextLong();
                                userService.deleteUser(id);
                                break;
                            case 4:
                                System.out.println("Введите id пользователя, которое хотите Update : ");
                                long idOld = scanner.nextLong();
                                System.out.println(userService.readUser(idOld));
                                if (userService.readUser(idOld) != null) {
                                    System.out.println("Введите данные для обновления пользователя");
                                    System.out.print("Введите id пользователя: ");
                                    long idNew = scanner.nextLong();
                                    System.out.print("Введите email пользователя: ");
                                    email = scanner.nextLine();
                                    email = scanner.nextLine();
                                    System.out.print("Введите пароль пользователя: ");
                                    password = scanner.nextLine();
                                    System.out.print("Введите имя пользователя: ");
                                    username = scanner.nextLine();
                                    System.out.print("Введите номер телефона пользователя: ");
                                    phonenumber = scanner.nextLine();
                                    userService.updateUser(new User(idNew, email, password, username, phonenumber), idOld);
                                }
                                break;
                            case 5:
                                System.out.println(userService.readAll());
                                break;
                            case 6:
                                userService.deleteAll();
                                break;

                        }
                    }
                    break;

            }
        }
    }
}
