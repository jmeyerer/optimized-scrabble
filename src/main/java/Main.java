/*
Author: Jackson Meyer
Date: 2 December 2020
 */


public class Main {

    public static void main(String args[]){

        Scrabble scrabble = new Scrabble();
        scrabble.populateBoard();
        scrabble.mainBoard.printBoard(scrabble.mainBoard.board);

    }
}
