import java.util.LinkedList;
import java.util.*;

public class MyDeque<E>{
    private E[] data;
    //private E first, last;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data=(E[])new LinkedList [10];
	size=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	data=(E[])new LinkedList[initialCapacity];
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
	}else{
	    data.push(val);
        }
    }
    public void addLast(E val){
	if (val==null){
	    throw new NullPointerException();
	}else if(size()==data.length){
	    System.out.println("WHY");
	}else{
	    data.pop(val);
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
