public class ScrabbleObject {
    private int x;
    private int y;
    private String letter;
    private ScrabbleObject LEFT;
    private ScrabbleObject RIGHT;
    private ScrabbleObject UP;
    private ScrabbleObject DOWN;

    public ScrabbleObject(int x, int y, String letter) 
    {
        this.x = x;
        this.y = y;
        this.letter = letter;

        this.LEFT   = null;
        this.RIGHT  = null;
        this.UP     = null;
        this.DOWN   = null;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public String getLetter() { return this.letter; }

    public ScrabbleObject getLeft()   { return this.LEFT; }
    public ScrabbleObject getRight()  { return this.RIGHT; }
    public ScrabbleObject getUp()     { return this.UP; }
    public ScrabbleObject getDown()   { return this.DOWN; }

    public void setLeft(ScrabbleObject obj)   { this.LEFT = obj; }
    public void setRight(ScrabbleObject obj)  { this.RIGHT = obj; }
    public void setUp(ScrabbleObject obj)     { this.UP = obj; }
    public void setDown(ScrabbleObject obj)   { this.DOWN = obj; }

}
