import java.util.*;
import java.io.*

public class FrontierStack{
    Stack<Location> locations;

    public void add(Location L){
	locations.push(L);
    }

    public Location next(){
	Location[] LOC=Maze.getNeighbors();
	for (int a=0; a<LOC.length; a++){
	    locations
	    return LOC[a];
	}
    }
}
