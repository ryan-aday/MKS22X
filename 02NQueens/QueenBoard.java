public class QueenBoard{
    public static void main(String[]args){
	QueenBoard a=new QueenBoard(69);
	System.out.println(a.toString());
	//a.addQueen(0,0);
   	//System.out.println(a.toString());
	/*	a.addQueen(0,0);
   	System.out.println(a.toString());
	a.removeQueen(0,0);
   	System.out.println(a.toString());
	
	a.removeQueen(0,0);
   	System.out.println(a.toString());
	*/
	System.out.println(a.solve());
	System.out.println(a.countSolutions());
    }
    
    private int[][] board;
    
    public QueenBoard(int size){
	board=new int[size][size];
	for(int row=0; row<size; row++){
	    for(int col=0; col<size; col++){
		board[row][col]=0;
	    }
	}
    }
    
    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	int ln=board.length;
	String ro="";
	for (int row=0; row<ln; row++){
	    ro=ro+"\n";
	    for (int col=0; col<ln; col++){
		if (board[row][col]==1){
		    ro=ro+"Q ";
		}else if (board[row][col]<0){
		    ro=ro+"T ";
		}else{
		    ro=ro+"_ ";
		}
	    }
      }return ro;
    }
    
    private boolean addQueen(int r, int c){
	if (r>=board.length || c>=board.length){
	    throw new IllegalStateException();
	}
	if(board[r][c]<0){
	    return false;
	}
	board[r][c]=1;
	
	for (int col=r; col<board.length; col++){
	    if(board[r][col]!=1){
		board[r][col]=board[r][col]-1;
	    }
	}

	int dc=c;
	for (int dr=r+1; dr<board.length; dr++){
	    dc++;
	    if (dc>=board.length){
	    }else if(board[dr][dc]!=1){
		board[dr][dc]=board[dr][dc]-1;
	    }else{}
	}return true;
    }
   
    private boolean removeQueen(int r, int c){
	if (r>board.length || c>board.length){
	    throw new IllegalStateException();
	}
	if (board[r][c]<1){
	    return false;
	}
	board[r][c]=0;
	
	for (int col=r; col<board.length; col++){
	    if(board[r][col]<0){
		board[r][col]=board[r][col]+1;
	    }
	}
	
	int dc=c;
	for (int dr=r+1; dr<board.length; dr++){
	    dc++;
	    if (dc>=board.length){
	    }else if(board[dr][dc]<0){
		board[dr][dc]=board[dr][dc]+1;
	    }else{}
	}return true;
	
    }

    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
    public boolean solve(){
	return solveHelp(0);
    }

    public boolean solveHelp(int col){
	if (col>=board.length){
	    return true;
	}
	for (int row=0; row<board.length; row++){
	    if (addQueen(row, col)){
		if (solveHelp(col+1)){
		    return true;
		}
	    }removeQueen(row, col);
	}return false;
    }
	    
  
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
     public int countSolutions(){
	 return countHelp(0,0);
     }

    public int countHelp(int col, int count){
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board.length; c++){
		if (board[r][c]==0 &&
	
	
	for (int row=0; row<board.length; row++){
	    if (addQueen(row, col)){
		if (solveHelp(col+1)){
		    count++;
		}
	    }removeQueen(row, col);
	}return count;
    }
}
    
	    
