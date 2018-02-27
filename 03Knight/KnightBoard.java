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

    
    private boolean addKnight(int r, int c, int counter){
	if (r>=board.length || c>=board[r].length){
	    throw new IllegalStateException();
	}
	if(board[r][c]!=0){
	    return false;
	}
	
	if((board[r+1][c+2]==0 && r+1<board.length && c+2<board[0].length) ||
	   board[r+2][c+1]==0 ||
	   board[r+2][c-1]==0 ||
	   board[r+1][c-2]==0 ||
	   board[r-1][c-2]==0 ||
	   board[r-2][c-1]==0 ||
	   board[r-2][c+1]==0 ||
	   board[r-1][c+2]==0){
	    board[r][c]=counter;
	    return true;
	}return false;
    }
}
