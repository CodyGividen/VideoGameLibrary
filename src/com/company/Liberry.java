package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Scanner;


public class Liberry {
    public final Menu menu;

    public Liberry(Menu menu) {
        this.menu = menu;
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/yy HH:mm:ss");

    protected List<Game> gameLibrary = new ArrayList<Game>();

    protected List<Game> checkOutLibrary = new ArrayList<Game>();

    private Scanner input = new Scanner(System.in);

    private String game;


    protected void addGame(Game game) {
        // code goes here to add where ever we are saving things to
//save game from user input from add game
        //display game list
        //remove game ability

        gameLibrary.add(game);
        menu.startMenu();

    }

    protected void removeGame() {


        gameLibrary.remove(input.nextInt() - 1);

    }

    protected void showGames() {
        int index = 1;
        for (Game game : gameLibrary) {
            System.out.println(index++ + ". " + game.getTitle());
        }


    }

    protected void checkOutGame(int gameIndex) {
        gameIndex--;
        Game game = gameLibrary.get(gameIndex);
        Calendar calendar = Calendar.getInstance();
        System.out.println("You checked out the game on " + dateFormat.format(calendar.getTime()));
        calendar.add(calendar.DAY_OF_YEAR, 4);
        System.out.println("Return checked out the game on " + dateFormat.format(calendar.getTime()));
        game.setDueDate(dateFormat.format(calendar.getTime()));
        checkOutLibrary.add(game);
        gameLibrary.remove(game);
        menu.startMenu();


    }


    protected void returnGame() {
        int userInput = input.nextInt() - 1;
        System.out.println("h");
        Game game = checkOutLibrary.get(userInput);
        checkOutLibrary.remove(input.nextInt() - 1);

        gameLibrary.add(game);


    }

    protected void showCheckOut() {
        int index = 1;
        for (Game game : checkOutLibrary) {
            System.out.println(index++ + ". " + game.getTitle());


        }
    }
}
