package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private Liberry liberry = new Liberry(this);
    //Menu to prompt user for library options

    public void startMenu() {
        System.out.println("Welcome to the video game library, what would you like to do? \n" +
                "1. Add a game to the library \n" +
                "2. Remove game from your library \n" +
                "3. View what games you currently have in your library \n" +
                "4. Check a game out of your library \n" +
                "5. Check a game in \n" +
                "6. View checked out game \n" +
                "7. Exit the program");


        try {

            switch (input.nextInt()) {
                case 1:
                    //Add game
                    //Game game = new Game(Liberry);
                    //Liberry.add;
                    System.out.println("What game would you like to add to you library");
                    input.nextLine();
                    Game game = new Game(input.nextLine());
                    System.out.println("You have entered " + game.getTitle() + "  to your video game library.");
                    liberry.addGame(game);


                    break;
                case 2:
                    //Remove game
                    if(liberry.gameLibrary.isEmpty()){
                        System.out.println("You have no games in library. ");
                        startMenu();
                    }else{
                        System.out.println("What number would you like to remove?");
                        liberry.showGames();
                        liberry.removeGame();
                        startMenu();
                    }

                    break;
                case 3:
                    //View main library
                    if(liberry.gameLibrary.isEmpty()){
                        System.out.println("You have no checked out games.");
                        startMenu();
                    }else{
                        System.out.println("Here is your library.");
                        liberry.showGames();
                        startMenu();

                    }
                    break;
                case 4:
                    //Checkout game
                    if(liberry.checkOutLibrary.isEmpty()) {
                        System.out.println("Here are the games you can check out: ");
                        liberry.showGames();
                        System.out.println("What game would you like to check out?");
                        liberry.checkOutGame(input.nextInt());
                        startMenu();
                    }else{
                        System.out.println("You have know checked out games.");
                        startMenu();
                    }
                    break;
                case 5:
                    //Check in games
                    if(liberry.checkOutLibrary.isEmpty()) {
                        System.out.println("What game would you like to check out?");
                        liberry.showCheckOut();
                        liberry.returnGame();
                        startMenu();
                    }else{
                        System.out.println("You have know checked out games.");
                        startMenu();
                    }
                    break;
                case 6:
                    // View checked out games
                    System.out.println("Here are your checked out games.");
                    liberry.showCheckOut();
                    startMenu();
                    break;
                case 7:
                    //Exit program
                    System.exit(0);
                    break;
                default:
                    //prompt user to pick correct number then loop back to menu
                    //if (liberry.showGames() = ){


//                    }else {
//                        System.out.println("Pick the correct number between 1 and 7.");
//                        break;
//                    }


            }


        } catch (InputMismatchException ime) {
            System.out.println("Please stop messing around, you know what a number is. Pick a number 1 - 7");
            input.nextLine();
            startMenu();

        }


    }
}
