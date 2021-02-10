/*
Author: Jackson Meyer
Date: 2 December 2020
 */

import java.util.HashMap;
import java.util.Map.*;

public class ScrabbleBoard
{
    public HashMap<String, Integer> letters;
    public HashMap<String, Integer> lettersLeft;
    public String[][] board;

    //was going to be hashmap but this works, stores values of letters left in "bag"
    //27 slots instead of 26 to account for blank space
    /*
        |CONSTRUCTOR|
          -  Just populates the hashmaps and initializes the 2D String Array
    */

    public ScrabbleBoard()
    {
        //Putting letter indexes into HashMap (plus blank space)
        letters = new HashMap<String, Integer>();
        letters.put("a", 1);
        letters.put("b", 2);
        letters.put("c", 3);
        letters.put("d", 4);
        letters.put("e", 5);
        letters.put("f", 6);
        letters.put("g", 7);
        letters.put("h", 8);
        letters.put("i", 9);
        letters.put("j", 10);
        letters.put("k", 11);
        letters.put("l", 12);
        letters.put("m", 13);
        letters.put("n", 14);
        letters.put("o", 15);
        letters.put("p", 16);
        letters.put("q", 17);
        letters.put("r", 18);
        letters.put("s", 19);
        letters.put("t", 20);
        letters.put("u", 21);
        letters.put("v", 22);
        letters.put("w", 23);
        letters.put("x", 24);
        letters.put("y", 25);
        letters.put("z", 26);
        letters.put("", 27);

        //Initializing amount of each piece in a board
        lettersLeft = new HashMap<String, Integer>();
        lettersLeft.put("a", 9);
        lettersLeft.put("b", 2);
        lettersLeft.put("c", 2);
        lettersLeft.put("d", 4);
        lettersLeft.put("e", 12);
        lettersLeft.put("f", 2);
        lettersLeft.put("g", 3);
        lettersLeft.put("h", 2);
        lettersLeft.put("i", 9);
        lettersLeft.put("j", 1);
        lettersLeft.put("k", 1);
        lettersLeft.put("l", 4);
        lettersLeft.put("m", 2);
        lettersLeft.put("n", 6);
        lettersLeft.put("o", 8);
        lettersLeft.put("p", 2);
        lettersLeft.put("q", 1);
        lettersLeft.put("r", 6);
        lettersLeft.put("s", 4);
        lettersLeft.put("t", 6);
        lettersLeft.put("u", 4);
        lettersLeft.put("v", 2);
        lettersLeft.put("w", 2);
        lettersLeft.put("x", 1);
        lettersLeft.put("y", 2);
        lettersLeft.put("z", 1);
        lettersLeft.put("", 2);

        board  = new String[15][15];
        for (int i = 0; i <= 14; i++)
        {
            for (int j = 0; j <= 14; j++)
            {
                board[i][j] = "-";
            }
        }
    }

    /*
       printBoard() |
       --------------
       Prints out a given board in it's current state.
    */

    public static void printBoard(String[][] input) {
        String output = "";

        System.out.println("******************************************************************");
        System.out.println("*                                                                *");
        for (int i = 0; i <= 14; i++)
        {
            for (int j = 0; j <= 14; j++)
            {
                output += input[i][j];
                output += "  ";
            }
            System.out.println("*          " + output + "         *");
            output = "";
        }

        System.out.println("*                                                                *");
        System.out.println("******************************************************************");


    }




}
