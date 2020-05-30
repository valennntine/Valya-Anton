//Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них

package com.company;

import java.util.Scanner;
/**
 * @author Valya
 * @version 1.2
 * Lab 3
 * */

public class Main {

    public static void main(String[] args) {
	Scanner f = new Scanner (System.in);
	int [] arr;
	int N;
	System.out.println("Введите число элементов в массиве:");
	N = f.nextInt();
	arr = new int[N];
	for (int i =0; i < N; i++)
    {
        arr[i] = f.nextInt();
    }
	int number;
	int temp1, temp2;
	int [] arr1 = new int [N];
	int a = 0;
	int b = 0;
	for (int i = 0; i < N; i++) {
        number = arr[i];
        a = 0;
        b = 0;
        while (arr[i] > 0) {
            temp1 = arr[i] % 10;
            arr[i] /= 10;
            temp2 = arr[i] % 10;
            if (temp2 < temp1) {
                a++;
            }
            b++;
        }
        if (a == b){
            System.out.println(number);
            break;
        }
    }

    }
}



