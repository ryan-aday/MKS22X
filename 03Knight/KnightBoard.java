public class KnightBoard{
    public static void main(String[]args){
        KnightBoard a=new KnightBoard(7, 7);
	System.out.println(a.toString());
	System.out.println(a.addKnight(3, 4, 21));
	System.out.println(a.toString());
	System.out.println(a.addKnight(4, 6, 22));
	System.out.println(a.toString());

	

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
		    layout += "_ ";
		}
		else if (board[row][col] < 10 && board[row][col] >= 1){
		    layout += "_" + board[row][col] + " ";
		}
		else {
		    layout += "" + board[row][col] + " ";
		}
	    }
	    layout += "\n";
	}
	return layout;
    }

    public boolean solve(int row, int col){
        if (row<0 ||
	    col<0 || 
	    row>=board.length ||
	    col >= board[0].length){
	    throw new IllegalArgumentException();
	}
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board[r].length;c++){
		if (board[r][c]!=0){
		    throw new IllegalStateException();	    
		}
	    }
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
	}
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board[r].length;c++){
		if (board[r][c]!=0){
		    throw new IllegalStateException();	    
		}
	    }
	}
	sols = 0;
	sols = helperCount(row,col,1);
	board[row][col] = 0;
	return sols;
    }

    public int helperCount(int row,int col, int count){
	if (count == (rmax * cmax)){
	    sols++;
	    return sols;
	}
	for (int r=0 ; r<xcor.length;r++){
	    board[row][col]=count;
	    try {
		if (board[row+xcor[r]][col+ycor[r]]==0){
		    helperCount(row+xcor[r],col+ycor[r],count++);
		    board[row+xcor[r]][col+ycor[r]]=0;
		}
	    } catch (ArrayIndexOutOfBoundsException e){}
	}return sols;
    }
}
