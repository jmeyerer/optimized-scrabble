/*
Author: Jackson Meyer
Date: 2 December 2020
 */

import java.util.HashMap;

public class ScrabbleBoard
{
    public HashMap<Integer, String> letters;
    public HashMap<String, Integer> lettersLeft;
    public String[][] board;
    public int TOTAL_LEFT = 100;

    //was going to be hashmap but this works, stores values of letters left in "bag"
    //27 slots instead of 26 to account for blank space
    /*
        |CONSTRUCTOR|
          -  Just populates the hashmaps and initializes the 2D String Array
    */

    public ScrabbleBoard()
    {
        //Putting letter indexes into HashMap (plus blank space)
        letters = new HashMap<Integer, String>();
        letters.put(1, "a");
        letters.put(2, "b");
        letters.put(3, "c");
        letters.put(4, "d");
        letters.put(5, "e");
        letters.put(6, "f");
        letters.put(7, "g");
        letters.put(8, "h");
        letters.put(9, "i");
        letters.put(10, "j");
        letters.put(11, "k");
        letters.put(12, "l");
        letters.put(13, "m");
        letters.put(14, "n");
        letters.put(15, "o");
        letters.put(16, "p");
        letters.put(17, "q");
        letters.put(18, "r");
        letters.put(19, "s");
        letters.put(20, "t");
        letters.put(21, "u");
        letters.put(22, "v");
        letters.put(23, "w");
        letters.put(24, "x");
        letters.put(25, "y");
        letters.put(26, "z");
        letters.put(27, "~");

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
        lettersLeft.put("~", 2);

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

    public void printBoard(String[][] input) 
    {
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
