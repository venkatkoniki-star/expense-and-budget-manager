package main;

import model.User;
import service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();

        while (true) {

            System.out.println("\n===== Expense Manager =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:

                    // Register
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    // Create User object
                    User user = new User(name, email, password);

                    // Call service
                    userService.registerUser(user);

                    break;

                case 2:

                    // Login
                    System.out.print("Enter email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = sc.nextLine();

                    // Call login service
                    User loggedInUser =
                            userService.loginUser(loginEmail, loginPassword);

                    if (loggedInUser != null) {
                        System.out.println("Welcome "
                                + loggedInUser.getName());
                    }

                    break;

                case 3:

                    System.out.println("Exiting application...");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}