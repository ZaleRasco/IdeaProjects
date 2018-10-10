package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File input = new File(System.getProperty("user.dir") + "\\weather.txt");
        File output = new File(System.getProperty("user.dir") + "\\weatherout.txt");
        
        try (Scanner reader = new Scanner(input)){
            System.out.print(reader.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.print("Error: Input file not found");
            System.out.print(e);
        }

    }
}
