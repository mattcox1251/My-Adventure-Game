package code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Allows for user input
        Scanner input = new Scanner(System.in);

        //Stores each of the rooms in an array
        Room[] rooms = new Room[3];
        rooms[0] = new Room("Spooky Living Room", "You are in what appears to be an old living room. " +
                "In this room, you see two skeletons sitting on rocking chairs that are rocking back and forth. You must quickly escape this room to avoid their fate!", "Flashlight");
        rooms[1] = new Room("Haunted Library", "This room is filled from floor to ceiling with old books. You look up and notice one of the biggest" +
                "spiderwebs you have ever seen. You do not want to see the spider that lives here, so quickly find the exit!", "Hint Potion");
        rooms[2] = new Room("Terrifying Terrace", "You find yourself in what looks like the last area before you can escape. " +
                "You are outside but from the brightness of the full moon, you can tell there is a lock on the gate. There are bats flying overhead " +
                "and wolves howling in the distance. Quickly get out of there!!", "");

        //Player Object
        Player player1 = new Player("Player1", rooms);

        //Startup Message
        System.out.println("=======================================");
        System.out.println("Welcome to Our Haunted Adventure Game!");
        System.out.println("=======================================");
        System.out.println("In our game, you are currently lost within a haunted house. You must find yourself through three rooms to reach the exit. " +
                "To get out of each of these rooms, you will guess a number from 1-3. Good luck and have fun!");
        //Game Menu
        boolean playingGame = true;
        while (playingGame) {
            System.out.println("Please choose from one of the following options:");
            System.out.println("1. Look around");
            System.out.println("2. Attempt to exit");
            System.out.println("3. Pick up item");
            System.out.println("4. Use item");
            System.out.println("5. Quit the game");
            System.out.print("Enter your choice: ");

            //Takes the user input and uses a switch statement to see what to do

            int option = input.nextInt();

            switch (option) {
                case 1:
                    player1.lookAround();
                    break;
                case 2:
                    player1.attemptExit();
                    break;
                case 3:
                    player1.pickUpItem();
                    break;
                case 4:
                    if (player1.getInventory().length >= 1) {
                        player1.useItem();
                    } else {
                        System.out.println("Inventory is empty");
                    }
                    break;
                case 5:
                    playingGame = false;
                    System.out.println("Thank you for playing our adventure game!!");
                    break;
                default:
                    System.out.println("Not a valid option. Please try again.");
                    break;
            }
            if (player1.getRoom() == 3) {
                playingGame = false;
            }

        }
        while (playingGame == true);
        input.close();

    }
}
