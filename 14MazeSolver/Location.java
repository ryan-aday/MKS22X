public class Location implements Comparable<Location>{
    private int x,y, dist;
    private Location previous;
    
    public Location(int Lx, int Ly, Location prev, int dist){
	x=Lx;
	y=Ly;
	this.dist=dist;
	previous=prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int getDistance(){
	return dist;
    }

    public Location getPrev(){
	return previous;
    }
    
    public boolean equals(Location n){
	return x==n.getX() && y==n.getY();
    }

    public String toString(){
	return "["+x+","+y+"]";
    }

    public int compareTo(Location given){
	return this.dist-given.getDistance();
    }
}
