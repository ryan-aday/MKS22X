import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){
    }

    public static int bronze(String filename){
	File f=new File(filename);
	try {
	Scanner in=new Scanner(f);
	String line=in.nextLine();
	String[] ary=line.split(" ");
	int row=Integer.parseInt(ary[0]);
	int col=Integer.parseInt(ary[1]);
	int level=Integer.parseInt(ary[2]);
	int moves=Integer.parseInt(ary[3]);
	int[][] board = new int[row][col];
	for (int r=0; r<row; r++){
	    for (int c = 0;c < col;c++){
		board[r][c] = Integer.parseInt(in.next());
	    }
	}
	while (moves != 0){
	    int rs = Integer.parseInt(in.next()) - 1;
	    int cs = Integer.parseInt(in.next()) - 1;
	    int stomp = Integer.parseInt(in.next());
	    int max = 0;
	    try {
		for (int r = 0; r<3; r++){
		    for (int c = 0;c < 3;c++){
			max = Math.max(board[rs+r][cs+c],max);
		    }
		}
	    } catch (ArrayIndexOutOfBoundsException e){}
	    stomp(rs,cs,board,max,stomp);
	    moves -= 1;
	}
	int depth=0;
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board[r].length; c++){
		int h=level-board[r][c];
		if (h>0){
		    depth += h;
		}
	    }
	}
	return depth*72*72;
	} catch (FileNotFoundException e){
	    System.exit(1);
	}
	return -1;
    }
    
    public static String toString(int[][] b){
	String str="";
	for (int r = 0; r<b.length; r++){
	    for (int c=0; c<b[r].length; c++){
		str+=b[r][c];
		str+=" ";
	    }
	    str+="\n";
	}
	return str;
    }

    public static String daOne(String[] b){
	String str = "";
	for (int i = 0;i < b.length;i++){
	    str += b[i];
	    str += " ";
	}
	return str;
    }
    
    public static void stomp(int r,int c,int[][] board,int max,int stompNum){
	for (int t=0; t<3; t++){
	    for (int d = 0;d < 3;d++){
		if (board[r+t][c+d]>(max-stompNum)){
		    board[r+t][c+d]=(max-stompNum);
		}
	    }
	}
    }

    public static int silver(String filename){
        File f = new File(filename);
	try {
	Scanner in = new Scanner(f);
	String[] skrt = in.nextLine().split(" ");
	int row = Integer.parseInt(skrt[0]);
	int col = Integer.parseInt(skrt[1]);
	int numOfMoves = Integer.parseInt(skrt[2]);
	char[][] board = new char[row][col];
	for (int i = 0;i < row;i++){
	    String line = in.nextLine();
	    for (int c = 0;c < col;c++){
		board[i][c] = line.charAt(c);
	    }
	}
	String[] cords = in.nextLine().split(" ");
	int r1 = Integer.parseInt(cords[0]);
	int c1 = Integer.parseInt(cords[1]);
	int r2 = Integer.parseInt(cords[2]);
	int c2 = Integer.parseInt(cords[3]);
	int[][] helperBoard = new int[row][col];
	int[][] helper2Board = new int[row][col];
	for (int i = 0;i < row;i++){
	    for (int c = 0;c < col;c++){
		if (board[i][c] == '*'){
		    helperBoard[i][c] = -1;
		    helper2Board[i][c] = -1;
		}
		else if (i == (r1 - 1) && c == (c1 - 1)){
		    helperBoard[i][c] = 1;
		    helper2Board[i][c] = 1;
		}
		else {
		    helperBoard[i][c] = 0;
		    helper2Board[i][c] = 0;
		}
	    }
	}
	for (int m = 0;m < numOfMoves;m++){
	    for (int i = 0;i < row;i++){
		for (int c = 0;c < col;c++){
		    helperBoard[i][c] =  helper2Board[i][c];
		}
	    }
	    for (int i = 0;i < row;i++){
		for (int c = 0;c < col;c++){
		    try{
			if (helper2Board[i][c] != -1){
			    helper2Board[i][c] = sumN(i,c,helperBoard);
			}
		    }catch (ArrayIndexOutOfBoundsException e){
		    }
		}
	    }
	}
	return  helper2Board[r2 - 1][c2 - 1];
	} catch (FileNotFoundException e){
	    System.exit(1);
	}
	return -1;
    }

    private static int sumN(int x, int y, int[][] board){
	int[] row = new int[]{0,0,1,-1};
	int[] col = new int[]{-1,1,0,0};
        int sum = 0;
	for (int i = 0;i < 4;i++){
	    if (isValid(x + row[i],y + col[i],board)){
		sum += board[x + row[i]][y + col[i]];
	    }
	}
        return sum;
    }

    private static boolean isValid(int x, int y, int[][] board){
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == -1);
    }

    /*
    public static void main(String[] args){
	    int b = silver("silver1.txt");
	    System.out.println(b);
	    System.out.println(bronze("makelake.in.txt"));
    }
    */

}
