import java.util.*;
import java.io.*;
public class Maze{

    private char[][] maze;
    private boolean animate;//false by default
    private int col;
    private int row;
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
	try{
	    File f = new File(filename);
	    Scanner input = new Scanner(f);

	    while (input.hasNext()){
	    String line = input.nextLine();
	    row++;
	    col=line.length();
	    }
	    
	    maze = new char[row][col];
	    Scanner output = new Scanner(f);
	    int r=0;
	    while (output.hasNext()){
		String oLine = output.nextLine();
		for (int c = 0;c < oLine.length();c++){
		    if (oLine.charAt(c) == 'S'){
		    sX=c;
		    sY=r;
		}
		    maze[r][c] = oLine.charAt(c);
		}
		r++;
	    }
	    if (!check()){
		throw new IllegalStateException();
	    }
	}
	catch (FileNotFoundException e){}
    }
    

    private boolean check(){
	int numS = 0;
	int numE = 0;
	for (int r=0; r<maze.length; r++){
	    for (int c=0; c<maze[r].length; c++){
		if (maze[r][c]=='S'){
		    numS++;
		}
		else if (maze[r][c]=='E'){
		    numE++;
		}
	    }
	}
	if (numS==1 && numE==1){
	    return true;
	}
	return false;
    }

    public String toString(){
	String str = "";
	for (int r=0; r<row; r++){
	    for (int c=0; c<col; c++){
		str+=maze[r][c];
	    }
	    str += "\n";
	}
	return str;
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){	
	animate = b;
    }
    
    public void clearTerminal(){
	//erase terminal, go to top left of screen.
	System.out.println("\033[2J\033[1;1H");
    }

   public int solve(){
	return solve(sY, sX,0);
    }

    private int solve(int row, int col,int moves){
	if (animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	if (maze[row][col] == 'E'){
	    return moves;
	}
	for (int count=0; count<4; count++){
	    if (maze[row+xMoves[count]][col+yMoves[count]] == ' ' ||
		maze[row+xMoves[count]][col+yMoves[count]] == 'E'){
		maze[row][col] = '@';
		int nums = solve(row+xMoves[count], 
				 col+yMoves[count],
				 moves++);
		if (nums > 0){
		    return nums;
		}
	    }
	    maze[row][col] = '.';
	}
	return -1;
    }    

   public static void main(String[]args){
        Maze f;
	//	try {
	    f = new Maze("Maze1.txt");//true animates the maze.
	    f.setAnimate(true);
	    System.out.println(f.solve());
	    //} catch (FileNotFoundException e){}
   }
}

