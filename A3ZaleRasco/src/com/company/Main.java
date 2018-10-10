package com.company;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DecimalFormat moneyF = new DecimalFormat("'$'0.00");
        DecimalFormat percentF = new DecimalFormat("#,##0%");
        DecimalFormat decF = new DecimalFormat("##.00");

        final double REJECT = 1.23;
        final String RC_COST = moneyF.format(21.99);
        final String ED_COST = moneyF.format(24.99);
        int rcCount = 100, edCount = 200, rejectED = 0, rejectRC = 0, dataCount;
        double avg = 0.00;

        System.out.print("Enter the number of data points: ");
        while(!reader.hasNextInt() || (dataCount = reader.nextInt()) < 0) {
            System.out.print("Please enter a non-negative whole number: ");
            reader.nextLine();
        }


        for(int i = 0; i < dataCount; i++){
            System.out.print("\nEnter the ski ID: ");
            String id = reader.next();
            double coef;

            while(true) {
                if (id.equals("RC" + rcCount)) {
                    rcCount++;
                    System.out.print("Enter the friction coefficient for ski " + id + ": ");
                    while (!reader.hasNextDouble() || (coef = reader.nextDouble()) < 1) {
                        System.out.print("Please enter a number greater than 1: ");
                        reader.nextLine();
                    }
                    avg += coef;
                    if(coef > 1.23) {
                        rejectRC++;
                        System.out.println("Component cost for ski " + id + ": " + RC_COST
                                                                        + " <--- REJECT");
                    }
                    else{System.out.println("Component cost for ski " + id + ": " + RC_COST);}
                    break;
                } else if (id.equals("ED" + edCount)) {
                    edCount++;
                    System.out.print("Enter the friction coefficient for ski " + id + ": ");
                    while (!reader.hasNextDouble() || (coef = reader.nextDouble()) < 1) {
                        System.out.print("Please enter a number greater than 1: ");
                        reader.nextLine();
                    }
                    avg += coef;
                    if(coef > 1.23) {
                        rejectED++;
                        System.out.println("Component cost for ski " + id + ": " + RC_COST
                                                                          + " <--- REJECT");
                    }
                    else {System.out.println("Component cost for ski " + id + ": " + ED_COST);}
                    break;
                } else {
                    System.out.print("Please enter a valid ski ID: ");
                    reader.nextLine();
                    id = reader.next();
                }
            }
        }
        double rejectCost = rejectED * 24.99 + rejectRC * 21.99;

        System.out.println("\nNumber of Data Points: " + dataCount);
        System.out.println("Average Friction Coefficient: " + decF.format(avg/dataCount));
        System.out.println("Number of rejected skis: " + (rejectED+rejectRC));
        System.out.println("Percentage of rejected skis: " +
                           percentF.format(((double)rejectED+(double)rejectRC)/dataCount));
        System.out.println("Cost of rejected skis: " + moneyF.format(rejectCost));
    }
}
