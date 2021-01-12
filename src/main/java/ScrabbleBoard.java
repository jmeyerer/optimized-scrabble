/*
Author: Jackson Meyer
Date: 2 December 2020
 */

import java.util.HashMap;
import java.util.Map.*;

public class ScrabbleBoard
{
    HashMap<String, Integer> letters;
    HashMap<String, Integer> lettersLeft;

    //enum values for alphabet, denoted by the letter with prefix '_' (underscore)
    //all values are the index value of their place in the alphabet - 1 (for indexing's sake)
    //there is a _blank tile of value 26, so it'll just be the last num in the array
    public enum Alphabet {
        _a(0, "a"),
        _b(1, "a"),
        _c(2, "a"),
        _d(3, "a"),
        _e(4, "a"),
        _f(5, "a"),
        _g(6, "a"),
        _h(7, "a"),
        _i(8, "a"),
        _j(9, "a"),
        _k(10, "a"),
        _l(11, "a"),
        _m(12, "a"),
        _n(13, "a"),
        _o(14, "a"),
        _p(15, "a"),
        _q(16, "a"),
        _r(17, "a"),
        _s(18, "a"),
        _t(19, "a"),
        _u(20, "a"),
        _v(21, "a"),
        _w(22, "a"),
        _x(23, "a"),
        _y(24, "a"),
        _z(25, "a"),
        _blank(Integer.MAX_VALUE, "");                                            //_blank for blank tile

        private int val;
        private String str;
        public int getVal(){ return this.val; }
        private Alphabet(int val, String str) {
            this.val = val;
            this.str = str;
        }
    }


    //was going to be hashmap but this works, stores values of letters left in "bag"
    //27 slots instead of 26 to account for

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

        //Initializing # of each piece in a board
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

    }


    public static void printBoard(ScrabbleBoard board) {
        //Should print out a given board

    }




}
