import java.util.*;
import java.io.*;

public class USACO{
    public static void main(String[] args){
	System.out.println(silver("ctravel.1.in")); 
	
    }
    
    public static int bronze(String filename){
	File f = new File(filename);
	try {
	    Scanner in = new Scanner(f);
	    String line = in.nextLine();
	    String[] array = line.split(" ");
	    int row = Integer.parseInt(ary[0]);
	    int col = Integer.parseInt(ary[1]);
	    int water = Integer.parseInt(ary[2]);
	    int moves = Integer.parseInt(ary[3]);
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
	    numOfMoves -- 1;
	    }
	    
	    int totalD = 0;
	    for (int rr==0; rr<board.length; rr++){
		for (int cc=0; cc<board[i].length; cc++){
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
	for (int row=0; row<b.length; row++){
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
		if (board[row+i][col+c]>(max - stampNum)){
		    board[row+i][col+c]=(max - stampNum);
		}
	    }
	}
    }

	
    public static int silver(String filename){
	
        File text = new File(filename);

        String[] dataS;
	char[][] data;
	int[] dataE;

	dataE=new int[7];

	int sizeX=0;
	int sizeY=0;
	int travel=0;

	int startX=0;
	int startY=0;
	int endX=0;
	int endY=0;

	
	
	try {	    
	    Scanner inf = new Scanner(text);
	    Scanner in= new Scanner(text);
	    Scanner i=new Scanner(text);

	    int lnCount=0;
	    int lnSize=0;
	    int dataCount=0;
	    int lneCount=0;
	    
	    while (inf.hasNextLine()){
		lnCount++;

		dataCount++;

		System.out.println(lnCount+" "+dataCount);
	    }

	    while (i.hasNextLine()){
		lneCount++;
		String ln=inf.nextLine();
		if (lneCount>0 && lneCount<dataCount){
		    lnSize=ln.length();
		    System.out.println(lnSize);
		}
	    }

	    dataS=new String[7];
	    
	    int Ecount=0;
	    while (inf.hasNextInt()){
		dataE[Ecount]=inf.nextInt();
		Ecount++;
	    }

	    data=new char[dataE[0]][dataE[1]];
	    
	    for (int count=1; count<dataS.length-1; count++){
		for (int ct=0; ct<lnSize; ct++){
		    if (dataS[count].charAt(ct)!= '*' || dataS[count].charAt(ct)!= '.'){
			data[count][ct]=dataS[count].charAt(ct);
		    }
		}
	    }
	}catch (FileNotFoundException e){
	    return -1;
	}return 0;
    }
}
