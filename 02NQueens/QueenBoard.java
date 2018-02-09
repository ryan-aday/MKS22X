public class QueenBoard{
    public static void main(String[]args){
	QueenBoard a=new QueenBoard(4);
	System.out.println(a.toString());
	a.addQueen(0,0);
   	System.out.println(a.toString());
	a.addQueen(1,0);
   	System.out.println(a.toString());
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
		if (board[row][col]==2){
		    ro=ro+"Q ";
		}else if (board[row][col]==1){
		    ro=ro+"T ";
		}else{
		    ro=ro+"_ ";
		}
	    }
      }return ro;
    }
    
    private boolean addQueen(int r, int c){
	board[r][c]=2;
	int count=0;
	
	for (int col=r; col<board.length; col++){
	    if(board[r][col]!=2){
		board[r][col]=1;
		count++;
	    }
	}

	for (int d=c+1; d<board.length; d++){
	    if(board[d][d]!=2){
		board[d][d]=1;
		count++;
	    }
	}
	if (count!=0){
	    return true;
	}return false;
    }
    
    //private boolean removeQueen(int r, int c)
	
    
  

  
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros; 
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
    // public boolean solve(){}
  
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
    // public int countSolutions(){}
  
    /*
    
    public int Board(int n){
	if (n<=0){
	    return -1;
	}
	if (n<3){
	    return 1;
	}
	
        int[][] grid=new int[n][n];
	for(int row=0; row<n; row++){
	    for(int col=0; col<n; col++){
		grid[row][col]=0;
	    }
	}

	int[] data=new int[n];
	int max=0;
	
	for(int vert=0; vert<n; vert++){
	    data[vert]=gridH(n,grid,vert,0,0);
	}

	for (int count=0; count<n; count++){
	    if (data[count]>max){
		max=data[count];
	    }
	}
	return max;
    }

    public int gridH(int n, int[][] grid, int row, int col,int total){
	if (n<3){
	    return 1;
	}
	grid[row][col]=2;
	for (int r=row; r<n; r++){
	    if(grid[r][col]!=2){
		grid[r][col]=1;
	    }
	}
	for (int c=col; c<n; c++){
	    if(grid[row][c]!=2){
		grid[row][c]=1;
	    }
	}

	for (int d=row; d<n; d++){
	    if(grid[d][d]!=2){
		grid[d][d]=1;
	    }
	}
	
	for(int rl=row+1; rl<n; rl++){
	    for(int cl=1; cl<n; cl++){
		if (grid[rl][cl]==0){
		    gridH(n, grid, rl, cl, total+1);
		}
	    }
	}
	return total;
    }
    */
}
    
	    
