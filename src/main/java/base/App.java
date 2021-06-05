/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Dillon Flaschner
 */

package base;

import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String principalString = myApp.principalInput();
        String roiString = myApp.roiInput();
        String yearString = myApp.yearInput();
        String numCompoundString = myApp.numCompound();

        int principal = Integer.parseInt(principalString);
        float roi = Float.parseFloat(roiString);
        int year = Integer.parseInt(yearString);
        int numCompound = Integer.parseInt(numCompoundString);

        double investment = myApp.investCalc(principal, roi, year, numCompound);

        String output = myApp.buildOutput(principalString, yearString, roiString, numCompoundString, investment);

        myApp.printOutput(output);
    }

    public String principalInput() {
        System.out.print("Enter the principal: ");
        return input.nextLine();
    }

    public String roiInput() {
        System.out.print("Enter the rate of interest (as a percent value): ");
        return input.nextLine();
    }

    public String yearInput() {
        System.out.print("Enter the number of years: ");
        return input.nextLine();
    }

    public String numCompound() {
        System.out.print("What is the number of times the interest is compounded per year? ");
        return input.nextLine();
    }

    public double investCalc(int principal, float roi, int year, int numCompound) {
        roi /= 100;
        return principal * Math.pow(1 + roi/numCompound, numCompound * year);
    }

    public String buildOutput(String principalString, String yearString, String roiString, String numCompoundString, double investment) {
        String investmentString = String.format("$%.2f", investment);
        return "$" + principalString + " invested at " + roiString + "% for " + yearString +
                " years compounded " + numCompoundString + " times per year is " + investmentString + ".";
    }

    public void printOutput(String output) {
        System.out.println(output);
    }
}
