import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int col;
    private int row;
    private boolean animate;
    private int sX;
    private int sY;
    private int[] xMoves;
    private int[] yMoves;

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename){
	animate = false;
	xMoves = new int[] {0,0,1,-1};
	yMoves = new int[] {1,-1,0,0};
	File f = new File(file);
	Scanner in = new Scanner(f);
	while (in.hasNext()){
	    String line = in.nextLine();
	    row += 1;
	    col = line.length();
	}
	
