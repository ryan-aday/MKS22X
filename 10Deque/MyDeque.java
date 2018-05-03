import java.util.LinkedList;
import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int f,b;
    private int size;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data=(E[])new Object[10];
	f=0;
	b=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data=(E[]) new Object[initialCapacity];
	f=0;
	b=0;
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
	public void resize() {
	E[] newArr = (E[])new Object[size*2];
	for (int i=0; i<data.length; i++){
	    newArr[i] = data[(i+f)%data.length];
	}
	data = newArr;
	f = 0;
	b = size-1;
    }
    
    public void addFirst(E value){
	if (value == null){
	    throw new NullPointerException();
	}
	if (size == data.length){
	    resize();
	}
	if (size != 0){
	    f = (f-1+data.length) % data.length;
	}
	data[f] = value;
	size++;
    }
    
    public void addLast(E value) {
	if (value==null){
	    throw new NullPointerException();
	}
	if (size==data.length){
	    resize();
	}
	if (size!=0){
	    b = (b+1) % data.length;
	}
	data[b]=value;
	size++;
    }

    public E removeFirst(){
	if (size<1) {
	    throw new NoSuchElementException();
	}
	E temp=data[f];
	data[f]=null;
	if (size>1){
	    f=(f+1)%data.length;
	}
	size--;
	return temp;
    }
 
    public E removeLast() {
	if (size<1) {
	    throw new NoSuchElementException();
	}
	E temp=data[b];
	data[b]=null;
	if (size>1){
	    b=(b-1+data.length)%data.length;
	}
	size--;
	return temp;
    }

    public E getFirst(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	return data[f];
    }

    public E getLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	return data[b];
    }

    public String toString(){
    String ans = "[";
    if(f<b){
      for (int c=f; c< b; c++){
        ans+=data[c]+" , ";
      }
    }
    else{
      for(int c=f; c<data.length; c++){
        ans+=data[c]+", ";
      }
      for(int c=0; c<=b; c++){
        ans+=data[c]+", ";
      }
    }
    ans=ans.substring(0, ans.length()-2)+"]";
    return ans;
  }
}
