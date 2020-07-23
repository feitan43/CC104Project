package cc104project;

import java.util.Scanner;

public class ReservationMenu {

   LinkedList rList = new LinkedList();
    Customer uInfo = new Customer(null, null);
    Scanner scan = new Scanner(System.in);
    ListIterator iterator = rList.listIterator();

    public void runMenu() {
        int choice;
        do {
            System.out.println("*-----Restaurant Reservation Application-----*");
            System.out.println("Please choose your options:");
            System.out.println("1) Reservations");
            System.out.println("2) Quit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    runReservations();
                    break;
                case 2:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                    

                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (choice != 3);

    }
    public void runReservations() {
        int choice;

        do {
            System.out.println("*-----RESERVATION MENU:-----*");
            System.out.println("1) Add New Customer");
            System.out.println("2) Change reservation");
            System.out.println("3) Remove reservation");
            System.out.println("4) View reservations");
            System.out.println("5) Back");         
            choice = scan.nextInt();

            switch (choice) {
                case 1: 
                    uInfo.displayInfo();
                    iterator.makeNewReservation(new Reservation(uInfo.name, uInfo.time));

                    break;

                case 2: 
                    changeReservation();

                    break;

                case 3: 
                    removeReservation();

                    break;

                case 4: 
                    displayReservation();
                    break;

                default:
                    break;
            }

        } while (choice != 5);
    }

    public void displayReservation() {
        System.out.println("Reservations total: " + rList.size());
        if (rList.isEmpty() == false) {
            for (int i = 0; i < rList.size(); i++) {
                System.out.println("Reservation #: " + (i + 1)
                        + "\nName: " + rList.get(i).rname
                        + "\nTime: " + rList.get(i).rtime
                        + "\n");
            }
        } else {
            System.out.println("List is empty!");
        }
    }

    public void removeReservation() {
        displayReservation();
        if (rList.isEmpty() == false) {
            System.out.println("Type index of reservation to be removed:");
            int removeIndex = scan.nextInt();  
            rList.removeIndex(removeIndex);    
            displayReservation();             
        }
    }

    public void changeReservation() {
        displayReservation();
        if (rList.isEmpty() == false) {
            System.out.println("Type index of reservation to be changed:");
            int changeIndex = scan.nextInt();  
            rList.removeIndex(changeIndex);
            uInfo.displayInfo();
            iterator.makeNewReservation(new Reservation(uInfo.name, uInfo.time));
        }
    }
}
