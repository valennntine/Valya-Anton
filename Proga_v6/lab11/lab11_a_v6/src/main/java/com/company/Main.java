package com.company;

import util.CashboxQueue;
import util.FastFoodRestaurant;
import util.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CashboxQueue> cashboxQueues = new ArrayList<>();

        ArrayList<Person> peopleList1 = new ArrayList<>();
        peopleList1.add(new Person("", 0));
        peopleList1.add(new Person("", 2));
        peopleList1.add(new Person("", 4));
        peopleList1.add(new Person("", 5));
        peopleList1.add(new Person("", 6));
        peopleList1.add(new Person("", 10));
        peopleList1.add(new Person("", 11));
        peopleList1.add(new Person("", 15));
        cashboxQueues.add(new CashboxQueue(peopleList1, 0));

        ArrayList<Person> peopleList2 = new ArrayList<>();
        peopleList2.add(new Person("", 3));
        peopleList2.add(new Person("", 7));
        peopleList2.add(new Person("", 8));
        peopleList2.add(new Person("", 12));
        peopleList2.add(new Person("", 13));
        cashboxQueues.add(new CashboxQueue(peopleList2, 1));

        ArrayList<Person> peopleList3 = new ArrayList<>();
        peopleList3.add(new Person("", 1));
        peopleList3.add(new Person("", 9));
        peopleList3.add(new Person("", 14));
        cashboxQueues.add(new CashboxQueue(peopleList3, 2));

        FastFoodRestaurant fastFoodRestaurant = new FastFoodRestaurant(cashboxQueues);

        System.out.println("initial queue:\n" + fastFoodRestaurant.toString());

        int nextPersonId = fastFoodRestaurant.getNextPersonId();

        for (int i = 0; i < 5; i ++) {
            fastFoodRestaurant.removeCustomer();
            System.out.println("customer is removed from queue;\n" + fastFoodRestaurant.toString());

            ArrayList<Person> lastPeopleInQueues = fastFoodRestaurant.getAllLastPeople();
            fastFoodRestaurant.updateQueues(lastPeopleInQueues);
            while (!fastFoodRestaurant.peopleThreadsAreFinished(lastPeopleInQueues)) { }
            System.out.println("Newly formed queues:\n" + fastFoodRestaurant.toString());

            Person newPerson = new Person("", nextPersonId);
            fastFoodRestaurant.addCustomer(newPerson);

            System.out.println("new customer is added to the queue;\n" + fastFoodRestaurant.toString());

            nextPersonId++;
        }
    }
}
