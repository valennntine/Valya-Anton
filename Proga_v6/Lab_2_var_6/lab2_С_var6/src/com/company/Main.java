//Вычислить норму матрицы.
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner f = new Scanner(System.in);
	int N = f.nextInt();
	int [][] arr = new int [N][N];
	for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++)
            arr[i][j] = f.nextInt();
    }
	int [] arr1 = new int [N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++)
                arr1[i] += arr[i][j];
        }
        int temp = arr1[0];
        for (int i = 0; i < N; i++){
            if (temp < arr1[i]){
                temp = arr1[i];
            }

        }
	System.out.println(temp);

    }
}
