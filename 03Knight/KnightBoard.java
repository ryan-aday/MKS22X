public class KnightBoard{
    public static void main(String[]args){
        KnightBoard a=new KnightBoard(3, 3);
	System.out.println(a);
	try{
	    for (int i = 0; i < 3; i++){
		for (int j = 0; j < 3; j++){
		    if (a.solve(i,j)){
	      System.out.println("There is an error with your solve method");
		    }
		}
	    }} catch (IllegalStateException e){
	}//prints nothing
	try{
	    System.out.println(a.countSolutions(0,0)); //prints 0
	} catch (IllegalStateException e){
	}
	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution
	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"
	
	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"
	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"
	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"
	try{
      KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"
	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"
	
	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"
	
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	
	KnightBoard c = new KnightBoard(5,5);
	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}
	System.out.println(totalSol); //prints 1728
	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304
    }
    
    private int[][] board;
    private int[] xcor;
    private int[] ycor;
    private int rmax;
    private int cmax;    

    public KnightBoard(int row, int col){
	if (row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[row][col];
	xcor = new int[] {-1,-1,1,1,-2,-2,2,2};
	ycor = new int[] {-2,2,-2,2,-1,1,-1,1};
	rmax = row;
	cmax = col;
    }

    public String toString(){
	String layout = "";
	for (int row=0; row<board.length; row++){
	    for (int col=0 ;col<board[row].length; col++){
		if (board[row][col]==0){
		    layout += " _ ";
		}
		else if (board[row][col] < 10 && board[row][col] >= 1){
		    layout += " "+ board[row][col] + " ";
		}
		else {
		    layout += board[row][col] + " ";
		}
	    }
	    layout += "\n";
	}
	return layout;
    }

    public boolean BoardScan(){
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board[r].length;c++){
		if (board[r][c]!=0){
		    return false;	    
		}
	    }
	}return true;
    }

    public boolean solve(int row, int col){
        if (row<0 ||
	    col<0 || 
	    row>=board.length ||
	    col >= board[0].length){
	    throw new IllegalArgumentException();
	}else if (!BoardScan()){
	    throw new IllegalStateException();
	}return solveHelp(row, col, 1);
    }

    public boolean solveHelp(int row,int col,int count){
	if (count==(rmax*cmax)){
	    board[row][col] = count;
	    return true;
	}
	for (int r=0; r<xcor.length; r++){
	    board[row][col] = count;
	    try {
		if (board[row + xcor[r]][col + ycor[r]]==0){
		    if (solveHelp(row+xcor[r], col+ycor[r], count++)){
			return true;
		    }
		    board[row+xcor[r]][col+ycor[r]]=0;
		}
	    }catch(ArrayIndexOutOfBoundsException e){}
	}
	board[row][col] = count;
	return false;
    }

    private int sols;
    public int countSolutions(int row, int col){
        if (row<0 ||
	    col<0 || 
	    row>=board.length ||
	    col >= board[0].length){
	    throw new IllegalArgumentException();
	}else if (!BoardScan()){
	    throw new IllegalStateException();
	}
	sols = 0;
	sols = countHelp(row,col,1);
	board[row][col] = 0;
	return sols;
    }

    public int countHelp(int row,int col, int count){
	if (count == (rmax * cmax)){
	    sols++;
	    return sols;
	}
	for (int r=0 ; r<xcor.length;r++){
	    board[row][col]=count;
	    try {
		if (board[row+xcor[r]][col+ycor[r]]==0){
		    countHelp(row+xcor[r],col+ycor[r],count++);
		    board[row+xcor[r]][col+ycor[r]]=0;
		}
	    } catch (ArrayIndexOutOfBoundsException e){}
	}return sols;
    }
}
