package code;

import java.lang.*;

import java.util.*;

import java.util.Scanner;

public class Player {

    // Class attributes
    public String name;
    private Room[] rooms;
    public String[] inventory = {};
    private int currentRoom = 0;

    // Default constructor
    public Player() {}

    // Overloaded constructor
    public Player(String playerName, Room[] rooms) {

        this.name = playerName;
        this.rooms = rooms;
        this.currentRoom = 0;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String[] getInventory() {
        return inventory;
    }

    public int getRoom() {
        return currentRoom;
    }

    public void setRoom(int roomNum) {
        this.currentRoom = roomNum;
    }

    //Allows the player to look around and see what room they are in
    public void lookAround() {
        Room room = rooms[currentRoom];
        System.out.println("You are in " + room.getName());
        System.out.println(room.getDescription());
    }

    // Adds found object to player's inventory
    public void addToInv(String item) {

        List < String > invList = new ArrayList < String > (Arrays.asList(this.inventory));
        invList.add(item);
        this.inventory = invList.toArray(this.inventory);

    }

    // Displays list of items in player's inventory
    public void displayInventory() {
        for (int i = 0; i < this.inventory.length; i++) {
            System.out.println(i + 1 + ". " + this.inventory[i]);
        }
    }

    // Allows player to use item in inventory
    public void useItem() {

        int itemChoice;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose an item to use");
        displayInventory();
        itemChoice = input.nextInt() - 1;

        if (this.inventory[itemChoice].compareTo("Flashlight") == 0) {
            System.out.println("You shine your flashlight and see the number " + rooms[currentRoom].getExitCode() + ". Your battery has run out!");
        } else if (this.inventory[itemChoice].compareTo("Hint Potion") == 0) {
            System.out.println("You drink the potion and think of the number " + rooms[currentRoom].getExitCode() + ". The potion is empty!");
        }
        removeItem(itemChoice);
    }

    // Allows player to pick up the item in the current room
    public void pickUpItem() {
        String itemInRoom = rooms[currentRoom].getItem();
        if ((itemInRoom.compareTo("Flashlight") == 0)) {
            System.out.println("You have found a flashlight!");
            addToInv(itemInRoom);
        } else if (itemInRoom.compareTo("Hint Potion") == 0) {
            System.out.println("You have found a Hint Potion!");
            addToInv(itemInRoom);
        } else {
            System.out.println("No item found.");
        }
    }

    // Removes item from player's inventory using ArrayList
    public void removeItem(int itemIndex) {
        List < String > invList = new ArrayList < String > (Arrays.asList(this.inventory));
        invList.remove(itemIndex);
        inventory = invList.toArray(this.inventory);

        List < String > newInv = new ArrayList < String > ();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].length() > 0) {
                newInv.add(inventory[i]);
            }
            inventory = newInv.toArray(new String[newInv.size()]);
        }
    }
    //Allows for user input
    Scanner input = new Scanner(System.in);

    //Allows the player to move to the next room
    public void move() {
        currentRoom++; // Increment the index to move to the next room
        if (currentRoom < rooms.length) {
            System.out.println("You've moved to the next room.");
        } else {
            System.out.println("Congratulations!! You've escaped and reached the end of the game.");
        }
    }

    //Checks to see if the players guess was right or not
    public void attemptExit() {
        Room room = rooms[currentRoom];
        int requiredCombination = room.getExitCode();
        System.out.print("Enter your guess (1-3): ");
        int enteredCombination = input.nextInt();

        if (enteredCombination == requiredCombination) {
            System.out.println("Congratulations! You've guessed the correct combination.");
            move();
        } else {
            System.out.println("Incorrect guess. Try again.");
        }
    }

}

