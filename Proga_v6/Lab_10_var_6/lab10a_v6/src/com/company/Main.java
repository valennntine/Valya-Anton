package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        String temp;
        List<String> text = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            while (true){
                String line = reader.readLine();
                if(line != null){
                   text.add(line);
                   n++;
                }else{
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < n-1; i ++){
            for(int j = 0; j < n-1 - i; j++){
                if(text.get(j).length() > text.get(j+1).length()){
                    temp = text.get(j);
                    text.set(j, text.get(j+1));
                    text.set(j+1,temp);

                }
            }
        }
        for(int i = 0; i < n; i ++) {
            System.out.println(text.get(i));
        }

    }
}
