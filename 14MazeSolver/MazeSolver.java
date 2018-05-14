import java.util.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    
    public static void main(String[]args){
		
	MazeSolver a=new MazeSolver("test2.txt");
	System.out.println(a);
	a.setAnimate(true);
	a.solve(2);
	System.out.println(a);
	
    }
    
    public MazeSolver(String fileName){
	maze=new Maze(fileName);
	animate=false;
    }
    
    private void wait(int time){
	try {
	    Thread.sleep(time);
	}
	catch (InterruptedException e) {
	}
    }
    
    public void setAnimate(boolean bool){
	animate=bool;
    }
    //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	//initialize your frontier
 	
	if (mode == 1){
	  frontier=new FrontierStack();
	}else if (mode == 0) {
	    frontier=new FrontierQueue();
	}else if (mode == 2){
	    frontier = new FrontierPriorityQueue();
	}else if (mode == 3){
	    maze.setAStar=true;
	}
	frontier.add(maze.getStart());
	Location end = maze.getEnd();
	while (frontier.hasNext()){
	    if (animate){
		System.out.println("\033[2J\033[1;1H");
		System.out.println(this);
		wait(30);
	    }
	    Location next = frontier.next();
	    maze.set(next.getX(),next.getY(),'.');
	    Location[] newL = maze.getNeighbors(next);
	    for (int a=0; a<newL.length; a++){
		Location c = newL[a];
		if (setAStar==true){
		    ///   
		}

		
		if (c != null){
		    if (c.equals(end)){
			maze.end = new Location(maze.end.getX(),maze.end.getY(),c.getPrev(),0, 0);
			maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
			return true;
		    }
		    frontier.add(c);
		    maze.set(c.getX(),c.getY(),'?');
		}
	    }
	}
	return false;
    }
    
    public String toString(){
	Location c = maze.getEnd().getPrev();
	while (c!=null){
	    maze.set(c.getX(), c.getY(), '@');
	    c=c.getPrev();
	    if (animate){
		System.out.println("\033[2J\033[1;1H");
		System.out.println(maze.colorize(maze.toString()));
		wait(30);
	    }
	}
	maze.set(maze.start.getX(),maze.start.getY(),'S');
	return maze.colorize(maze.toString());
    }
}
