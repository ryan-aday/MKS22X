public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
        
    public static void main(String[]args){
	/*
	MyLinkedList a=new MyLinkedList();
	System.out.println(a.isEmpty());
	System.out.println(a.size());
	a.add(2);
	System.out.println(a.isEmpty());
	a.add(1);
	a.add(0);
		
	System.out.println(a.get(0));
	System.out.println(a.toString());
	*/
	}	
    
    public MyLinkedList(){
	first=new Node();
	last=new Node();
	length=0;
    }

    //Misc Functions

    public String toString(){
	String a="";
	for (int c=0; c<length; c++){
	    a= a+get(c)+" ";
	}return a;
    }
    
    public boolean isEmpty(){
	return first==null || length==0;
    }

    public int size(){
	return length;
    }

    public int clear(){
	first=null;
	first=null;
	length=0;
    }

    //Add Functions
    public boolean add(int value){
	if (isEmpty()){
	    first.setNext(last);
	    last.setPrev(first);
	    first.setValue(value);
	    length++;
	}else if (length==1){
	    last.setValue(value);
	    length++;
	}else{
	    Node next=new Node();
	    last.setNext(next);
	    next.setPrev(last);
	    last=next;
	    last.setValue(value);
	    length++;
	}return true;
    }
    
    public void add(int n, int value){
	if(n>= 0 && n<=size()){
	    Node c = new Node();
	    c.setValue(value);
	    if(n==0){
		if(size()==0){
		    first.setNext(last);
		    last.setPrev(first);
		    first.setValue(value);
		}else if(length==1){
		    last.setValue(first.getValue());
		    first.setValue(value);
		}else{
		    c.setNext(first);
		    first.setPrev(c);
		    first=c;
		}
	    }else if(n==size()){
		if(size()==1){
		    last.setValue(value);
		}else{
		    c.setPrev(last);
		    last.setNext(c);
		    last=c;
		}
	    }else{
		Node bef= getNode(n-1);
		Node aft= getNode(n);
		bef.setNext(c);
		aft.setPrev(c);
	        c.setPrev(bef);
	        c.setNext(aft);
	    }
	    length++;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public int remove(int n){
	if(n>=0 && n<size()){
	    int t = 0;
	    Node c = getNode(n);
	    if(n==0){
		t=first.getValue();
		if(size()==1){
		    first.setNext(null);
		    last.setPrev(null);
		    first.setValue(null);
		}else if(length==2){
		    first.setValue(last.getValue());
		    last.setValue(null);
		}else{
		    c.getNext().setPrev(null);
		    first = c.getNext();
		}
	    }else if(n==size()-1){
		t=c.getValue();
		if(size()==2){
		    c.setValue(null);
		}else{
		    c.getPrev().setNext(null);
		    last=c.getPrev();
		}
	    }else{
		t=c.getValue();
		c.getPrev().setNext(c.getNext());
		c.getNext().setPrev(c.getPrev());
	    }
	    length--;
	    return t;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public boolean remove(Integer value){
	if(first.getValue()==value){
	    if(size()==1){
		first.setNext(null);
		last.setPrev(null);
	    }else if(size()==2){
		first.setValue(last.getValue());
		last.setValue(null);
	    }else{
		first.getNext().setPrev(null);
		first=first.getNext();
	    }
	    length--;
	    return true;
	}else{
	    Node c=first;
	    for(int d=0; d<length-1; d++){
		if(c.getValue() == value){
		    c.getPrev().setNext(c.getNext());
		    c.getNext().setPrev(c.getPrev());
		    length--;
		    return true;
		}
		c=c.getNext();
	    }
	    if(c.getValue()==value){
		if(length==2){
		    last.setValue(null);
		}else{
		    c.getPrev().setNext(null);
		    last=c.getPrev();
		}
		length--;
		return true;
	    }
	}
	return false;
    }

    //get, set methods

    public int get(int n){
	if (size()>0 && n>=0 && n<length){
	    return getNode(n).getValue();
	}else throw new IndexOutOfBoundsException();
    }

    public int set(int n, int value){
	if (size()>0 && n>=0 && n<size()){
	    Node c=getNode(n);
	    int t=c.getValue();
	    c.setValue(value);
	    return t;
	}else throw new IndexOutOfBoundsException();
    }

    public int indexOf(int value){
	if (size()==1){
	    if (first.getValue()==value){
		return 0;
	    }   
	}else {
	    Node c=first;
	    int t=0;
	    for (int d=0; d<size()-1; d++){
		if (c.getValue()==value){
		    return d;
		}
		c=c.getNext();
		t++;
	    }
	    if (c.getValue()==value){
		return t;
	    }
	}return -1;
    }
    
    private Node getNode(int n){
	Node c=first;
	for(int d=0; d<n; d++){
	    c=c.getNext();
	}return c;
    }

}
