import java.util.*;
import java.io.*;

public class USACO{
    public static void main(String[] args){
	System.out.println(silver("ctravel.1.in")); 
	
    }
    
    public static int bronze(String filename){
	return -1;
    }

    public static int silver(String filename){
	
        File text = new File(filename);
        

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

	    int lnCount=0;
	    while (
	    
	    for (int count=0; count<; count++){
		String dataC= inf.next();
		
		if (dataC.substring(0,1)!="." || line.substring(0,1)!="*"){
		    
		}
		System.out.println(line);
	    }
		
	}catch (FileNotFoundException e){
	    return -1;
	}return 0;
    }
}
