/*
Author: Jackson Meyer
Date: 2 December 2020
 */


public class Main {

    public static void main(String args[]){

        int i = 0;
        while (i < 5) {
            for(int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                if (j == 3) break;
            }
            System.out.println("i = " + i);
            i++;
        }

    }
}
