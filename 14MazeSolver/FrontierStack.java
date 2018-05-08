import java.util.*;
import java.io.*;

public class FrontierStack implements Frontier{
    private Stack<Location> locs;
    
    public FrontierStack(){
	locs=new Stack<Location>();
    }
    
    public Location next(){
	return locs.pop();
    }
    
    public void add(Location n){
	locs.add(n);
    }
    
    public boolean hasNext(){
	return locs.size()!=0;
    }
}
