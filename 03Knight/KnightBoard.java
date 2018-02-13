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
    
    public KnightBoard(int rows, int cols){
	board=new int[rows][cols];
	for(int row=0; row<rows; row++){
	    for(int col=0; col<cols; col++){
		board[row][col]=0;
	    }
	}
    }
    
    public String toString(){
	int ln=board.length;
	String ro="";
	for (int row=0; row<ln; row++){
	    ro=ro+"\n";
	    for (int col=0; col<ln; col++){
		if (board[row][col]<10){
		    ro=ro+"  "+board[row][col];
		}else{
		    ro=ro+" "+board[row][col];
		}
	    }
      }return ro;
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
