package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private Double balance;
    private ArrayList<User> friendsList = new ArrayList<>();
    private ArrayList<Game> gamesList = new ArrayList<>();
    private LocalDate creationAcc;

    // Constructor without parameters
    public User() {
    }

    // Constructor with parameters
    public User(String username, Double balance, List<User> friendsList, List<Game> gamesList, LocalDate creationAcc) {
        this.username = username;
        this.balance = balance;
        this.friendsList = (ArrayList<User>) friendsList;
        this.gamesList = (ArrayList<Game>) gamesList;
        this.creationAcc = creationAcc;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = (ArrayList<User>) friendsList;
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Game> gamesList) {
        this.gamesList = (ArrayList<Game>) gamesList;
    }

    public LocalDate getCreationAcc() {
        return creationAcc;
    }

    public void setCreationAcc(LocalDate creationAcc) {
        this.creationAcc = creationAcc;
    }

    // Method toString modified
    public void userInfo() {
        System.out.println("~~~~~~~~~~ Model.User info ~~~~~~~~~~\n\n\tModel.User Name:[" + username + "]\n\tBalance: [" + balance + "]\n\tThe account was created: [" + creationAcc + "]\n\n~~~~~~~~~~ More info ~~~~~~~~~~\n\n\tGames owned: [" + gamesList.size() + "]\n\tFriends: [" + friendsList.size() + "]");
    } // End userInfo Method

    // Purchase method
    public void purchaseGame (User user, Game game){
        if (game == null){
            System.out.println("Invalid game");
        }
        assert game != null;
        if (user.getBalance() < game.getPrice()){ // Check if the balance is less tha the price of the game
            System.out.println("You can't purchase " + game.getName() + ".\nCheck your balance!");
        }else{ // If not, purchase the game successfully
            balance -= game.getPrice();
            gamesList.add(game);
            System.out.println("The game was successfully purchased.");
        }

    } // End purchase method

    // Add Balance method
    public void addBalanceToAcc (Double amount){
        balance+=amount;
        System.out.println("Balance added successfully!");
    }// End addBalanceToAcc Method

    //Method add friend
    public void addFriend (User user){
        if (friendsList.contains(user)){
            System.out.println(user.username + " already is in your friend list.");
        } else if (user == null) {
            System.out.println("Something went wrong!");
        }else{
            friendsList.add(user);
            System.out.println("The user was added to the friend list successfully!");
        }
    } // End add friend method

    //Method remove friend
    public void removeFriend (User user){
        boolean removed = false;
        if (friendsList.isEmpty()){
            System.out.println("The friend list is empty. \nAdd friends to the list. [Extended user menu > 3. Add friend to the list.]");
        } else {
            for (User user1 : friendsList) {
                for (int i = 0; i < friendsList.size(); i++) {
                    if (user1.getUsername().equalsIgnoreCase(user.getUsername())) {
                        friendsList.remove(i);
                        System.out.println("The user was successfully removed from " + username + " friend list.");
                        removed = true;
                        break;
                    }
                }
                if (removed){
                    System.out.println("The user was successfully removed from " + username + " friend list.");
                    break;
                }
            }
        }
    } // End remove friend method

    //Method list friends
    public void listFriends (){
        System.out.println("List of friends from " + username + ":");
        for (User friend: friendsList){
            System.out.println("\t- " + friend.getUsername());
        }
    } // End list friends method

    //Method list games
    public void listGamesOwned (){
        System.out.println("List of games owned from " + username + ":");
        for (Game game: gamesList){
            System.out.println("\t- " + game.getName());
        }
    } // End list games owned method

} // End class {Model.User}