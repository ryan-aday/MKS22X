public class Location implements Comparable<Location>{
    private int x,y, dist, dSF;
    private Location previous;
    
    public Location(int Lx, int Ly, Location prev, int dist, int dSF){
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

    public int getDistanceSoFar(){
	if (getPrev()==null){
	    return 1;
	}
	
	return getPrev().getDistanceSoFar()+1;
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
