package code;

import java.util.Random;


public class Room {

    //attributes
    private String name;
    private String description;
    private Room[] exits;
    private int exitCode;
    private String item;

    //Default Constructor
    public Room() {}

    //Overloaded Constructor
    public Room(String name, String description, String item) {
        this.name = name;
        this.description = description;
        this.exits = new Room[4];
        this.exitCode = createKey();
        this.item = item;
    }
    //Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getExitCode() {
        return exitCode;
    }

    public Room[] getExits() {
        return exits;
    }

    public String getItem() {
        return this.item;
    }

    //Creates the random number that the player has to guess
    public int createKey() {
        Random key = new Random();
        return key.nextInt(3) + 1;
    }
}
