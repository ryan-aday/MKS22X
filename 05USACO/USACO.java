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
