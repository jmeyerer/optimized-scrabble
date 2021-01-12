/*
Author: Jackson Meyer
Date: 2 December 2020
 */


import java.io.*;
import java.util.HashMap;
import java.util.Map.*;

public class DictionaryEditor {

    public static void main(String[] args) throws IOException {
        File destFile1 = new File("src/fixed-test.csv");                //File being written to, test destination file
        File destFile2 = new File("src/fixed-dictionary.csv");          //File being written to, final destination file
        File inputFile1 = new File("src/test.csv");                     //test file with words "one" through "ten"
        File inputFile2 = new File("src/scrabble-dictionary.csv");      //real scrabble dictionary file

        BufferedReader br = new BufferedReader(new FileReader(inputFile1));      //FileReader takes in test.csv
//        BufferedReader br = new BufferedReader(new FileReader(inputFile2));      //FileReader takes in scrabble-dictionary.csv
//        BufferedReader br = new BufferedReader(new FileReader(destFile2));       //FileReader takes in fixed-dictionary.csv

        FileWriter csvWriter = new FileWriter(destFile1);                        //Destination file is fixed-test.csv
//        FileWriter csvWriter = new FileWriter(destFile2);                        //Destination file is fixed-dictionary.csv
        PrintWriter printWriter = new PrintWriter(csvWriter);                    //printer always writes to the csvWriter, no change needed


        String line = br.readLine();

        ScrabbleBoard sb = new ScrabbleBoard();         //scrabble board so we can use methods in there


//        int i = 1;
//        while (i <= 1000)                            //testing on the real file, iterate through first 1000 words
//        {
//            printWriter.println(line);
//            line = br.readLine();
//            i++;
//        }

//        while (line != null)                         //loops until end of file
//        {
//            printWriter.println(line);
//            line = br.readLine();
//        }

//        while (line != null) {                       //loops until end of file
//            if(line.length() == 10) {                //only adds words of length 10
//                printWriter.println(line);
//            }
//            line = br.readLine();
//        }

        halfLetterFilter(line, br, sb, printWriter);

        printWriter.close();

        System.out.println("Done.");

    }


    /*
        halfLetterFilterCheck() |
        -------------------------
        Function takes input and checks that a given line (string from a csv) doesn't have over 50% of a single letter.
        Important so that we don't waste, for example, all (or a majority) of our A's on one word, leaving none for the
        rest of the scrabble board.

    */
    public static void halfLetterFilter(String line, BufferedReader br, ScrabbleBoard sb, PrintWriter printWriter) throws IOException {
        HashMap<String, Integer> currentWord = new HashMap<String, Integer>();
        String currentLetter;
        while(line != null)                                                 //run until the end of the list
        {
            System.out.println("Current Word: " + line);
            for (int i = 0; i < line.length() - 1; i++)                     //run the entire length of the string
            {
                currentLetter = line.substring(i, i + 1);                   //just so we don't have to do the computation over and over again
                if (line != null)
                {
                    if (!currentWord.containsKey(currentLetter))            //if the letter is not found in the hashmap add it with value 1
                    {
                        currentWord.put(currentLetter, 1);
                        System.out.println("Flag 3");
                    }
                    if (currentWord.containsKey(currentLetter))             //if the letter is in the hashmap update the value
                    {
                        currentWord.put(currentLetter, currentWord.get(currentLetter) + 1);
                        System.out.println("Flag 5");
                        if (currentWord.get(currentLetter) > Math.ceil((0.5) * sb.lettersLeft.get(currentLetter)))
                        {                                                   // ^ if the new value is above half the letters available in scrabble, dump it
                            currentWord.clear();                            //clears the hashmap
                            System.out.println("Flag extra");
                            break;
                        }
                    }
                }
                System.out.println("Flag 2");
            }
            if (!currentWord.isEmpty())         //if theres stuff in the hashmap after the loop we want to add it to the list
            {
                printWriter.println(line);      //write it to the file
                currentWord.clear();             //reset the hashmap to be empty
                System.out.println("Flag 6");
            }
            System.out.println("Flag 1");
        }
        line = br.readLine();                   //read next line in the source file

    }







}


