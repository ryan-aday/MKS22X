import java.util.*;
import java.io.*;

public class USACO{
    public static void main(String[] args){
	//System.out.println(silver("ctravel.2.in")); 
	
    }
    
    public static int bronze(String filename){
	File f = new File(filename);
	try {
	    Scanner in = new Scanner(f);
	    String line = in.nextLine();
	    String[] array = line.split(" ");
	    int row = Integer.parseInt(array[0]);
	    int col = Integer.parseInt(array[1]);
	    int water = Integer.parseInt(array[2]);
	    int moves = Integer.parseInt(array[3]);
	    int[][] board = new int[row][col];
	    for (int r = 0; r<row; r++){
		for (int c = 0;c < col;c++){
		    board[r][c] = Integer.parseInt(in.next());
		}
	    }
	    while (moves!=0){
	    int rS = Integer.parseInt(in.next()) - 1;
	    int cS = Integer.parseInt(in.next()) - 1;
	    int stomp = Integer.parseInt(in.next());
	    int max = 0;
	    try {
		for (int ro=0; ro<3; ro++){
		    for (int co=0; co<3; co++){
			max = Math.max(board[rS+ro][cS+co],max);
		    }
		}
	    } 
	    catch (ArrayIndexOutOfBoundsException e){}
	    
	    //stamp(rS,cS,board,max,stomp);
	    moves--;
	    }
	    
	    int totalD = 0;
	    for (int rr=0; rr<board.length; rr++){
		for (int cc=0; cc<board[rr].length; cc++){
		    int w = water-board[rr][cc];
		    if (w>0){
			totalD+=w;
		}
		}
	    }
	    return totalD * 72 * 72;
	} catch (FileNotFoundException e){
	    System.exit(1);
	}
	return -1;
    }

    public static String toString(int[][] board){
	String line = "";
	for (int row=0; row<board.length; row++){
	    for (int col=0; col<board[row].length;col++){
		line=line+board[row][col]+" ";
	    }
	    line+="\n";
	}
	return line;
    }
    
    public static void stamp(int row, int col, int[][] board,
			     int max, int stampNum){
	for (int r = 0; r < 3; r++){
	    for (int c=0; c<3; c++){
		if (board[row+r][col+c]>(max - stampNum)){
		    board[row+r][col+c]=(max - stampNum);
		}
	    }
	}
    }

	
    public static int silver(String filename){
	File f = new File(filename);
	try {
	    Scanner inf = new Scanner(f);
	    String[] data = inf.nextLine().split(" ");
	    int row = Integer.parseInt(data[0]);
	    int col = Integer.parseInt(data[1]);
	    int moves = Integer.parseInt(data[2]);
	    char[][] board = new char[row][col];

	    for (int r=0; r<row; r++){
		String line = inf.nextLine();
		for (int c=0; c<col; c++){
		    board[r][c] = line.charAt(c);
		}
	    }

	    String[] coor = inf.nextLine().split(" ");
	    int sr = Integer.parseInt(coor[0]);
	    int sc = Integer.parseInt(coor[1]);
	    int er = Integer.parseInt(coor[2]);
	    int ec = Integer.parseInt(coor[3]);
	    int[][] oldHelp= new int[row][col];
	    int[][] newHelp= new int[row][col];
	  
	    for (int ro= 0; ro<row; ro++){
		for (int co=0; co<col; co++){
		    if (board[ro][co] == '*'){
			oldHelp[ro][co] = -1;
			newHelp[ro][co] = -1;
		    }
		    else if (ro==(sr-1) && co== (sc-1)){
		        oldHelp[ro][co]=1;
			newHelp[ro][co]=1;
		    }
		    else {
			oldHelp[ro][co] = 0;
			newHelp[ro][co] = 0;
		    }
		}
	    }

	    for (int m=0; m<moves; m++){
		for (int r=0; r<row; r++){
		    for (int c = 0;c < col;c++){
			oldHelp[r][c] =  newHelp[r][c];
		    }
		}
		for (int r=0; r<row; r++){
		    for (int c=0; c<col; c++){
			try{
			    if (newHelp[r][c]!=-1){
				newHelp[r][c]=sumNum(r, c, oldHelp);
			    }
			}catch (ArrayIndexOutOfBoundsException e){
			}
		    }
		}
	    }
	    return  newHelp[er-1][ec-1];
	} catch (FileNotFoundException e){
	    System.exit(1);
	}
	return -1;
    }
    
    private static int sumNum(int r, int c, int[][] board){
	int[] row = new int[]{0,0,1,-1};
	int[] col = new int[]{-1,1,0,0};
        int sum=0;
	for (int count=0; count<4; count++){
	    if (isValid(r+row[count], c+col[count], board)){
		sum+=board[r+ row[count]][c + col[count]];
	    }
	}
        return sum;
    }
    
    private static boolean isValid(int r, int c, int[][] board){
     return !(r<0|| 
	      r>=board.length|| 
	      c<0|| 
	      c>=board[0].length|| 
	      board[r][c] == -1);
    }   
}
