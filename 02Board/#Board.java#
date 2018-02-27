public class Board{
    public static void main(String[] args){
	Board a=new Board();
	System.out.println(a.Board(12));
    }
    
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
}
    
	    
