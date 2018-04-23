import java.util.LinkedList;
import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int f,b;
    private int size;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	f=0;
	b=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[initialCapacity];
	f=0;
	b=0;
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
   private void resize(){
	E[] temp = (E[]) new Object[size() * 2];
	for (int c=0; c<size(); c++){
	    temp[c] = data[c];
	}
	data=temp;
	f=0;
	b=size() - 1;
    }
    
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
		resize();
	    }
	if (size == 0){
	    data[f] = element;
	}
	else{
	    if (f <= 0){
	        f = f + data.length - 1;
		data[f] = element;
	    }
	    else{
		front--;
		data[f] = element;
	    }
	}
	size++;
    }

    public void addLast(E element){
	if (size == data.length){
	    resize();
	}
	if (element == null){
	    throw new NullPointerException();
	}
	if (size==0){
	    data[b] = element;
	}
	else {
	    if (b >= data.length - 1){
		b = b - (data.length - 1);
		data[b] = element;
	    }
	    else{
		b++;
		data[b] = element;
	    }
	}
	size++;
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp=data[front];
	data[f]=null;
	if (f==data.length - 1){
	    f=0;
	}
	else{
	    f++;
	}
        size--;
	return temp;
    }

    public E removeLast(){
	if (size()==0){
	    throw new NoSuchElementException();
	}
	E temp=data[b];
	data[b]=null;
	if (b==0){
	    b=data.length - 1;
	}
	else {
	    b-=1;
	}
        size-=1;
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
    if(f < b){
      for (int c=f; c< b; c++){
        ans += data[c] + " , ";
      }
    }
    else{
      for(int c=f; c<data.length; c++){
        ans += data[c] + ", ";
      }
      for(int c=0; c<=b; c++){
        ans += data[c] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }
}
