/*
6. House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица,
Тип здания, Срок эксплуатации.
Создать массив объектов. Вывести:
a) список квартир, имеющих заданное число комнат;
b) список квартир, имеющих заданное число комнат и расположенных
на этаже, который находится в заданном промежутке;
c) список квартир, имеющих площадь, превосходящую заданную.
*/
package com.company;

import java.util.Scanner;

public class Main {
    public static class Flat{
        int id;
        int numflat;
        double S;
        int flour;
        int numroom;
        String street;
        String type;
        int srok;

        public Flat(){
            id = 0;
            numflat = 0;
            S = 0;
            flour = 0;
            numroom = 0;
            street = "0";
            type = "0";
            srok = 0;
        }
        public Flat(int id, int numflat, double S, int flour, int numroom, String street, String type, int srok){
            this.id = id;
            this.numflat = numflat;
            this.S = S;
            this.flour = flour;
            this.numroom = numroom;
            this.street = street;
            this.type = type;
            this.srok = srok;
        }
        public void setid(int id){
            this.id = id;
        }
        public int getid (){
            return this.id;
        }
        public void setnumflat(int numflat){
            this.numflat = numflat;
        }
        public int getnumflat (){
            return this.numflat;
        }
        public void setS(double S){
            this.S = S;
        }
        public double getS (){
            return this.S;
        }
        public void  setflour(int flour){
            this.flour = flour;
        }
        public int getflour(){
            return this.flour;
        }
        public void setnumroom(int numroom){
            this.numroom = numroom;
        }
        public int getnumroom(){
            return this.numroom;
        }
        public void setstreet(String street){
            this.street = street;
        }
        public String gerstreet(){
            return this.street;
        }
        public void settype(String type){
            this.type = type;
        }
        public String gettype(){
            return this.type;
        }
        public void setsrok(int srok) {
            this.srok = srok;
        }
        public int getsrock(){
            return this.srok;
        }
        public void printFlat()
        {
            System.out.println("Id квартиры: " + this.id);
            System.out.println("Номер квартиры: " + this.numflat);
            System.out.println("Площадь: " + this.S);
            System.out.println("Этаж: " + this.flour);
            System.out.println("Количество комнат: " + this.numroom);
            System.out.println("Улица: " + this.street);
            System.out.println("Тип: " + this.type);
            System.out.println("Срок эксплутации: " + this.srok);

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Flat [] arr = new Flat[n];
        int temp;
        String tempS1, tempS2;
        for(int i = 0; i < n; i++){
            arr[i] = new Flat();
            System.out.print("Введите id для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setid(temp);
            System.out.print("Введите номер для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setnumflat(temp);
            System.out.print("Введите площадь для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setS(temp);
            System.out.print("Введите этаж для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setflour(temp);
            System.out.print("Введите количество комнат для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setnumroom(temp);
            tempS2 = scanner.nextLine();
            System.out.print("Введите улицу для "+(i+1)+ " квартиры: ");
            tempS2 = scanner.nextLine();
            arr[i].setstreet(tempS2);
            System.out.print("Введите тип здания для "+(i+1)+ " квартиры: ");
            tempS2 = scanner.nextLine();
            arr[i].settype(tempS2);
            System.out.print("Введите срок эксплуатации для "+(i+1)+ " квартиры: ");
            temp = scanner.nextInt();
            arr[i].setsrok(temp);
        }
        for (int i = 0; i < n;i++)
        {
            System.out.println();
            System.out.println("Квартира номер - "+ (i+1) +":");
            System.out.println();
            arr[i].printFlat();
        }
        System.out.print("Введите какое количество комнат должно быть в квартире: ");
        temp = scanner.nextInt();
        for (int i = 0; i < n; i++)
        {
            if(arr[i].numroom == temp)
            {
                System.out.println();
                arr[i].printFlat();
                System.out.println();
            }
        }
        System.out.println();
        System.out.print("Введите какое количество комнат должно быть в квартире, и промежуток этажей через пробел: ");
        int a,b;
        temp = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        for (int i = 0; i < n ; i ++)
        {
            if(arr[i].numroom == temp)
            {
                if(arr[i].flour>=a && arr[i].flour<=b)
                {
                    arr[i].printFlat();
                }
            }
        }
        System.out.print("Задайте площадь: ");
        double tempD;
        tempD = (int) scanner.nextDouble();
        for (int i = 0; i < n; i++)
        {
            if(arr[i].S >= tempD)
            {
                System.out.println();
                arr[i].printFlat();
                System.out.println();
            }
        }

    }
}
