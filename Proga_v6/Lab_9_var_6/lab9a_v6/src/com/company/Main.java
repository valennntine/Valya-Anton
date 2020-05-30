package com.company;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            while (true){
                String line = reader.readLine();
                if(line != null){
                    text = text + "\n" + line;
                }else{
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(text);
        System.out.println("Введите колчество слов которые вы хотите проверить на совпадения");
        int n = scanner.nextInt();
        String [] strings = new String[n];
        int [] counts = new int[n];
        for (int i = 0; i < n; i++){
            System.out.print("Введите " + (i+1) + " слово: ");
            scanner.nextLine();
            strings[i] = scanner.nextLine();
            counts[i] = 0;
        }
        List<String> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length() ; i++){

            if(text.charAt(i) != ' ' && text.charAt(i) != ',' && text.charAt(i) != '—' && text.charAt(i) != '«'
                    && text.charAt(i) != '»' && text.charAt(i) != ':' && text.charAt(i) != '\n' && text.charAt(i) != '.' && text.charAt(i) != '?' && text.charAt(i) != '…'){
                temp.append(text.charAt(i));
            }else {
                if(i!=0)
                    words.add(temp.toString());
                temp.delete(0,text.length());
            }

        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < words.size(); j++){
                if(words.get(j).equals(strings[i])){
                    counts[i]++;
                }
            }
        }
        int tempInt;
        String tempString;

        for(int i = 0; i < n-1; i ++){
            for(int j = 0; j < n-1 - i; j++){
                if(counts[j] > counts[j+1]){
                    tempInt = counts[j];
                    counts[j] = counts[j+1];
                    counts[j+1] = tempInt;
                    tempString = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tempString;
                }
            }
        }
        StringBuilder fileOut = new StringBuilder();
        for (int i = 0 ; i < n; i ++)
        {
            System.out.println(strings[i] + " "+counts[i]);
            fileOut.append(strings[i]).append(" ").append(counts[i]).append("\n");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("textOut.txt"))) {
            writer.write(fileOut.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }

    }
}
