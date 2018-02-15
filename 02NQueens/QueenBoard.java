public class QueenBoard{
    public static void main(String[]args){
	QueenBoard a=new QueenBoard(4);
	a.addQueen(1,1);
	System.out.println(a.toString());
	a.addQueen(1,0);
   	System.out.println(a.toString());
	
	a.removeQueen(1,1);
   	System.out.println(a.toString());
	/*	a.addQueen(0,0);
   	System.out.println(a.toString());
	a.removeQueen(0,0);
   	System.out.println(a.toString());
	
	a.removeQueen(0,0);
   	System.out.println(a.toString());
	*/
	//System.out.println(a.solve());
	//	System.out.println(a.toString());
	//	System.out.println(a.countSolutions());
	//	System.out.println(a.toString());
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
	if(board[r][c]!=0){
	    return false;
	}
	/*	if (r>0 && r<board.length-1){
	    if (c>0 && c<board.length-1){
		if (board[r-1][c]==1 ||
		    board[r+1][c]==1 ||
		    board[r][c-1]==1 ||
		    board[r][c+1]==1 ||
		    board[r-1][c-1]==1 ||
		    board[r+1][c+1]==1 ||
		    board[r-1][c+1]==1 ||
		    board[r+1][c-1]==1){
		    return false;
		}
	    }
	}
	*/


	board[r][c]=1;

	for (int urow=r-1; urow>-1; urow--){
	    if(board[urow][c]!=1){
		board[urow][c]=board[urow][c]-1;
	    }
	}
	
	for (int row=r+1; row<board.length; row++){
	    if(board[row][c]!=1){
		board[row][c]=board[row][c]-1;
	    }
	}
	
	for (int ucol=c-1; ucol>-1; ucol--){
	    if(board[r][ucol]!=1){
		board[r][ucol]=board[r][ucol]-1;
	    }
	}
	
	for (int col=c+1; col<board.length; col++){
	    if(board[r][col]!=1){
		board[r][col]=board[r][col]-1;
	    }
	}

	int dc=c;
	for (int dr=r+1; dr<board.length; dr++){
	    dc++;
	    if (dc>=board.length-1){
		if(board[dr][dc]!=1){
		    board[dr][dc]=board[dr][dc]-1;
		}else{}
	    }
	}

	int uc=c;
	for (int ur=r+1; ur<board.length; ur++){
	    uc--;
	    if (uc>=0){
		if(board[ur][uc]!=1){
		    board[ur][uc]=board[ur][uc]-1;
		}
	    }else{}
	}
	
	int ddc=c;
	for (int ddr=r+1; ddr<board.length; ddr++){
	    ddc--;
	    if (ddc>=board.length-1){
		if(board[ddr][ddc]!=1){
		    board[ddr][ddc]=board[ddr][ddc]-1;
		}else{}
	    }
	}

	int uuc=c;
	for (int uur=r+1; uur<board.length; uur++){
	    uuc++;
	    if (uuc>=0){
		if(board[uur][uuc]!=1){
		    board[uur][uuc]=board[uur][uuc]-1;
		}
	    }else{}
	}return true;
    }
   
    private boolean removeQueen(int r, int c){
	if (r>=board.length || c>=board.length){
	    throw new IllegalStateException();
	}
	if(board[r][c]!=1){
	    return false;
	}

	board[r][c]=0;

	for (int urow=r-1; urow>-1; urow--){
	    if(board[urow][c]!=1){
		board[urow][c]=board[urow][c]+1;
	    }
	}
	
	for (int row=r+1; row<board.length; row++){
	    if(board[row][c]!=1){
		board[row][c]=board[row][c]+1;
	    }
	}
	
	for (int ucol=c-1; ucol>-1; ucol--){
	    if(board[r][ucol]!=1){
		board[r][ucol]=board[r][ucol]+1;
	    }
	}
	
	for (int col=c+1; col<board.length; col++){
	    if(board[r][col]!=1){
		board[r][col]=board[r][col]+1;
	    }
	}

	int dc=c;
	for (int dr=r+1; dr<board.length; dr++){
	    dc++;
	    if (dc>=0){
		if(board[dr][dc]!=1){
		    board[dr][dc]=board[dr][dc]+1;
		}else{}
	    }
	}

	int uc=c;
	for (int ur=r-1; ur>-1; ur--){
	    uc++;
	    if (uc>=0){
		if(board[ur][uc]!=1){
		    board[ur][uc]=board[ur][uc]+1;
		}
	    }else{}
	}
	
	int ddc=c;
	for (int ddr=c+1; ddr<board.length; ddr++){
	    ddc--;
	    if (ddc>=board.length-1){
		if(board[ddr][ddc]!=1){
		    board[ddr][ddc]=board[ddr][ddc]+1;
		}else{}
	    }
	}

	int uur=r;
	for (int uuc=r+1; uuc<board.length; uuc++){
	    uur++;
	    if (uuc>=0){
		if(board[uur][uuc]!=1){
		    board[uur][uuc]=board[uur][uuc]+1;
		}
	    }else{}
	}return true;
    }

    

    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
    public boolean solve(){
	 for (int r=0; r<board.length; r++){
	     for (int c=0; c<board.length; c++){
		 if (board[r][c]!=0){
		     throw new IllegalStateException();
		 }
	     }
	 }
	 /*	 if (-1*(countSolutions())>0){
	     System.out.println(toString());
	     for (int ro=0; ro<board.length; ro++){
		 for (int co=0; co<board.length; co++){
		     board[ro][co]=0;
		 }
	     }return true;
	 }for (int row=0; row<board.length; row++){
	     for (int col=0; col<board.length; col++){
		 board[row][col]=0;
	     }
	 }return false;
	 */

	 return solveHelp(0, 0);
    }
    
    public boolean solveHelp(int col, int counter){
	if (col>=board.length){
	    //return true;
	}
	for (int row=0; row<board.length; row++){
	    if (addQueen(row, col)){
		if (solveHelp(col+1, counter+1)){
		    counter++;
		    return true;
		}
	    }else if(row<board.length){
		removeQueen(row, col);
	    }else{
		return false;
	    }
	}
	if (col==board.length-1 && counter!= board.length){
	    return false;
	}
	return true;
    }
	    
  
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
    /*
    public int countSolutions(){
	 /*if (board.length==1 || board.length==2){
	     return board.length;
	 }
	 
	 int counter=0;
	 
	 for (int r=0; r<board.length; r++){
	     for (int c=0; c<board.length; c++){
		 if (solveHelp(r, c)){
		     throw new IllegalStateException();
		 }
	     }
	 }
	 return countHelp(0,0);
     }
    */

    /* public int countHelp(int col, int count){	
	//boolean work=false;

	for (int row=0; row<board.length; row++){
 	    if (addQueen(row, col)){
		if (solveHelp(col+1)){
		    count++;
		}
	    }else{
		removeQueen(row, col);
		count--;
	    }
	}
    */
	//work=true;
	//System.out.println(toString());

	/*if (col>=board.length || work==true){
	    for (int r=0; r<board.length; r++){
		for (int c=0; c<board.length; c++){
		    if (board[r][c]==1){
			count++;
		    }board[r][c]=0;
		} 
	    }
	}
	
	//System.out.println(toString());
	if (count>=board.length){
	    return count;
	}return count;
    }
	*/
}
