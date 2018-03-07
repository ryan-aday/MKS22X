import java.util.*;
import java.io.*;

public class USACO{
    public static void main(String[] args){
	System.out.println(silver("ctravel.10.in")); 
	
    }
    
    public static int bronze(String filename){
	return -1;
    }

    public static int silver(String filename){
	int rcount=0;
	int ccount=0;
	
        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File("input.txt");// can be a path like: "/full/path/to/file.txt" 
	char[][] data;
	
        //inf stands for the input file
	try {
	    Scanner inf = new Scanner(text);
	    Scanner actual = new Scanner(text);

	    int row=-1;
	    String ch="";

	    while (inf.hasNextLine()){
		rcount++;
		ch=inf.nextLine();
	    }
	    ccount=ch.length();
	    data=new char[rcount][ccount];
	    
	    // System.out.println(board.length+" "+board[0].length);

	    while (actual.hasNextLine()){
		row++;
		String line=actual.nextLine();
		for (int count=0; count<line.length(); count++){
		    data[row][count]=line.charAt(count);
		}
	    }
	    
	    String test="";
	    for (int rw=0; rw<data.length; rw++){
		test=test+"\n";
		for (int col=0; col<data[rw].length; col++){
		    test=test+data[rw][col];
		}
	    }
	    System.out.println(test);
	    
	
	}catch (FileNotFoundException e){
	    return -1;
	}return -1;
    }
}
