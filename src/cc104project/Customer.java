/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc104project;

import java.util.Scanner;

public class Customer {

    String name;
    String time;

    public Customer(String name, String time) {
        this.name = name;
        this.time = time;

    }

    public boolean checkTime(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));

        return !(time.charAt(2) != ':' || time.length() != 5
                || hours > 24 || minutes > 59);
    }

    public void displayInfo() {

        String tempTime;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customer Name:");
        setName(scanner.nextLine());

        System.out.println("Reservation"
                + " time [hh:mm format ]  Example: 12:51 ]:");
        tempTime = scanner.nextLine();
        while (checkTime(tempTime) == false) 
        {
            System.out.println("Invalid time.");
            System.out.println("Please type the reservation time [hh:mm continous])");
            tempTime = scanner.nextLine();
        }
        setTime(tempTime); 
    }

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
}
