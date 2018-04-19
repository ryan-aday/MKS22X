import java.util.LinkedList;
import java.util.*;

public class MyDeque<E>{
    private E[] data;
    //private E first, last;
    private int size, first, last;

    public static void main(String[]args){
	MyDeque<Integer> a= new MyDeque<Integer>();
	a.addFirst(12);
	System.out.println(a.toString());
	a.addFirst(12);
	System.out.println(a.toString());
	a.addFirst(12);
	System.out.println(a.toString());
	a.addFirst(12);
	System.out.println(a.toString());

	
    }

    public String toString(){
	String str="";
	for (int c=0; c<data.length; c++){
	    str=str+" "+data[c];
	}
	return str;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data=(E[])new Object[10];
	size=0;
	first=0;
	last=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	data=(E[])new Object[initialCapacity];
	size=0;
    }

    public int size(){
	return size;
    }

    public void addFirst(E val){
	if (val==null){
	    throw new NullPointerException();
	}else if(size()==data.length){
	    System.out.println("WHY");
	}else if (size()==0){
	    data[0]=val;
	    last=1;
	}else if(first<last){
	    for (int d=first; d>0; d--){
		if (data[d]!=null){
		    data[d]=val;
		    first=d;
		}
	    }
	}else{
	    for (int c=data.length-1; c>first+1; c--){	
		if (data[c]!=null){
		    data[c]=val;
		    first=c;
		}
	    }
	}
    }
    
    public void addLast(E val){
	if (val==null){
	    throw new NullPointerException();
	}else if(size()==data.length){
	    System.out.println("WHY");

	}else if (size()==0){
	    data[0]=val;
	    last=1;
	}else if(last>first){
	    for (int d=last; d>data.length; d++){
		if (data[d]!=null){
		    data[d]=val;
		    last=d;
		}
	    }
	}else{
	    for (int c=0; c<last; c++){	
		if (data[c]!=null){
		    data[c]=val;
		    last=c;
		}
	    }
	}
    }
    
    //throw new NullPointerException();  if the specified element is null and this deque does not permit null elements

    /*
    public E removeFirst(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
    }
    public E removeLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
    }
    //throw new NoSuchElementException(); 
	
    public E getFirst(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
    }
    public E getLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
    }

    */
}
    //throw new NoSuchElementException(); 


    //resize will demand a suppress
