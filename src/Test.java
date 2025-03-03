import Model.Game;
import Model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static Scanner scanner = new Scanner(System.in);
    static User user = new User();
    static Game game = new Game();

    public static void main(String[] args) {
        program();
        scanner.close();
    }

    private static void program() {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Game> games = new ArrayList<>();
        int op;
            do {
                op = showMainMenuAndReadOp();
                menuBasedOnUserOption(op, users, games);
            } while (op != 3);
    } // End program method

    private static int showMainMenuAndReadOp() {
        int op;
        System.out.println("~~~~~~~~~~ Main menu ~~~~~~~~~~");
        System.out.println("\t1. Access to user menu.");
        System.out.println("\t2. Access to game menu.");
        System.out.println("\t3. Exit the program.");
        op = scanner.nextInt();
        scanner.nextLine();
        return op;
    } // End show main menu and read op method

    private static void menuBasedOnUserOption(int op, ArrayList<User> users, ArrayList<Game> games) {
        switch (op) {
            case 1:
                addUserOption(users, games);
                break; // End case 1 [Add a user]
            case 2:
                addGameOption(users, games);
                break; // End case 2 [Add a game]
            case 3:
                System.out.println("Exiting from the main menu...");
                break; // End case 3 [Exit the program]
            default:
                System.out.println("Something went wrong.");
        } // End switch with option user
    } // End menu based on user option method

    private static void addUserOption(ArrayList<User> users, ArrayList<Game> games) {
        User userFounded;
        Game gameFounded;
        User userFriendListModified;
        ArrayList<User> friendList = new ArrayList<>();
        ArrayList<Game> gamesOwnedList = new ArrayList<>();
        int op;
        do {
            op = showUserMenuAndReadOp(scanner);
            switch (op) {
                case 1:
                    users = addUser(users, friendList, gamesOwnedList);
                    break; // End case 1 [create user]
                case 2:
                    do {
                        op = showExtendedMenuUserAndReadOp();
                        switch (op) {
                            case 1:
                                userFounded = whichUser(users, "Type the username from the user which you want to add balance to his wallet.");
                                assert userFounded != null;
                                addBalanceOfUser(userFounded);
                                break; // End case 1 [Add balance]
                            case 2:
                                userFounded = whichUser(users, "Type the username from the user which you want to know the balance.");
                                assert userFounded != null;
                                balanceOfUser(userFounded);
                                break; // End case 1 [check balance]
                            case 3:
                                userFriendListModified = whichUser(users, "Type the username from the user which you want modify the friend list.");
                                assert userFriendListModified != null;
                                userFounded = whichUser(users, "Type the username from the user which you want add to the friend list.");
                                assert userFounded != null;
                                addFriendFromTheList(userFriendListModified, userFounded);
                                break; // End case 2 [Add friend to list]
                            case 4:
                                userFriendListModified = whichUser(users, "Type the username from the user which you want modify the friend list.");
                                assert userFriendListModified != null;
                                userFounded = whichUser(users, "Type the username from the user which you want remove to the friend list.");
                                assert userFounded != null;
                                removeFriendFromTheList(userFriendListModified, userFounded);
                                break; // End case 3 [Remove friend from the list]
                            case 5:
                                userFounded = whichUser(users, "Type the username from the user which you want to know the list of friends.");
                                assert userFounded != null;
                                friendListOf(userFounded);
                                break; // End case 5 [Check fiend list]
                            case 6:
                                userFounded = whichUser(users, "Type the username from the user which you want to know the list of his games  owned.");
                                assert userFounded != null;
                                listGamesOwned(userFounded);
                                break; // End case 6 [Check gameOwnedList list]
                            case 7:
                                userFounded = whichUser(users, "Type the username from the user which you want to know more information.");
                                assert userFounded != null;
                                extendedUserInfo(userFounded);
                                break; // End case 7 [Check all the user info]
                            case 8:
                                userFounded = whichUser(users, "Type the username from the user which you want to know when he created his account.");
                                assert userFounded != null;
                                dateOfAccCreation(userFounded);
                                break; // End case 8 [When the acc was created]
                            case 9:
                                userFounded = whichUser(users, "Type the username from the user which you want to purchase a game.");
                                assert userFounded != null;
                                gameFounded = whichGame(games, "Type the game from the game which you want purchase.");
                                purchaseAGame(userFounded, gameFounded);
                                break; // End case 10 [Exit extended user menu]
                            case 10:
                                System.out.println("Exiting extended user menu...\n\n");
                                break; // End case 10 [Exit extended user menu]
                            default:
                                System.out.println("Something went wrong.\n\n");
                                break;
                        }
                    } while (op != 10);
                    break; // End case 2 [Extended user menu]
                case 3:
                    System.out.println("Exiting from user menu...\n\n");
                    break; // End case 3 [Exiting user menu]
                default:
                    System.out.println("Something went wrong.\n\n");
            }
        } while (op != 3);
    } // End add user option

    /**
     * Displays the user menu and reads the user's option.
     *
     * @return The selected option.
     */
    private static int showUserMenuAndReadOp(Scanner scanner) {
        int op;
        System.out.println("\n\n~~~~~~~~~~ Model.User menu ~~~~~~~~~~");
        System.out.println("\t1. Create user.");
        System.out.println("\t2. Extended user menu.");
        System.out.println("\t3. Exit from the user menu.");
       op = scanner.nextInt();
        scanner.nextLine();
        return op;
    } // End Show Model.User Menu and read Option

    /**
     * Creates and adds a new user to the list.
     *
     * @param users         The list of users.
     * @param friendList    The list of friends for the new user.
     * @param gamesOwnedList The list of owned games for the new user.
     * @return The updated user list.
     */
    private static ArrayList<User> addUser(ArrayList<User> users, ArrayList<User> friendList, ArrayList<Game> gamesOwnedList) {
        User newUser = createUser(friendList, gamesOwnedList);
        boolean duplicated = false;
        if (users.size() > 1){
            for(User userChecker : users){
                for (int i = 0; i < users.size(); i++) {
                    if (userChecker.getUsername().equals(newUser.getUsername())){
                        System.out.println("The user already exists!\nTry again with other username.");
                        duplicated = true;
                        break;
                    }
                }
                if (duplicated) {
                    break;
                }
            }
        }
        if (!duplicated || users.size() == 0){
            users.add(newUser);
            System.out.println("The user was successfully added!");
        }
        return users;
    } // End add user method

    /**
     * Creates a new user instance based on user input.
     *
     * @param friendList    The initial list of friends.
     * @param gamesOwnedList The initial list of owned games.
     * @return The created user object.
     */
    private static User createUser(ArrayList<User> friendList, ArrayList<Game> gamesOwnedList) {
        User userCreated = new User();
        userCreated.setUsername(readString("What is your username?"));
        userCreated.setBalance(readDouble("What is your balance?"));
        userCreated.setFriendsList(friendList);
        userCreated.setGamesList(gamesOwnedList);
        userCreated.setCreationAcc(LocalDate.parse(readString("When you created your account? || DATE FORMAT [yyyy-MM-dd]")));
        return userCreated;
    } // End create user method

    private static User whichUser(ArrayList<User> users, String message) {
        String username = readString(message);
        user = null;
        for (User userTest : users) {
            if (userTest.getUsername().equalsIgnoreCase(username)) {
                user = userTest;
                System.out.println("The user was found!\n");
                break;
            }
        }
        if (user == null){
            System.out.println("The user was not found.\n");
        }
        return user;
    } // End which user method

    private static int showExtendedMenuUserAndReadOp() {
        int op;
        System.out.println("\n\n~~~~~~~~~~ Extended user menu ~~~~~~~~~~");
        System.out.println("\t1. Add balance.");
        System.out.println("\t2. Check balance.");
        System.out.println("\t3. Add friend to the list.");
        System.out.println("\t4. Remove friend from the list.");
        System.out.println("\t5. Check fiends list.");
        System.out.println("\t6. Check game owned list.");
        System.out.println("\t7. Check all the user info.");
        System.out.println("\t8. When I created my acc?");
        System.out.println("\t9. Purchase a game.");
        System.out.println("\t10. Exit the user menu.");
        op = scanner.nextInt();
        scanner.nextLine();
        return op;
    } // End show extended menu user and read option

    private static void addBalanceOfUser(  User userFounded) {
        Double amount = readDouble("Amount what you want add");
        userFounded.addBalanceToAcc(amount);
    } // End add balance of user method

    private static void balanceOfUser(  User user) {
        System.out.println("The balance in the " + user.getUsername() + " wallet is: [" + user.getBalance() + "].");
    } // End balance of user method

    private static void addFriendFromTheList(  User userFriendListModified, User userFounded) {
        userFriendListModified.addFriend(userFounded);
    } // End add friend from the list method

    private static void removeFriendFromTheList(  User userFriendListModified, User userFounded) {
        userFriendListModified.removeFriend(userFounded);
    } // End remove friend from the list method

    private static void friendListOf(  User userFounded) {
        userFounded.listFriends();
    } // End list friends method

    private static void listGamesOwned(  User userFounded) {
        userFounded.listGamesOwned();
    } // End list games owned method

    private static void extendedUserInfo(  User userFounded) {
        userFounded.userInfo();
    } // End extended user information method

    private static void dateOfAccCreation(  User userFounded) {
        LocalDate today = LocalDate.now();
        System.out.println("The account was created " + userFounded.getCreationAcc().until(today) + " ago [" + userFounded.getCreationAcc() + "]");
    } // End date of account creation method

    private static void purchaseAGame(  User purchaser, Game gameFounded) {
        purchaser.purchaseGame(purchaser, gameFounded);
    } // End purchase a game method

    private static void addGameOption(ArrayList<User> users, ArrayList<Game> games) {
        Game gameFounded;
        int op;
        do {
            op = showGameMenuAndReadOp();
            switch (op) {
                case 1:
                    games = addGame(games);
                    break;
                case 2:
                    do {
                        op = showExtendedGameMenu();
                        switch (op) {
                            case 1:
                                gameFounded = whichGame(games, "Type the name of the game.");
                                assert gameFounded != null;
                                System.out.println("The author/s of [" + gameFounded.getName() + "] is/are [" + gameFounded.getAuthor() + "].");
                                break; // End case 1 [Check author]
                            case 2:
                                gameFounded = whichGame(games, "Type the game which the game from you want know the price.");
                                assert gameFounded != null;
                                System.out.println(gameFounded.getName() + " cost [" + gameFounded.getPrice() + "].");
                                break; // End case 2 [Check price]
                            case 3:
                                gameFounded = whichGame(games, "Type the name from the game which you want know more about.");
                                assert gameFounded != null;
                                System.out.println("The description from [" + gameFounded.getName() + "] is \n{" + gameFounded.getDescription() + "}");
                                break; // End case 3 [Check price]
                            case 4:
                                gameFounded = whichGame(games, "Type the name from the game which you want know the PEGI.");
                                assert gameFounded != null;
                                System.out.println("The PEGI from [" + gameFounded.getName() + "] is [" + gameFounded.getPeg() + "].");
                                break; // End case 4 [Check PEG]
                            case 5:
                                gameFounded = whichGame(games, "Type the name from the game which you want know all about.");
                                assert gameFounded != null;
                                gameFounded.gameInfo();
                                break; // End case 5 [Check all the game info]
                            case 6:
                                gameFounded = whichGame(games, "Type the name from the game which you want know the released date.");
                                assert gameFounded != null;
                                gameDateReleased(gameFounded);
                                break; // End case 6 [game released date]
                            case 7:
                                System.out.println("Exiting from extended game menu...\n\n");
                                break; // End case 7 [Exit from extended game menu]
                            default:
                                System.out.println("Something went wrong...\n\n");
                                break;
                        }
                    } while (op != 7);
                    break; // End case 2 [Extended game menu]
                case 3:
                    System.out.println("Exiting game menu...\n\n");
                    break; // End case 3 [Exiting game menu]
                default:
                    System.out.println("Something went wrong.\n\n");
                    break;
            }
        } while (op != 3);
    } // End add game option method

    private static int showGameMenuAndReadOp() {
        int op;
        System.out.println("\n\n~~~~~~~~~~ Model.Game menu ~~~~~~~~~~");
        System.out.println("\t1. Create a game.");
        System.out.println("\t2. Access to extended game menu.");
        System.out.println("\t3. Exit from game menu.");
        op = scanner.nextInt();
        scanner.nextLine();
        return op;
    } // End show extended game menu method

    private static ArrayList<Game> addGame(ArrayList<Game> games) {
        Game newGame = createGame(games);
        boolean duplicated = false;

        if (games.size() > 1 ){
            for (Game gamesChecker : games){
                for (int i = 0; i < games.size(); i++) {
                    if (gamesChecker.getName().equalsIgnoreCase(newGame.getName())){
                        System.out.println("The game already exists!\nTry to add with other name.");
                        duplicated = true;
                        break;
                    }
                }
                if (duplicated){
                    break;
                }
            }
        }

        if (!duplicated || games.size() == 0){
            games.add(newGame);
            System.out.println("The game was added successfully!");
        }
        return games;
    } // End add game method


    private static Game createGame(ArrayList<Game> games) {
        Game gameCreated = new Game();
        gameCreated.setName(readString("How is the game called?"));
        gameCreated.setAuthor(readString("Who is/are the author/s from the game?"));
        gameCreated.setDescription(readString("Type a description of the game"));
        gameCreated.setPeg(readInt());
        gameCreated.setPrice(readDouble("How much gonna cost the game?"));
        gameCreated.setReleased(LocalDate.parse(readString("When is released the game? || DATE FORMAT [yyyy-MM-dd]")));
        return gameCreated;
    }

    private static Game whichGame(ArrayList<Game> games, String message) {
        String name = readString(message);
        game = null;

        for (Game gameSearch : games){
            if (gameSearch.getName().equalsIgnoreCase(name)){
                game = gameSearch;
                System.out.println("The game was found!\n");
                break;
            }
        }

        if (game == null){
            System.out.println("The game was not found!");
        }
        return game;
    } // End which game method

    private static int showExtendedGameMenu() {
        int op;
        System.out.println("\n\n~~~~~~~~~~ Extended game menu ~~~~~~~~~~");
        System.out.println("\t1. Check author.");
        System.out.println("\t2. Check price.");
        System.out.println("\t3. Check description.");
        System.out.println("\t4. Check PEG.");
        System.out.println("\t5. Check all the game info.");
        System.out.println("\t6. When the game was released?");
        System.out.println("\t7. Exit from extended game menu.");
        op = scanner.nextInt();
        scanner.nextLine();
        return op;
    } // End menu based on game option method

    private static void gameDateReleased(Game gameFounded) {
        LocalDate now = LocalDate.now();
        System.out.println("The game was released [" + gameFounded.getReleased().until(now) + "] ago. [" + gameFounded.getReleased() + "].");
    } // End game date released method

    /**
     * Reads a string input from the user.
     *
     * @param message The message prompt.
     * @return The user input.
     */
    private static String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    } // End read String method

    /**
     * Reads an integer input from the user.
     *
     * @return The user input.
     */
    private static int readInt() {
        int integer;
        System.out.println("What is the minimum age to play?");
        integer = scanner.nextInt();
        scanner.nextLine();
        return integer;
    } // End read int method

    /**
     * Reads a double input from the user.
     *
     * @param message The message prompt.
     * @return The user input.
     */
    private static Double readDouble(String message) {
        double doubleRead;
        System.out.println(message); // Print the user message
        doubleRead = scanner.nextDouble();
        scanner.nextLine();
        return doubleRead;
    } // End read Double method

} // End class {Test}