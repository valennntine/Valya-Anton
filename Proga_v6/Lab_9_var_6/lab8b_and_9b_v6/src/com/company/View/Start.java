package com.company.View;

import com.company.Checks.TestGemView;
import com.company.Service.GemService;
import com.company.models.Gem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    GemService gemService;
    Scanner scanner;
    TestGemView testGemView;

    public Start() {
        gemService = new GemService();
        scanner = new Scanner(System.in);
        testGemView = new TestGemView();
    }

    public ArrayList<Gem> start() {
        int k;
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
              return gemService.readAll();
            }
            switch (k) {
                case 1:
                    System.out.println("Info:");
                    System.out.print("Enter id: ");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    System.out.print("Enter weight: ");
                    String weight = scanner.nextLine();
                    System.out.print("Enter price: ");
                    String price = scanner.nextLine();
                    System.out.print("Enter visibility: ");
                    String visibility = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    if(testGemView.test(id,weight,price,visibility)) {
                        gemService.createGem(new Gem(Long.parseLong(id), Double.parseDouble(weight), Double.parseDouble(price), Double.parseDouble(visibility), name));
                    }
                    break;
                case 2:
                    System.out.println("Enter id : ");
                    scanner.nextLine();
                    id = scanner.nextLine();
                    if(testGemView.test(id))
                        System.out.println(gemService.readGem(Long.parseLong(id)));
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    scanner.nextLine();
                    id = scanner.nextLine();
                    if(testGemView.test(id))
                        gemService.deleteGem(Long.parseLong(id));
                    break;
                case 4:
                    System.out.println("Enter id for update : ");
                    scanner.nextLine();
                    String idOld = scanner.nextLine();
                    if(testGemView.test(idOld)){
                        System.out.println(gemService.readGem(Long.parseLong(idOld)));
                        if (gemService.readGem(Long.parseLong(idOld)) != null) {
                            System.out.println("Info:");
                            System.out.print("Enter id: ");
                             id = scanner.nextLine();
                            System.out.print("Enter weight: ");
                             weight = scanner.nextLine();
                            System.out.print("Enter price: ");
                             price = scanner.nextLine();
                            System.out.print("Enter visibility: ");
                             visibility = scanner.nextLine();
                            System.out.print("Enter Name: ");
                             name = scanner.nextLine();
                            gemService.updateGem(new Gem(Long.parseLong(id), Double.parseDouble(weight), Double.parseDouble(price), Double.parseDouble(visibility), name), Long.parseLong(idOld));
                        }
                    }
                    break;
                case 5:
                    System.out.println(gemService.readAll());
                    break;
                case 6:
                    gemService.deleteAll();
                    break;


            }
        }
    }
}
