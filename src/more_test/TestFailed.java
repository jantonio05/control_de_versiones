package more_test;

import Model.Game;
import Model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        User user = new User();
        ArrayList<User> friendList = new ArrayList<>();
        ArrayList<Game> gamesOwnedList = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Game> games = new ArrayList<>();
        program(scanner, op, user, friendList, gamesOwnedList, users, games);
    } // End main

    private static void program(Scanner scanner, int op, User user, ArrayList<User> friendList, ArrayList<Game> gamesOwnedList, ArrayList<User> users, ArrayList<Game> games) {
        do {
            op = showMainMenuAndReadOp(scanner, op);
            menuBasedOnUserOption(op, scanner, user, friendList, gamesOwnedList, users, games);
        } while (op !=3);
    } // End the program method

    private static int showMainMenuAndReadOp(Scanner scanner, int op) {
        System.out.println("~~~~~~~~~~ Main menu ~~~~~~~~~~");
        System.out.println("\t1. Access to user menu.");
        System.out.println("\t2. Access to game menu.");
        System.out.println("\t3. Exit the program.");
        return op = scanner.nextInt();
    } // End show main menu and read op method

    private static void menuBasedOnUserOption(int op, Scanner scanner, User user, ArrayList<User> friendList, ArrayList<Game> gamesOwnedList, ArrayList<User> users, ArrayList<Game> games) {
        switch (op) {
            case 1:
                do {
                    op = showUserMenuAndReadOp(scanner, op);
                    menuBasedOnUserMenu(op, scanner, user, friendList, gamesOwnedList, users);
                } while (op !=7);
                break; // End case 1 [Add a user]
            case 2:
                do {
                    op = showGameMenuAndReadOp(scanner, op);
                    menuBasedOnGameOption(scanner, op, games);
                } while (op != 4);
                break; // End case 2 [Add a game]
            case 3:
                System.out.println("Exit...");
                break; // End case 3 [Exit the program]
            default:
                System.out.println("Something went wrong");
        } // End switch with option user
    } // End menu based on user option method

    private static int showUserMenuAndReadOp(Scanner scanner, int op) {
        System.out.println("\n\n~~~~~~~~~~ User menu ~~~~~~~~~~");
        System.out.println("\t1. Create user.");
        System.out.println("\t2. Check balance.");
        System.out.println("\t3. Check fiends list.");
        System.out.println("\t4. Check game list.");
        System.out.println("\t5. Check all the user info.");
        System.out.println("\t6. When I created my acc?");
        System.out.println("\t7. Exit the user menu.");
        return  op = scanner.nextInt();
    } // End Show User Menu and read Option

    private static void menuBasedOnUserMenu(int op, Scanner scanner, User user, ArrayList<User> friendList, ArrayList<Game> gamesOwnedList, ArrayList<User> users) {
        User userFounded;
        switch (op){
            case 1:
                user = createUser(scanner, user, friendList, gamesOwnedList, users);
                break; // End case 1 [create user]
            case 2:
                userFounded = wichUser(scanner, user, users);
                balanceOfUser(user);
                break; // End case 2 [check balance]
            case 3:
                userFounded = wichUser(scanner, user, users);
                break; // End case 3 [Check fiend list]
            case 4:
                userFounded = wichUser(scanner, user, users);
                break; // End case 4 [Check game list]
            case 5:
                userFounded = wichUser(scanner, user, users);
                break; // End case 5 [Check all the user info]
            case 6:
                userFounded = wichUser(scanner, user, users);
                break; // End case 6 [When the acc was created]
            case 7:
                System.out.println("Quitting user menu...");
                break; // End case 7 [Exit the user menu]
            default:
                System.out.println("Something went wrong");
        }
    } // End menu based on user

    private static User createUser(Scanner scanner, User user, ArrayList<User> friendList, ArrayList<Game> gamesOwnedList, ArrayList<User> users) {
        String choose;
        user = new User(readString(scanner, "What's your username?"), readDouble(scanner, "What's your balance?"), friendList, gamesOwnedList, LocalDate.parse(readString(scanner, "When you created your account? || DATE FORMAT [yyyy-MM-dd]")));
        users.add(user);
        return user;
    } // End create user method

    private static User wichUser(Scanner scanner, User user, ArrayList<User> users) {
        String username = readString(scanner, "Type the username from the user what you want know the balance.");
        for (User userTest: users){
            if (userTest.getUsername().equalsIgnoreCase(username)){

            } else {
                System.out.println("The user was not found!");
                return null;
            }
        }
        return user;
    }

    private static void balanceOfUser(User user) {
        System.out.println("The balance in the " + user.getUsername() + " wallet is: [" + user.getBalance() + "].");
    }

    private static int showGameMenuAndReadOp(Scanner scanner, int op) {
        System.out.println("\n\n~~~~~~~~~~ Game menu ~~~~~~~~~~");
        System.out.println("\t1. Create a game.");
        System.out.println("\t2. Check balance.");
        System.out.println("\t3. Check fiends list.");
        System.out.println("\t4. Check game list.");
        System.out.println("\t5. Check all the user info.");
        System.out.println("\t6. When I created my acc?");
        System.out.println("\t7. Exit the user menu.");
        return op = scanner.nextInt();
    }

    private static void menuBasedOnGameOption(Scanner scanner, Integer op, ArrayList<Game> games) {

    } // End menu based on game option method

    private static Double readDouble(Scanner scanner, String message) {
        System.out.println(message); // Print the user message
        return scanner.nextDouble();
    } // End read Double method

    private static String readString(Scanner scanner, String message){
        System.out.println(message);
        return scanner.next();
    } // End read String method

} // End class {Test}

// if (users.contains(user)){
//            System.out.println("The user already exist!");
//            System.out.println("Are you sure you want add the user knowing that it's duplicated? [y/n]");
//            choose = scanner.nextLine();
//            if (choose.equalsIgnoreCase("y")){
//                users.add(user);
//                System.out.println("\nThe user was created successfully!");
//            } else if (choose.equalsIgnoreCase("n")) {
//                System.out.println("Okay, the user will not be added to the user list");
//            } else {
//                System.out.println("Something went wrong");
//            }// End choose if
//        } // End checking user existence