public class Location{
    private int x,y;
    private Location previous;

    public Location(int Lx, int Ly, Location prev){
	x=Lx;
	y=Ly;
	previous=prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }
}
