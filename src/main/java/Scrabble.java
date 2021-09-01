/*
Author: Jackson Meyer
Date: 2 December 2020
 */

import java.util.*;

public class Scrabble {

    ScrabbleBoard mainBoard;
    List<ScrabbleObject> objects;
    ScrabbleObject[][] objectCoords;
    List<String> directions;

    public Scrabble() {  
        mainBoard       = new ScrabbleBoard();
        objects         = new ArrayList<>();
        objectCoords    = new ScrabbleObject[15][15];
        directions      = new ArrayList<>(Arrays.asList("UP", 
                                                        "DOWN", 
                                                        "LEFT", 
                                                        "RIGHT"));
    }

    public ScrabbleBoard populateBoard()
    {        
        // Set first random letter in middle of board
        int letterRange = 27;
        String letter = mainBoard.letters.get((int)(Math.random() * letterRange));
        int newAmount = mainBoard.lettersLeft.get(letter) - 1;
        mainBoard.lettersLeft.put(letter, newAmount);
        mainBoard.board[7][7] = letter;
        mainBoard.TOTAL_LEFT -= 1;

        ScrabbleObject first = new ScrabbleObject(7, 7, letter);
        objectCoords[7][7] = first; // add to list of known populated spots
        objects.add(first);
        int directionRange = 4;

        while(mainBoard.TOTAL_LEFT >= 0) 
        {
            if(objects.size() == 1)
            {
                letter = mainBoard.letters.get((int)(Math.random() * letterRange));
                newAmount = mainBoard.lettersLeft.get(letter) - 1;
                mainBoard.lettersLeft.put(letter, newAmount);
                mainBoard.TOTAL_LEFT -= 1;
                String direction = directions.get((int)(Math.random()*directionRange)); // Choose random direction (index between 1 and 4)
                
                int tempX = first.getX();
                int tempY = first.getY();

                switch(direction) {
                    case "UP":
                        tempY -= 1;
                        break;
                    case "DOWN":
                        tempY += 1;
                        break;
                    case "LEFT":
                        tempX -= 1;
                        break;
                    case "RIGHT":
                        tempX += 1;
                }

                ScrabbleObject newObject = new ScrabbleObject(tempX, tempY, letter);
                objects.add(newObject);
                objectCoords[tempX][tempY] = newObject;  // add to list of known populated spots
                update(newObject);
            }
                   
            letter = mainBoard.letters.get((int)(Math.random() * letterRange));
            while(mainBoard.lettersLeft.get(letter) == null) 
            {
                letter = mainBoard.letters.get((int)(Math.random() * letterRange));
            }
            System.out.println("Letter selected = " + letter + " | Letters Left: " + mainBoard.TOTAL_LEFT);

            newAmount = mainBoard.lettersLeft.get(letter) - 1;
            mainBoard.lettersLeft.put(letter, newAmount);
            mainBoard.TOTAL_LEFT -= 1;
            List<String> tempDirections = new ArrayList<>(Arrays.asList("UP", "DOWN", "LEFT", "RIGHT"));
            int tempRange = objects.size();

            ScrabbleObject so = objects.get((int)(Math.random()*tempRange));
            int tempX = so.getX();
            int tempY = so.getY();
            boolean shouldLoop = true;

            // Finding a spot for the letter on the board that is connected to another letter but in a valid spot
            while(shouldLoop) {
                tempDirections = new ArrayList<>(Arrays.asList("UP", "DOWN", "LEFT", "RIGHT"));     // Reset tempDirections to be populated

                if(tempY == 0   || so.getUp()    != null)   tempDirections.remove("UP");
                if(tempY == 14  || so.getDown()  != null)   tempDirections.remove("DOWN");
                if(tempX == 0   || so.getLeft()  != null)   tempDirections.remove("LEFT");
                if(tempX == 14  || so.getRight() != null)   tempDirections.remove("RIGHT");

                if (tempDirections.size() != 0 && (objectCoords[tempX][tempY] == null)) {
                    int tempDirectionRange = tempDirections.size();
                    String randDirection = tempDirections.get((int)(Math.random()*tempDirectionRange));
        
                    switch(randDirection) {
                        case "UP":
                            tempY -= 1;
                            break;
                        case "DOWN":
                            tempY += 1;
                            break;
                        case "LEFT":
                            tempX -= 1;
                            break;
                        case "RIGHT":
                            tempX += 1;
                    }

                    ScrabbleObject newObj = new ScrabbleObject(tempX, tempY, letter);
                    objects.add(newObj);
                    mainBoard.board[tempX][tempY] = letter;
                    objectCoords[tempX][tempY] = newObj;  // add to list of known populated spots
                    update(newObj); // Update newObj and its neighbors
                    shouldLoop = false;
                }


                if(tempDirections.size() == 0 || (objectCoords[tempX][tempY] != null)) {
                    so = objects.get((int)(Math.random()*tempRange));
                    tempX = so.getX();
                    tempY = so.getY();
                    shouldLoop = true;
                }
            }

                
            
        }


        return mainBoard;
    }

    public double boardDensity(ScrabbleBoard sb)
    {

        return 0;
    }

    private void update(ScrabbleObject obj) 
    {
        int x = obj.getX();
        int y = obj.getY();

        // Update Left
        if(x != 0 && objectCoords[x-1][y] != null) {
            obj.setLeft(objectCoords[x-1][y]);    // Add neighbor to obj
            objectCoords[x-1][y].setRight(obj);   // Add obj to neighbor
        }

        // Update Right
        if(x != 14 && objectCoords[x+1][y] != null) {
            obj.setRight(objectCoords[x+1][y]);   // Add neighbor to obj
            objectCoords[x+1][y].setLeft(obj);    // Add obj to neighbor
        }

        // Update Up
        if(y != 0 && objectCoords[x][y-1] != null) {
            obj.setUp(objectCoords[x][y-1]);      // Add neighbor to obj
            objectCoords[x][y-1].setDown(obj);    // Add obj to neighbor
        }

        // Update Down
        if(y != 14 && objectCoords[x][y+1] != null) {
            obj.setDown(objectCoords[x][y+1]);    // Add neighbor to obj
            objectCoords[x][y+1].setUp(obj);      // Add obj to neighbor
        }
    }


}
