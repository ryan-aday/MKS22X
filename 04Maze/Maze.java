import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

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
	try{
	    File text = new File("data1.dat");// can be a path like: "/full/path/to/file.txt" 
	    //inf stands for the input file
	    Scanner inf = new Scanner(text);
	    Scanner actual = new Scanner(text);
	    int rcount=0;
	    int ccount=0;

	    int row=-1;
	    String ch="";

	    while (inf.hasNextLine()){
		rcount++;
		ch=inf.nextLine();
	    }
	    ccount=ch.length();
	    maze=new char[rcount][ccount];
	    
	    System.out.println(maze.length+" "+maze[0].length);

	    while (actual.hasNextLine()){
		row++;
		String line=actual.nextLine();
		for (int count=0; count<line.length(); count++){
		    maze[row][count]=line.charAt(count);
		}
	    }
	    
	    String test="";
	    for (int rw=0; rw<maze.length; rw++){
		test=test+"\n";
		for (int col=0; col<maze[rw].length; col++){
		    test=test+maze[rw][col];
		}
	    }
	    System.out.println(test);
	}
	

	catch (FileNotFoundException e){
	    e.printStackTrace();
	}
	    

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


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S.
	int startX, startY;
	
	for (int row=0; row<maze.length; row++){
	    for (int col=0; col<maze[row.length]; col++){
		if (maze[row][col]=='S'){
		    startX=row;
		    startY=col;
		}
	    }
	}
	
            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
	return -1;
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}
