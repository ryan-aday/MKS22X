import java.util.*;

public class FrontierQueue implements Frontier{
  private LinkedList<Location> locs;

  public FrontierQueue(){
    locs=new LinkedList<Location>();
  }

  public void add(Location n){
    locs.add(n);
  }

  public Location next(){
    return locs.remove();
  }

  public boolean hasNext(){
    return locs.peek() != null;
  }
}
