/*
*   Author: Tyler Osborne
*   Date: 2021-11-18
*   Description:
*       This program class is used for testing and using the Vector2D Class
* */

package ca.durhamcollege;

import java.util.Scanner;

// Driver class
public class Main {

    public static void main(String[] args)
    {
        // Scanner for input
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // creates first point and prompts for data input
        Vector2D point1 = new Vector2D();
        System.out.println("Enter the first point (x, y): ");

        // Collects, splits and assigns data to the first point
        input = scanner.nextLine();
        var values = input.split(",");
        point1.set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

        // Outputs the result of the first point
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("You Entered " + point1.toString() + " for the first point" );
        System.out.println("--------------------------------------------------------------\n");

        // Creates and prompts for the second point
        Vector2D point2 =  new Vector2D();
        System.out.print("Enter the second point (x, y): ");

        // Collects, splits and assigns data to the second point
        input = scanner.nextLine();
        values = input.split(",");
        point2.set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

        // Outputs the result for the second point
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("You Entered " + point2.toString() + " for the second point");
        System.out.println("--------------------------------------------------------------");

        // Outputs final results magnitude and distance for the points
        System.out.println("==============================================================");
        System.out.printf("Magnitude of first point is: %.3f \n", point1.getMagnitude());
        System.out.printf("Magnitude of second point is: %.3f \n",point2.getMagnitude());
        System.out.printf("Distance between first and second point is: %.3f \n", Vector2D.distance(point1, point2));
        System.out.println("==============================================================");
    }
}
