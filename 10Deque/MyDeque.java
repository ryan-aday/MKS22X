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

    /*
    public static void main(String[] args) {
	try{
	    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	    ArrayList<String> b = new ArrayList<>();
	    int size = Integer.parseInt(args[0]);
	    for(int i = 0; i < size; i++){
		int temp = (int)(Math.random() * 1000);
		if(temp % 2 == 0){
		    a.addFirst("" + temp);
		    a1.addFirst("" + temp);
		    b.add(0, "" + temp);
		}
		else{
		    a.addLast("" + temp);
		    a1.addLast("" + temp);
		    b.add("" + temp);
		}
	    }
	    int index = 0;
	    boolean hasError = false;
	    String errorEvaluation = "Errors found at these indices: ";
	    for (String x : b){
		if (!(x.equals(a.getFirst()))){
		    System.out.println("The getFirst() function is incorrect at index " + index);
		    hasError = true;
		}
		if (!(x.equals(a.removeFirst()))){
		    System.out.println("There is an error at index " + index);
		    errorEvaluation += index + ", ";
		    hasError = true;
		}
		index++;
	    }
	    if(hasError){
		errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
		System.out.println(errorEvaluation);
		System.out.println("MyDeque: " + a1);
		System.out.println("Actual Deque: " + b);
	    }
	    else{
		System.out.println("Your deque is bug-free!");
	    }
	}catch (NoSuchElementException e){
	}
    }
    */
}
