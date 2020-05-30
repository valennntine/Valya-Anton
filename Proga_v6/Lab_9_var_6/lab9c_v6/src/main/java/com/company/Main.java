package com.company;

import main.resources.FileCreator;
import main.resources.FileInput;
import main.resources.FileOutput;
import main.resources.InstanceCheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String directory = "output";
        String filename = "result.txt";
        String path = directory + "/" + filename;
        FileCreator fileCreator = new FileCreator(directory, filename);
        fileCreator.createDirectory();
        fileCreator.createFileInDirectory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input type:");
        String type = scanner.nextLine();

        InstanceCheck instanceCheck = new InstanceCheck();
        FileInput fileInput = new FileInput("input.txt");
        FileOutput fileOutput = new FileOutput(path);
        ArrayList<String> filteredStrings = fileInput.getFileContent().stream()
                .filter(s -> instanceCheck.getType(s).equals(type))
                .collect(Collectors.toCollection(ArrayList::new));

        for (String str: filteredStrings) {
            fileOutput.writeLine(str);
        }
        fileOutput.closeStream();
    }
}
